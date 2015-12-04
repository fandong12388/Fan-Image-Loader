package com.fans.fanimageloader;

import android.app.Application;
import android.os.Environment;

import com.fans.loader.FanImageLoader;

import java.io.File;

/**
 * time: 2015/12/4
 * description:
 *
 * @author fandong
 */
public class FanApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ImageLoader
        FanImageLoader.init(this, getCacheDirPath());
    }

    private String getCacheDirPath() {
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/fan_image_loader/";
        File file = new File(dirPath);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
