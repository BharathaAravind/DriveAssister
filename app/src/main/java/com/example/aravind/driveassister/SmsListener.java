package com.example.aravind.driveassister;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeechService;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by aravind on 03-12-2015.
 */
public class SmsListener extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"inside on receive",Toast.LENGTH_LONG).show();



        Bundle bundle = intent.getExtras();
            //---get the SMS message passed in---
            SmsMessage[] msgs = null;
            String msg_from;

            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                        String msgBody = msgs[i].getMessageBody();
                        Toast.makeText(context,msgBody,Toast.LENGTH_LONG).show();
                        Toast.makeText(context,msg_from,Toast.LENGTH_LONG).show();
                        MediaPlayer mediaPlayer = MediaPlayer.create(context,R.raw.m);
                        mediaPlayer.start();

                    }

                }catch(Exception e){
                           Log.d("Exception caught", e.getMessage());
                }
            }

    }
}



