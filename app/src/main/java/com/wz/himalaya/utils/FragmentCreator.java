package com.wz.himalaya.utils;

import com.wz.himalaya.base.BaseFragement;
import com.wz.himalaya.fragments.HistoryFragment;
import com.wz.himalaya.fragments.RecommendFragment;
import com.wz.himalaya.fragments.SubscriptionFragment;

import java.util.HashMap;
import java.util.Map;

public class FragmentCreator {
    public final static int INDEX_RECOMMEND = 0;
    public final static int INDEX_SUBSCRIPTION = 1;
    public final static int INDEX_HISTORY = 2;
    public final static int PAGE_COUNT = 3;
    private static Map<Integer, BaseFragement> sCache = new HashMap<>();

    public static BaseFragement getFragment(int index){
        BaseFragement baseFragement = sCache.get(index);
        if (baseFragement != null){
            return baseFragement;
        }
        switch (index){
            case INDEX_RECOMMEND:
                baseFragement = new RecommendFragment();
                break;
            case INDEX_SUBSCRIPTION:
                baseFragement = new SubscriptionFragment();
                break;
            case INDEX_HISTORY:
                baseFragement = new HistoryFragment();
                break;
        }
        sCache.put(index,baseFragement);
        return baseFragement;
    }
}
