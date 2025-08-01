package com.rayneo.arsdk.android.ui.util;

import com.rayneo.arsdk.android.focus.IFocusable;
import com.rayneo.arsdk.android.touch.TempleAction;
import com.rayneo.arsdk.android.util.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "},
   d2 = {"Lcom/rayneo/arsdk/android/ui/util/FixPosFocusTracker;", "", "focusHolder", "Lcom/rayneo/arsdk/android/ui/util/FocusHolder;", "continuous", "", "ignoreDelta", "", "(Lcom/rayneo/arsdk/android/ui/util/FocusHolder;ZI)V", "getFocusHolder", "()Lcom/rayneo/arsdk/android/ui/util/FocusHolder;", "focusObj", "Lcom/rayneo/arsdk/android/focus/IFocusable;", "getFocusObj", "()Lcom/rayneo/arsdk/android/focus/IFocusable;", "lastValidDelta", "", "onFocusChangeListener", "Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;", "getOnFocusChangeListener", "()Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;", "setOnFocusChangeListener", "(Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;)V", "continuousLogic", "", "action", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "handleFocusTargetEvent", "onInternalActionUp", "onInternalSlideContinuous", "delta", "oneStepLogic", "MercurySDK_release"}
)
public final class FixPosFocusTracker {
   private final FocusHolder focusHolder;
   private final boolean continuous;
   private final int ignoreDelta;
   private float lastValidDelta;
   private OnTrackerFocusChangeListener onFocusChangeListener;
   private final IFocusable focusObj;

   public FixPosFocusTracker(FocusHolder focusHolder, boolean continuous, int ignoreDelta) {
      Intrinsics.checkNotNullParameter(focusHolder, "focusHolder");
      super();
      this.focusHolder = focusHolder;
      this.continuous = continuous;
      this.ignoreDelta = ignoreDelta;
      IFocusable focusHolder1;
      focusHolder1 = new IFocusable() {
         private boolean hasFocus;
         private IFocusable focusParent;

         public boolean getHasFocus() {
            return this.hasFocus;
         }

         public void setHasFocus(boolean value) {
            boolean var2;
            if (this.hasFocus != value) {
               var2 = true;
            } else {
               var2 = false;
            }

            if (var2) {
               this.hasFocus = value;
            }

            OnTrackerFocusChangeListener var3;
            if (var2 && (var3 = FixPosFocusTracker.this.getOnFocusChangeListener()) != null) {
               var3.onFocusChange(value);
            }

         }

         public IFocusable getFocusParent() {
            return this.focusParent;
         }

         public void setFocusParent(IFocusable var1) {
            this.focusParent = var1;
         }
      }.<init>();
      this.focusObj = focusHolder1;
   }

   // $FF: synthetic method
   public FixPosFocusTracker(FocusHolder var1, boolean var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = true;
      }

      if ((var4 & 4) != 0) {
         var3 = 50;
      }

      this(var1, var2, var3);
   }

   private final void continuousLogic(TempleAction action) {
      if (action instanceof TempleAction.SlideContinuous) {
         this.onInternalSlideContinuous(((TempleAction.SlideContinuous)action).getDelta());
      } else if (action instanceof TempleAction.ActionUp) {
         this.onInternalActionUp();
      } else {
         this.focusHolder.getCurrentFocusItem().getEventHandler().invoke(action);
      }

   }

   private final void oneStepLogic(TempleAction action) {
      if (action instanceof TempleAction.SlideForward) {
         this.focusHolder.next();
      } else if (action instanceof TempleAction.SlideBackward) {
         this.focusHolder.previous();
      } else {
         this.focusHolder.getCurrentFocusItem().getEventHandler().invoke(action);
      }

   }

   private final void onInternalSlideContinuous(float delta) {
      float var2;
      int var3;
      if ((var2 = delta - this.lastValidDelta) > (float)(var3 = this.ignoreDelta)) {
         FLogger.d("next");
         this.focusHolder.next();
         this.lastValidDelta = delta;
      } else if (var2 < (float)(-var3)) {
         this.focusHolder.previous();
         FLogger.d("previous");
         this.lastValidDelta = delta;
      }

   }

   private final void onInternalActionUp() {
      this.lastValidDelta = 0.0F;
   }

   public final FocusHolder getFocusHolder() {
      return this.focusHolder;
   }

   public final OnTrackerFocusChangeListener getOnFocusChangeListener() {
      return this.onFocusChangeListener;
   }

   public final void setOnFocusChangeListener(OnTrackerFocusChangeListener var1) {
      this.onFocusChangeListener = var1;
   }

   public final IFocusable getFocusObj() {
      return this.focusObj;
   }

   public final void handleFocusTargetEvent(TempleAction action) {
      Intrinsics.checkNotNullParameter(action, "action");
      if (this.focusObj.getHasFocus()) {
         if (this.continuous) {
            this.continuousLogic(action);
         } else {
            this.oneStepLogic(action);
         }

      }
   }
}
