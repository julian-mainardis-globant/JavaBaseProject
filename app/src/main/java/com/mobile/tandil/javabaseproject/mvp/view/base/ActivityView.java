package com.mobile.tandil.javabaseproject.mvp.view.base;

import android.app.Activity;

import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

public class ActivityView {
    private WeakReference<Activity> activityRef;

    public ActivityView(Activity activity) {
        activityRef = new WeakReference<>(activity);
    }

    @Nullable
    public Activity getActivity() { return activityRef.get(); }
}