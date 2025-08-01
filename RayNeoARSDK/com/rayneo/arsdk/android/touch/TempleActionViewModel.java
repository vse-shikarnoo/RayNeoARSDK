package com.rayneo.arsdk.android.touch;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"},
   d2 = {"Lcom/rayneo/arsdk/android/touch/TempleActionViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_state", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "state", "Lkotlinx/coroutines/flow/SharedFlow;", "getState", "()Lkotlinx/coroutines/flow/SharedFlow;", "userTempleAction", "Lkotlinx/coroutines/channels/Channel;", "getUserTempleAction", "()Lkotlinx/coroutines/channels/Channel;", "handleIntent", "", "MercurySDK_release"}
)
public final class TempleActionViewModel extends AndroidViewModel {
   private final Channel<TempleAction> userTempleAction;
   private final MutableSharedFlow<TempleAction> _state;
   private final SharedFlow<TempleAction> state;

   public TempleActionViewModel(Application application) {
      TempleActionViewModel var10000 = this;
      TempleActionViewModel var10001 = this;
      Intrinsics.checkNotNullParameter(application, "application");
      super(application);
      this.userTempleAction = ChannelKt.Channel$default(0, (BufferOverflow)null, (Function1)null, 7, (Object)null);
      MutableSharedFlow var2;
      this._state = var2 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow)null, 7, (Object)null);
      var10001.state = FlowKt.asSharedFlow(var2);
      var10000.handleIntent();
   }

   private final void handleIntent() {
      CoroutineScope var10000 = ViewModelKt.getViewModelScope(this);
      Function2 var1;
      var1 = new Function2<CoroutineScope, Continuation<? super Unit>, Object>() {
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
               Flow var10000 = FlowKt.consumeAsFlow(TempleActionViewModel.this.getUserTempleAction());
               FlowCollector var4;
               var4 = new FlowCollector() {
                  public final Object emit(TempleAction it, Continuation<? super Unit> $completion) {
                     Object var3;
                     return (var3 = null.super._state.emit(it, $completion)) == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
                  }
               }.<init>();
               this.label = 1;
               if (var10000.collect(var4, this) == var2) {
                  return var2;
               }
            }

            return Unit.INSTANCE;
         }

         public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
            return new <anonymous constructor>($completion);
         }

         public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }.<init>((Continuation)null);
      BuildersKt.launch$default(var10000, (CoroutineContext)null, (CoroutineStart)null, var1, 3, (Object)null);
   }

   public final Channel<TempleAction> getUserTempleAction() {
      return this.userTempleAction;
   }

   public final SharedFlow<TempleAction> getState() {
      return this.state;
   }
}
