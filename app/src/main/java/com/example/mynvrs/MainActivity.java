package com.example.mynvrs;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.example.mynvrs.adapter.TopicAdapter;
import com.example.mynvrs.base.BaseActivity;
import com.example.mynvrs.interfaces.TopicConstract;
import com.example.mynvrs.models.bean.TopicBean;
import com.example.mynvrs.persenter.TopicPersenter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;

public class MainActivity extends BaseActivity<TopicConstract.Persenter> implements TopicConstract.View {


    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.headLayout)
    RelativeLayout headLayout;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.recyc)
    RecyclerView recyc;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    private static final int scrollFlag0 = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL;
    private static final int scrollFlag1 = AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED;
    private int tabHeight;
    private int appBarHeight;
    private int slideDistance;
    private TopicAdapter topicAdapter;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

//        setPageTitle("协调者布局");
//        setBackIV();
//        openBT.setText("展开");
//        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.THEME_BLUE));
//        refreshLayout.setOnRefreshListener(this);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if (i <= 8) {
                tab.addTab(tab.newTab());
                tab.getTabAt(i).setText("tab" + i);
            }
            stringList.add(String.valueOf(i));
        }
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        ArrayList<TopicBean> topicBeans = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyc.setLayoutManager(linearLayoutManager);
        recyc.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        topicAdapter = new TopicAdapter(topicBeans, this);
        recyc.setAdapter(topicAdapter);

//        tabHeight = getResources().getDimensionPixelSize(R.dimen.tabHeight);
//        appBarHeight = getResources().getDimensionPixelOffset(R.dimen.appBarHeight);
//        slideDistance = appBarHeight - tabHeight;
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (-1 * slideDistance == verticalOffset) {
//                    View child = appBarLayout.getChildAt(0);
//                    AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) child.getLayoutParams();
//                    layoutParams.setScrollFlags(0);//禁止滑动
//                    child.setLayoutParams(layoutParams);
//
//                    ViewGroup.LayoutParams appBarLP = appBarLayout.getLayoutParams();
//                    appBarLP.height = tabHeight;//直接设置高度为tabLayout的高度
//                    appBarLayout.setLayoutParams(appBarLP);
//                    headLayout.setVisibility(View.GONE);
////                    openBT.setVisibility(View.VISIBLE);
//                }
//            }
//        });
    }

    @Override
    protected void initData() {
        persenter.getTopicData();
    }

    @Override
    protected TopicConstract.Persenter createPersenter() {
        return new TopicPersenter();
    }

    @Override
    public void getTopicDataReturn(TopicBean result) {
        topicAdapter.updata(result.getData().getTopicList());
    }

//    @OnClick(R.id.btn1_header1_save)
//    public void onViewClicked() {
//        View child = appBarLayout.getChildAt(0);
//        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) child.getLayoutParams();
//        layoutParams.setScrollFlags(scrollFlag0 | scrollFlag1);//恢复滑动
//        child.setLayoutParams(layoutParams);
//
//        ViewGroup.LayoutParams appBarLP = appBarLayout.getLayoutParams();
//        appBarLP.height = appBarHeight;//恢复appBar的高度
//        appBarLayout.setLayoutParams(appBarLP);
//        headLayout.setVisibility(View.VISIBLE);
//        openBT.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void onRefresh() {
//        Global.getHandler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                refreshLayout.setRefreshing(false);
//                Global.showToast("刷新成功！");
//            }
//        }, 2000);
//    }


}
