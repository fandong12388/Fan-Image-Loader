package com.fans.loader.core.cache;

import android.graphics.Bitmap;

import com.fans.loader.FanImageLoader;
import com.fans.loader.internal.cache.disc.impl.BaseDiskCache;
import com.fans.loader.internal.utils.IoUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * time: 15/10/17
 * description: 自定义的本地缓存机制
 *
 * @author fandong
 */
public class CustomDiskCache extends BaseDiskCache {
    private ConcurrentLinkedQueue<String> mQueue;
    //标识是否正在轮循
    private boolean mIsPoll;
    //标识是否销毁
    private boolean mIsDestroy;

    public CustomDiskCache(File cacheDir, File reserveCacheDir) {
        super(cacheDir, reserveCacheDir);
        this.mQueue = new ConcurrentLinkedQueue<String>();
    }


    @Override
    public boolean save(String cacheKey) throws IOException {
        if (!mQueue.contains(cacheKey)) {
            mQueue.add(cacheKey);
        }
        if (!mIsPoll) {
            mIsPoll = true;
            Thread thread = new Thread(getCacheTask());
            thread.start();
        }
        return true;
    }

    public Runnable getCacheTask() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    String cacheKey = mQueue.poll();
                    do {
                        //0.如果销毁就跳出线程
                        if (mIsDestroy) {
                            break;
                        }
                        boolean savedSuccessfully = false;
                        //1.从内存当中拿出缓存
                        Bitmap bitmap = FanImageLoader.getMemoryCache(cacheKey);
                        if (bitmap == null || bitmap.isRecycled()) {
                            continue;
                        }
                        //2.保存到sd卡上面
                        File imageFile = getFileByCacheKey(cacheKey);
                        FileOutputStream os = new FileOutputStream(imageFile);
                        try {
                            savedSuccessfully = bitmap.compress(compressFormat, compressQuality, os);
                        } finally {
                            IoUtils.closeSilently(os);
                            if (!savedSuccessfully) {
                                if (imageFile.exists()) {
                                    imageFile.delete();
                                }
                            }
                        }
                    } while ((cacheKey = mQueue.poll()) != null);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mIsPoll = false;
                }
            }
        };
    }


    @Override
    public void close() {
        this.mIsDestroy = true;
        if (mQueue != null) {
            mQueue.clear();
        }
    }
}
