package com.fans.loader.core.display;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;

import com.fans.loader.internal.core.assist.LoadedFrom;
import com.fans.loader.internal.core.imageaware.ImageAware;


/**
 * time: 15/6/11
 * description:高斯模糊+淡入显示
 *
 * @author fandong
 */
public class BlurFadeInBitmapDisplayer extends BlurBitmapDisplayer {
    private final int durationMillis;
    private final boolean animateFromNetwork;
    private final boolean animateFromDisk;
    private final boolean animateFromMemory;

    public BlurFadeInBitmapDisplayer(int depth, int durationMillis) {
        this(depth, durationMillis, true, true, true);
    }

    public BlurFadeInBitmapDisplayer(int depth, int durationMillis, boolean animateFromNetwork,
                                     boolean animateFromDisk, boolean animateFromMemory) {
        super(depth);
        this.durationMillis = durationMillis;
        this.animateFromNetwork = animateFromNetwork;
        this.animateFromDisk = animateFromDisk;
        this.animateFromMemory = animateFromMemory;
    }

    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        super.display(bitmap, imageAware, loadedFrom);
        if (this.animateFromNetwork && loadedFrom == LoadedFrom.NETWORK || this.animateFromDisk
                && loadedFrom == LoadedFrom.DISC_CACHE || this.animateFromMemory
                && loadedFrom == LoadedFrom.MEMORY_CACHE) {
            animate(imageAware.getWrappedView(), this.durationMillis);
        }

    }

    public static void animate(View imageView, int durationMillis) {
        if (imageView != null) {
            AlphaAnimation fadeImage = new AlphaAnimation(0.0F, 1.0F);
            fadeImage.setDuration((long) durationMillis);
            fadeImage.setInterpolator(new DecelerateInterpolator());
            imageView.startAnimation(fadeImage);
        }

    }
}
