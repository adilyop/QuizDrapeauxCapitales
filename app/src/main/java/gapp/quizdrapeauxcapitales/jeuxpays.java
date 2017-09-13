package gapp.quizdrapeauxcapitales;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import gapp.quizdrapeauxcapitales.R;

public class jeuxpays extends Activity {
	Db db;
	Boolean isValid = false;
	ImageView song1;
	ImageView song2;
	Intent in4, lose;
	ImageView precedent;
	ImageView drap;
	private MediaPlayer mp;
	 String s1="reponse1",s2="reponse2",s3="reponse3",s4="reponse4",s="test", choice="";
	Button valider ,quitter , recommencer , b1, b2, b3,b4, next, temp;
	int vrai,faux1,faux2,faux3;
	public static int score=0;
	TextView scor;
		
	
	 String[] adil(int nbr, String s11,String s21,String s31,String s41){
		
		String[] s={"0","0","0","0"};
		s[nbr] = s11;
		s[(nbr+1)%4] = s21;
		s[(nbr+2)%4] = s31;
		s[(nbr+3)%4] = s41;	
		return s;
	}
		
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeuxpays);

		AdView adView = (AdView) findViewById(R.id.adView); AdRequest adRequest = new AdRequest.Builder() .setRequestAgent("android_studio:ad_template").build(); adView.loadAd(adRequest);
		mp = MediaPlayer.create(jeuxpays.this, R.raw.wrong);
		in4 = new Intent(jeuxpays.this, music.class);
		startService(in4);

        scor =  (TextView) findViewById(R.id.textView3);
		scor.setText("0");
		b1 = (Button) findViewById(R.id.button9);
		b2 = (Button) findViewById(R.id.button10);
		b3 = (Button) findViewById(R.id.button7);
		b4 = (Button) findViewById(R.id.button8);
        next = (Button) findViewById(R.id.next);
        valider = (Button) findViewById(R.id.valider);
        quitter = (Button) findViewById(R.id.quitter);
        recommencer = (Button) findViewById(R.id.recommencer);
        drap = (ImageView) findViewById(R.id.imageView2);
        score=0;
        vrai = (int)(206.00 * Math.random()) + 1;
        faux1 = (int)(206.00 * Math.random()) + 1;
        faux2 = (int)(206.00 * Math.random()) + 1;
        faux3 = (int)(206.00 * Math.random()) + 1;
        drap.setImageResource(resultat.mesFlags[vrai-1]);
        int nbr= (int)(4.0 * Math.random()) ;

        db=new Db(jeuxpays.this);
        db.open();
        s1 = db.getName(vrai);
        s2 = db.getName(faux1);
        s3 = db.getName(faux2);
        s4 = db.getName(faux3);
        db.close();

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
				vrai = (int)(206.00 * Math.random()) + 1;
				faux1 = (int)(206.00 * Math.random()) + 1;
				faux2 = (int)(206.00 * Math.random()) + 1;
				faux3 = (int)(206.00 * Math.random()) + 1;
				int nbr= (int)(4.0 * Math.random()) ;
				drap.setImageResource(resultat.mesFlags[vrai-1]);
				db=new Db(jeuxpays.this);
				db.open();
				s1 = db.getName(vrai);
				s2 = db.getName(faux1);
				s3 = db.getName(faux2);
				s4 = db.getName(faux3);
				db.close();

				b1.setText(adil(nbr,s1,s2,s3,s4)[0]);
				b2.setText(adil(nbr,s1,s2,s3,s4)[1]);
				b3.setText(adil(nbr,s1,s2,s3,s4)[2]);
				b4.setText(adil(nbr,s1,s2,s3,s4)[3]);

				b1.setBackgroundColor(Color.parseColor("#bbffc100"));
				b2.setBackgroundColor(Color.parseColor("#bbffc100"));
				b3.setBackgroundColor(Color.parseColor("#bbffc100"));
				b4.setBackgroundColor(Color.parseColor("#bbffc100"));
            }});

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
				isValid = false;
				startService(in4);
				score=0;
				scor.setText("0");
				valider.setVisibility(Button.VISIBLE);
				recommencer.setVisibility(Button.GONE);
				quitter.setVisibility(Button.GONE);
				vrai = (int)(206.00 * Math.random()) + 1;
				faux1 = (int)(206.00 * Math.random()) + 1;
				faux2 = (int)(206.00 * Math.random()) + 1;
				faux3 = (int)(206.00 * Math.random()) + 1;
				int nbr= (int)(4.0 * Math.random()) ;
				drap.setImageResource(resultat.mesFlags[vrai-1]);
				db=new Db(jeuxpays.this);
				db.open();
				s1 = db.getName(vrai);
				s2 = db.getName(faux1);
				s3 = db.getName(faux2);
				s4 = db.getName(faux3);
				db.close();

				b1.setText(adil(nbr,s1,s2,s3,s4)[0]);
				b2.setText(adil(nbr,s1,s2,s3,s4)[1]);
				b3.setText(adil(nbr,s1,s2,s3,s4)[2]);
				b4.setText(adil(nbr,s1,s2,s3,s4)[3]);
				b1.setBackgroundColor(Color.parseColor("#bbffc100"));
				b2.setBackgroundColor(Color.parseColor("#bbffc100"));
				b3.setBackgroundColor(Color.parseColor("#bbffc100"));
				b4.setBackgroundColor(Color.parseColor("#bbffc100"));
				}});
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
				}});
 precedent = (ImageView) findViewById(R.id.imageView1);
 precedent.setOnClickListener(new OnClickListener() {		
			public void onClick(View v) {
				finish();			
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
					if(choice.equals(""+s1))
					{
						isValid = false;
						temp.setBackgroundColor(Color.argb(160,10,163,5));
						score +=1;
						scor.setText(""+score);

						next.setVisibility(Button.VISIBLE);
						valider.setVisibility(Button.GONE);

					}
					else {
						stopService(in4);
						mp.start();
						temp.setBackgroundColor(Color.argb(160,255,0,0));
						valider.setVisibility(Button.GONE);
						recommencer.setVisibility(Button.VISIBLE);
						quitter.setVisibility(Button.VISIBLE);
						Toast.makeText(jeuxpays.this, "La bonne réponse est : "+s1+"\n Votre score est : "+score, 100).show();

					}
				}

			}
		});//valider
}
	protected void onDestroy() {
		stopService(new Intent(jeuxpays.this,music.class));
		super.onDestroy();
	}

}

