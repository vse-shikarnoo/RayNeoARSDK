package com.ffalconxr.mercury.ipc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.IBinder.DeathRecipient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ffalconxr.mercury.ipc.speech.ISpeechInterface;
import com.ffalconxr.mercury.ipc.speech.Speech;
import java.util.concurrent.CopyOnWriteArraySet;

public class Launcher {
   private static final String TAG = "Launcher";
   private static final String LAUNCHER_APP_ID = "com.ffalconxr.mercury.launcher";
   private static final String SERVICE_CLASS_NAME = "com.ffalconxr.mercury.launcher.ipc.RemoteMultiService";
   public static final int BINDER_TYPE_DEFAULT = 0;
   public static final int BINDER_TYPE_SPEECH = 1;
   @SuppressLint({"StaticFieldLeak"})
   private static volatile Launcher instance;
   private final Speech speech;
   private final Context mContext;
   private IRemoteService mRemoteService;
   private IBinderFactory binderFactory;
   private final CopyOnWriteArraySet<Launcher.OnResponseListener> mResponseListeners;
   private final CopyOnWriteArraySet<Launcher.OnConnectionStateListener> mConnectionStateListeners;
   private DeathRecipient deathRecipient;
   private final ServiceConnection mServiceConnection;
   private final IRemoteServiceCallback.Stub mRemoteServiceCallback;
   private ActivityLifecycleCallbacks ipcLifecycle;

   public boolean isReady() {
      return this.mRemoteService != null;
   }

   public synchronized void connect() {
      if (this.isReady()) {
         LogUtil.d(TAG, "Already bind the remote service");
      } else {
         this.bindRemoteService();
      }
   }

   public synchronized void disConnect() {
      if (this.isReady()) {
         Launcher var10000 = this;
         this.mContext.unbindService(this.mServiceConnection);

         try {
            var10000.mRemoteService.unRegister(this.mRemoteServiceCallback, this.mContext.getPackageName());
         } catch (RemoteException var2) {
            var2.printStackTrace();
         }

         this.mRemoteService = null;
         System.gc();
         LogUtil.d(TAG, "Already unbind the remote service");
      } else {
         LogUtil.d(TAG, "remote service has not bind yet");
      }

   }

   public void request(String var1) {
      LogUtil.d(TAG, "request() --> " + var1);
      IRemoteService var2;
      if ((var2 = this.mRemoteService) != null) {
         try {
            var2.request(new Request(this.mContext.getPackageName(), var1));
         } catch (RemoteException var3) {
            var3.printStackTrace();
         }

      }
   }

   public Speech getSpeech() {
      return this.speech;
   }

   public void addOnResponseListener(Launcher.OnResponseListener var1) {
      this.mResponseListeners.add(var1);
   }

   public void removeOnResponseListener(Launcher.OnResponseListener var1) {
      this.mResponseListeners.remove(var1);
   }

   public void addOnConnectionState(Launcher.OnConnectionStateListener var1) {
      this.mConnectionStateListeners.add(var1);
      this.notifyConnectionStateChanged();
   }

   public void removeOnConnectionStateListener(Launcher.OnConnectionStateListener var1) {
      this.mConnectionStateListeners.remove(var1);
   }

   public void disableLog() {
      LogUtil.disableLog();
   }

   public void enableLog() {
      LogUtil.enableLog();
   }

