package gapp.quizdrapeauxcapitales;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class musicError extends Service {

	MediaPlayer mp ;
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		mp = MediaPlayer.create(this, R.raw.wrong);
		mp.start();
		//mp.release();
	};
	
	@Override
	public void onDestroy() {
		mp.stop();
		super.onDestroy();
		
		
	}
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	

}
