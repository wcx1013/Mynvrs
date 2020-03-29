package com.example.mynvrs.base;

import com.example.mynvrs.interfaces.IBasePersenter;
import com.example.mynvrs.interfaces.IBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePersenter<V extends IBaseView> implements IBasePersenter<V> {

    protected V mView;
    //对v 层进行弱引用
    private WeakReference<V> weakReference;
    protected CompositeDisposable compositeDisposable;
    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<>(view);
         mView =weakReference.get();
    }
    //把当前业务下的网络请求对象添加到compositeDisposable
    protected  void  addSubscribe(Disposable disposable){
        if (compositeDisposable==null){
            compositeDisposable=new CompositeDisposable();
            compositeDisposable.add(disposable);
        }
    }

    protected void unSubsoribe(){
        if (compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }

    @Override
    public void detachView() {
        this.mView=null;
    }
}
