package com.example.mynvrs.base;

import android.os.Bundle;
import android.util.Log;

import com.example.mynvrs.interfaces.IBasePersenter;
import com.example.mynvrs.interfaces.IBaseView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

//定义Activity的基类，用来实现Activity的基础功能
//1.应该包含用来处理网络数据逻辑的P层
//2.具备界面初始化的方法initViewBaseActivity()
//3.具备数据初始化的方法initData()
//4.获取当前电视的xml布局页面
//5.生命周期结束时解绑P层关联
public abstract class BaseActivity<P extends IBasePersenter> extends
        AppCompatActivity implements IBaseView {
    public P persenter;
     Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        initView();
        persenter=createPersenter();
        if(persenter!=null){
            persenter.attachView(this);
        }
        initData();
    }


    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract P createPersenter();
    @Override
    public void showError(String str) {
        Log.i("shibai",str);
    }

    //在界面移除的时候解绑P层和V 层，以及ButterKnife

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(persenter!=null){
            persenter.detachView();
        }
        if(unbinder!=null){
            unbinder.unbind();
        }
    }
}
