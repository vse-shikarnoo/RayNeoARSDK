package com.rayneo.arsdk.android.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.viewbinding.ViewBinding;
import com.rayneo.arsdk.android.core.BindingPair;
import com.rayneo.arsdk.android.core.BindingPairKt;
import com.rayneo.arsdk.android.touch.CommonTouchCallbackMapping;
import com.rayneo.arsdk.android.touch.TempleAction;
import com.rayneo.arsdk.android.touch.TouchDispatcher;
import com.rayneo.arsdk.android.ui.wiget.MirrorContainerView;
import com.rayneo.arsdk.android.util.FLogger;
import com.rayneo.arsdk.android.util.MyTouchUtils;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/dialog/FDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "touchCallback", "Lcom/rayneo/arsdk/android/touch/CommonTouchCallbackMapping;", "touchDispatcher", "Lcom/rayneo/arsdk/android/touch/TouchDispatcher;", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "Builder", "MercurySDK_release"}
)
public final class FDialog extends Dialog {
   private TouchDispatcher touchDispatcher;
   private CoroutineScope scope;
   private final CommonTouchCallbackMapping touchCallback;

   private FDialog(Context context, int themeResId) {
      super(context, themeResId);
      this.touchDispatcher = new TouchDispatcher(TouchDispatcher.Source.Activity.INSTANCE);
      this.scope = CoroutineScopeKt.MainScope();
      this.touchCallback = new CommonTouchCallbackMapping(this.scope, (String)null, 2, (DefaultConstructorMarker)null);
   }

   // $FF: synthetic method
   public FDialog(Context var1, int var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = 0;
      }

