package com.appsbyjimmy.registrodealumons;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// wifi telefono bateria,etc
		Object[] mensajes=(Object[]) intent.getExtras().get("pdus");
		byte[] primero=(byte[]) mensajes[0];
		
		SmsMessage sms=SmsMessage.createFromPdu(primero);
		
		String telefono = sms.getDisplayOriginatingAddress();
		
		Toast.makeText(context, "SMS desde telefono "+telefono,Toast.LENGTH_LONG).show();
		
		AlumnoDAO dao=new AlumnoDAO(context);
		boolean esAlumno=dao.isAlumno(telefono);
		dao.close();
		
		
		if(esAlumno){
			MediaPlayer player = MediaPlayer.create(context,R.raw.main);
			player.start();
			Toast.makeText(context, "tocando musica", Toast.LENGTH_LONG).show();
		}
		
		
		
		
	}

}
