package com.fans.loader.core.listener;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

import com.fans.loader.FanImageLoader;


/**
 * time: 15/6/11
 * description:当控件(ListView)在滑动过程当中时暂停图片的加载，停止后恢复加载
 *
 * @author fandong
 */
public class AbsListPauseOnScrollListener implements OnScrollListener {
    private final boolean pauseOnScroll;
    private final boolean pauseOnFling;
    private final OnScrollListener externalListener;

    public AbsListPauseOnScrollListener(boolean pauseOnScroll, boolean pauseOnFling) {
        this(pauseOnScroll, pauseOnFling, null);
    }

    public AbsListPauseOnScrollListener(boolean pauseOnScroll, boolean pauseOnFling, OnScrollListener customListener) {
        this.pauseOnScroll = pauseOnScroll;
        this.pauseOnFling = pauseOnFling;
        this.externalListener = customListener;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case SCROLL_STATE_IDLE:
                FanImageLoader.resume();
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                if (this.pauseOnScroll) {
                    FanImageLoader.pause();
                }
                break;
            case SCROLL_STATE_FLING:
                if (this.pauseOnFling) {
                    FanImageLoader.pause();
                }
        }

        if (this.externalListener != null) {
            this.externalListener.onScrollStateChanged(view, scrollState);
        }

    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (this.externalListener != null) {
            this.externalListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }

    }
}