      this(var1, var2);
   }

   // $FF: synthetic method
   public FDialog(Context context, int themeResId, DefaultConstructorMarker $constructor_marker) {
      this(context, themeResId);
   }

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Window var2;
      if ((var2 = this.getWindow()) != null) {
         LayoutParams savedInstanceState1;
         if ((savedInstanceState1 = var2.getAttributes()) != null) {
            Intrinsics.checkNotNullExpressionValue(savedInstanceState1, "attributes");
            savedInstanceState1.height = -1;
            savedInstanceState1.width = -1;
         }

         var2.getDecorView().setBackgroundColor(0);
      }

   }

   public void dismiss() {
      super.dismiss();
      CoroutineScopeKt.cancel$default(this.scope, (CancellationException)null, 1, (Object)null);
   }

   public boolean onTouchEvent(MotionEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (MyTouchUtils.isRight(event)) {
         this.touchDispatcher.onMotionEvent(event, this.touchCallback);
      }

      return super.onTouchEvent(event);
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0014\u001a\u00020\nJ\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u0017JH\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2 \u0010\u001d\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"J&\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eJ\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010'\u001a\u00020\fJ \u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0*J \u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006-"},
      d2 = {"Lcom/rayneo/arsdk/android/ui/dialog/FDialog$Builder;", "T", "Landroidx/viewbinding/ViewBinding;", "", "context", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "dialog", "Lcom/rayneo/arsdk/android/ui/dialog/FDialog;", "<set-?>", "Lcom/rayneo/arsdk/android/ui/dialog/FocusTracker;", "mFocusTracker", "getMFocusTracker", "()Lcom/rayneo/arsdk/android/ui/dialog/FocusTracker;", "Lcom/rayneo/arsdk/android/core/BindingPair;", "mPair", "getMPair", "()Lcom/rayneo/arsdk/android/core/BindingPair;", "build", "setCancelable", "cancelable", "", "setCanceledOnTouchOutside", "cancel", "setContentView", "bindingClz", "Ljava/lang/Class;", "initViewBlock", "Lkotlin/Function2;", "Landroid/content/DialogInterface;", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "setEventHandler", "handler", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "setFocusTracker", "focusTracker", "setOnDismissListener", "onDismiss", "Lkotlin/Function1;", "setOnShowListener", "onShow", "MercurySDK_release"}
   )
   public static final class Builder<T extends ViewBinding> {
      private final Context context;
      private final FDialog dialog;
      private BindingPair<T> mPair;
      private FocusTracker mFocusTracker;

      public Builder(Context context, int themeResId) {
         FDialog.Builder var10000 = this;
         Intrinsics.checkNotNullParameter(context, "context");
         super();
         this.context = context;
         FDialog var3;
         var3 = new FDialog.<init>(context, themeResId, (DefaultConstructorMarker)null);
         var10000.dialog = var3;
      }

      // $FF: synthetic method
      public Builder(Context var1, int var2, int var3, DefaultConstructorMarker var4) {
         if ((var3 & 2) != 0) {
            var2 = 0;
         }

         this(var1, var2);
      }

      // $FF: synthetic method
      public static FDialog.Builder setContentView$default(FDialog.Builder var0, Class var1, Function2 var2, android.view.ViewGroup.LayoutParams var3, int var4, Object var5) {
         if ((var4 & 4) != 0) {
            var3 = new android.view.ViewGroup.LayoutParams.<init>(-1, -1);
         }

         return var0.setContentView(var1, var2, var3);
      }

      private static final void setOnDismissListener$lambda_2/* $FF was: setOnDismissListener$lambda-2*/(Function1 $tmp0, DialogInterface p0) {
         Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
         $tmp0.invoke(p0);
      }

      private static final void setOnShowListener$lambda_3/* $FF was: setOnShowListener$lambda-3*/(Function1 $tmp0, DialogInterface p0) {
         Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
         $tmp0.invoke(p0);
      }

      public final BindingPair<T> getMPair() {
         BindingPair var1;
         if ((var1 = this.mPair) != null) {
            return var1;
         } else {
            Intrinsics.throwUninitializedPropertyAccessException("mPair");
            return null;
         }
      }

      public final FocusTracker getMFocusTracker() {
         return this.mFocusTracker;
      }

      public final FDialog.Builder<T> setContentView(Class<T> bindingClz, Function2<? super BindingPair<T>, ? super DialogInterface, Unit> initViewBlock, android.view.ViewGroup.LayoutParams params) {
         Intrinsics.checkNotNullParameter(bindingClz, "bindingClz");
         MirrorContainerView var4;
         MirrorContainerView var10001 = var4 = new MirrorContainerView;
         var4.<init>(this.context);
         var4.setLayoutParams(params);
         BindingPair bindingClz1 = var10001.bindTo(bindingClz);
         if (initViewBlock != null) {
            initViewBlock.invoke(bindingClz1, this.dialog);
         }

         View var10004 = ((ViewBinding)bindingClz1.getLeft()).getRoot();
         Intrinsics.checkNotNullExpressionValue(var10004, "left.root");
         View var10005 = ((ViewBinding)bindingClz1.getRight()).getRoot();
         Intrinsics.checkNotNullExpressionValue(var10005, "right.root");
         BindingPairKt.make3DEffect(var10004, var10005, true, 8.0F);
         this.mPair = bindingClz1;
         this.dialog.setContentView(var4);
         return this;
      }

      public final FDialog.Builder<T> setFocusTracker(FocusTracker focusTracker) {
         Intrinsics.checkNotNullParameter(focusTracker, "focusTracker");
         this.mFocusTracker = focusTracker;
         return this;
      }

      public final FDialog.Builder<T> setCancelable(boolean cancelable) {
         this.dialog.setCancelable(cancelable);
         return this;
      }

      public final FDialog.Builder<T> setCanceledOnTouchOutside(boolean cancel) {
         this.dialog.setCanceledOnTouchOutside(cancel);
         return this;
      }

      public final FDialog.Builder<T> setOnDismissListener(Function1<? super DialogInterface, Unit> onDismiss) {
         Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
         this.dialog.setOnDismissListener(FDialog.Builder::setOnDismissListener$lambda-2);
         return this;
      }

      public final FDialog.Builder<T> setOnShowListener(Function1<? super DialogInterface, Unit> onShow) {
         Intrinsics.checkNotNullParameter(onShow, "onShow");
         this.dialog.setOnShowListener(FDialog.Builder::setOnShowListener$lambda-3);
         return this;
      }

      public final FDialog.Builder<T> setEventHandler(Function2<? super TempleAction, ? super DialogInterface, Unit> handler) {
         Intrinsics.checkNotNullParameter(handler, "handler");
         CoroutineScope var10001 = this.dialog.scope;
         Function2 var2;
         var2 = new Function2<CoroutineScope, Continuation<? super Unit>, Object>() {
            public int label;
            // $FF: synthetic field
            public final Function2<TempleAction, DialogInterface, Unit> $handler;

            public {
               this.$handler = $handler;
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
                  SharedFlow var10000 = Builder.this.dialog.touchCallback.getAction();
                  FlowCollector var4;
                  FlowCollector var10002 = var4 = new FlowCollector() {
                     // $FF: synthetic field
                     public final FDialog.Builder<T> this$0;

                     public {
                        this.this$0 = $receiver;
                     }

                     public final Object emit(TempleAction it, Continuation<? super Unit> $completion) {
                        invoke(it, this.this$0.dialog);
                        FLogger.i("FDialog", "action = " + it);
                        FocusTracker var3;
                        if (it instanceof TempleAction.SlideForward) {
                           if ((var3 = this.this$0.getMFocusTracker()) != null) {
                              var3.next();
                           }
                        } else if (it instanceof TempleAction.SlideBackward) {
                           if ((var3 = this.this$0.getMFocusTracker()) != null) {
                              var3.previous();
                           }
                        } else {
                           FocusTracker $completion1;
                           if (($completion1 = this.this$0.getMFocusTracker()) != null) {
                              FDialog.Builder var4 = this.this$0;
                              $completion1.getCurrentFocusItem().getEventHandler().invoke(it, var4.dialog);
                           }
                        }

                        return Unit.INSTANCE;
                     }
                  };
                  Function2 var5 = this.$handler;
                  var10002.<init>(Builder.this);
                  this.label = 1;
                  if (var10000.collect(var4, this) == var2) {
                     return var2;
                  }
               }

               throw new KotlinNothingValueException();
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
               <undefinedtype> var10002 = this;
               FDialog.Builder var3 = Builder.this;
               return new <anonymous constructor>(var10002.$handler, $completion);
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
               return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
         }.<init>(handler, (Continuation)null);
         BuildersKt.launch$default(var10001, (CoroutineContext)null, (CoroutineStart)null, var2, 3, (Object)null);
         return this;
      }

      public final FDialog build() {
         return this.dialog;
      }
   }
}
