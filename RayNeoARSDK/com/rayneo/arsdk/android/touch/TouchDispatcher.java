package com.rayneo.arsdk.android.touch;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.rayneo.arsdk.android.MercurySDK;
import com.rayneo.arsdk.android.util.FLogger;
import com.rayneo.arsdk.android.util.MyTouchUtils;
import com.tct.gesturedetectorwithsound.GestureDetectorWithSound;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0002*+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018J\u0014\u0010!\u001a\u00020\u001c2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018H\u0002J\u001a\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020#2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018J\u0014\u0010$\u001a\u00020\u001c2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018H\u0002J\u0014\u0010%\u001a\u00020\u001c2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010&\u001a\u00020\u001cH\u0002J\u0016\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"},
   d2 = {"Lcom/rayneo/arsdk/android/touch/TouchDispatcher;", "", "source", "Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source;", "(Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source;)V", "IGNORE_DELTA", "", "LONG_PINCH_TIME", "", "currentDownPinchTime", "currentDownTime", "downX", "", "downY", "gestureDetector", "Lcom/tct/gesturedetectorwithsound/GestureDetectorWithSound;", "hasSetLongClick", "", "isLongClick", "isLongPinch", "lastDelta", "mHandler", "Landroid/os/Handler;", "touchCallback", "Lcom/rayneo/arsdk/android/touch/CommonTouchCallback;", "createExtendedGestureListener", "Lcom/tct/gesturedetectorwithsound/GestureDetectorWithSound$ExtendedSimpleOnGestureListener;", "onDoubleClick", "", "onKeyEvent", "event", "Landroid/view/KeyEvent;", "callback", "onLongPinch", "onMotionEvent", "Landroid/view/MotionEvent;", "onPinch", "onTPClick", "onTripleClick", "toggleClickSoundEffect", "type", "enable", "Companion", "Source", "MercurySDK_release"}
)
public final class TouchDispatcher {
   public static final TouchDispatcher.Companion Companion = new TouchDispatcher.Companion((DefaultConstructorMarker)null);
   private static final String TAG = "TouchDispatcher";
   private static final int KEY_RIGHT_PINCH = 320;
   private final TouchDispatcher.Source source;
   private final int IGNORE_DELTA;
   private float downX;
   private float downY;
   private long currentDownTime;
   private boolean isLongClick;
   private long currentDownPinchTime;
   private long LONG_PINCH_TIME;
   private boolean isLongPinch;
   private CommonTouchCallback touchCallback;
   private boolean hasSetLongClick;
   private float lastDelta;
   private final Handler mHandler;
   private final GestureDetectorWithSound gestureDetector;

   public TouchDispatcher(TouchDispatcher.Source source) {
      Intrinsics.checkNotNullParameter(source, "source");
      super();
      this.source = source;
      this.IGNORE_DELTA = 5;
      this.LONG_PINCH_TIME = 1000L;
      Looper var2 = Looper.getMainLooper();
      this.mHandler = new Handler(var2) {
         public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Object var2;
            if ((var2 = msg.obj) == null) {
               FLogger.e$default("TouchDispatcher", "msg,obj==null", (Throwable)null, 4, (Object)null);
            } else {
               TouchDispatcher var10000;
               int msg1;
               if ((msg1 = msg.what) != 3) {
                  if (msg1 == 4) {
                     var10000 = TouchDispatcher.this;
                     Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type com.rayneo.arsdk.android.touch.CommonTouchCallback");
                     var10000.onPinch((CommonTouchCallback)var2);
                  }
               } else {
                  var10000 = TouchDispatcher.this;
                  Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type com.rayneo.arsdk.android.touch.CommonTouchCallback");
                  var10000.onLongPinch((CommonTouchCallback)var2);
               }

            }
         }
      };
      GestureDetectorWithSound var6;
      GestureDetectorWithSound var10001 = var6 = new GestureDetectorWithSound;
      Application var3 = MercurySDK.INSTANCE.getMApplication();
      GestureDetectorWithSound.ExtendedSimpleOnGestureListener var4 = this.createExtendedGestureListener();
      GestureDetectorWithSound.ExtendedSimpleOnGestureListener var5 = this.createExtendedGestureListener();
      var10001.<init>(var3, var4, var5);
      if (Intrinsics.areEqual(source, TouchDispatcher.Source.Global.INSTANCE)) {
         var6.a();
      }

