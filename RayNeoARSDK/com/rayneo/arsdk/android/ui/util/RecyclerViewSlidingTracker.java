package com.rayneo.arsdk.android.ui.util;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.rayneo.arsdk.android.R.id;
import com.rayneo.arsdk.android.core.EventReceiver;
import com.rayneo.arsdk.android.core.MotionEventDispatcher;
import com.rayneo.arsdk.android.core.ViewPair;
import com.rayneo.arsdk.android.focus.IFocusable;
import com.rayneo.arsdk.android.touch.TempleAction;
import com.rayneo.arsdk.android.touch.a;
import com.rayneo.arsdk.android.util.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 A2\u00020\u0001:\u0001AB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020\u0007J\u0010\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0004H\u0002J\"\u00101\u001a\u00020)2\u0006\u00102\u001a\u0002032\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020)0\u0012J\b\u00105\u001a\u00020)H\u0007J\u0006\u00106\u001a\u00020)J\u000e\u00107\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0007J\"\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u00102\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012J\u0010\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020\u0013H\u0016J\u000e\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0007J\u0010\u0010?\u001a\u00020)2\b\b\u0002\u0010@\u001a\u00020+R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006B"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/util/RecyclerViewSlidingTracker;", "Lcom/rayneo/arsdk/android/core/EventReceiver;", "mPair", "Lcom/rayneo/arsdk/android/core/ViewPair;", "Landroidx/recyclerview/widget/RecyclerView;", "(Lcom/rayneo/arsdk/android/core/ViewPair;)V", "<set-?>", "", "currentSelectPos", "getCurrentSelectPos", "()I", "focusObj", "Lcom/rayneo/arsdk/android/focus/IFocusable;", "getFocusObj", "()Lcom/rayneo/arsdk/android/focus/IFocusable;", "mDispatcher", "Lcom/rayneo/arsdk/android/core/MotionEventDispatcher;", "mEventTransform", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "getMPair", "()Lcom/rayneo/arsdk/android/core/ViewPair;", "onFocusChangeListener", "Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;", "getOnFocusChangeListener", "()Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;", "setOnFocusChangeListener", "(Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;)V", "onItemFocusListener", "Lcom/rayneo/arsdk/android/ui/util/OnItemFocusListener;", "getOnItemFocusListener", "()Lcom/rayneo/arsdk/android/ui/util/OnItemFocusListener;", "setOnItemFocusListener", "(Lcom/rayneo/arsdk/android/ui/util/OnItemFocusListener;)V", "refreshListener", "Lcom/rayneo/arsdk/android/ui/util/PullToRefreshListener;", "getRefreshListener", "()Lcom/rayneo/arsdk/android/ui/util/PullToRefreshListener;", "setRefreshListener", "(Lcom/rayneo/arsdk/android/ui/util/PullToRefreshListener;)V", "autoRegisterWhenFocusChange", "", "change", "", "checkPosSelected", "pos", "checkedSelectPos", "findSelectedPosition", "recyclerView", "handleActionEvent", "it", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "block", "notifyDataSetChanged", "notifyFocusChanged", "notifyItemChanged", "observeOriginMotionEventStream", "dispatcher", "eventTransform", "onReceiveEvent", "event", "setCurrentSelectPos", "index", "smoothScrollToPosition", "smoothScroll", "Companion", "MercurySDK_release"}
)
public final class RecyclerViewSlidingTracker implements EventReceiver {
   public static final RecyclerViewSlidingTracker.Companion Companion = new RecyclerViewSlidingTracker.Companion((DefaultConstructorMarker)null);
   public static final String TAG = "RecyclerViewSlidingTracker";
   private final ViewPair<RecyclerView> mPair;
   private final IFocusable focusObj;
   private int currentSelectPos;
   private PullToRefreshListener refreshListener;
   private OnItemFocusListener onItemFocusListener;
   private OnTrackerFocusChangeListener onFocusChangeListener;
   private MotionEventDispatcher mDispatcher;
   private Function1<? super MotionEvent, MotionEvent> mEventTransform;

