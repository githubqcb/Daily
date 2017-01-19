package com.cins.daily.mvp.presenter.impl;

import com.cins.daily.common.Constants;
import com.cins.daily.greendao.NewsChannelTable;
import com.cins.daily.mvp.presenter.NewsChannelPresenter;
import com.cins.daily.mvp.presenter.base.BasePresenterImpl;
import com.cins.daily.mvp.view.NewsChannelView;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Eric on 2017/1/19.
 */

public class NewsChannelPresenterImpl extends BasePresenterImpl<NewsChannelView,
        Map<Integer, List<NewsChannelTable>>> implements NewsChannelPresenter {
    private NewsChannelInteractorImpl mNewsChannelInteractor;

    @Inject
    public NewsChannelPresenterImpl(NewsChannelInteractorImpl newsChannelInteractor) {
        mNewsChannelInteractor = newsChannelInteractor;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mNewsChannelInteractor.lodeNewsChannels(this);
    }

    @Override
    public void success(Map<Integer, List<NewsChannelTable>> data) {
        super.success(data);
        mView.initRecyclerViews(data.get(Constants.NEWS_CHANNEL_MINE),data.get(Constants.NEWS_CHANNEL_MORE));
    }
}