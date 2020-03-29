package com.example.mynvrs.persenter;

import com.example.mynvrs.base.BasePersenter;
import com.example.mynvrs.common.CommonSubscriber;
import com.example.mynvrs.interfaces.TopicConstract;
import com.example.mynvrs.models.HttpManager;
import com.example.mynvrs.models.bean.TopicBean;
import com.example.mynvrs.utils.RxUtils;

public class TopicPersenter extends BasePersenter<TopicConstract.View> implements TopicConstract.Persenter {
    @Override
    public void getTopicData() {
        addSubscribe(HttpManager.getInstance().getShopApi().getTopicData()
                .compose(RxUtils.<TopicBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<TopicBean>(mView){

                    @Override
                    public void onNext(TopicBean topicBean) {
                        mView.getTopicDataReturn(topicBean);
                    }
                }));
    }
}
