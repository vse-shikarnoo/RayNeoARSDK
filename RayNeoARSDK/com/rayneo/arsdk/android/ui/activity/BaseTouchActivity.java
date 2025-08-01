package com.rayneo.arsdk.android.ui.activity;

import android.view.MotionEvent;
import com.rayneo.arsdk.android.core.MotionEventDispatcher;
import com.rayneo.arsdk.android.touch.CommonTouchCallback;
import com.rayneo.arsdk.android.touch.FlingArgs;
import com.rayneo.arsdk.android.touch.TouchDispatcher;
import com.rayneo.arsdk.android.util.FLogger;
import com.rayneo.arsdk.android.util.MyTouchUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0004R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/activity/BaseTouchActivity;", "Lcom/rayneo/arsdk/android/ui/activity/BaseActivity;", "()V", "callback", "com/rayneo/arsdk/android/ui/activity/BaseTouchActivity$callback$1", "Lcom/rayneo/arsdk/android/ui/activity/BaseTouchActivity$callback$1;", "motionEventDispatcher", "Lcom/rayneo/arsdk/android/core/MotionEventDispatcher;", "getMotionEventDispatcher", "()Lcom/rayneo/arsdk/android/core/MotionEventDispatcher;", "touchDispatcher", "Lcom/rayneo/arsdk/android/touch/TouchDispatcher;", "onActionUp", "", "onClick", "", "onDoubleClick", "onLongClick", "onMoveUp", "isLongClick", "onSlideBackward", "args", "Lcom/rayneo/arsdk/android/touch/FlingArgs;", "onSlideContinuous", "delta", "", "longClick", "onSlideForward", "onTPTripleClick", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "toggleSoundEffect", "type", "", "enable", "MercurySDK_release"}
)
public class BaseTouchActivity extends BaseActivity {
   private TouchDispatcher touchDispatcher;
   private final MotionEventDispatcher motionEventDispatcher;
   private final <undefinedtype> callback;

   public BaseTouchActivity() {
      this.touchDispatcher = new TouchDispatcher(TouchDispatcher.Source.Activity.INSTANCE);
      String var10004 = this.getClass().getSimpleName();
      Intrinsics.checkNotNullExpressionValue(var10004, "this.javaClass.simpleName");
      this.motionEventDispatcher = new MotionEventDispatcher(var10004);
      this.callback = new CommonTouchCallback() {
         public boolean onTPLongClick() {
            return BaseTouchActivity.this.onLongClick();
         }

         public boolean onTPClick() {
            return BaseTouchActivity.this.onClick();
         }

         public boolean onTPDoubleClick() {
            return BaseTouchActivity.this.onDoubleClick();
         }

         public boolean onTPSlideBackward(FlingArgs args) {
            Intrinsics.checkNotNullParameter(args, "args");
            return BaseTouchActivity.this.onSlideBackward(args);
         }

         public boolean onTPSlideForward(FlingArgs args) {
            Intrinsics.checkNotNullParameter(args, "args");
            return BaseTouchActivity.this.onSlideForward(args);
         }

         public boolean onTPSlideContinuous(float delta, boolean longClick) {
            return BaseTouchActivity.this.onSlideContinuous(delta, longClick);
         }

         public boolean onTPMoveUp(boolean longClick) {
            return BaseTouchActivity.this.onMoveUp(longClick);
         }

         public void onActionUp() {
            BaseTouchActivity.this.onActionUp();
         }

         public void onTPTripleClick() {
            BaseTouchActivity.this.onTPTripleClick();
         }
      };
   }

   public final MotionEventDispatcher getMotionEventDispatcher() {
      return this.motionEventDispatcher;
   }

   public boolean onTouchEvent(MotionEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      FLogger.d("BaseTouchActivity", "onTouchEvent：x = " + event.getX() + ", y = " + event.getY() + ",action = " + BaseTouchActivityKt.actionName(event) + ", deviceId = " + event.getDeviceId() + ",deviceName = " + event.getDevice().getName() + ",downTime = " + event.getDownTime() + ",eventTime = " + event.getEventTime());
      if (MyTouchUtils.isRight(event)) {
         this.touchDispatcher.onMotionEvent(event, this.callback);
         this.motionEventDispatcher.dispatchTouchEvent(event);
      }

      return super.onTouchEvent(event);
   }

   public boolean onLongClick() {
      return false;
   }

   public boolean onClick() {
      return false;
   }

   public boolean onDoubleClick() {
      return false;
   }

   public void onTPTripleClick() {
   }

   public boolean onSlideBackward(FlingArgs args) {
      Intrinsics.checkNotNullParameter(args, "args");
      return false;
   }

   public boolean onSlideForward(FlingArgs args) {
      Intrinsics.checkNotNullParameter(args, "args");
      return false;
   }

   public void onActionUp() {
   }

   public boolean onSlideContinuous(float delta, boolean longClick) {
      return false;
   }

   public boolean onMoveUp(boolean isLongClick) {
      return false;
   }

   public final void toggleSoundEffect(int type, boolean enable) {
      this.touchDispatcher.toggleClickSoundEffect(type, enable);
   }
}
