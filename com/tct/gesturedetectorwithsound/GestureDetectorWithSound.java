package com.tct.gesturedetectorwithsound;

import android.content.Context;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.System;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class GestureDetectorWithSound {
   // $FF: synthetic field
   public static final int k;
   public Context a;
   public GestureDetector b;
   public GestureDetector c;
   public GestureDetectorWithSound.a d;
   public GestureDetectorWithSound.b e;
   public int f;
   public boolean g = false;
   public float h = 100.0F;
   public float i = 400.0F;
   public MotionEvent j;

   public GestureDetectorWithSound(Context var1, GestureDetectorWithSound.ExtendedSimpleOnGestureListener var2, GestureDetectorWithSound.ExtendedSimpleOnGestureListener var3) {
      this.a = var1;
      int var4;
      int var10000 = var4 = System.getInt(var1.getContentResolver(), "major_tp_type", 0);
      this.f = var4;
      if (var10000 != 1 && var4 != 0) {
         Log.d("GestureDetectorWithSound", "settings.system.major_tp_type invalid, only can be 0 or 1, please check!");
         this.f = 0;
      }

      GestureDetector var10001;
      GestureDetector var6;
      Context var7;
      if (var2 != null) {
         GestureDetectorWithSound.a var5;
         var5 = new GestureDetectorWithSound.a.<init>(this.a, var2);
         this.d = var5;
         var10001 = var6 = new GestureDetector;
         var7 = this.a;
         var10001.<init>(var7, this.d);
         this.b = var6;
      }

      if (var3 != null) {
         GestureDetectorWithSound.b var8;
         var8 = new GestureDetectorWithSound.b.<init>(var3);
         this.e = var8;
         var10001 = var6 = new GestureDetector;
         var7 = this.a;
         var10001.<init>(var7, this.e);
         this.c = var6;
      }

      this.h = System.getFloat(this.a.getContentResolver(), "scale_for_gd", 100.0F);
      this.i = System.getFloat(this.a.getContentResolver(), "scale_for_ring", 400.0F);
      Log.d("GestureDetectorWithSound", com.rayneo.arsdk.android.touch.a.a("mRingScaleForGD =").append(this.h).append(",mRingScaleForRing=").append(this.i).toString());
   }

   public static MotionEvent a(GestureDetectorWithSound var0, MotionEvent var1) {
      if (var0.a(var1) == 2) {
         MotionEvent var2;
         MotionEvent var10000 = var2 = MotionEvent.obtain(var1);
         MotionEvent var10002 = var1;
         float var5 = var1.getX();
         float var3 = var10002.getY();
         float var10001 = var0.i / var0.h;
         float var4 = var10001 * var5;
         var5 = var10001 * var3;
         var10000.setLocation(var4, var5);
         Log.d("GestureDetectorWithSound", "originalX =" + var4 + ",originalY=" + var5);
         var1 = var2;
      }

      return var1;
   }

   public static float a(GestureDetectorWithSound var0) {
      return var0.h / var0.i;
   }

   public final boolean a(int var1) {
      GestureDetectorWithSound.a var3;
      if ((var3 = this.d) != null) {
         boolean var10000;
         switch(var1) {
         case 0:
         case 1:
         case 2:
         case 3:
            var10000 = true;
            break;
         default:
            Log.d("GestureDetectorWithSound", "Unknown gesture type!");
            var10000 = false;
         }

         if (!var10000) {
            Log.d("GestureDetectorWithSound", "GestureType inValid");
            var10000 = false;
         } else {
            Log.d("GestureDetectorWithSound", com.rayneo.arsdk.android.touch.a.a("disable touch sound for type ").append(var3.b(var1)).toString());
            var3.a(var1, false);
            var10000 = true;
         }

         return var10000;
      } else {
         return false;
      }
   }

   public final boolean b(int var1) {
      GestureDetectorWithSound.a var3;
      if ((var3 = this.d) != null) {
         boolean var10000;
         switch(var1) {
         case 0:
         case 1:
         case 2:
         case 3:
            var10000 = true;
            break;
         default:
            Log.d("GestureDetectorWithSound", "Unknown gesture type!");
            var10000 = false;
         }

         if (!var10000) {
            Log.d("GestureDetectorWithSound", "GestureType inValid");
            var10000 = false;
         } else {
            Log.d("GestureDetectorWithSound", com.rayneo.arsdk.android.touch.a.a("enable touch sound for type").append(var3.b(var1)).toString());
            var3.a(var1, true);
            var10000 = true;
         }

         return var10000;
      } else {
         return false;
      }
   }

   public final void a() {
      GestureDetectorWithSound.a var1;
      if ((var1 = this.d) != null) {
         Log.d("GestureDetectorWithSound", "disable all system touch sound");
         var1.a(0, false);
         var1.a(1, false);
         var1.a(2, false);
         var1.a(3, false);
      }

   }

   public final int a(MotionEvent var1) {
      if (var1 == null) {
         return -1;
      } else {
         MotionEvent var10000 = var1;
         String var3 = "";

         label27: {
            String var4;
            try {
               var4 = var10000.getDevice().getName();
            } catch (Exception var2) {
               var2.printStackTrace();
               break label27;
            }

            var3 = var4;
         }

         if (var3.equals("iqs7211a")) {
            return 1;
         } else if (var3.equals("iqs7211b")) {
            return 0;
         } else if (var3.equals("Virtual")) {
            return 2;
         } else {
            Log.d("GestureDetectorWithSound", "Unknown tp type, name=" + var3);
            return -1;
         }
      }
   }

   private class b extends GestureDetectorWithSound.ExtendedSimpleOnGestureListener {
      public GestureDetectorWithSound.ExtendedSimpleOnGestureListener a;
      public GestureDetectorWithSound.b.a b;

      public b(GestureDetectorWithSound.ExtendedSimpleOnGestureListener var1) {
         this.a = var1;
         GestureDetectorWithSound.b.a var2;
         var2 = new GestureDetectorWithSound.b.a.<init>();
         this.b = var2;
      }

      public final boolean onSingleTapUp(MotionEvent var1) {
         if (this.b.hasMessages(0)) {
            GestureDetectorWithSound.b var10000 = this;
            GestureDetectorWithSound.b var10002 = this;
            GestureDetectorWithSound.b var10003 = this;
            this.b.removeMessages(0);
            Message var2 = this.b.obtainMessage(1, var1);
            var10003.b.sendMessageDelayed(var2, 450L);
            var10002.a.onTripleTap(var1);
            return var10000.onSingleTapUp(var1);
         } else {
            return super.onSingleTapUp(var1);
         }
      }

      public final boolean onSingleTapConfirmed(MotionEvent var1) {
         if (this.b.hasMessages(1)) {
            this.b.removeMessages(1);
            return super.onSingleTapConfirmed(var1);
         } else {
            this.a.onSingleTapConfirmed(var1);
            return super.onSingleTapConfirmed(var1);
         }
      }

      public final boolean onDoubleTap(MotionEvent var1) {
         if (this.b.hasMessages(1)) {
            this.b.removeMessages(1);
            return super.onDoubleTap(var1);
         } else {
            GestureDetectorWithSound.b var10000 = this;
            GestureDetectorWithSound.b var10002 = this;
            Message var2 = this.b.obtainMessage(0, var1);
            var10002.b.sendMessageDelayed(var2, 450L);
            return var10000.onDoubleTap(var1);
         }
      }

      public final boolean onDoubleTapEvent(MotionEvent var1) {
         return super.onDoubleTapEvent(var1);
      }

      public final boolean onFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
         label17: {
            label16: {
               float var5 = var1.getX();
               float var6 = var1.getX();
               float var7 = var1.getY();
               float var10000 = var2.getY();
               var5 = var6 - var5;
               var6 = var10000 - var7;
               if (Math.abs(var5) > Math.abs(var6)) {
                  if (var5 <= 0.0F) {
                     break label16;
                  }
               } else if (var6 < 0.0F) {
                  break label16;
               }

               this.a.onFlingBackward(var1, var2, var3, var4);
               break label17;
            }

            this.a.onFlingForward(var1, var2, var3, var4);
         }

         this.a.onFling(var1, var2, var3, var4);
         return super.onFling(var1, var2, var3, var4);
      }

      public final void onLongPress(MotionEvent var1) {
         this.a.onLongPress(var1);
         super.onLongPress(var1);
      }

      public final boolean onDown(MotionEvent var1) {
         this.a.onDown(var1);
         return super.onDown(var1);
      }

      public final boolean onUp(MotionEvent var1) {
         this.a.onUp(var1);
         return super.onUp(var1);
      }

      public final boolean onTripleTap(MotionEvent var1) {
         return super.onTripleTap(var1);
      }

      public final boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
         label17: {
            label16: {
               float var5 = var1.getX();
               float var6 = var1.getX();
               float var7 = var1.getY();
               float var10000 = var2.getY();
               var5 = var6 - var5;
               var6 = var10000 - var7;
               if (Math.abs(var5) > Math.abs(var6)) {
                  if (var5 <= 0.0F) {
                     break label16;
                  }
               } else if (var6 < 0.0F) {
                  break label16;
               }

               this.a.onScrollBackward(var1, var2, var3, var4);
               break label17;
            }

            this.a.onScrollForward(var1, var2, var3, var4);
         }

         this.a.onScroll(var1, var2, var3, var4);
         return super.onScroll(var1, var2, var3, var4);
      }

      private class a extends Handler {
         public a() {
         }

         public final void handleMessage(Message var1) {
            int var2;
            if ((var2 = var1.what) != 0) {
               if (var2 == 1) {
                  int var10000 = GestureDetectorWithSound.k;
                  Log.d("GestureDetectorWithSound", "tripletap timeout");
               }
            } else {
               b.this.a.onDoubleTap((MotionEvent)var1.obj);
            }

         }
      }
   }

   private class a extends GestureDetectorWithSound.ExtendedSimpleOnGestureListener {
      public Context a;
      public GestureDetectorWithSound.ExtendedSimpleOnGestureListener b;
      public GestureDetectorWithSound.a.b c;
      public GestureDetectorWithSound.a.b d;
      public GestureDetectorWithSound.a.b e;
      public GestureDetectorWithSound.a.b f;
      public SoundPool g;
      public GestureDetectorWithSound.a.c h;
      public final Map<Integer, Integer> i = new ConcurrentHashMap();
      public final Set<Integer> j = new HashSet();
      public GestureDetectorWithSound.a.b[] k;
      public <undefinedtype> l = new OnLoadCompleteListener() {
         public final void onLoadComplete(SoundPool var1, int var2, int var3) {
            GestureDetectorWithSound.a var4;
            if (var1 == (var4 = a.this).g) {
               if (var3 == 0) {
                  var4.j.add(var2);
               }

            }
         }
      };

      public a(Context var2, GestureDetectorWithSound.ExtendedSimpleOnGestureListener var3) {
         this.a = var2;
         this.b = var3;
         this.h = new GestureDetectorWithSound.a.c();
         this.a();
         SoundPool var4;
         SoundPool var10001 = var4 = new SoundPool;
         var4.<init>(4, 2, 1);
         this.g = var4;
         var10001.setOnLoadCompleteListener(this.l);
         if (this.g != null) {
            this.b();
         }

      }

      public final String b(int var1) {
         switch(var1) {
         case 0:
            return "mercury_system_single_tap_right";
         case 1:
            return "mercury_system_double_click_right";
         case 2:
            return "mercury_system_fling_right";
         case 3:
            return "mercury_system_long_press_right";
         default:
            return "";
         }
      }

      public final int a(int var1) {
         GestureDetectorWithSound.a var10000 = this;
         String var3 = this.b(var1);

         try {
            return var10000.a.getResources().getIdentifier(var3, "raw", "android");
         } catch (Exception var2) {
            throw var2;
         }
      }

      public final void a() {
         GestureDetectorWithSound.a.b var1;
         var1 = new GestureDetectorWithSound.a.b.<init>(this.a(0));
         this.c = var1;
         var1 = new GestureDetectorWithSound.a.b.<init>(this.a(1));
         this.d = var1;
         var1 = new GestureDetectorWithSound.a.b.<init>(this.a(2));
         this.e = var1;
         var1 = new GestureDetectorWithSound.a.b.<init>(this.a(3));
         this.f = var1;
         GestureDetectorWithSound.a.b[] var2;
         GestureDetectorWithSound.a.b[] var10001 = var2 = new GestureDetectorWithSound.a.b[4];
         var2[0] = this.c;
         var2[1] = this.d;
         var10001[2] = this.e;
         var10001[3] = var1;
         this.k = var2;
      }

      public final boolean c(int var1) {
         if (var1 <= 0) {
            int var10000 = GestureDetectorWithSound.k;
            Log.d("GestureDetectorWithSound", "sound effect stay the same!");
            return false;
         } else {
            return true;
         }
      }

      public final boolean a(GestureDetectorWithSound.a.b var1) {
         if (!var1.a) {
            int var10000 = GestureDetectorWithSound.k;
            Log.d("GestureDetectorWithSound", "sound effect is disabled");
            return false;
         } else {
            int var2;
            if (this.c(var2 = var1.c) && (var2 = (Integer)this.i.get(var2)) > 0 && this.j.contains(var2)) {
               this.g.play(var2, 1.0F, 1.0F, 0, 0, 1.0F);
            }

            return false;
         }
      }

      public final void b() {
         int var10000 = GestureDetectorWithSound.k;
         Log.d("GestureDetectorWithSound", "load original touch sound");

         GestureDetectorWithSound.a.b[] var2;
         for(int var1 = 0; var1 < (var2 = this.k).length; ++var1) {
            int var4;
            if (!this.c(var4 = var2[var1].b)) {
               var4 = -1;
            } else if (this.i.containsKey(var4)) {
               var4 = (Integer)this.i.get(var4);
            } else {
               int var3 = this.g.load(this.a, var4, 0);
               ConcurrentHashMap var6 = this.i;
               Integer var5 = var4;
               var6.put(var5, var3);
               var4 = var3;
            }

            var10000 = GestureDetectorWithSound.k;
            Log.d("GestureDetectorWithSound", com.rayneo.arsdk.android.touch.a.a("preLoadOriginalSounds: res=").append(this.k[var1].b).append(",sample id=").append(var4).toString());
         }

      }

      public final boolean onSingleTapUp(MotionEvent var1) {
         var1 = GestureDetectorWithSound.a(GestureDetectorWithSound.this, var1);
         if (this.h.hasMessages(0)) {
            GestureDetectorWithSound.a var10000 = this;
            GestureDetectorWithSound.a var10002 = this;
            GestureDetectorWithSound.a var10003 = this;
            this.h.removeMessages(0);
            Message var2 = this.h.obtainMessage(1, var1);
            var10003.h.sendMessageDelayed(var2, 450L);
            var10002.b.onTripleTap(var1);
            return var10000.onSingleTapUp(var1);
         } else {
            return super.onSingleTapUp(var1);
         }
      }

      public final boolean onSingleTapConfirmed(MotionEvent var1) {
         var1 = GestureDetectorWithSound.a(GestureDetectorWithSound.this, var1);
         if (this.h.hasMessages(1)) {
            this.h.removeMessages(1);
            return super.onSingleTapConfirmed(var1);
         } else {
            this.a(this.c);
            this.b.onSingleTapConfirmed(var1);
            return super.onSingleTapConfirmed(var1);
         }
      }

      public final boolean onDoubleTap(MotionEvent var1) {
         var1 = GestureDetectorWithSound.a(GestureDetectorWithSound.this, var1);
         if (this.h.hasMessages(1)) {
            this.h.removeMessages(1);
            return super.onDoubleTap(var1);
         } else {
            GestureDetectorWithSound.a var10000 = this;
            GestureDetectorWithSound.a var10002 = this;
            Message var2 = this.h.obtainMessage(0, var1);
            var10002.h.sendMessageDelayed(var2, 450L);
            return var10000.onDoubleTap(var1);
         }
      }

      public final boolean onDoubleTapEvent(MotionEvent var1) {
         return super.onDoubleTapEvent(GestureDetectorWithSound.a(GestureDetectorWithSound.this, var1));
      }

      public final boolean onFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
         this.a(this.e);
         MotionEvent var5 = GestureDetectorWithSound.a(GestureDetectorWithSound.this, var1);
         var2 = GestureDetectorWithSound.a(GestureDetectorWithSound.this, var2);
         if (GestureDetectorWithSound.this.a(var1) == 2) {
            var3 = GestureDetectorWithSound.a((GestureDetectorWithSound)GestureDetectorWithSound.this) * var3;
            var4 = GestureDetectorWithSound.a((GestureDetectorWithSound)GestureDetectorWithSound.this) * var4;
         }

         label20: {
            label19: {
               float var8 = var5.getX();
               float var6 = var2.getX();
               float var7 = var5.getY();
               float var10000 = var2.getY();
               var8 = var6 - var8;
               var6 = var10000 - var7;
               if (Math.abs(var8) > Math.abs(var6)) {
                  if (var8 <= 0.0F) {
                     break label19;
                  }
               } else if (var6 < 0.0F) {
                  break label19;
               }

               this.b.onFlingBackward(var5, var2, var3, var4);
               break label20;
            }

            this.b.onFlingForward(var5, var2, var3, var4);
         }

         this.b.onFling(var5, var2, var3, var4);
         return super.onFling(var5, var2, var3, var4);
      }

      public final boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
         MotionEvent var5 = GestureDetectorWithSound.a(GestureDetectorWithSound.this, var1);
         var2 = GestureDetectorWithSound.a(GestureDetectorWithSound.this, var2);
         if (GestureDetectorWithSound.this.a(var1) == 2) {
            var3 = GestureDetectorWithSound.a((GestureDetectorWithSound)GestureDetectorWithSound.this) * var3;
            var4 = GestureDetectorWithSound.a((GestureDetectorWithSound)GestureDetectorWithSound.this) * var4;
         }

         label20: {
            label19: {
               float var8 = var5.getX();
               float var6 = var2.getX();
               float var7 = var5.getY();
               float var10000 = var2.getY();
               var8 = var6 - var8;
               var6 = var10000 - var7;
               if (Math.abs(var8) > Math.abs(var6)) {
                  if (var8 <= 0.0F) {
                     break label19;
                  }
               } else if (var6 < 0.0F) {
                  break label19;
               }

               this.b.onScrollBackward(var5, var2, var3, var4);
               break label20;
            }

            this.b.onScrollForward(var5, var2, var3, var4);
         }

         this.b.onScroll(var5, var2, var3, var4);
         return super.onScroll(var5, var2, var3, var4);
      }

      public final void onLongPress(MotionEvent var1) {
         var1 = GestureDetectorWithSound.a(GestureDetectorWithSound.this, var1);
         this.a(this.f);
         this.b.onLongPress(var1);
         super.onLongPress(var1);
      }

      public final boolean onDown(MotionEvent var1) {
         MotionEvent var10001 = GestureDetectorWithSound.a(GestureDetectorWithSound.this, var1);
         this.b.onDown(var10001);
         return super.onDown(var10001);
      }

      public final boolean onUp(MotionEvent var1) {
         MotionEvent var10001 = GestureDetectorWithSound.a(GestureDetectorWithSound.this, var1);
         this.b.onUp(var10001);
         return super.onUp(var10001);
      }

      public final boolean onTripleTap(MotionEvent var1) {
         return super.onTripleTap(GestureDetectorWithSound.a(GestureDetectorWithSound.this, var1));
      }

      public final void a(int var1, boolean var2) {
         GestureDetectorWithSound.a.b var10000;
         switch(var1) {
         case 0:
            var10000 = this.c;
            break;
         case 1:
            var10000 = this.d;
            break;
         case 2:
            var10000 = this.e;
            break;
         case 3:
            var10000 = this.f;
            break;
         default:
            return;
         }

         var10000.a = var2;
      }

      public class b {
         public boolean a = true;
         public final int b;
         public int c;

         public b(int var2) {
            this.b = var2;
            this.c = var2;
         }
      }

      public class c extends Handler {
         public final void handleMessage(Message var1) {
            int var2;
            if ((var2 = var1.what) != 0) {
               if (var2 == 1) {
                  int var10000 = GestureDetectorWithSound.k;
                  Log.d("GestureDetectorWithSound", "TripleTap timeout");
               }
            } else {
               GestureDetectorWithSound.a var10001 = a.this;
               var10001.a(var10001.d);
               a.this.b.onDoubleTap((MotionEvent)var1.obj);
            }

         }
      }
   }

   public static class ExtendedSimpleOnGestureListener implements OnGestureListener, OnDoubleTapListener {
      public boolean onSingleTapUp(MotionEvent e) {
         return false;
      }

      public void onLongPress(MotionEvent e) {
      }

      public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
         return false;
      }

      public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
         return false;
      }

      public void onShowPress(MotionEvent e) {
      }

      public boolean onDown(MotionEvent e) {
         return false;
      }

      public boolean onDoubleTap(MotionEvent e) {
         return false;
      }

      public boolean onDoubleTapEvent(MotionEvent e) {
         return false;
      }

      public boolean onSingleTapConfirmed(MotionEvent e) {
         return false;
      }

      public boolean onTripleTap(MotionEvent e) {
         return false;
      }

      public boolean onUp(MotionEvent e) {
         return false;
      }

      public boolean onFlingBackward(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
         return false;
      }

      public boolean onFlingForward(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
         return false;
      }

      public boolean onScrollForward(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
         return false;
      }

      public boolean onScrollBackward(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
         return false;
      }
   }
}
