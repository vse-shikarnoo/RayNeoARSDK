package com.ffalconxr.mercury.ipc.speech;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;

public class Speech {
   private ISpeechInterface speechInterface;

   private boolean checkBinder() {
      ISpeechInterface var1;
      return (var1 = this.speechInterface) == null ? false : var1.asBinder().isBinderAlive();
   }

   @RestrictTo({Scope.LIBRARY})
   public void setService(ISpeechInterface var1) {
      this.speechInterface = var1;
   }

   public void startDialog(INLPCallback var1, Bundle var2) {
      if (this.checkBinder()) {
         try {
            this.speechInterface.startDialog(var1, var2);
         } catch (RemoteException var3) {
            var3.printStackTrace();
         }

      }
   }

   public void stopDialog() {
      if (this.checkBinder()) {
         try {
            this.speechInterface.stopDialog();
         } catch (RemoteException var1) {
            var1.printStackTrace();
         }

      }
   }

   public void startTTS(String var1, Speech.TTSListener var2) {
      if (this.checkBinder()) {
         try {
            this.speechInterface.startTTS(var1, var2);
         } catch (RemoteException var3) {
            var3.printStackTrace();
         }

      }
   }

   public void stopTTS() {
      if (this.checkBinder()) {
         try {
            this.speechInterface.stopTTS();
         } catch (RemoteException var1) {
            var1.printStackTrace();
         }

      }
   }

   public void setAIUIListener(Speech.AIUIListener var1) {
      if (this.checkBinder()) {
         try {
            this.speechInterface.setAiuiListener(var1);
         } catch (RemoteException var2) {
            var2.printStackTrace();
         }

      }
   }

   public abstract static class AIUIListener extends IAIUIEventListener.Stub {
   }

   public abstract static class NLPCallback extends INLPCallback.Stub {
   }

   public abstract static class TTSListener extends ITTSListener.Stub {
   }
}
