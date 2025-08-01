package com.rayneo.arsdk.android.touch;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016¨\u0006\u0016"},
   d2 = {"Lcom/rayneo/arsdk/android/touch/CommonTouchCallback;", "", "()V", "onActionUp", "", "onKeyLongPinch", "onKeyPinch", "onTPClick", "", "onTPDoubleClick", "onTPLongClick", "onTPMoveUp", "longClick", "onTPSlideBackward", "args", "Lcom/rayneo/arsdk/android/touch/FlingArgs;", "onTPSlideContinuous", "delta", "", "onTPSlideForward", "onTPTripleClick", "Companion", "MercurySDK_release"}
)
public abstract class CommonTouchCallback {
   public static final CommonTouchCallback.Companion Companion = new CommonTouchCallback.Companion((DefaultConstructorMarker)null);
   public static final int COMMON_TP_CLICK = 0;
   public static final int COMMON_LONG_PINCH = 3;
   public static final int COMMON_PINCH = 4;

   // $FF: synthetic method
   public static boolean onTPSlideContinuous$default(CommonTouchCallback var0, float var1, boolean var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         return var0.onTPSlideContinuous(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTPSlideContinuous");
      }
   }

   public boolean onTPLongClick() {
      return false;
   }

   public boolean onTPClick() {
      return false;
   }

   public boolean onTPDoubleClick() {
      return false;
   }

   public void onTPTripleClick() {
   }

   public boolean onTPSlideBackward(FlingArgs args) {
      Intrinsics.checkNotNullParameter(args, "args");
      return false;
   }

   public boolean onTPSlideForward(FlingArgs args) {
      Intrinsics.checkNotNullParameter(args, "args");
      return false;
   }

   public boolean onTPSlideContinuous(float delta, boolean longClick) {
      return false;
   }

   public boolean onTPMoveUp(boolean longClick) {
      return false;
   }

   public void onActionUp() {
   }

   public void onKeyPinch() {
   }

   public void onKeyLongPinch() {
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/CommonTouchCallback$Companion;", "", "()V", "COMMON_LONG_PINCH", "", "COMMON_PINCH", "COMMON_TP_CLICK", "MercurySDK_release"}
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
