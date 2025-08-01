package com.rayneo.arsdk.android.ui.activity;

import android.view.MotionEvent;
import com.rayneo.arsdk.android.touch.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 2,
   xi = 48,
   d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"},
   d2 = {"actionName", "", "Landroid/view/MotionEvent;", "MercurySDK_release"}
)
public final class BaseTouchActivityKt {
   public static final String actionName(MotionEvent $this$actionName) {
      Intrinsics.checkNotNullParameter($this$actionName, "<this>");
      String var10000;
      switch($this$actionName.getAction()) {
      case 0:
         var10000 = "ACTION_DOWN";
         break;
      case 1:
         var10000 = "ACTION_UP";
         break;
      case 2:
         var10000 = "ACTION_MOVE";
         break;
      case 3:
         var10000 = "ACTION_CANCEL";
         break;
      case 4:
         var10000 = "ACTION_OUTSIDE";
         break;
      default:
         var10000 = a.a("Action_").append($this$actionName.getAction()).toString();
      }

      return var10000;
   }
}
