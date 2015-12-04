package com.fans.fanimageloader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fans.loader.FanImageLoader;
import com.fans.loader.view.FanImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * time: 2015/12/4
 * description:适配器
 *
 * @author fandong
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private float mItemWidth;

    private List<String> urls = new ArrayList<String>() {{
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
        add("http://a.hiphotos.baidu.com/zhidao/pic/item/78310a55b319ebc46fae62e08126cffc1f1716f0.jpg");
    }};

    public MyAdapter(Context context) {
        this.mContext = context;
        this.mItemWidth = (context.getResources().getDisplayMetrics().widthPixels -
                (context.getResources().getDimension(R.dimen.recycler_item_padding) * 2
                        + context.getResources().getDimension(R.dimen.recycler_item_padding) * 4)) / 2.f;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new ViewHolder(inflater.inflate(R.layout.vw_recycler_item, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //1.重置视图的高度,这一步可以通过自定义View，在onMeasure里面做成方图
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) holder.fanImageView.getLayoutParams();
        params.height = (int) mItemWidth;
        params.width = (int) mItemWidth;
        LinearLayout.LayoutParams ivParams = (LinearLayout.LayoutParams) holder.imageView.getLayoutParams();
        ivParams.height = (int) mItemWidth;
        ivParams.width = (int) mItemWidth;
        //2.进行显示
        if (0 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_DEFAULT)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_DEFAULT)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .into(holder.fanImageView);
        } else if (1 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_FADE_IN)
                    .setFadeInTime(1000)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setFadeInTime(1000)
                    .setDisplayType(FanImageLoader.DISPLAY_FADE_IN)
                    .into(holder.fanImageView);
        } else if (2 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setRoundRadius(36)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setRoundRadius(36)
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_DEFAULT)
                    .into(holder.fanImageView);
        } else if (3 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND_FADE_IN)
                    .setRoundRadius(36)
                    .setFadeInTime(1000)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND_FADE_IN)
                    .setRoundRadius(36)
                    .setFadeInTime(1000)
                    .into(holder.fanImageView);
        } else if (4 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND_VIGNETTE)
                    .setRoundRadius(36)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND_VIGNETTE)
                    .setRoundRadius(36)
                    .into(holder.fanImageView);
        } else if (5 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND_VIGNETTE_FADE_IN)
                    .setRoundRadius(36)
                    .setFadeInTime(1000)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND_VIGNETTE_FADE_IN)
                    .setRoundRadius(36)
                    .setFadeInTime(1000)
                    .into(holder.fanImageView);
        } else if (6 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_CIRCLE)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_CIRCLE)
                    .into(holder.fanImageView);
        } else if (7 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_CIRCLE_FADE_IN)
                    .setFadeInTime(1000)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_CIRCLE_FADE_IN)
                    .setFadeInTime(1000)
                    .into(holder.fanImageView);
        } else if (8 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_CIRCLE_RING)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setStrokeWidth(5.f)
                    .setRingColor(0xff00ff00)
                    .setRingPadding(5.f)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_CIRCLE_RING)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setStrokeWidth(5.f)
                    .setRingColor(0xff00ff00)
                    .setRingPadding(5.f)
                    .into(holder.fanImageView);
        } else if (9 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_BLUR)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setBlurDepth(10)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setBlurDepth(10)
                    .setDisplayType(FanImageLoader.DISPLAY_DEFAULT)
                    .into(holder.fanImageView);
        } else if (10 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_BLUR_FADE_IN)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setBlurDepth(10)
                    .setFadeInTime(1000)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setBlurDepth(10)
                    .setFadeInTime(1000)
                    .setDisplayType(FanImageLoader.DISPLAY_DEFAULT)
                    .into(holder.fanImageView);
        } else if (11 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND_BLUR)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setRoundRadius(6)
                    .setBlurDepth(10)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND_BLUR)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setRoundRadius(6)
                    .setBlurDepth(10)
                    .into(holder.fanImageView);
        } else if (12 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND_BLUR_VIGNETTE)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setRoundRadius(36)
                    .setBlurDepth(10)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_ROUND_BLUR_VIGNETTE)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setRoundRadius(36)
                    .setBlurDepth(10)
                    .into(holder.fanImageView);
        } else if (13 == position) {
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_CIRCLE_BLUR)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setBlurDepth(10)
                    .into(holder.imageView);
            FanImageLoader.create(urls.get(position))
                    .setShowSize((int) mItemWidth, (int) mItemWidth)
                    .setDisplayType(FanImageLoader.DISPLAY_CIRCLE_BLUR)
                    .setDefaultRes(R.drawable.ic_launcher)
                    .setFailRes(R.drawable.ic_launcher)
                    .setEmptyRes(R.drawable.ic_launcher)
                    .setBlurDepth(10)
                    .into(holder.fanImageView);
        }


    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.fan_image_view)
        FanImageView fanImageView;
        @InjectView(R.id.iv)
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
