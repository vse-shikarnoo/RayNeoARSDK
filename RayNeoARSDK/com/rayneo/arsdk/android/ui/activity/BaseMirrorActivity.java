package com.rayneo.arsdk.android.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
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
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u0010\u0010\u0005\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0015"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/activity/BaseMirrorActivity;", "B", "Landroidx/viewbinding/ViewBinding;", "Lcom/rayneo/arsdk/android/ui/activity/BaseEventActivity;", "()V", "leftBinding", "Landroidx/viewbinding/ViewBinding;", "mBindingPair", "Lcom/rayneo/arsdk/android/core/BindingPair;", "getMBindingPair", "()Lcom/rayneo/arsdk/android/core/BindingPair;", "setMBindingPair", "(Lcom/rayneo/arsdk/android/core/BindingPair;)V", "rightBinding", "generateRootView", "Landroid/view/ViewGroup;", "initPair", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "MercurySDK_release"}
)
public abstract class BaseMirrorActivity<B extends ViewBinding> extends BaseEventActivity {
   private B leftBinding;
   private B rightBinding;
   public BindingPair<B> mBindingPair;

   private final void initPair() {
      Type var10002 = this.getClass().getGenericSuperclass();
      Intrinsics.checkNotNull(var10002, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
      var10002 = ((ParameterizedType)var10002).getActualTypeArguments()[0];
      Intrinsics.checkNotNull(var10002, "null cannot be cast to non-null type java.lang.Class<B of com.rayneo.arsdk.android.ui.activity.BaseMirrorActivity>");
      Class var6 = (Class)var10002;
      Class[] var1;
      (var1 = new Class[1])[0] = LayoutInflater.class;
      Method var7 = var6.getDeclaredMethod("inflate", var1);
      Intrinsics.checkNotNullExpressionValue(var7, "bindingClz.getDeclaredMe…youtInflater::class.java)");
      Object[] var4;
      (var4 = new Object[1])[0] = LayoutInflater.from(this);
      Object var10004 = var7.invoke((Object)null, var4);
      Intrinsics.checkNotNull(var10004, "null cannot be cast to non-null type B of com.rayneo.arsdk.android.ui.activity.BaseMirrorActivity");
      this.leftBinding = (ViewBinding)var10004;
      (var4 = new Object[1])[0] = LayoutInflater.from(this);
      Object var8 = var7.invoke((Object)null, var4);
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type B of com.rayneo.arsdk.android.ui.activity.BaseMirrorActivity");
      this.rightBinding = (ViewBinding)var8;
      BindingPair var5 = new BindingPair;
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

      var5.<init>(var2, var3);
      this.setMBindingPair(var5);
   }

   private final ViewGroup generateRootView() {
      LinearLayout var1;
      LinearLayout var10000 = var1 = new LinearLayout() {
         public boolean onInterceptTouchEvent(MotionEvent ev) {
            return true;
         }
      };
      var1.<init>(this);
      var1.setLayoutParams(new LayoutParams(-1, -1));
      var1.setOrientation(0);
      View var10004 = ((ViewBinding)this.getMBindingPair().getLeft()).getRoot();
      android.widget.LinearLayout.LayoutParams var10005 = new android.widget.LinearLayout.LayoutParams(0, -1);
      var10005.weight = 1.0F;
      Unit var10006 = Unit.INSTANCE;
      var1.addView(var10004, var10005);
      View var10002 = ((ViewBinding)this.getMBindingPair().getRight()).getRoot();
      android.widget.LinearLayout.LayoutParams var10003 = new android.widget.LinearLayout.LayoutParams(0, -1);
      var10003.weight = 1.0F;
      Unit var2 = Unit.INSTANCE;
      var10000.addView(var10002, var10003);
      return var10000;
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

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.initPair();
      this.setContentView(this.generateRootView());
   }
}
