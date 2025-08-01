package com.rayneo.arsdk.android.ext;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewbinding.ViewBinding;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"},
   d2 = {"Lcom/rayneo/arsdk/android/ext/SimpleBindingAdapter;", "B", "Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rayneo/arsdk/android/ext/BaseBindingHolder;", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "MercurySDK_release"}
)
public abstract class SimpleBindingAdapter<B extends ViewBinding> extends Adapter<BaseBindingHolder<B>> {
   public BaseBindingHolder<B> onCreateViewHolder(ViewGroup parent, int viewType) {
      Intrinsics.checkNotNullParameter(parent, "parent");
      Type var10000 = this.getClass().getGenericSuperclass();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
      var10000 = ((ParameterizedType)var10000).getActualTypeArguments()[0];
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type java.lang.Class<B of com.rayneo.arsdk.android.ext.SimpleBindingAdapter>");
      Class var6 = (Class)var10000;
      Class[] var3;
      Class[] var10001 = var3 = new Class[3];
      var10001[0] = LayoutInflater.class;
      var10001[1] = ViewGroup.class;
      var10001[2] = Boolean.TYPE;
      Method var7 = var6.getDeclaredMethod("inflate", var3);
      Intrinsics.checkNotNullExpressionValue(var7, "bindingClz.getDeclaredMe…ean::class.java\n        )");
      Object[] var4;
      Object[] var8 = var4 = new Object[3];
      var8[0] = LayoutInflater.from(parent.getContext());
      var8[1] = parent;
      var8[2] = Boolean.FALSE;
      Object var5 = var7.invoke((Object)null, var4);
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type B of com.rayneo.arsdk.android.ext.SimpleBindingAdapter");
      return new BaseBindingHolder((ViewBinding)var5);
   }
}
