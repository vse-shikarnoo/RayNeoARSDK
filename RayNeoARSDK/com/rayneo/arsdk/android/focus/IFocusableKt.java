package com.rayneo.arsdk.android.focus;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¨\u0006\u0005"},
   d2 = {"releaseFocus", "", "Lcom/rayneo/arsdk/android/focus/IFocusable;", "reqFocus", "parent", "MercurySDK_release"}
)
public final class IFocusableKt {
   public static final void reqFocus(IFocusable $this$reqFocus, IFocusable parent) {
      Intrinsics.checkNotNullParameter($this$reqFocus, "<this>");
      $this$reqFocus.setHasFocus(true);
      if (parent != null) {
         $this$reqFocus.setFocusParent(parent);
      }

   }

   // $FF: synthetic method
   public static void reqFocus$default(IFocusable var0, IFocusable var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = null;
      }

      reqFocus(var0, var1);
   }

   public static final void releaseFocus(IFocusable $this$releaseFocus) {
      Intrinsics.checkNotNullParameter($this$releaseFocus, "<this>");
      $this$releaseFocus.setHasFocus(false);
      if (($this$releaseFocus = $this$releaseFocus.getFocusParent()) != null) {
         reqFocus$default($this$releaseFocus, (IFocusable)null, 1, (Object)null);
      }

   }
}
