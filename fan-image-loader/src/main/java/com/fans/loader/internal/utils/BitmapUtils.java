package com.fans.loader.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * time: 2015/10/14
 * description:
 *
 * @author fandong
 */
public class BitmapUtils {
    /**
     * 根据一张图片的输入流和显示视图的宽高，返回指定宽高的bitmap
     *
     * @param is     原始的图片数据
     * @param width  目标宽度
     * @param height 目标高度
     * @return 指定尺寸的位图
     */
    public static Bitmap createScaledBitmap(InputStream is, int width, int height) {
        try {
            //1.加到一个byte数组当中
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            IoUtils.copyStream(is, bos, null);
            byte[] buffer = bos.toByteArray();
            bos.close();
            is.close();
            //2.计算宽高
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(buffer, 0, buffer.length, options);
            float width_ratio = options.outWidth / (float) width;
            float height_ratio = options.outHeight / (float) height;
            int ratio = (int) (width_ratio > height_ratio ? width_ratio : height_ratio);
            ratio = ratio > 1 ? ratio : 1;
            //3.decode
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = ratio;
            return BitmapFactory.decodeByteArray(buffer, 0, buffer.length, options);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OutOfMemoryError error) {
            error.printStackTrace();
        }
        return null;
    }
}
