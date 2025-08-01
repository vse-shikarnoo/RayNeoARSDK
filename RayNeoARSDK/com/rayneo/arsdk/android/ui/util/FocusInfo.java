package com.rayneo.arsdk.android.ui.util;

import com.rayneo.arsdk.android.touch.TempleAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0002\u0010\rJ\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\tR,\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/util/FocusInfo;", "", "target", "eventHandler", "Lkotlin/Function1;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "Lkotlin/ParameterName;", "name", "action", "", "focusChangeHandler", "", "hasFocus", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getEventHandler", "()Lkotlin/jvm/functions/Function1;", "getTarget", "()Ljava/lang/Object;", "fetchFocus", "releaseFocus", "MercurySDK_release"}
)
public final class FocusInfo {
   private final Object target;
   private final Function1<TempleAction, Unit> eventHandler;
   private final Function1<Boolean, Unit> focusChangeHandler;

   public FocusInfo(Object target, Function1<? super TempleAction, Unit> eventHandler, Function1<? super Boolean, Unit> focusChangeHandler) {
      Intrinsics.checkNotNullParameter(target, "target");
      Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
      Intrinsics.checkNotNullParameter(focusChangeHandler, "focusChangeHandler");
      super();
      this.target = target;
      this.eventHandler = eventHandler;
      this.focusChangeHandler = focusChangeHandler;
   }

   public final Object getTarget() {
      return this.target;
   }

   public final Function1<TempleAction, Unit> getEventHandler() {
      return this.eventHandler;
   }

   public final void fetchFocus() {
      this.focusChangeHandler.invoke(Boolean.TRUE);
   }

   public final void releaseFocus() {
      this.focusChangeHandler.invoke(Boolean.FALSE);
   }
}
