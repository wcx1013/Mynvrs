package com.example.mynvrs.interfaces;

import com.example.mynvrs.models.bean.TopicBean;

public interface TopicConstract {
    interface View extends IBaseView{
        void getTopicDataReturn(TopicBean result);
    }
    interface Persenter extends IBasePersenter<View>{
        void getTopicData();
    }















}
