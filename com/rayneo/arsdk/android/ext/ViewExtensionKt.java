package com.rayneo.arsdk.android.ext;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 2,
   xi = 48,
   d1 = {"\u00002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0002\u0010\u000f\u001a\n\u0010\u0010\u001a\u00020\u0004*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0004*\u00020\u0011\u001a\n\u0010\u0013\u001a\u00020\u000b*\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0014"},
   d2 = {"dp", "", "getDp", "(F)F", "", "(I)I", "sp", "getSp", "setViewVisible", "", "visible", "", "views", "", "Landroid/view/View;", "(Z[Landroid/view/View;)V", "findFirstVisibleItemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "findLastVisibleItemPosition", "lastItemVisible", "MercurySDK_release"}
)
public final class ViewExtensionKt {
   public static final void setViewVisible(boolean visible, View... views) {
      Intrinsics.checkNotNullParameter(views, "views");
      int var2 = 0;

      for(int var3 = views.length; var2 < var3; ++var2) {
         View var4 = views[var2];
         byte var5;
         if (visible) {
            var5 = 0;
         } else {
            var5 = 8;
         }

         var4.setVisibility(var5);
      }

   }

   public static final int findFirstVisibleItemPosition(RecyclerView $this$findFirstVisibleItemPosition) {
      Intrinsics.checkNotNullParameter($this$findFirstVisibleItemPosition, "<this>");
      LayoutManager var10000 = $this$findFirstVisibleItemPosition.getLayoutManager();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      return ((LinearLayoutManager)var10000).findFirstVisibleItemPosition();
   }

   public static final int findLastVisibleItemPosition(RecyclerView $this$findLastVisibleItemPosition) {
      Intrinsics.checkNotNullParameter($this$findLastVisibleItemPosition, "<this>");
      LayoutManager var10000 = $this$findLastVisibleItemPosition.getLayoutManager();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      return ((LinearLayoutManager)var10000).findLastVisibleItemPosition();
   }

   public static final boolean lastItemVisible(RecyclerView $this$lastItemVisible) {
      Intrinsics.checkNotNullParameter($this$lastItemVisible, "<this>");
      Adapter var1;
      if ((var1 = $this$lastItemVisible.getAdapter()) != null) {
         return findLastVisibleItemPosition($this$lastItemVisible) == var1.getItemCount() - 1;
      } else {
         return false;
      }
   }

   public static final float getDp(float $this$dp) {
      DisplayMetrics var1 = Resources.getSystem().getDisplayMetrics();
      return TypedValue.applyDimension(1, $this$dp, var1);
   }

   public static final int getDp(int $this$dp) {
      float var10000 = (float)$this$dp;
      DisplayMetrics $this$dp1 = Resources.getSystem().getDisplayMetrics();
      return (int)TypedValue.applyDimension(1, var10000, $this$dp1);
   }

   public static final float getSp(float $this$sp) {
      DisplayMetrics var1 = Resources.getSystem().getDisplayMetrics();
      return TypedValue.applyDimension(2, $this$sp, var1);
   }

   public static final int getSp(int $this$sp) {
      float var10000 = (float)$this$sp;
      DisplayMetrics $this$sp1 = Resources.getSystem().getDisplayMetrics();
      return (int)TypedValue.applyDimension(2, var10000, $this$sp1);
   }
}
