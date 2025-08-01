package com.ffalconxr.mercury.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IRemoteService extends IInterface {
   void register(IRemoteServiceCallback var1, String var2);

   void request(Request var1);

   void unRegister(IRemoteServiceCallback var1, String var2);

   public abstract static class Stub extends Binder implements IRemoteService {
      private static final String DESCRIPTOR = "com.ffalconxr.mercury.ipc.IRemoteService";
      public static final int TRANSACTION_register = 1;
      public static final int TRANSACTION_request = 2;
      public static final int TRANSACTION_unRegister = 3;

      public Stub() {
         this.attachInterface(this, "com.ffalconxr.mercury.ipc.IRemoteService");
      }

      public static IRemoteService asInterface(IBinder var0) {
         if (var0 == null) {
            return null;
         } else {
            IInterface var1;
            return (IRemoteService)((var1 = var0.queryLocalInterface("com.ffalconxr.mercury.ipc.IRemoteService")) != null && var1 instanceof IRemoteService ? (IRemoteService)var1 : new IRemoteService.Stub.Proxy(var0));
         }
      }

      public static boolean setDefaultImpl(IRemoteService var0) {
         if (IRemoteService.Stub.Proxy.sDefaultImpl == null) {
            if (var0 != null) {
               IRemoteService.Stub.Proxy.sDefaultImpl = var0;
               return true;
            } else {
               return false;
            }
         } else {
            throw new IllegalStateException("setDefaultImpl() called twice");
         }
      }

      public static IRemoteService getDefaultImpl() {
         return IRemoteService.Stub.Proxy.sDefaultImpl;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
         String var5 = "com.ffalconxr.mercury.ipc.IRemoteService";
         IRemoteService.Stub var10001;
         IRemoteServiceCallback var6;
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 3) {
                  if (var1 != 1598968902) {
                     return super.onTransact(var1, var2, var3, var4);
                  } else {
                     var3.writeString(var5);
                     return true;
                  }
               } else {
                  var10001 = this;
                  var2.enforceInterface(var5);
                  var6 = IRemoteServiceCallback.Stub.asInterface(var2.readStrongBinder());
                  var10001.unRegister(var6, var2.readString());
                  var3.writeNoException();
                  return true;
               }
            } else {
               var2.enforceInterface(var5);
               Request var7;
               if (var2.readInt() != 0) {
                  var7 = (Request)Request.CREATOR.createFromParcel(var2);
               } else {
                  var7 = null;
               }

               this.request(var7);
               var3.writeNoException();
               return true;
            }
         } else {
            var10001 = this;
            var2.enforceInterface(var5);
            var6 = IRemoteServiceCallback.Stub.asInterface(var2.readStrongBinder());
            var10001.register(var6, var2.readString());
            var3.writeNoException();
            return true;
         }
      }

      private static class Proxy implements IRemoteService {
         public static IRemoteService sDefaultImpl;
         private IBinder mRemote;

         public Proxy(IBinder var1) {
            this.mRemote = var1;
         }

         public IBinder asBinder() {
            return this.mRemote;
         }

         public String getInterfaceDescriptor() {
            return "com.ffalconxr.mercury.ipc.IRemoteService";
         }

         public void register(IRemoteServiceCallback var1, String var2) {
            Parcel var3;
            Parcel var10001 = var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            Throwable var10000;
            label371: {
               boolean var49;
               try {
                  var10001.writeInterfaceToken("com.ffalconxr.mercury.ipc.IRemoteService");
               } catch (Throwable var47) {
                  var10000 = var47;
                  var49 = false;
                  break label371;
               }

               IBinder var5;
               if (var1 != null) {
                  IBinder var48;
                  try {
                     var48 = var1.asBinder();
                  } catch (Throwable var46) {
                     var10000 = var46;
                     var49 = false;
                     break label371;
                  }

                  var5 = var48;
               } else {
                  var5 = null;
               }

               boolean var50;
               try {
                  var3.writeStrongBinder(var5);
                  var3.writeString(var2);
                  var50 = this.mRemote.transact(1, var3, var4, 0);
               } catch (Throwable var45) {
                  var10000 = var45;
                  var49 = false;
                  break label371;
               }

               Parcel var52;
               if (!var50) {
                  IRemoteService var51;
                  try {
                     var51 = IRemoteService.Stub.getDefaultImpl();
                  } catch (Throwable var44) {
                     var10000 = var44;
                     var49 = false;
                     break label371;
                  }

                  if (var51 != null) {
                     try {
                        var52 = var3;
                        var10001 = var4;
                        IRemoteService.Stub.getDefaultImpl().register(var1, var2);
                     } catch (Throwable var42) {
                        var10000 = var42;
                        var49 = false;
                        break label371;
                     }

                     var10001.recycle();
                     var52.recycle();
                     return;
                  }
               }

               try {
                  var52 = var3;
                  var10001 = var4;
                  var4.readException();
               } catch (Throwable var43) {
                  var10000 = var43;
                  var49 = false;
                  break label371;
               }

               var10001.recycle();
               var52.recycle();
               return;
            }

            var4.recycle();
            var3.recycle();
            throw var10000;
         }

         public void request(Request param1) {
            // $FF: Couldn't be decompiled
         }

         public void unRegister(IRemoteServiceCallback var1, String var2) {
            Parcel var3;
            Parcel var10001 = var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            Throwable var10000;
            label371: {
               boolean var49;
               try {
                  var10001.writeInterfaceToken("com.ffalconxr.mercury.ipc.IRemoteService");
               } catch (Throwable var47) {
                  var10000 = var47;
                  var49 = false;
                  break label371;
               }

               IBinder var5;
               if (var1 != null) {
                  IBinder var48;
                  try {
                     var48 = var1.asBinder();
                  } catch (Throwable var46) {
                     var10000 = var46;
                     var49 = false;
                     break label371;
                  }

                  var5 = var48;
               } else {
                  var5 = null;
               }

               boolean var50;
               try {
                  var3.writeStrongBinder(var5);
                  var3.writeString(var2);
                  var50 = this.mRemote.transact(3, var3, var4, 0);
               } catch (Throwable var45) {
                  var10000 = var45;
                  var49 = false;
                  break label371;
               }

               Parcel var52;
               if (!var50) {
                  IRemoteService var51;
                  try {
                     var51 = IRemoteService.Stub.getDefaultImpl();
                  } catch (Throwable var44) {
                     var10000 = var44;
                     var49 = false;
                     break label371;
                  }

                  if (var51 != null) {
                     try {
                        var52 = var3;
                        var10001 = var4;
                        IRemoteService.Stub.getDefaultImpl().unRegister(var1, var2);
                     } catch (Throwable var42) {
                        var10000 = var42;
                        var49 = false;
                        break label371;
                     }

                     var10001.recycle();
                     var52.recycle();
                     return;
                  }
               }

               try {
                  var52 = var3;
                  var10001 = var4;
                  var4.readException();
               } catch (Throwable var43) {
                  var10000 = var43;
                  var49 = false;
                  break label371;
               }

               var10001.recycle();
               var52.recycle();
               return;
            }

            var4.recycle();
            var3.recycle();
            throw var10000;
         }
      }
   }

   public static class Default implements IRemoteService {
      public void register(IRemoteServiceCallback var1, String var2) {
      }

      public void request(Request var1) {
      }

      public void unRegister(IRemoteServiceCallback var1, String var2) {
      }

      public IBinder asBinder() {
         return null;
      }
   }
}
