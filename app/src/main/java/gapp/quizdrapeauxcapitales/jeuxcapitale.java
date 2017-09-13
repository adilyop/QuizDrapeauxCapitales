package gapp.quizdrapeauxcapitales;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Color;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import gapp.quizdrapeauxcapitales.R;

public class jeuxcapitale extends Activity {
	Db db;
	boolean song = true;
	Boolean isValid = false;
	String s1="reponse1",s2="reponse2",s3="reponse3",s4="reponse4",pays="", choice="";
	int v,f1,f2,f3;
	Intent inten ;
	String s="adil";
	private MediaPlayer mp;
	ImageView precedent ;
	Intent in4;
	Button valider,recommencer,quitter, b1, b2, b3,b4, next, temp;
	int faux1,faux2,faux3,vrais;
	TextView txtscore;
	TextView kestion;
	public static int points = 0;
	
	//Rand la place de la reponse correcte
String[] adil(int nbr,String s11,String s21,String s31,String s41){
		
		String[] s={"0","0","0","0"};
		s[nbr] = s11;
		s[(nbr+1)%4] = s21;
		s[(nbr+2)%4] = s31;
		s[(nbr+3)%4] = s41;	
		return s;
	}
		
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        setContentView(R.layout.jeuxcapitale);

		AdView adView = (AdView) findViewById(R.id.adView); AdRequest adRequest = new AdRequest.Builder() .setRequestAgent("android_studio:ad_template").build(); adView.loadAd(adRequest);
		mp = MediaPlayer.create(jeuxcapitale.this, R.raw.wrong);
		in4 = new Intent(jeuxcapitale.this,music.class);
		startService(in4);
        kestion = (TextView) findViewById(R.id.textView2);
        precedent =(ImageView) findViewById(R.id.imagejeuxcap);
        valider = (Button) findViewById(R.id.button2);
		next = (Button) findViewById(R.id.next01);
        recommencer = (Button) findViewById(R.id.button3);
        quitter = (Button) findViewById(R.id.button1);
        txtscore =  (TextView) findViewById(R.id.textView3);
		b1 = (Button) findViewById(R.id.button01);
		b2 = (Button) findViewById(R.id.button02);
		b3 = (Button) findViewById(R.id.button03);
		b4 = (Button) findViewById(R.id.button04);

		vrais = (int)(206.00 * Math.random()) + 1;
		faux1 = (int)(206.00 * Math.random()) + 1;
		faux2 = (int)(206.00 * Math.random()) + 1;
		faux3 = (int)(206.00 * Math.random()) + 1;

		db=new Db(jeuxcapitale.this);
		db.open();
		s1 = db.getCapital(vrais);
		s2 = db.getCapital(faux1);
		s3 = db.getCapital(faux2);
		s4 = db.getCapital(faux3);
		pays = db.getName(vrais);
		kestion.setText(pays);
		db.close();

		int nbr= (int)(4.0 * Math.random()) ;
		b1.setText(adil(nbr,s1,s2,s3,s4)[0]);
		b2.setText(adil(nbr,s1,s2,s3,s4)[1]);
		b3.setText(adil(nbr,s1,s2,s3,s4)[2]);
		b4.setText(adil(nbr,s1,s2,s3,s4)[3]);

