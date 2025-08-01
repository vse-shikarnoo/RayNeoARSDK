package com.rayneo.arsdk.android.core;

import android.view.MotionEvent;
import com.rayneo.arsdk.android.util.FLogger;
import com.rayneo.arsdk.android.util.MyTouchUtils;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"},
   d2 = {"Lcom/rayneo/arsdk/android/core/MotionEventDispatcher;", "", "source", "", "(Ljava/lang/String;)V", "eventReceiverList", "Ljava/util/HashSet;", "Lcom/rayneo/arsdk/android/core/EventReceiver;", "Lkotlin/collections/HashSet;", "addEventReceiver", "", "eventReceiver", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "iSystemActionGlassLeg", "", "removeEventReceiver", "MercurySDK_release"}
)
public final class MotionEventDispatcher {
   private final String source;
   private final HashSet<EventReceiver> eventReceiverList;

   public MotionEventDispatcher(String source) {
      MotionEventDispatcher var10000 = this;
      Intrinsics.checkNotNullParameter(source, "source");
      super();
      this.source = source;
      HashSet var2;
      var2 = new HashSet.<init>();
      var10000.eventReceiverList = var2;
   }

   public final void addEventReceiver(EventReceiver eventReceiver) {
      Intrinsics.checkNotNullParameter(eventReceiver, "eventReceiver");
      FLogger.d(this.source, "addEventReceiver");
      this.eventReceiverList.add(eventReceiver);
   }

   public final void removeEventReceiver(EventReceiver eventReceiver) {
      Intrinsics.checkNotNullParameter(eventReceiver, "eventReceiver");
      FLogger.d(this.source, "removeEventReceiver");
      this.eventReceiverList.remove(eventReceiver);
   }

   public final boolean iSystemActionGlassLeg(MotionEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      return MyTouchUtils.isLeft(event);
   }

   public final void dispatchTouchEvent(MotionEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Iterator var2 = this.eventReceiverList.iterator();

      while(var2.hasNext()) {
         ((EventReceiver)var2.next()).onReceiveEvent(event);
      }

   }
}