   public RecyclerViewSlidingTracker(ViewPair<RecyclerView> mPair) {
      Intrinsics.checkNotNullParameter(mPair, "mPair");
      super();
      this.mPair = mPair;
      this.focusObj = new IFocusable() {
         private boolean hasFocus;
         private IFocusable focusParent;

         public boolean getHasFocus() {
            return this.hasFocus;
         }

         public void setHasFocus(boolean value) {
            boolean var2;
            if (this.hasFocus != value) {
               var2 = true;
            } else {
               var2 = false;
            }

            if (var2) {
               this.hasFocus = value;
            }

            if (var2) {
               RecyclerViewSlidingTracker.this.notifyFocusChanged();
               OnTrackerFocusChangeListener var3;
               if ((var3 = RecyclerViewSlidingTracker.this.getOnFocusChangeListener()) != null) {
                  var3.onFocusChange(value);
               }
            }

            RecyclerViewSlidingTracker.this.autoRegisterWhenFocusChange(value);
         }

         public IFocusable getFocusParent() {
            return this.focusParent;
         }

         public void setFocusParent(IFocusable var1) {
            this.focusParent = var1;
         }
      };
      this.currentSelectPos = -1;
      ((RecyclerView)mPair.getLeft()).addOnScrollListener(new OnScrollListener() {
         public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0 && (newState = RecyclerViewSlidingTracker.this.findSelectedPosition(recyclerView)) != -1) {
               RecyclerViewSlidingTracker.this.setCurrentSelectPos(newState);
               OnItemFocusListener var3;
               if ((var3 = RecyclerViewSlidingTracker.this.getOnItemFocusListener()) != null) {
                  var3.OnItemFocus(newState, recyclerView);
               }

               RecyclerViewSlidingTracker.this.notifyDataSetChanged();
            }

         }

         public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            ((RecyclerView)RecyclerViewSlidingTracker.this.getMPair().getRight()).scrollBy(dx, dy);
         }
      });
   }

   private final void autoRegisterWhenFocusChange(boolean change) {
      MotionEventDispatcher change1;
      if (change) {
         if ((change1 = this.mDispatcher) != null) {
            change1.addEventReceiver(this);
         }
      } else if ((change1 = this.mDispatcher) != null) {
         change1.removeEventReceiver(this);
      }

   }

   private final int findSelectedPosition(RecyclerView recyclerView) {
      LayoutManager var2;
      if ((var2 = recyclerView.getLayoutManager()) == null) {
         return -1;
      } else {
         SnapHelper recyclerView1;
         View recyclerView2;
         return (recyclerView1 = (SnapHelper)recyclerView.getTag(id.tag_snap_helper)) != null && (recyclerView2 = recyclerView1.findSnapView(var2)) != null ? var2.getPosition(recyclerView2) : -1;
      }
   }

   // $FF: synthetic method
   public static void smoothScrollToPosition$default(RecyclerViewSlidingTracker var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = true;
      }

      var0.smoothScrollToPosition(var1);
   }

   public final ViewPair<RecyclerView> getMPair() {
      return this.mPair;
   }

   public final IFocusable getFocusObj() {
      return this.focusObj;
   }

   public final int getCurrentSelectPos() {
      return this.currentSelectPos;
   }

   public final PullToRefreshListener getRefreshListener() {
      return this.refreshListener;
   }

   public final void setRefreshListener(PullToRefreshListener var1) {
      this.refreshListener = var1;
   }

   public final OnItemFocusListener getOnItemFocusListener() {
      return this.onItemFocusListener;
   }

   public final void setOnItemFocusListener(OnItemFocusListener var1) {
      this.onItemFocusListener = var1;
   }

   public final OnTrackerFocusChangeListener getOnFocusChangeListener() {
      return this.onFocusChangeListener;
   }

   public final void setOnFocusChangeListener(OnTrackerFocusChangeListener var1) {
      this.onFocusChangeListener = var1;
   }

   public final void observeOriginMotionEventStream(MotionEventDispatcher dispatcher, Function1<? super MotionEvent, MotionEvent> eventTransform) {
      Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
      Intrinsics.checkNotNullParameter(eventTransform, "eventTransform");
      this.mDispatcher = dispatcher;
      this.mEventTransform = eventTransform;
      this.autoRegisterWhenFocusChange(this.focusObj.getHasFocus());
   }

   public void onReceiveEvent(MotionEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      Function1 var2;
      if ((var2 = this.mEventTransform) != null) {
         MotionEvent var10000 = (MotionEvent)var2.invoke(event);
         ((RecyclerView)this.mPair.getLeft()).dispatchTouchEvent(var10000);
         var10000.recycle();
      }

   }

   public final void setCurrentSelectPos(int index) {
      this.currentSelectPos = index;
   }

   public final void handleActionEvent(TempleAction it, Function1<? super TempleAction, Unit> block) {
      Intrinsics.checkNotNullParameter(it, "it");
      Intrinsics.checkNotNullParameter(block, "block");
      if (this.focusObj.getHasFocus()) {
         if (!(it instanceof TempleAction.DoubleClick) && !(it instanceof TempleAction.Click)) {
            if (it instanceof TempleAction.SlideBackward) {
               this.mPair.setLeft(new Function1<RecyclerView, Unit>() {
                  public final void invoke(RecyclerView $this$setLeft) {
                     Intrinsics.checkNotNullParameter($this$setLeft, "$this$setLeft");
                     PullToRefreshListener var2;
                     int $this$setLeft1;
                     if (($this$setLeft1 = RecyclerViewSlidingTracker.this.findSelectedPosition($this$setLeft)) != -1 && $this$setLeft1 == 0 && (var2 = RecyclerViewSlidingTracker.this.getRefreshListener()) != null) {
                        var2.onRefresh();
                     }

                  }
               });
            }
         } else {
            block.invoke(it);
            it.setConsumed(true);
         }

      }
   }

   public final int checkedSelectPos() {
      return this.focusObj.getHasFocus() ? this.currentSelectPos : -1;
   }

   public final boolean checkPosSelected(int pos) {
      return this.currentSelectPos == pos && this.focusObj.getHasFocus();
   }

   public final void notifyItemChanged(final int pos) {
      this.mPair.update(new Function1<RecyclerView, Unit>() {
         public final void invoke(RecyclerView $this$update) {
            Intrinsics.checkNotNullParameter($this$update, "$this$update");
            Adapter $this$update1;
            if (($this$update1 = $this$update.getAdapter()) != null) {
               $this$update1.notifyItemChanged(pos);
            }

         }
      });
   }

   public final void notifyFocusChanged() {
      this.notifyItemChanged(this.currentSelectPos);
   }

   public final void notifyDataSetChanged() {
      this.mPair.update(null.INSTANCE);
   }

   public final void smoothScrollToPosition(final boolean smoothScroll) {
      FLogger.i("rilke", a.a("smoothScrollToPosition, currentPos = ").append(this.currentSelectPos).toString());
      if (this.currentSelectPos != -1) {
         this.mPair.update(new Function1<RecyclerView, Unit>() {
            public final void invoke(RecyclerView $this$update) {
               Intrinsics.checkNotNullParameter($this$update, "$this$update");
               if (smoothScroll) {
                  $this$update.smoothScrollToPosition(RecyclerViewSlidingTracker.this.getCurrentSelectPos());
               } else {
                  LayoutManager var10000 = $this$update.getLayoutManager();
                  Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                  ((LinearLayoutManager)var10000).scrollToPositionWithOffset(RecyclerViewSlidingTracker.this.getCurrentSelectPos(), 0);
               }

            }
         });
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"},
      d2 = {"Lcom/rayneo/arsdk/android/ui/util/RecyclerViewSlidingTracker$Companion;", "", "()V", "TAG", "", "MercurySDK_release"}
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
