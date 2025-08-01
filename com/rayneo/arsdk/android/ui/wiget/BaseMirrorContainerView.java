package com.rayneo.arsdk.android.ui.wiget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.viewbinding.ViewBinding;
import com.rayneo.arsdk.android.core.BindingPair;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0004J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH&R\u0010\u0010\r\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001e"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/wiget/BaseMirrorContainerView;", "B", "Landroidx/viewbinding/ViewBinding;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftBinding", "Landroidx/viewbinding/ViewBinding;", "mBindingPair", "Lcom/rayneo/arsdk/android/core/BindingPair;", "getMBindingPair", "()Lcom/rayneo/arsdk/android/core/BindingPair;", "setMBindingPair", "(Lcom/rayneo/arsdk/android/core/BindingPair;)V", "mH", "Landroid/os/Handler;", "getMH", "()Landroid/os/Handler;", "rightBinding", "init", "", "initPair", "onInit", "MercurySDK_release"}
)
public abstract class BaseMirrorContainerView<B extends ViewBinding> extends LinearLayout {
   private B leftBinding;
   private B rightBinding;
   public BindingPair<B> mBindingPair;
   private final Handler mH;

   public BaseMirrorContainerView(Context context) {
      Intrinsics.checkNotNullParameter(context, "context");
      super(context);
      this.mH = new Handler(Looper.getMainLooper());
      this.init();
   }

   public BaseMirrorContainerView(Context context, AttributeSet attrs) {
      Intrinsics.checkNotNullParameter(context, "context");
      super(context, attrs);
      this.mH = new Handler(Looper.getMainLooper());
      this.init();
   }

   public BaseMirrorContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
      Intrinsics.checkNotNullParameter(context, "context");
      super(context, attrs, defStyleAttr);
      this.mH = new Handler(Looper.getMainLooper());
      this.init();
   }

   private final void initPair() {
      Type var10002 = this.getClass().getGenericSuperclass();
      Intrinsics.checkNotNull(var10002, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
      var10002 = ((ParameterizedType)var10002).getActualTypeArguments()[0];
      Intrinsics.checkNotNull(var10002, "null cannot be cast to non-null type java.lang.Class<B of com.rayneo.arsdk.android.ui.wiget.BaseMirrorContainerView>");
      Class var12 = (Class)var10002;
      Class[] var1;
      (var1 = new Class[1])[0] = LayoutInflater.class;
      Method var13 = var12.getDeclaredMethod("inflate", var1);
      Intrinsics.checkNotNullExpressionValue(var13, "bindingClz.getDeclaredMe…youtInflater::class.java)");
      Object[] var5;
      (var5 = new Object[1])[0] = LayoutInflater.from(this.getContext());
      Object var10004 = var13.invoke((Object)null, var5);
      Intrinsics.checkNotNull(var10004, "null cannot be cast to non-null type B of com.rayneo.arsdk.android.ui.wiget.BaseMirrorContainerView");
      this.leftBinding = (ViewBinding)var10004;
      (var5 = new Object[1])[0] = LayoutInflater.from(this.getContext());
      Object var14 = var13.invoke((Object)null, var5);
      Intrinsics.checkNotNull(var14, "null cannot be cast to non-null type B of com.rayneo.arsdk.android.ui.wiget.BaseMirrorContainerView");
      this.rightBinding = (ViewBinding)var14;
      BindingPair var6 = new BindingPair;
      ViewBinding var2;
      if ((var2 = this.leftBinding) == null) {
         Intrinsics.throwUninitializedPropertyAccessException("leftBinding");
         var2 = null;
      }

      ViewBinding var3;
      if ((var3 = this.rightBinding) == null) {
         Intrinsics.throwUninitializedPropertyAccessException("rightBinding");
         var3 = null;
      }

      var6.<init>(var2, var3);
      this.setMBindingPair(var6);
      ViewBinding var7;
      if ((var7 = this.leftBinding) == null) {
         Intrinsics.throwUninitializedPropertyAccessException("leftBinding");
         var7 = null;
      }

      View var9 = var7.getRoot();
      LayoutParams var8;
      LayoutParams var15 = var8 = new LayoutParams;
      var15.<init>(0, -1);
      var15.weight = 1.0F;
      Unit var16 = Unit.INSTANCE;
      this.addView(var9, var8);
      if ((var7 = this.rightBinding) == null) {
         Intrinsics.throwUninitializedPropertyAccessException("rightBinding");
         var7 = null;
      }

      BaseMirrorContainerView var10000 = this;
      View var4 = var7.getRoot();
      LayoutParams var10;
      LayoutParams var10001 = var10 = new LayoutParams;
      var10001.<init>(0, -1);
      var10001.weight = 1.0F;
      Unit var11 = Unit.INSTANCE;
      var10000.addView(var4, var10);
   }

   public final BindingPair<B> getMBindingPair() {
      BindingPair var1;
      if ((var1 = this.mBindingPair) != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("mBindingPair");
         return null;
      }
   }

   public final void setMBindingPair(BindingPair<B> var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.mBindingPair = var1;
   }

   public final Handler getMH() {
      return this.mH;
   }

   public final void init() {
      this.setOrientation(0);
      this.initPair();
      this.onInit();
   }

   public abstract void onInit();
}
