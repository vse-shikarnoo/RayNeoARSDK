package com.rayneo.arsdk.android.ui.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(
   mv = {1, 7, 1},
   k = 3,
   xi = 48,
   d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"},
   d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$4"}
)
public final class BaseEventActivity$special$$inlined$viewModels$default$3 extends Lambda implements Function0<CreationExtras> {
   // $FF: synthetic field
   public final Function0 $extrasProducer;
   // $FF: synthetic field
   public final ComponentActivity $this_viewModels;

   public BaseEventActivity$special$$inlined$viewModels$default$3(Function0 $extrasProducer, ComponentActivity $receiver) {
      super(0);
      this.$extrasProducer = $extrasProducer;
      this.$this_viewModels = $receiver;
   }

   public final CreationExtras invoke() {
      Object var1;
      if ((var1 = this.$extrasProducer) == null || (var1 = (CreationExtras)((Function0)var1).invoke()) == null) {
         Intrinsics.checkNotNullExpressionValue(var1 = this.$this_viewModels.getDefaultViewModelCreationExtras(), "this.defaultViewModelCreationExtras");
      }

      return (CreationExtras)var1;
   }
}