		b1.setBackgroundColor(Color.parseColor("#bbffc100"));
		b2.setBackgroundColor(Color.parseColor("#bbffc100"));
		b3.setBackgroundColor(Color.parseColor("#bbffc100"));
		b4.setBackgroundColor(Color.parseColor("#bbffc100"));
		valider.setVisibility(Button.VISIBLE);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = b1.getText().toString();
				isValid = true;
				temp = b1;
				b1.setBackgroundColor(Color.parseColor("#ffc100"));
				b2.setBackgroundColor(Color.parseColor("#bbffc100"));
				b3.setBackgroundColor(Color.parseColor("#bbffc100"));
				b4.setBackgroundColor(Color.parseColor("#bbffc100"));
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = b2.getText().toString();
				isValid = true;
				temp = b2;
				b1.setBackgroundColor(Color.parseColor("#bbffc100"));
				b2.setBackgroundColor(Color.parseColor("#ffc100"));
				b3.setBackgroundColor(Color.parseColor("#bbffc100"));
				b4.setBackgroundColor(Color.parseColor("#bbffc100"));
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = b3.getText().toString();
				isValid = true;
				temp = b3;
				b1.setBackgroundColor(Color.parseColor("#bbffc100"));
				b2.setBackgroundColor(Color.parseColor("#bbffc100"));
				b3.setBackgroundColor(Color.parseColor("#ffc100"));
				b4.setBackgroundColor(Color.parseColor("#bbffc100"));
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = b4.getText().toString();
				isValid = true;
				temp = b4;
				b1.setBackgroundColor(Color.parseColor("#bbffc100"));
				b2.setBackgroundColor(Color.parseColor("#bbffc100"));
				b3.setBackgroundColor(Color.parseColor("#bbffc100"));
				b4.setBackgroundColor(Color.parseColor("#ffc100"));
			}
		});
		quitter.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN: {
						quitter.setBackgroundResource(R.drawable.shape);
						break;
					}
					case MotionEvent.ACTION_UP:
					case MotionEvent.ACTION_CANCEL: {
						quitter.setBackgroundResource(R.drawable.shapetr);
						break;
					}
				}

				return false;
			}
		});
        quitter.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
					finish();
				}
		});

		recommencer.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN: {
						recommencer.setBackgroundResource(R.drawable.shapevalidertr);
						break;
					}
					case MotionEvent.ACTION_UP:
					case MotionEvent.ACTION_CANCEL: {
						recommencer.setBackgroundResource(R.drawable.shapevalider);
						break;
					}
				}

				return false;
			}
		});
        recommencer.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				points =0;
				isValid = false;
				startService(in4);
				txtscore.setText(""+points);
				vrais = (int)(206.00 * Math.random()) + 1;
				faux1 = (int)(206.00 * Math.random()) + 1;
				faux2 = (int)(206.00 * Math.random()) + 1;
				faux3 = (int)(206.00 * Math.random()) + 1;

				db=new Db(jeuxcapitale.this);
				db.open();
				s1 = db.getCapital(vrais);
				s2 = db.getCapital(faux1);
				s3 = db.getCapital(faux2);
				s4 = db.getCapital(faux3);
				pays = db.getName(vrais);
				kestion.setText(pays);
				db.close();

				int nbr= (int)(4.0 * Math.random()) ;
				b1.setText(adil(nbr,s1,s2,s3,s4)[0]);
				b2.setText(adil(nbr,s1,s2,s3,s4)[1]);
				b3.setText(adil(nbr,s1,s2,s3,s4)[2]);
				b4.setText(adil(nbr,s1,s2,s3,s4)[3]);

				b1.setBackgroundColor(Color.parseColor("#bbffc100"));
				b2.setBackgroundColor(Color.parseColor("#bbffc100"));
				b3.setBackgroundColor(Color.parseColor("#bbffc100"));
				b4.setBackgroundColor(Color.parseColor("#bbffc100"));
				valider.setVisibility(Button.VISIBLE);
				quitter.setVisibility(Button.GONE);
				recommencer.setVisibility(Button.GONE);
				}
		});
        
        
        precedent.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 finish();
				}
		});
		next.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN: {
						next.setBackgroundResource(R.drawable.shapenexttr);
						break;
					}
					case MotionEvent.ACTION_UP:
					case MotionEvent.ACTION_CANCEL: {
						next.setBackgroundResource(R.drawable.shapenext);
						break;
					}
				}

				return false;
			}
		});
		next.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				isValid = false;
				valider.setVisibility(Button.VISIBLE);
				next.setVisibility(Button.GONE);
				vrais = (int)(206.00 * Math.random()) + 1;
				faux1 = (int)(206.00 * Math.random()) + 1;
				faux2 = (int)(206.00 * Math.random()) + 1;
				faux3 = (int)(206.00 * Math.random()) + 1;

				db=new Db(jeuxcapitale.this);
				db.open();
				s1 = db.getCapital(vrais);
				s2 = db.getCapital(faux1);
				s3 = db.getCapital(faux2);
				s4 = db.getCapital(faux3);
				pays = db.getName(vrais);
				kestion.setText(pays);
				db.close();

				int nbr= (int)(4.0 * Math.random()) ;
				b1.setText(adil(nbr,s1,s2,s3,s4)[0]);
				b2.setText(adil(nbr,s1,s2,s3,s4)[1]);
				b3.setText(adil(nbr,s1,s2,s3,s4)[2]);
				b4.setText(adil(nbr,s1,s2,s3,s4)[3]);

				b1.setBackgroundColor(Color.parseColor("#bbffc100"));
				b2.setBackgroundColor(Color.parseColor("#bbffc100"));
				b3.setBackgroundColor(Color.parseColor("#bbffc100"));
				b4.setBackgroundColor(Color.parseColor("#bbffc100"));
			}});

		valider.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN: {
						valider.setBackgroundResource(R.drawable.shapevalidertr);
						break;
					}
					case MotionEvent.ACTION_UP:
					case MotionEvent.ACTION_CANCEL: {
						valider.setBackgroundResource(R.drawable.shapevalider);
						break;
					}
				}

				return false;
			}
		});
		valider.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (isValid) {
					if (choice.equals("" + s1)) {
						isValid = false;
						points += 1;
						txtscore.setText("" + points);
						temp.setBackgroundColor(Color.argb(160, 10, 163, 5));
						next.setVisibility(Button.VISIBLE);
						valider.setVisibility(Button.GONE);
					} else {
						stopService(in4);
						mp.start();
						temp.setBackgroundColor(Color.argb(160, 255, 0, 0));
						Toast.makeText(jeuxcapitale.this, "La bonne reponse est :" + s1 + "\nVotre score est : " + points, 10).show();
						quitter.setVisibility(ImageView.VISIBLE);
						recommencer.setVisibility(ImageView.VISIBLE);
						valider.setVisibility(Button.GONE);

					}

				}
			}});//valider

}
	
	
	
	@Override
	protected void onDestroy() {
		//in4 = new Intent(jeuxcapitale.this,music.class);
		stopService(new Intent(jeuxcapitale.this,music.class));
		
		
		super.onDestroy();
	}

}