   private Launcher(Context var1) {
      Launcher var10000 = this;
      Launcher var10001 = this;
      Launcher var10002 = this;
      super();
      this.mRemoteService = null;
      this.binderFactory = null;
      CopyOnWriteArraySet var2;
      var2 = new CopyOnWriteArraySet.<init>();
      this.mResponseListeners = var2;
      var2 = new CopyOnWriteArraySet.<init>();
      this.mConnectionStateListeners = var2;
      DeathRecipient var4;
      var4 = new DeathRecipient() {
         // $FF: synthetic field
         public final Launcher this$0;

         public {
            this.this$0 = var1;
         }

         public void binderDied() {
            LogUtil.e(Launcher.access$000(), "binderDied");
            if (Launcher.access$100(this.this$0) != null) {
               Launcher.access$100(this.this$0).asBinder().unlinkToDeath(Launcher.access$200(this.this$0), 0);
            }

            Launcher.access$300(this.this$0);
         }
      }.<init>();
      this.deathRecipient = var4;
      ServiceConnection var5;
      var5 = new ServiceConnection() {
         // $FF: synthetic field
         public final Launcher this$0;

         public {
            this.this$0 = var1;
         }

         public void onServiceConnected(ComponentName var1, IBinder var2) {
            <undefinedtype> var10000 = this;
            <undefinedtype> var10001 = this;
            <undefinedtype> var10002 = this;
            <undefinedtype> var10003 = this;
            IBinder var10004 = var2;
            <undefinedtype> var10005 = this;
            <undefinedtype> var10006 = this;
            LogUtil.d(Launcher.access$000(), "onServiceConnected() --> " + var1);

            RemoteException var9;
            label42: {
               boolean var10;
               try {
                  Launcher.access$102(var10006.this$0, IBinderFactory.Stub.asInterface(var2));
               } catch (RemoteException var6) {
                  var9 = var6;
                  var10 = false;
                  break label42;
               }

               IRemoteService var12;
               try {
                  var10004.linkToDeath(Launcher.access$200(var10005.this$0), 0);
                  var12 = IRemoteService.Stub.asInterface(Launcher.access$100(var10003.this$0).generateBinder(0));
               } catch (RemoteException var5) {
                  var9 = var5;
                  var10 = false;
                  break label42;
               }

               IRemoteService var7 = var12;

               ISpeechInterface var11;
               try {
                  var11 = ISpeechInterface.Stub.asInterface(Launcher.access$100(var10002.this$0).generateBinder(1));
               } catch (RemoteException var4) {
                  var9 = var4;
                  var10 = false;
                  break label42;
               }

               ISpeechInterface var8 = var11;

               try {
                  Launcher.access$400(var10001.this$0, var7);
                  Launcher.access$500(var10000.this$0).setService(var8);
                  return;
               } catch (RemoteException var3) {
                  var9 = var3;
                  var10 = false;
               }
            }

            var9.printStackTrace();
         }

         public void onServiceDisconnected(ComponentName var1) {
            <undefinedtype> var10000 = this;
            LogUtil.d(Launcher.access$000(), "onServiceDisconnected() --> " + var1.toString());

            try {
               Launcher.access$800(var10000.this$0).unRegister(Launcher.access$600(this.this$0), Launcher.access$700(this.this$0).getPackageName());
            } catch (RemoteException var2) {
               var2.printStackTrace();
            }

            Launcher.access$802(this.this$0, (IRemoteService)null);
         }
      }.<init>();
      this.mServiceConnection = var5;
      IRemoteServiceCallback.Stub var6;
      var6 = new IRemoteServiceCallback.Stub() {
         // $FF: synthetic field
         public final Launcher this$0;

         public {
            this.this$0 = var1;
         }

         // $FF: synthetic method
         private static void lambda$onResponse$0(Response var0, Launcher.OnResponseListener var1) {
            var1.onResponse(var0);
         }

         public void onResponse(Response var1) {
            LogUtil.d(Launcher.access$000(), "onResponse() --> " + var1);
            if (var1.getPackages().contains(Launcher.access$700(this.this$0).getPackageName())) {
               Launcher.access$900(this.this$0).forEach((var1) -> {
                  var1.onResponse(var0);
               });
            }
         }
      }.<init>();
      this.mRemoteServiceCallback = var6;
      ActivityLifecycleCallbacks var7;
      var7 = new ActivityLifecycleCallbacks() {
         private int activeActivities;
         // $FF: synthetic field
         public final Launcher this$0;

         public {
            this.this$0 = var1;
            this.activeActivities = 0;
         }

         public void onActivityCreated(@NonNull Activity var1, @Nullable Bundle var2) {
            LogUtil.i(Launcher.access$000(), "onActivityCreated: " + this.activeActivities);
         }

         public void onActivityStarted(@NonNull Activity var1) {
            ++this.activeActivities;
            LogUtil.i(Launcher.access$000(), "onActivityStarted: " + this.activeActivities);
            if (this.activeActivities == 1) {
               TopPackageHelper.addTopPackage(Launcher.access$700(this.this$0));
            }

         }

         public void onActivityResumed(@NonNull Activity var1) {
            LogUtil.i(Launcher.access$000(), "onActivityResumed: " + this.activeActivities);
         }

         public void onActivityPaused(@NonNull Activity var1) {
            LogUtil.i(Launcher.access$000(), "onActivityPaused: " + this.activeActivities);
         }

         public void onActivityStopped(@NonNull Activity var1) {
            --this.activeActivities;
            LogUtil.i(Launcher.access$000(), "onActivityStopped: " + this.activeActivities);
            if (this.activeActivities == 0) {
               TopPackageHelper.removeTopPackage(Launcher.access$700(this.this$0));
            }

         }

         public void onActivitySaveInstanceState(@NonNull Activity var1, @NonNull Bundle var2) {
            LogUtil.i(Launcher.access$000(), "onActivitySaveInstanceState: " + this.activeActivities);
         }

         public void onActivityDestroyed(@NonNull Activity var1) {
            LogUtil.i(Launcher.access$000(), "onActivityDestroyed: " + this.activeActivities);
         }
      }.<init>();
      this.ipcLifecycle = var7;
      this.mContext = var1;
      Speech var3;
      var3 = new Speech.<init>();
      var10002.speech = var3;
      var10001.bindRemoteService();
      var10000.registerActivityLifecycle(var1);
   }

