package com.rayneo.arsdk.android.touch;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"},
   d2 = {"Lcom/rayneo/arsdk/android/touch/CommonTouchCallbackMapping;", "Lcom/rayneo/arsdk/android/touch/CommonTouchCallback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tag", "", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)V", "_sharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "action", "Lkotlinx/coroutines/flow/SharedFlow;", "getAction", "()Lkotlinx/coroutines/flow/SharedFlow;", "mappingAction", "", "onActionUp", "onKeyLongPinch", "onKeyPinch", "onTPClick", "", "onTPDoubleClick", "onTPLongClick", "onTPMoveUp", "longClick", "onTPSlideBackward", "args", "Lcom/rayneo/arsdk/android/touch/FlingArgs;", "onTPSlideContinuous", "delta", "", "onTPSlideForward", "onTPTripleClick", "MercurySDK_release"}
)
public final class CommonTouchCallbackMapping extends CommonTouchCallback {
   private final CoroutineScope scope;
   private final String tag;
   private final MutableSharedFlow<TempleAction> _sharedFlow;
   private final SharedFlow<TempleAction> action;

   public CommonTouchCallbackMapping(CoroutineScope scope, String tag) {
      CommonTouchCallbackMapping var10000 = this;
      Intrinsics.checkNotNullParameter(scope, "scope");
      Intrinsics.checkNotNullParameter(tag, "tag");
      super();
      this.scope = scope;
      this.tag = tag;
      MutableSharedFlow var3;
      this._sharedFlow = var3 = SharedFlowKt.MutableSharedFlow$default(0, 5, (BufferOverflow)null, 5, (Object)null);
      var10000.action = FlowKt.asSharedFlow(var3);
   }

   // $FF: synthetic method
   public CommonTouchCallbackMapping(CoroutineScope var1, String var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = "default";
      }

      this(var1, var2);
   }

   private final void mappingAction(TempleAction action) {
      CoroutineScope var10000 = this.scope;
      Function2 var2;
      var2 = new Function2<CoroutineScope, Continuation<? super Unit>, Object>() {
         public int label;
         // $FF: synthetic field
         public final TempleAction $action;

         public {
            this.$action = $action;
         }

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
               MutableSharedFlow var10000 = CommonTouchCallbackMapping.this._sharedFlow;
               TempleAction var4 = this.$action;
               this.label = 1;
               if (var10000.emit(var4, this) == var2) {
                  return var2;
               }
            }

            return Unit.INSTANCE;
         }

         public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
            <undefinedtype> var10002 = this;
            CommonTouchCallbackMapping var3 = CommonTouchCallbackMapping.this;
            return new <anonymous constructor>(var10002.$action, $completion);
         }

         public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }.<init>(action, (Continuation)null);
      BuildersKt.launch$default(var10000, (CoroutineContext)null, (CoroutineStart)null, var2, 3, (Object)null);
   }

   public final SharedFlow<TempleAction> getAction() {
      return this.action;
   }

   public boolean onTPLongClick() {
      CommonTouchCallbackMapping var10000 = this;
      TempleAction.LongClick var1;
      var1 = new TempleAction.LongClick.<init>(false, 0L, 3, (DefaultConstructorMarker)null);
      var10000.mappingAction(var1);
      return false;
   }

   public boolean onTPClick() {
      CommonTouchCallbackMapping var10000 = this;
      TempleAction.Click var1;
      var1 = new TempleAction.Click.<init>(false, 0L, 3, (DefaultConstructorMarker)null);
      var10000.mappingAction(var1);
      return false;
   }

   public boolean onTPDoubleClick() {
      CommonTouchCallbackMapping var10000 = this;
      TempleAction.DoubleClick var1;
      var1 = new TempleAction.DoubleClick.<init>(false, 0L, 3, (DefaultConstructorMarker)null);
      var10000.mappingAction(var1);
      return false;
   }

   public void onTPTripleClick() {
      CommonTouchCallbackMapping var10000 = this;
      TempleAction.TripleClick var1;
      var1 = new TempleAction.TripleClick.<init>(false, 0L, 3, (DefaultConstructorMarker)null);
      var10000.mappingAction(var1);
   }

   public boolean onTPSlideBackward(FlingArgs args) {
      CommonTouchCallbackMapping var10000 = this;
      Intrinsics.checkNotNullParameter(args, "args");
      TempleAction.SlideBackward var2;
      var2 = new TempleAction.SlideBackward.<init>(args, false, 0L, 6, (DefaultConstructorMarker)null);
      var10000.mappingAction(var2);
      return false;
   }

   public boolean onTPSlideForward(FlingArgs args) {
      CommonTouchCallbackMapping var10000 = this;
      Intrinsics.checkNotNullParameter(args, "args");
      TempleAction.SlideForward var2;
      var2 = new TempleAction.SlideForward.<init>(args, false, 0L, 6, (DefaultConstructorMarker)null);
      var10000.mappingAction(var2);
      return false;
   }

   public boolean onTPSlideContinuous(float delta, boolean longClick) {
      CommonTouchCallbackMapping var10000 = this;
      TempleAction.SlideContinuous var3;
      var3 = new TempleAction.SlideContinuous.<init>(delta, longClick, 0L, 4, (DefaultConstructorMarker)null);
      var10000.mappingAction(var3);
      return false;
   }

   public boolean onTPMoveUp(boolean longClick) {
      CommonTouchCallbackMapping var10000 = this;
      TempleAction.MoveUp var2;
      var2 = new TempleAction.MoveUp.<init>(longClick, 0L, 2, (DefaultConstructorMarker)null);
      var10000.mappingAction(var2);
      return false;
   }

   public void onActionUp() {
      CommonTouchCallbackMapping var10000 = this;
      TempleAction.ActionUp var1;
      var1 = new TempleAction.ActionUp.<init>(0L, 1, (DefaultConstructorMarker)null);
      var10000.mappingAction(var1);
   }

   public void onKeyPinch() {
   }

   public void onKeyLongPinch() {
   }
}
