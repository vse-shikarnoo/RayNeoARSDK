package com.rayneo.arsdk.android.util;

import android.view.View;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lcom/rayneo/arsdk/android/util/StartSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "offset2Start", "", "(I)V", "mHorizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "mVerticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToFirst", "helper", "findFirstView", "findSnapView", "getHorizontalHelper", "getVerticalHelper", "MercurySDK_release"}
)
public final class StartSnapHelper extends LinearSnapHelper {
   private final int offset2Start;
   private OrientationHelper mVerticalHelper;
   private OrientationHelper mHorizontalHelper;

   public StartSnapHelper(int offset2Start) {
      this.offset2Start = offset2Start;
   }

   private final int distanceToFirst(LayoutManager layoutManager, View targetView, OrientationHelper helper) {
      return helper.getDecoratedStart(targetView) - helper.getStartAfterPadding();
   }

   private final View findFirstView(LayoutManager layoutManager, OrientationHelper helper) {
      int var3;
      if ((var3 = layoutManager.getChildCount()) == 0) {
         return null;
      } else {
         View var4 = null;
         int var9 = helper.getStartAfterPadding() + this.offset2Start;
         int var5 = Integer.MAX_VALUE;

         for(int var6 = 0; var6 < var3; ++var6) {
            View var7;
            int var8 = helper.getDecoratedStart(var7 = layoutManager.getChildAt(var6));
            if ((var8 = Math.abs(helper.getDecoratedMeasurement(var7) / 2 + var8 - var9)) < var5) {
               var5 = var8;
               var4 = var7;
            }
         }

         return var4;
      }
   }

   private final OrientationHelper getVerticalHelper(LayoutManager layoutManager) {
      OrientationHelper var2;
      if ((var2 = this.mVerticalHelper) == null || (var2 != null ? var2.getLayoutManager() : null) != layoutManager) {
         this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
      }

      OrientationHelper var10000 = this.mVerticalHelper;
      Intrinsics.checkNotNull(var10000);
      return var10000;
   }

   private final OrientationHelper getHorizontalHelper(LayoutManager layoutManager) {
      OrientationHelper var2;
      if ((var2 = this.mHorizontalHelper) == null || (var2 != null ? var2.getLayoutManager() : null) != layoutManager) {
         this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
      }

      OrientationHelper var10000 = this.mHorizontalHelper;
      Intrinsics.checkNotNull(var10000);
      return var10000;
   }

   public int[] calculateDistanceToFinalSnap(LayoutManager layoutManager, View targetView) {
      Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
      Intrinsics.checkNotNullParameter(targetView, "targetView");
      int[] var3 = new int[2];
      if (layoutManager.canScrollHorizontally()) {
         OrientationHelper var4 = this.getHorizontalHelper(layoutManager);
         var3[0] = this.distanceToFirst(layoutManager, targetView, var4);
      } else {
         var3[0] = 0;
      }

      if (layoutManager.canScrollVertically()) {
         StartSnapHelper var10001 = this;
         OrientationHelper var5 = this.getVerticalHelper(layoutManager);
         var3[1] = var10001.distanceToFirst(layoutManager, targetView, var5);
      } else {
         var3[1] = 0;
      }

      return var3;
   }

   public View findSnapView(LayoutManager layoutManager) {
      Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
      if (layoutManager.canScrollVertically()) {
         return this.findFirstView(layoutManager, this.getVerticalHelper(layoutManager));
      } else {
         return layoutManager.canScrollHorizontally() ? this.findFirstView(layoutManager, this.getHorizontalHelper(layoutManager)) : null;
      }
   }
}
