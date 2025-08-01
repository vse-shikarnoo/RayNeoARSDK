package com.ffalconxr.mercury.ipc.speech;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ITTSListener extends IInterface {
   void onTTSStart();

   void onTTSComplete();

   public abstract static class Stub extends Binder implements ITTSListener {
      private static final String DESCRIPTOR = "com.ffalconxr.mercury.ipc.speech.ITTSListener";
      public static final int TRANSACTION_onTTSStart = 1;
      public static final int TRANSACTION_onTTSComplete = 2;

      public Stub() {
         this.attachInterface(this, "com.ffalconxr.mercury.ipc.speech.ITTSListener");
      }

      public static ITTSListener asInterface(IBinder var0) {
         if (var0 == null) {
            return null;
         } else {
            IInterface var1;
            return (ITTSListener)((var1 = var0.queryLocalInterface("com.ffalconxr.mercury.ipc.speech.ITTSListener")) != null && var1 instanceof ITTSListener ? (ITTSListener)var1 : new ITTSListener.Stub.Proxy(var0));
         }
      }

      public static boolean setDefaultImpl(ITTSListener var0) {
         if (ITTSListener.Stub.Proxy.sDefaultImpl == null) {
            if (var0 != null) {
               ITTSListener.Stub.Proxy.sDefaultImpl = var0;
               return true;
            } else {
               return false;
            }
         } else {
            throw new IllegalStateException("setDefaultImpl() called twice");
         }
      }

      public static ITTSListener getDefaultImpl() {
         return ITTSListener.Stub.Proxy.sDefaultImpl;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
         String var5 = "com.ffalconxr.mercury.ipc.speech.ITTSListener";
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 1598968902) {
                  return super.onTransact(var1, var2, var3, var4);
               } else {
                  var3.writeString(var5);
                  return true;
               }
            } else {
               var2.enforceInterface(var5);
               this.onTTSComplete();
               var3.writeNoException();
               return true;
            }
         } else {
            var2.enforceInterface(var5);
            this.onTTSStart();
            var3.writeNoException();
            return true;
         }
      }

      private static class Proxy implements ITTSListener {
         public static ITTSListener sDefaultImpl;
         private IBinder mRemote;

         public Proxy(IBinder var1) {
            this.mRemote = var1;
         }

         public IBinder asBinder() {
            return this.mRemote;
         }

         public String getInterfaceDescriptor() {
            return "com.ffalconxr.mercury.ipc.speech.ITTSListener";
         }

         public void onTTSStart() {
            ITTSListener.Stub.Proxy var10000 = this;
            Parcel var23;
            Parcel var10001 = var23 = Parcel.obtain();
            Parcel var1 = Parcel.obtain();

            Throwable var24;
            label190: {
               boolean var25;
               boolean var26;
               try {
                  var10001.writeInterfaceToken("com.ffalconxr.mercury.ipc.speech.ITTSListener");
                  var25 = var10000.mRemote.transact(1, var23, var1, 0);
               } catch (Throwable var22) {
                  var24 = var22;
                  var26 = false;
                  break label190;
               }

               Parcel var28;
               if (!var25) {
                  ITTSListener var27;
                  try {
                     var27 = ITTSListener.Stub.getDefaultImpl();
                  } catch (Throwable var21) {
                     var24 = var21;
                     var26 = false;
                     break label190;
                  }

                  if (var27 != null) {
                     try {
                        var28 = var23;
                        var10001 = var1;
                        ITTSListener.Stub.getDefaultImpl().onTTSStart();
                     } catch (Throwable var19) {
                        var24 = var19;
                        var26 = false;
                        break label190;
                     }

                     var10001.recycle();
                     var28.recycle();
                     return;
                  }
               }

               try {
                  var28 = var23;
                  var10001 = var1;
                  var1.readException();
               } catch (Throwable var20) {
                  var24 = var20;
                  var26 = false;
                  break label190;
               }

               var10001.recycle();
               var28.recycle();
               return;
            }

            var1.recycle();
            var23.recycle();
            throw var24;
         }

         public void onTTSComplete() {
            ITTSListener.Stub.Proxy var10000 = this;
            Parcel var23;
            Parcel var10001 = var23 = Parcel.obtain();
            Parcel var1 = Parcel.obtain();

            Throwable var24;
            label190: {
               boolean var25;
               boolean var26;
               try {
                  var10001.writeInterfaceToken("com.ffalconxr.mercury.ipc.speech.ITTSListener");
                  var25 = var10000.mRemote.transact(2, var23, var1, 0);
               } catch (Throwable var22) {
                  var24 = var22;
                  var26 = false;
                  break label190;
               }

               Parcel var28;
               if (!var25) {
                  ITTSListener var27;
                  try {
                     var27 = ITTSListener.Stub.getDefaultImpl();
                  } catch (Throwable var21) {
                     var24 = var21;
                     var26 = false;
                     break label190;
                  }

                  if (var27 != null) {
                     try {
                        var28 = var23;
                        var10001 = var1;
                        ITTSListener.Stub.getDefaultImpl().onTTSComplete();
                     } catch (Throwable var19) {
                        var24 = var19;
                        var26 = false;
                        break label190;
                     }

                     var10001.recycle();
                     var28.recycle();
                     return;
                  }
               }

               try {
                  var28 = var23;
                  var10001 = var1;
                  var1.readException();
               } catch (Throwable var20) {
                  var24 = var20;
                  var26 = false;
                  break label190;
               }

               var10001.recycle();
               var28.recycle();
               return;
            }

            var1.recycle();
            var23.recycle();
            throw var24;
         }
      }
   }

   public static class Default implements ITTSListener {
      public void onTTSStart() {
      }

      public void onTTSComplete() {
      }

      public IBinder asBinder() {
         return null;
      }
   }
}
