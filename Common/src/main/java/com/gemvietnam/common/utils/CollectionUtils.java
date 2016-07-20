package com.gemvietnam.common.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Collection Utils
 * Created by neo on 7/20/2016.
 */
public class CollectionUtils {

    public static void setupVerticalRecyclerView(Context context, RecyclerView mRecyclerView) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setClipToPadding(false);
        mRecyclerView.setHasFixedSize(true);
    }
}
