package com.rayneo.arsdk.android.core;

import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"},
   d2 = {"Lcom/rayneo/arsdk/android/core/EventReceiver;", "", "onReceiveEvent", "", "event", "Landroid/view/MotionEvent;", "MercurySDK_release"}
)
public interface EventReceiver {
   void onReceiveEvent(MotionEvent var1);
}
