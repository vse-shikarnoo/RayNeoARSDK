package com.rayneo.arsdk.android.ui.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.viewbinding.ViewBinding;
import com.rayneo.arsdk.android.core.BindingPair;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00120\f\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u001e\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/wiget/MirrorContainerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBindingPair", "Lcom/rayneo/arsdk/android/core/BindingPair;", "getMBindingPair", "()Lcom/rayneo/arsdk/android/core/BindingPair;", "setMBindingPair", "(Lcom/rayneo/arsdk/android/core/BindingPair;)V", "bindTo", "B", "Landroidx/viewbinding/ViewBinding;", "bindingClz", "Ljava/lang/Class;", "init", "", "MercurySDK_release"}
)
public final class MirrorContainerView extends LinearLayout {
   public BindingPair<?> mBindingPair;

   public MirrorContainerView(Context context) {
      Intrinsics.checkNotNullParameter(context, "context");
      super(context);
      this.init();
   }

   public MirrorContainerView(Context context, AttributeSet attrs) {
      Intrinsics.checkNotNullParameter(context, "context");
      super(context, attrs);
      this.init();
   }

   public MirrorContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
      Intrinsics.checkNotNullParameter(context, "context");
      super(context, attrs, defStyleAttr);
      this.init();
   }

   private final void init() {
      this.setOrientation(0);
   }

   public final BindingPair<?> getMBindingPair() {
      BindingPair var1;
      if ((var1 = this.mBindingPair) != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("mBindingPair");
         return null;
      }
   }

   public final void setMBindingPair(BindingPair<?> var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.mBindingPair = var1;
   }

   public final <B extends ViewBinding> BindingPair<B> bindTo(Class<B> bindingClz) {
      Class var10002 = bindingClz;
      Intrinsics.checkNotNullParameter(bindingClz, "bindingClz");
      Class[] bindingClz1;
      (bindingClz1 = new Class[1])[0] = LayoutInflater.class;
      Method var7 = var10002.getDeclaredMethod("inflate", bindingClz1);
      Intrinsics.checkNotNullExpressionValue(var7, "bindingClz.getDeclaredMe…youtInflater::class.java)");
      Object[] bindingClz2;
      (bindingClz2 = new Object[1])[0] = LayoutInflater.from(this.getContext());
      Object var10003 = var7.invoke((Object)null, bindingClz2);
      Intrinsics.checkNotNull(var10003, "null cannot be cast to non-null type B of com.rayneo.arsdk.android.ui.wiget.MirrorContainerView.bindTo");
      ViewBinding bindingClz3 = (ViewBinding)var10003;
      Object[] var2;
      (var2 = new Object[1])[0] = LayoutInflater.from(this.getContext());
      Object var8 = var7.invoke((Object)null, var2);
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type B of com.rayneo.arsdk.android.ui.wiget.MirrorContainerView.bindTo");
      ViewBinding var6;
      ViewBinding var9 = var6 = (ViewBinding)var8;
      this.setMBindingPair(new BindingPair(bindingClz3, var6));
      View var10004 = bindingClz3.getRoot();
      LayoutParams var10005 = new LayoutParams(0, -1);
      var10005.weight = 1.0F;
      Unit var10006 = Unit.INSTANCE;
      this.addView(var10004, var10005);
      View var10 = var9.getRoot();
      LayoutParams var11 = new LayoutParams(0, -1);
      var11.weight = 1.0F;
      Unit var12 = Unit.INSTANCE;
      this.addView(var10, var11);
      BindingPair var10000 = this.getMBindingPair();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type com.rayneo.arsdk.android.core.BindingPair<B of com.rayneo.arsdk.android.ui.wiget.MirrorContainerView.bindTo>");
      return var10000;
   }
}