   public static Launcher getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private void setService(IRemoteService var1) {
      IRemoteService var10000 = var1;
      Launcher var10001 = this;
      this.mRemoteService = var1;

      try {
         var10000.register(var10001.mRemoteServiceCallback, this.mContext.getPackageName());
      } catch (RemoteException var2) {
         var2.printStackTrace();
      }

      this.notifyConnectionStateChanged();
   }

   private void registerActivityLifecycle(Context var1) {
      ((Application)var1.getApplicationContext()).registerActivityLifecycleCallbacks(this.ipcLifecycle);
   }

   private void bindRemoteService() {
      String var10000 = TAG;
      LogUtil.d(var10000, "bindRemoteService()");
      Intent var1;
      Intent var10002 = var1 = new Intent;
      var10002.<init>();
      var10002.setComponent(new ComponentName("com.ffalconxr.mercury.launcher", "com.ffalconxr.mercury.launcher.ipc.RemoteMultiService"));
      LogUtil.d(var10000, "bind remote service success: " + this.mContext.bindService(var1, this.mServiceConnection, 1));
   }

   private void notifyConnectionStateChanged() {
      this.mConnectionStateListeners.forEach((var1) -> {
         Launcher.ConnectionState var2;
         if (this.isReady()) {
            var2 = Launcher.ConnectionState.CONNECTED;
         } else {
            var2 = Launcher.ConnectionState.DISCONNECTED;
         }

         var1.onConnectionState(var2);
      });
   }

   // $FF: synthetic method
   public static String access$000() {
      return TAG;
   }

   // $FF: synthetic method
   public static IBinderFactory access$100(Launcher var0) {
      return var0.binderFactory;
   }

   // $FF: synthetic method
   public static DeathRecipient access$200(Launcher var0) {
      return var0.deathRecipient;
   }

   // $FF: synthetic method
   public static void access$300(Launcher var0) {
      var0.bindRemoteService();
   }

   // $FF: synthetic method
   public static IBinderFactory access$102(Launcher var0, IBinderFactory var1) {
      var0.binderFactory = var1;
      return var1;
   }

   // $FF: synthetic method
   public static void access$400(Launcher var0, IRemoteService var1) {
      var0.setService(var1);
   }

   // $FF: synthetic method
   public static Speech access$500(Launcher var0) {
      return var0.speech;
   }

   // $FF: synthetic method
   public static IRemoteServiceCallback.Stub access$600(Launcher var0) {
      return var0.mRemoteServiceCallback;
   }

   // $FF: synthetic method
   public static Context access$700(Launcher var0) {
      return var0.mContext;
   }

   // $FF: synthetic method
   public static IRemoteService access$800(Launcher var0) {
      return var0.mRemoteService;
   }

   // $FF: synthetic method
   public static IRemoteService access$802(Launcher var0, IRemoteService var1) {
      var0.mRemoteService = var1;
      return var1;
   }

   // $FF: synthetic method
   public static CopyOnWriteArraySet access$900(Launcher var0) {
      return var0.mResponseListeners;
   }

   public static enum ConnectionState {
      CONNECTED,
      DISCONNECTED;

      // $FF: synthetic method
      private static Launcher.ConnectionState[] $values() {
         return new Launcher.ConnectionState[]{CONNECTED, DISCONNECTED};
      }
   }

   public interface OnConnectionStateListener {
      void onConnectionState(Launcher.ConnectionState var1);
   }

   public interface OnResponseListener {
      void onResponse(Response var1);
   }
}
