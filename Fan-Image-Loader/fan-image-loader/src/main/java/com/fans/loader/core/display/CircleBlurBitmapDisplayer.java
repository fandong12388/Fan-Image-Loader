package com.fans.loader.core.display;

import android.graphics.Bitmap;

import com.fans.loader.core.util.GaussianBlur;
import com.fans.loader.internal.core.assist.LoadedFrom;
import com.fans.loader.internal.core.imageaware.ImageAware;


/**
 * time: 15/6/11
 * description:经过高斯模糊之后的圆形图片
 *
 * @author fandong
 */
public class CircleBlurBitmapDisplayer extends CircleBitmapDisplayer {
    private final int depth;

    public CircleBlurBitmapDisplayer(int depth) {
        this.depth = depth;
    }

    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        GaussianBlur blurProcess = new GaussianBlur();
        Bitmap blurBitmap = blurProcess.blur(bitmap, (float) this.depth);
//Bitmap blurBitmap = BlurUtil.blurBitmap(bitmap, depth);
        if (blurBitmap != null && !blurBitmap.isRecycled()) {
            imageAware.setImageDrawable(new CircleDrawable(blurBitmap));
        }

    }
}
