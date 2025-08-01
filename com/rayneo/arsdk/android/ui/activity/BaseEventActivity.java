package com.rayneo.arsdk.android.ui.activity;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.rayneo.arsdk.android.touch.FlingArgs;
import com.rayneo.arsdk.android.touch.TempleAction;
import com.rayneo.arsdk.android.touch.TempleActionViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\nH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/activity/BaseEventActivity;", "Lcom/rayneo/arsdk/android/ui/activity/BaseTouchActivity;", "()V", "templeActionViewModel", "Lcom/rayneo/arsdk/android/touch/TempleActionViewModel;", "getTempleActionViewModel", "()Lcom/rayneo/arsdk/android/touch/TempleActionViewModel;", "templeActionViewModel$delegate", "Lkotlin/Lazy;", "mappingAction", "", "action", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "onActionUp", "onClick", "", "onDoubleClick", "onLongClick", "onMoveUp", "isLongClick", "onSlideBackward", "args", "Lcom/rayneo/arsdk/android/touch/FlingArgs;", "onSlideContinuous", "delta", "", "longClick", "onSlideForward", "onTPTripleClick", "MercurySDK_release"}
)
public abstract class BaseEventActivity extends BaseTouchActivity {
   private final Lazy templeActionViewModel$delegate;

   public BaseEventActivity() {
      BaseEventActivity$special$$inlined$viewModels$default$1 var1;
      var1 = new BaseEventActivity$special$$inlined$viewModels$default$1.<init>(this);
      ViewModelLazy var2;
      ViewModelLazy var10001 = var2 = new ViewModelLazy;
      KClass var3 = Reflection.getOrCreateKotlinClass(TempleActionViewModel.class);
      BaseEventActivity$special$$inlined$viewModels$default$2 var4;
      var4 = new BaseEventActivity$special$$inlined$viewModels$default$2.<init>(this);
      BaseEventActivity$special$$inlined$viewModels$default$3 var5;
      var5 = new BaseEventActivity$special$$inlined$viewModels$default$3.<init>((Function0)null, this);
      var10001.<init>(var3, var4, var1, var5);
      this.templeActionViewModel$delegate = var2;
   }

   private final void mappingAction(final TempleAction action) {
      LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation)null) {
         public int label;

         public final Object invokeSuspend(Object var1) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var3;
            if ((var3 = this.label) != 0) {
               if (var3 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Channel var10000 = BaseEventActivity.this.getTempleActionViewModel().getUserTempleAction();
               TempleAction var4 = action;
               this.label = 1;
               if (var10000.send(var4, this) == var2) {
                  return var2;
               }
            }

            return Unit.INSTANCE;
         }

         public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
            <undefinedtype> var10002 = this;
            BaseEventActivity var3 = BaseEventActivity.this;
            return new <anonymous constructor>($completion);
         }

         public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      });
   }

   public final TempleActionViewModel getTempleActionViewModel() {
      return (TempleActionViewModel)this.templeActionViewModel$delegate.getValue();
   }

   public final boolean onLongClick() {
      BaseEventActivity var10000 = this;
      TempleAction.LongClick var1;
      var1 = new TempleAction.LongClick.<init>(false, 0L, 3, (DefaultConstructorMarker)null);
      var10000.mappingAction(var1);
      return false;
   }

   public final boolean onClick() {
      BaseEventActivity var10000 = this;
      TempleAction.Click var1;
      var1 = new TempleAction.Click.<init>(false, 0L, 3, (DefaultConstructorMarker)null);
      var10000.mappingAction(var1);
      return false;
   }

   public final boolean onDoubleClick() {
      BaseEventActivity var10000 = this;
      TempleAction.DoubleClick var1;
      var1 = new TempleAction.DoubleClick.<init>(false, 0L, 3, (DefaultConstructorMarker)null);
      var10000.mappingAction(var1);
      return false;
   }

   public final boolean onSlideBackward(FlingArgs args) {
      BaseEventActivity var10000 = this;
      Intrinsics.checkNotNullParameter(args, "args");
      TempleAction.SlideBackward var2;
      var2 = new TempleAction.SlideBackward.<init>(args, false, 0L, 6, (DefaultConstructorMarker)null);
      var10000.mappingAction(var2);
      return false;
   }

   public final boolean onSlideForward(FlingArgs args) {
      BaseEventActivity var10000 = this;
      Intrinsics.checkNotNullParameter(args, "args");
      TempleAction.SlideForward var2;
      var2 = new TempleAction.SlideForward.<init>(args, false, 0L, 6, (DefaultConstructorMarker)null);
      var10000.mappingAction(var2);
      return false;
   }

   public final boolean onSlideContinuous(float delta, boolean longClick) {
      BaseEventActivity var10000 = this;
      TempleAction.SlideContinuous var3;
      var3 = new TempleAction.SlideContinuous.<init>(delta, longClick, 0L, 4, (DefaultConstructorMarker)null);
      var10000.mappingAction(var3);
      return false;
   }

   public final boolean onMoveUp(boolean isLongClick) {
      BaseEventActivity var10000 = this;
      TempleAction.MoveUp var2;
      var2 = new TempleAction.MoveUp.<init>(isLongClick, 0L, 2, (DefaultConstructorMarker)null);
      var10000.mappingAction(var2);
      return false;
   }

   public final void onTPTripleClick() {
      BaseEventActivity var10000 = this;
      TempleAction.TripleClick var1;
      var1 = new TempleAction.TripleClick.<init>(false, 0L, 3, (DefaultConstructorMarker)null);
      var10000.mappingAction(var1);
   }

   public void onActionUp() {
      BaseEventActivity var10000 = this;
      super.onActionUp();
      TempleAction.ActionUp var1;
      var1 = new TempleAction.ActionUp.<init>(0L, 1, (DefaultConstructorMarker)null);
      var10000.mappingAction(var1);
   }
}
