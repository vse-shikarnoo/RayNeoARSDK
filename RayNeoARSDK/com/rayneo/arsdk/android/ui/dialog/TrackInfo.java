package com.rayneo.arsdk.android.ui.dialog;

import android.content.DialogInterface;
import com.rayneo.arsdk.android.touch.TempleAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001Br\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00126\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0019\u001a\u00020\u000bJ\u0006\u0010\u001a\u001a\u00020\u000bRA\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R)\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/dialog/TrackInfo;", "", "target", "eventHandler", "Lkotlin/Function2;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "Lkotlin/ParameterName;", "name", "action", "Landroid/content/DialogInterface;", "dialog", "", "focusChangeHandler", "Lkotlin/Function1;", "", "hasFocus", "isSelected", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Z)V", "getEventHandler", "()Lkotlin/jvm/functions/Function2;", "()Z", "setSelected", "(Z)V", "getTarget", "()Ljava/lang/Object;", "fetchFocus", "releaseFocus", "MercurySDK_release"}
)
public final class TrackInfo {
   private final Object target;
   private final Function2<TempleAction, DialogInterface, Unit> eventHandler;
   private final Function1<Boolean, Unit> focusChangeHandler;
   private boolean isSelected;

   public TrackInfo(Object target, Function2<? super TempleAction, ? super DialogInterface, Unit> eventHandler, Function1<? super Boolean, Unit> focusChangeHandler, boolean isSelected) {
      Intrinsics.checkNotNullParameter(target, "target");
      Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
      Intrinsics.checkNotNullParameter(focusChangeHandler, "focusChangeHandler");
      super();
      this.target = target;
      this.eventHandler = eventHandler;
      this.focusChangeHandler = focusChangeHandler;
      this.isSelected = isSelected;
   }

   // $FF: synthetic method
   public TrackInfo(Object var1, Function2 var2, Function1 var3, boolean var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = false;
      }

      this(var1, var2, var3, var4);
   }

   public final Object getTarget() {
      return this.target;
   }

   public final Function2<TempleAction, DialogInterface, Unit> getEventHandler() {
      return this.eventHandler;
   }

   public final boolean isSelected() {
      return this.isSelected;
   }

   public final void setSelected(boolean var1) {
      this.isSelected = var1;
   }

   public final void fetchFocus() {
      this.focusChangeHandler.invoke(Boolean.TRUE);
   }

   public final void releaseFocus() {
      this.focusChangeHandler.invoke(Boolean.FALSE);
   }
}
