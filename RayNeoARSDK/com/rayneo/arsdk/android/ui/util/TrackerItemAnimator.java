package com.rayneo.arsdk.android.ui.util;

import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.rayneo.arsdk.android.core.BindingPairKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/util/TrackerItemAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "isLeft", "", "checkPosSelected", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "(ZLkotlin/jvm/functions/Function1;)V", "onAnimationFinished", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "MercurySDK_release"}
)
public final class TrackerItemAnimator extends DefaultItemAnimator {
   private final boolean isLeft;
   private final Function1<Integer, Boolean> checkPosSelected;

   public TrackerItemAnimator(boolean isLeft, Function1<? super Integer, Boolean> checkPosSelected) {
      Intrinsics.checkNotNullParameter(checkPosSelected, "checkPosSelected");
      super();
      this.isLeft = isLeft;
      this.checkPosSelected = checkPosSelected;
      this.setSupportsChangeAnimations(false);
   }

   public void onAnimationFinished(ViewHolder viewHolder) {
      ViewHolder var10000 = viewHolder;
      Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
      int viewHolder1 = viewHolder.getAdapterPosition();
      View var2 = var10000.itemView;
      Intrinsics.checkNotNullExpressionValue(var2, "viewHolder.itemView");
      BindingPairKt.make3DEffectForSide$default(var2, this.isLeft, (Boolean)this.checkPosSelected.invoke(viewHolder1), 0.0F, 8, (Object)null);
   }
}
