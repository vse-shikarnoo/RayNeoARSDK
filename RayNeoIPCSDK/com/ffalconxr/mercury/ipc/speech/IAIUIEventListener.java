package com.ffalconxr.mercury.ipc.speech;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IAIUIEventListener extends IInterface {
   void onAIUIEvent(int var1, int var2, int var3, String var4);

   public abstract static class Stub extends Binder implements IAIUIEventListener {
      private static final String DESCRIPTOR = "com.ffalconxr.mercury.ipc.speech.IAIUIEventListener";
      public static final int TRANSACTION_onAIUIEvent = 1;

      public Stub() {
         this.attachInterface(this, "com.ffalconxr.mercury.ipc.speech.IAIUIEventListener");
      }

      public static IAIUIEventListener asInterface(IBinder var0) {
         if (var0 == null) {
            return null;
         } else {
            IInterface var1;
            return (IAIUIEventListener)((var1 = var0.queryLocalInterface("com.ffalconxr.mercury.ipc.speech.IAIUIEventListener")) != null && var1 instanceof IAIUIEventListener ? (IAIUIEventListener)var1 : new IAIUIEventListener.Stub.Proxy(var0));
         }
      }

      public static boolean setDefaultImpl(IAIUIEventListener var0) {
         if (IAIUIEventListener.Stub.Proxy.sDefaultImpl == null) {
            if (var0 != null) {
               IAIUIEventListener.Stub.Proxy.sDefaultImpl = var0;
               return true;
            } else {
               return false;
            }
         } else {
            throw new IllegalStateException("setDefaultImpl() called twice");
         }
      }

      public static IAIUIEventListener getDefaultImpl() {
         return IAIUIEventListener.Stub.Proxy.sDefaultImpl;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
         String var5 = "com.ffalconxr.mercury.ipc.speech.IAIUIEventListener";
         if (var1 != 1) {
            if (var1 != 1598968902) {
               return super.onTransact(var1, var2, var3, var4);
            } else {
               var3.writeString(var5);
               return true;
            }
         } else {
            Parcel var10000 = var3;
            IAIUIEventListener.Stub var10001 = this;
            Parcel var10002 = var2;
            var2.enforceInterface(var5);
            int var6 = var2.readInt();
            var1 = var2.readInt();
            int var7 = var2.readInt();
            String var8 = var10002.readString();
            var10001.onAIUIEvent(var6, var1, var7, var8);
            var10000.writeNoException();
            return true;
         }
      }

      private static class Proxy implements IAIUIEventListener {
         public static IAIUIEventListener sDefaultImpl;
         private IBinder mRemote;

         public Proxy(IBinder var1) {
            this.mRemote = var1;
         }

         public IBinder asBinder() {
            return this.mRemote;
         }

         public String getInterfaceDescriptor() {
            return "com.ffalconxr.mercury.ipc.speech.IAIUIEventListener";
         }

         public void onAIUIEvent(int var1, int var2, int var3, String var4) {
            IAIUIEventListener.Stub.Proxy var10000 = this;
            Parcel var26;
            Parcel var10001 = var26 = Parcel.obtain();
            String var10002 = var4;
            Parcel var10003 = var26;
            int var10004 = var3;
            Parcel var10005 = var26;
            int var10006 = var2;
            Parcel var10007 = var26;
            int var10008 = var1;
            Parcel var10009 = var26;
            Parcel var5 = Parcel.obtain();

            Throwable var27;
            label190: {
               boolean var28;
               boolean var29;
               try {
                  var10009.writeInterfaceToken("com.ffalconxr.mercury.ipc.speech.IAIUIEventListener");
                  var10007.writeInt(var10008);
                  var10005.writeInt(var10006);
                  var10003.writeInt(var10004);
                  var10001.writeString(var10002);
                  var28 = var10000.mRemote.transact(1, var26, var5, 0);
               } catch (Throwable var25) {
                  var27 = var25;
                  var29 = false;
                  break label190;
               }

               Parcel var31;
               if (!var28) {
                  IAIUIEventListener var30;
                  try {
                     var30 = IAIUIEventListener.Stub.getDefaultImpl();
                  } catch (Throwable var24) {
                     var27 = var24;
                     var29 = false;
                     break label190;
                  }

                  if (var30 != null) {
                     try {
                        var31 = var26;
                        var10001 = var5;
                        IAIUIEventListener.Stub.getDefaultImpl().onAIUIEvent(var1, var2, var3, var4);
                     } catch (Throwable var22) {
                        var27 = var22;
                        var29 = false;
                        break label190;
                     }

                     var10001.recycle();
                     var31.recycle();
                     return;
                  }
               }

               try {
                  var31 = var26;
                  var10001 = var5;
                  var5.readException();
               } catch (Throwable var23) {
                  var27 = var23;
                  var29 = false;
                  break label190;
               }

               var10001.recycle();
               var31.recycle();
               return;
            }

            var5.recycle();
            var26.recycle();
            throw var27;
         }
      }
   }

   public static class Default implements IAIUIEventListener {
      public void onAIUIEvent(int var1, int var2, int var3, String var4) {
      }

      public IBinder asBinder() {
         return null;
      }
   }
}
