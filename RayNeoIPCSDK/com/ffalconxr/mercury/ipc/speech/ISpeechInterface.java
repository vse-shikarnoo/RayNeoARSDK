package com.ffalconxr.mercury.ipc.speech;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ISpeechInterface extends IInterface {
   void startDialog(INLPCallback var1, Bundle var2);

   void stopDialog();

   void startTTS(String var1, ITTSListener var2);

   void stopTTS();

   void setAiuiListener(IAIUIEventListener var1);

   public abstract static class Stub extends Binder implements ISpeechInterface {
      private static final String DESCRIPTOR = "com.ffalconxr.mercury.ipc.speech.ISpeechInterface";
      public static final int TRANSACTION_startDialog = 1;
      public static final int TRANSACTION_stopDialog = 2;
      public static final int TRANSACTION_startTTS = 3;
      public static final int TRANSACTION_stopTTS = 4;
      public static final int TRANSACTION_setAiuiListener = 5;

      public Stub() {
         this.attachInterface(this, "com.ffalconxr.mercury.ipc.speech.ISpeechInterface");
      }

      public static ISpeechInterface asInterface(IBinder var0) {
         if (var0 == null) {
            return null;
         } else {
            IInterface var1;
            return (ISpeechInterface)((var1 = var0.queryLocalInterface("com.ffalconxr.mercury.ipc.speech.ISpeechInterface")) != null && var1 instanceof ISpeechInterface ? (ISpeechInterface)var1 : new ISpeechInterface.Stub.Proxy(var0));
         }
      }

      public static boolean setDefaultImpl(ISpeechInterface var0) {
         if (ISpeechInterface.Stub.Proxy.sDefaultImpl == null) {
            if (var0 != null) {
               ISpeechInterface.Stub.Proxy.sDefaultImpl = var0;
               return true;
            } else {
               return false;
            }
         } else {
            throw new IllegalStateException("setDefaultImpl() called twice");
         }
      }

      public static ISpeechInterface getDefaultImpl() {
         return ISpeechInterface.Stub.Proxy.sDefaultImpl;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
         String var5 = "com.ffalconxr.mercury.ipc.speech.ISpeechInterface";
         if (var1 != 1598968902) {
            switch(var1) {
            case 1:
               var2.enforceInterface(var5);
               INLPCallback var6 = INLPCallback.Stub.asInterface(var2.readStrongBinder());
               Bundle var7;
               if (var2.readInt() != 0) {
                  var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var7 = null;
               }

               this.startDialog(var6, var7);
               var3.writeNoException();
               return true;
            case 2:
               var2.enforceInterface(var5);
               this.stopDialog();
               var3.writeNoException();
               return true;
            case 3:
               var2.enforceInterface(var5);
               this.startTTS(var2.readString(), ITTSListener.Stub.asInterface(var2.readStrongBinder()));
               var3.writeNoException();
               return true;
            case 4:
               var2.enforceInterface(var5);
               this.stopTTS();
               var3.writeNoException();
               return true;
            case 5:
               var2.enforceInterface(var5);
               this.setAiuiListener(IAIUIEventListener.Stub.asInterface(var2.readStrongBinder()));
               var3.writeNoException();
               return true;
            default:
               return super.onTransact(var1, var2, var3, var4);
            }
         } else {
            var3.writeString(var5);
            return true;
         }
      }

      public static class Proxy implements ISpeechInterface {
         public static ISpeechInterface sDefaultImpl;
         private IBinder mRemote;

         public Proxy(IBinder var1) {
            this.mRemote = var1;
         }

         public IBinder asBinder() {
            return this.mRemote;
         }

         public String getInterfaceDescriptor() {
            return "com.ffalconxr.mercury.ipc.speech.ISpeechInterface";
         }

         public void startDialog(INLPCallback param1, Bundle param2) {
            // $FF: Couldn't be decompiled
         }

         public void stopDialog() {
            ISpeechInterface.Stub.Proxy var10000 = this;
            Parcel var23;
            Parcel var10001 = var23 = Parcel.obtain();
            Parcel var1 = Parcel.obtain();

            Throwable var24;
            label190: {
               boolean var25;
               boolean var26;
               try {
                  var10001.writeInterfaceToken("com.ffalconxr.mercury.ipc.speech.ISpeechInterface");
                  var25 = var10000.mRemote.transact(2, var23, var1, 0);
               } catch (Throwable var22) {
                  var24 = var22;
                  var26 = false;
                  break label190;
               }

               Parcel var28;
               if (!var25) {
                  ISpeechInterface var27;
                  try {
                     var27 = ISpeechInterface.Stub.getDefaultImpl();
                  } catch (Throwable var21) {
                     var24 = var21;
                     var26 = false;
                     break label190;
                  }

                  if (var27 != null) {
                     try {
                        var28 = var23;
                        var10001 = var1;
                        ISpeechInterface.Stub.getDefaultImpl().stopDialog();
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

         public void startTTS(String var1, ITTSListener var2) {
            Parcel var3;
            Parcel var10001 = var3 = Parcel.obtain();
            String var10002 = var1;
            Parcel var10003 = var3;
            Parcel var4 = Parcel.obtain();

            Throwable var10000;
            label371: {
               boolean var49;
               try {
                  var10003.writeInterfaceToken("com.ffalconxr.mercury.ipc.speech.ISpeechInterface");
                  var10001.writeString(var10002);
               } catch (Throwable var47) {
                  var10000 = var47;
                  var49 = false;
                  break label371;
               }

               IBinder var5;
               if (var2 != null) {
                  IBinder var48;
                  try {
                     var48 = var2.asBinder();
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
                  var50 = this.mRemote.transact(3, var3, var4, 0);
               } catch (Throwable var45) {
                  var10000 = var45;
                  var49 = false;
                  break label371;
               }

               Parcel var52;
               if (!var50) {
                  ISpeechInterface var51;
                  try {
                     var51 = ISpeechInterface.Stub.getDefaultImpl();
                  } catch (Throwable var44) {
                     var10000 = var44;
                     var49 = false;
                     break label371;
                  }

                  if (var51 != null) {
                     try {
                        var52 = var3;
                        var10001 = var4;
                        ISpeechInterface.Stub.getDefaultImpl().startTTS(var1, var2);
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

         public void stopTTS() {
            ISpeechInterface.Stub.Proxy var10000 = this;
            Parcel var23;
            Parcel var10001 = var23 = Parcel.obtain();
            Parcel var1 = Parcel.obtain();

            Throwable var24;
            label190: {
               boolean var25;
               boolean var26;
               try {
                  var10001.writeInterfaceToken("com.ffalconxr.mercury.ipc.speech.ISpeechInterface");
                  var25 = var10000.mRemote.transact(4, var23, var1, 0);
               } catch (Throwable var22) {
                  var24 = var22;
                  var26 = false;
                  break label190;
               }

               Parcel var28;
               if (!var25) {
                  ISpeechInterface var27;
                  try {
                     var27 = ISpeechInterface.Stub.getDefaultImpl();
                  } catch (Throwable var21) {
                     var24 = var21;
                     var26 = false;
                     break label190;
                  }

                  if (var27 != null) {
                     try {
                        var28 = var23;
                        var10001 = var1;
                        ISpeechInterface.Stub.getDefaultImpl().stopTTS();
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

         public void setAiuiListener(IAIUIEventListener var1) {
            Parcel var2;
            Parcel var10001 = var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            Throwable var10000;
            label371: {
               boolean var48;
               try {
                  var10001.writeInterfaceToken("com.ffalconxr.mercury.ipc.speech.ISpeechInterface");
               } catch (Throwable var46) {
                  var10000 = var46;
                  var48 = false;
                  break label371;
               }

               IBinder var4;
               if (var1 != null) {
                  IBinder var47;
                  try {
                     var47 = var1.asBinder();
                  } catch (Throwable var45) {
                     var10000 = var45;
                     var48 = false;
                     break label371;
                  }

                  var4 = var47;
               } else {
                  var4 = null;
               }

               boolean var49;
               try {
                  var2.writeStrongBinder(var4);
                  var49 = this.mRemote.transact(5, var2, var3, 0);
               } catch (Throwable var44) {
                  var10000 = var44;
                  var48 = false;
                  break label371;
               }

               Parcel var51;
               if (!var49) {
                  ISpeechInterface var50;
                  try {
                     var50 = ISpeechInterface.Stub.getDefaultImpl();
                  } catch (Throwable var43) {
                     var10000 = var43;
                     var48 = false;
                     break label371;
                  }

                  if (var50 != null) {
                     try {
                        var51 = var2;
                        var10001 = var3;
                        ISpeechInterface.Stub.getDefaultImpl().setAiuiListener(var1);
                     } catch (Throwable var41) {
                        var10000 = var41;
                        var48 = false;
                        break label371;
                     }

                     var10001.recycle();
                     var51.recycle();
                     return;
                  }
               }

               try {
                  var51 = var2;
                  var10001 = var3;
                  var3.readException();
               } catch (Throwable var42) {
                  var10000 = var42;
                  var48 = false;
                  break label371;
               }

               var10001.recycle();
               var51.recycle();
               return;
            }

            var3.recycle();
            var2.recycle();
            throw var10000;
         }
      }
   }

   public static class Default implements ISpeechInterface {
      public void startDialog(INLPCallback var1, Bundle var2) {
      }

      public void stopDialog() {
      }

      public void startTTS(String var1, ITTSListener var2) {
      }

      public void stopTTS() {
      }

      public void setAiuiListener(IAIUIEventListener var1) {
      }

      public IBinder asBinder() {
         return null;
      }
   }
}
