package com.fans.fanimageloader;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.fans.loader.core.listener.RecyclerPauseOnScrollListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.recycler_view)
    public RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.得到控件
        ButterKnife.inject(this);
        //2.初始化recyclerView
        initRecyclerView();
        //3.设置数据
        MyAdapter adapter = new MyAdapter(this);
        mRecyclerView.setAdapter(adapter);
    }


    private void initRecyclerView() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(null);
        mRecyclerView.addOnScrollListener(new RecyclerPauseOnScrollListener(true, true));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                //这里的间距跟RecPictureItemView.java的MARGIN字段保持2被关系
                int position = parent.getChildAdapterPosition(view);
                int margin = (int) getResources().getDimension(R.dimen.recycler_item_margin);
                int top = 0;
                if (position == 0 || position == 1) {
                    top = margin;
                }
                outRect.set(0, top, 0, (int) getResources().getDimension(R.dimen.recycler_item_margin));
            }
        });
    }
}
