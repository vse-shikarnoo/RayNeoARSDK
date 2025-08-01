package com.rayneo.arsdk.android.ext;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewbinding.ViewBinding;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"},
   d2 = {"Lcom/rayneo/arsdk/android/ext/BaseBindingAdapter;", "B", "Landroidx/viewbinding/ViewBinding;", "VH", "Lcom/rayneo/arsdk/android/ext/BaseBindingHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "(Landroid/view/ViewGroup;I)Lcom/rayneo/arsdk/android/ext/BaseBindingHolder;", "MercurySDK_release"}
)
public abstract class BaseBindingAdapter<B extends ViewBinding, VH extends BaseBindingHolder<B>> extends Adapter<VH> {
   public VH onCreateViewHolder(ViewGroup parent, int viewType) {
      Intrinsics.checkNotNullParameter(parent, "parent");
      Type var10000 = this.getClass().getGenericSuperclass();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
      Type[] var7 = ((ParameterizedType)var10000).getActualTypeArguments();
      Type var10001 = var7[0];
      Intrinsics.checkNotNull(var7[0], "null cannot be cast to non-null type java.lang.Class<B of com.rayneo.arsdk.android.ext.BaseBindingAdapter>");
      Class var3;
      Class var9 = var3 = (Class)var10001;
      Class[] viewType1;
      Class[] var10002 = viewType1 = new Class[3];
      var10002[0] = LayoutInflater.class;
      var10002[1] = ViewGroup.class;
      var10002[2] = Boolean.TYPE;
      Method var11 = var9.getDeclaredMethod("inflate", viewType1);
      Intrinsics.checkNotNullExpressionValue(var11, "bindingClz.getDeclaredMe…ean::class.java\n        )");
      Object[] viewType2;
      Object[] var12 = viewType2 = new Object[3];
      var12[0] = LayoutInflater.from(parent.getContext());
      var12[1] = parent;
      var12[2] = Boolean.FALSE;
      Object parent1 = var11.invoke((Object)null, viewType2);
      var10000 = var7[1];
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type java.lang.Class<VH of com.rayneo.arsdk.android.ext.BaseBindingAdapter>");
      Constructor var8 = ((Class)var10000).getConstructor(var3);
      var8.setAccessible(true);
      Object var10 = var8.newInstance(parent1);
      Intrinsics.checkNotNullExpressionValue(var10, "holderConstructor.newInstance(binding)");
      return (BaseBindingHolder)var10;
   }
}
