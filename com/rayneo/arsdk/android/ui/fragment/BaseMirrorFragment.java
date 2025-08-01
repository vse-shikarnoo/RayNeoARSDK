package com.rayneo.arsdk.android.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import com.rayneo.arsdk.android.core.BaseScreenHolder;
import com.rayneo.arsdk.android.core.BindingPair;
import com.rayneo.arsdk.android.core.HolderPair;
import java.lang.reflect.Constructor;
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
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H&R\u0010\u0010\u0007\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\b¨\u0006\""},
   d2 = {"Lcom/rayneo/arsdk/android/ui/fragment/BaseMirrorFragment;", "B", "Landroidx/viewbinding/ViewBinding;", "H", "Lcom/rayneo/arsdk/android/core/BaseScreenHolder;", "Landroidx/fragment/app/Fragment;", "()V", "leftBinding", "Landroidx/viewbinding/ViewBinding;", "mBindingPair", "Lcom/rayneo/arsdk/android/core/BindingPair;", "getMBindingPair", "()Lcom/rayneo/arsdk/android/core/BindingPair;", "setMBindingPair", "(Lcom/rayneo/arsdk/android/core/BindingPair;)V", "mPair", "Lcom/rayneo/arsdk/android/core/HolderPair;", "getMPair", "()Lcom/rayneo/arsdk/android/core/HolderPair;", "setMPair", "(Lcom/rayneo/arsdk/android/core/HolderPair;)V", "rightBinding", "generateRootView", "Landroid/view/ViewGroup;", "initPair", "", "inflater", "Landroid/view/LayoutInflater;", "onCreateView", "Landroid/view/View;", "container", "savedInstanceState", "Landroid/os/Bundle;", "rootView", "MercurySDK_release"}
)
public abstract class BaseMirrorFragment<B extends ViewBinding, H extends BaseScreenHolder<B>> extends Fragment {
   private B leftBinding;
   private B rightBinding;
   public HolderPair<B, H> mPair;
   public BindingPair<B> mBindingPair;

   private final void initPair(LayoutInflater inflater) {
      Type var10000 = this.getClass().getGenericSuperclass();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
      Type[] var2;
      Type[] var18 = var2 = ((ParameterizedType)var10000).getActualTypeArguments();
      Type var10002 = var2[0];
      Intrinsics.checkNotNull(var2[0], "null cannot be cast to non-null type java.lang.Class<B of com.rayneo.arsdk.android.ui.fragment.BaseMirrorFragment>");
      Class var3;
      Class var20 = var3 = (Class)var10002;
      Class[] var4;
      (var4 = new Class[1])[0] = LayoutInflater.class;
      Method var21 = var20.getDeclaredMethod("inflate", var4);
      Intrinsics.checkNotNullExpressionValue(var21, "bindingClz.getDeclaredMe…youtInflater::class.java)");
      Object[] var12;
      (var12 = new Object[1])[0] = inflater;
      Object var10004 = var21.invoke((Object)null, var12);
      Intrinsics.checkNotNull(var10004, "null cannot be cast to non-null type B of com.rayneo.arsdk.android.ui.fragment.BaseMirrorFragment");
      this.leftBinding = (ViewBinding)var10004;
      (var12 = new Object[1])[0] = inflater;
      Object var22 = var21.invoke((Object)null, var12);
      Intrinsics.checkNotNull(var22, "null cannot be cast to non-null type B of com.rayneo.arsdk.android.ui.fragment.BaseMirrorFragment");
      this.rightBinding = (ViewBinding)var22;
      BaseScreenHolder inflater1;
      BaseScreenHolder var9;
      HolderPair var13;
      if (var18[1] instanceof ParameterizedType) {
         inflater1 = new BaseScreenHolder;
         ViewBinding var8;
         if ((var8 = this.leftBinding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftBinding");
            var8 = null;
         }

         inflater1.<init>(var8);
         var9 = new BaseScreenHolder;
         ViewBinding var10;
         if ((var10 = this.rightBinding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightBinding");
            var10 = null;
         }

         var9.<init>(var10);
         var13 = new HolderPair.<init>(inflater1, var9);
         this.setMPair(var13);
      } else {
         Type var10001 = var2[1];
         Intrinsics.checkNotNull(var2[1], "null cannot be cast to non-null type java.lang.Class<H of com.rayneo.arsdk.android.ui.fragment.BaseMirrorFragment>");
         Constructor inflater2;
         (inflater2 = ((Class)var10001).getConstructor(var3)).setAccessible(true);
         Object[] var11 = new Object[1];
         byte var14 = 0;
         ViewBinding var15;
         if ((var15 = this.leftBinding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftBinding");
            var15 = null;
         }

         var11[var14] = var15;
         Object var19 = inflater2.newInstance(var11);
         Intrinsics.checkNotNull(var19, "null cannot be cast to non-null type H of com.rayneo.arsdk.android.ui.fragment.BaseMirrorFragment");
         var9 = (BaseScreenHolder)var19;
         Object[] var16 = new Object[1];
         byte var17 = 0;
         ViewBinding var5;
         if ((var5 = this.rightBinding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightBinding");
            var5 = null;
         }

         var16[var17] = var5;
         var19 = inflater2.newInstance(var16);
         Intrinsics.checkNotNull(var19, "null cannot be cast to non-null type H of com.rayneo.arsdk.android.ui.fragment.BaseMirrorFragment");
         inflater1 = (BaseScreenHolder)var19;
         var13 = new HolderPair.<init>(var9, inflater1);
         this.setMPair(var13);
      }

      this.setMBindingPair(this.getMPair().getBindingPair());
   }

   private final ViewGroup generateRootView() {
      Context var1 = this.getContext();
      LinearLayout var2;
      LinearLayout var10000 = var2 = new LinearLayout() {
         public boolean onInterceptTouchEvent(MotionEvent ev) {
            return true;
         }
      };
      var2.<init>(var1);
      var2.setLayoutParams(new LayoutParams(-1, -1));
      var2.setOrientation(0);
      View var10004 = this.getMPair().getLeftHolder().getBinding().getRoot();
      android.widget.LinearLayout.LayoutParams var10005 = new android.widget.LinearLayout.LayoutParams(0, -1);
      var10005.weight = 1.0F;
      Unit var10006 = Unit.INSTANCE;
      var2.addView(var10004, var10005);
      View var10002 = this.getMPair().getRightHolder().getBinding().getRoot();
      android.widget.LinearLayout.LayoutParams var10003 = new android.widget.LinearLayout.LayoutParams(0, -1);
      var10003.weight = 1.0F;
      Unit var3 = Unit.INSTANCE;
      var10000.addView(var10002, var10003);
      return var10000;
   }

   public final HolderPair<B, H> getMPair() {
      HolderPair var1;
      if ((var1 = this.mPair) != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("mPair");
         return null;
      }
   }

   public final void setMPair(HolderPair<B, H> var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.mPair = var1;
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

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      Intrinsics.checkNotNullParameter(inflater, "inflater");
      this.initPair(inflater);
      ViewGroup var10000 = this.generateRootView();
      this.onCreateView(var10000, savedInstanceState);
      return var10000;
   }

   public abstract void onCreateView(View var1, Bundle var2);
}