      if (Intrinsics.areEqual(source, TouchDispatcher.Source.Activity.INSTANCE)) {
         var6.a(3);
      }

      this.gestureDetector = var6;
   }

   private final GestureDetectorWithSound.ExtendedSimpleOnGestureListener createExtendedGestureListener() {
      return new GestureDetectorWithSound.ExtendedSimpleOnGestureListener() {
         public boolean onDown(MotionEvent e) {
            FLogger.v("TouchDispatcher", a.a("[source=").append(TouchDispatcher.this.source.getClass().getSimpleName()).append("]onDown").toString());
            TouchDispatcher.this.isLongClick = false;
            return true;
         }

         public void onLongPress(MotionEvent e) {
            FLogger.v("TouchDispatcher", a.a("[source=").append(TouchDispatcher.this.source.getClass().getSimpleName()).append("]onLongPress").toString());
            TouchDispatcher.this.isLongClick = true;
            CommonTouchCallback var2;
            if ((var2 = TouchDispatcher.this.touchCallback) != null) {
               var2.onTPLongClick();
            }

         }

         public boolean onSingleTapConfirmed(MotionEvent e) {
            FLogger.v("TouchDispatcher", a.a("[source=").append(TouchDispatcher.this.source.getClass().getSimpleName()).append("]onSingleTapConfirmed").toString());
            TouchDispatcher var10000 = TouchDispatcher.this;
            var10000.onTPClick(var10000.touchCallback);
            return true;
         }

         public boolean onDoubleTap(MotionEvent e) {
            FLogger.v("TouchDispatcher", a.a("[source=").append(TouchDispatcher.this.source.getClass().getSimpleName()).append("]onDoubleTap").toString());
            TouchDispatcher.this.onDoubleClick();
            return true;
         }

         public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            FlingArgs var7;
            CommonTouchCallback var8;
            label42: {
               Intrinsics.checkNotNullParameter(e1, "e1");
               Intrinsics.checkNotNullParameter(e2, "e2");
               float var5;
               float var10000 = var5 = e2.getX() - e1.getX();
               float var6 = e2.getY() - e1.getY();
               FLogger.v("TouchDispatcher", a.a("[source=").append(TouchDispatcher.this.source.getClass().getSimpleName()).append("]onFling: Vx=").append(velocityX).append(", dx(e2.x-e1.x)=").append(var5).append(",Vy=").append(velocityY).append(",dy(e2.y-e1.y)=").append(var6).toString());
               var7 = new FlingArgs.<init>(e1, e2, velocityX, velocityY);
               if (Math.abs(var10000) > Math.abs(var6)) {
                  if (var5 < 0.0F) {
                     if ((var8 = TouchDispatcher.this.touchCallback) == null) {
                        return true;
                     }
                     break label42;
                  }

                  if ((var8 = TouchDispatcher.this.touchCallback) == null) {
                     return true;
                  }
               } else {
                  if (var6 < 0.0F) {
                     if ((var8 = TouchDispatcher.this.touchCallback) == null) {
                        return true;
                     }
                     break label42;
                  }

                  if ((var8 = TouchDispatcher.this.touchCallback) == null) {
                     return true;
                  }
               }

               var8.onTPSlideBackward(var7);
               return true;
            }

            var8.onTPSlideForward(var7);
            return true;
         }

         public boolean onTripleTap(MotionEvent e) {
            FLogger.v("TouchDispatcher", a.a("[source=").append(TouchDispatcher.this.source.getClass().getSimpleName()).append("]onTripleTap").toString());
            TouchDispatcher.this.onTripleClick();
            return super.onTripleTap(e);
         }
      };
   }

   // $FF: synthetic method
   public static void onMotionEvent$default(TouchDispatcher var0, MotionEvent var1, CommonTouchCallback var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.onMotionEvent(var1, var2);
   }

   // $FF: synthetic method
   public static void onKeyEvent$default(TouchDispatcher var0, KeyEvent var1, CommonTouchCallback var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.onKeyEvent(var1, var2);
   }

   private final void onTPClick(CommonTouchCallback callback) {
      FLogger.v("TouchDispatcher", "onTPClick");
      if (callback != null) {
         callback.onTPClick();
      }

   }

   // $FF: synthetic method
   public static void onTPClick$default(TouchDispatcher var0, CommonTouchCallback var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = null;
      }

      var0.onTPClick(var1);
   }

   private final void onDoubleClick() {
      FLogger.v("TouchDispatcher", "onDoubleClick");
      CommonTouchCallback var1;
      if ((var1 = this.touchCallback) != null) {
         var1.onTPDoubleClick();
      }

   }

   private final void onTripleClick() {
      FLogger.v("TouchDispatcher", "onTripleClick");
      CommonTouchCallback var1;
      if ((var1 = this.touchCallback) != null) {
         var1.onTPTripleClick();
      }

   }

   private final void onPinch(CommonTouchCallback callback) {
      FLogger.d("TouchDispatcher", "onPinch " + callback);
      if (MyTouchUtils.isMonkey()) {
         if (callback != null) {
            callback.onTPDoubleClick();
         }
      } else if (callback != null) {
         callback.onKeyPinch();
      }

   }

   // $FF: synthetic method
   public static void onPinch$default(TouchDispatcher var0, CommonTouchCallback var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = null;
      }

      var0.onPinch(var1);
   }

   private final void onLongPinch(CommonTouchCallback callback) {
      this.isLongPinch = true;
      FLogger.d("TouchDispatcher", "onLongPinch");
      if (callback != null) {
         callback.onKeyLongPinch();
      }

   }

   // $FF: synthetic method
   public static void onLongPinch$default(TouchDispatcher var0, CommonTouchCallback var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = null;
      }

      var0.onLongPinch(var1);
   }

   public final void toggleClickSoundEffect(int type, boolean enable) {
      if (enable) {
         FLogger.d("TouchDispatcher", "Enable click sound effect");
         this.gestureDetector.b(type);
      } else {
         FLogger.d("TouchDispatcher", "Disable click sound effect");
         this.gestureDetector.a(type);
      }

   }

   public final void onMotionEvent(MotionEvent event, CommonTouchCallback callback) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (callback != null) {
         this.touchCallback = callback;
         GestureDetectorWithSound var3;
         if ((var3 = this.gestureDetector).d == null && var3.e == null) {
            Log.d("GestureDetectorWithSound", "No listeners!");
         } else {
            label102: {
               var3.f = System.getInt(var3.a.getContentResolver(), "major_tp_type", 0);
               int var4 = event.getAction();
               int var5;
               boolean var16;
               if ((var5 = var3.a(event)) != 2 && var5 != var3.f) {
                  var16 = false;
               } else {
                  var16 = true;
               }

               MotionEvent.obtain(event);
               if (var3.a(event) == 2) {
                  var3.g = true;
               } else {
                  var3.g = false;
               }

               if (var3.g) {
                  MotionEvent var6;
                  MotionEvent var10002 = var6 = MotionEvent.obtain(event);
                  float var7 = event.getX();
                  float var8 = event.getY();
                  float var10004 = var3.h / var3.i;
                  var7 = var10004 * var7;
                  var8 = var10004 * var8;
                  var10002.setLocation(var7, var8);
                  Log.d("GestureDetectorWithSound", "scaledX =" + var7 + ",scaledY=" + var8);
                  var3.j = var10002;
                  GestureDetectorWithSound.a var18;
                  if ((var4 & 255) == 1 && (var18 = var3.d) != null) {
                     var18.onUp(var6);
                  }

                  GestureDetector var17;
                  if ((var17 = var3.b) != null) {
                     var17.onTouchEvent(var3.j);
                     break label102;
                  }
               }

               GestureDetector var12;
               if (var16) {
                  GestureDetectorWithSound.a var14;
                  if ((var4 & 255) == 1 && (var14 = var3.d) != null) {
                     var14.onUp(event);
                  }

                  if ((var12 = var3.b) == null) {
                     break label102;
                  }
               } else {
                  GestureDetectorWithSound.b var15;
                  if ((var4 & 255) == 1 && (var15 = var3.e) != null) {
                     var15.onUp(event);
                  }

                  if ((var12 = var3.c) == null) {
                     break label102;
                  }
               }

               var12.onTouchEvent(event);
            }
         }

         int var13;
         if ((var13 = event.getAction()) != 0) {
            if (var13 != 1) {
               if (var13 == 2) {
                  FLogger.v("TouchDispatcher", a.a("[source=").append(this.source.getClass().getSimpleName()).append("]ACTION_MOVE").toString());
                  float callback1;
                  float var10000 = callback1 = event.getX() - this.downX;
                  float event1 = event.getY() - this.downY;
                  FLogger.v("TouchDispatcher", "deltaX=====" + callback1 + "   deltaY=====" + event1);
                  if (Math.abs(var10000) > (float)this.IGNORE_DELTA && Math.abs(callback1) > Math.abs(event1)) {
                     CommonTouchCallback event2;
                     if ((event2 = this.touchCallback) != null) {
                        event2.onTPSlideContinuous(callback1, this.isLongClick);
                     }
                  } else if (Math.abs(event1) > (float)this.IGNORE_DELTA && Math.abs(event1) > Math.abs(callback1) && (callback = this.touchCallback) != null) {
                     callback.onTPSlideContinuous(event1, this.isLongClick);
                  }
               }
            } else {
               FLogger.v("TouchDispatcher", a.a("[source=").append(this.source.getClass().getSimpleName()).append("]ACTION_UP").toString());
               if (this.isLongClick) {
                  callback.onTPMoveUp(true);
               }

               callback.onActionUp();
            }
         } else {
            this.downX = event.getX();
            this.downY = event.getY();
            this.currentDownTime = event.getDownTime();
            FLogger.v("TouchDispatcher", a.a("[source=").append(this.source.getClass().getSimpleName()).append("]ACTION_DOWN").toString());
         }

      }
   }

   public final void onKeyEvent(KeyEvent event, CommonTouchCallback callback) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (event.getKeyCode() == 320) {
         Message var10001;
         int var3;
         Message event1;
         if ((var3 = event.getAction()) != 0) {
            if (var3 == 1) {
               FLogger.d("TouchDispatcher", "Pinch_actionUP");
               this.mHandler.removeMessages(3);
               if (!this.isLongPinch) {
                  var10001 = event1 = Message.obtain();
                  var10001.obj = callback;
                  var10001.what = 4;
                  this.mHandler.sendMessage(event1);
               }

               this.isLongPinch = false;
            }
         } else {
            FLogger.d("TouchDispatcher", "Pinch_ACTION_DOWN");
            if (this.mHandler.hasMessages(3) || this.isLongPinch) {
               return;
            }

            this.currentDownPinchTime = event.getDownTime();
            var10001 = event1 = Message.obtain();
            var10001.obj = callback;
            var10001.what = 3;
            this.mHandler.sendMessageDelayed(event1, this.LONG_PINCH_TIME);
         }
      }

   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source;", "", "()V", "Activity", "Global", "Window", "Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source$Activity;", "Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source$Global;", "Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source$Window;", "MercurySDK_release"}
   )
   public abstract static class Source {
      private Source() {
      }

      // $FF: synthetic method
      public Source(DefaultConstructorMarker $constructor_marker) {
         this();
      }

      @Metadata(
         mv = {1, 7, 1},
         k = 1,
         xi = 48,
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
         d2 = {"Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source$Global;", "Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source;", "()V", "MercurySDK_release"}
      )
      public static final class Global extends TouchDispatcher.Source {
         public static final TouchDispatcher.Source.Global INSTANCE = new TouchDispatcher.Source.Global();

         private Global() {
            super((DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         mv = {1, 7, 1},
         k = 1,
         xi = 48,
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
         d2 = {"Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source$Activity;", "Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source;", "()V", "MercurySDK_release"}
      )
      public static final class Activity extends TouchDispatcher.Source {
         public static final TouchDispatcher.Source.Activity INSTANCE = new TouchDispatcher.Source.Activity();

         private Activity() {
            super((DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         mv = {1, 7, 1},
         k = 1,
         xi = 48,
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
         d2 = {"Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source$Window;", "Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Source;", "()V", "MercurySDK_release"}
      )
      public static final class Window extends TouchDispatcher.Source {
         public static final TouchDispatcher.Source.Window INSTANCE = new TouchDispatcher.Source.Window();

         private Window() {
            super((DefaultConstructorMarker)null);
         }
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TouchDispatcher$Companion;", "", "()V", "KEY_RIGHT_PINCH", "", "TAG", "", "MercurySDK_release"}
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
