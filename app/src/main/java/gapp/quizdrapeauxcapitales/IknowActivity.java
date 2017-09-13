package gapp.quizdrapeauxcapitales;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class IknowActivity extends Activity  {
    /** Called when the activity is first created. */
    Button b11 ;
    TextView drapeaux, capitales, recherche;
    LinearLayout b1,b2,b4,b3;
  


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        drapeaux = (TextView) findViewById(R.id.textDrapeaux);
        capitales = (TextView) findViewById(R.id.textcapitales);
        recherche = (TextView) findViewById(R.id.textrecherche);
        
        
        b1 = (LinearLayout) findViewById(R.id.linearLayout2);
        b1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        b1.setBackgroundResource(R.drawable.shapetr);
                        drapeaux.setTextColor(Color.parseColor("#66C4CDE0"));
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        b1.setBackgroundResource(R.drawable.shape);
                        drapeaux.setTextColor(Color.parseColor("#C4CDE0"));
                        break;
                    }
                }

                return false;
            }
        });
        b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
                Intent in = new Intent(IknowActivity.this,jeuxpays.class);
			startActivity(in);
			
			}});
        
        b2 = (LinearLayout) findViewById(R.id.linearLayout3);
        b2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        b2.setBackgroundResource(R.drawable.shapetr);
                        capitales.setTextColor(Color.parseColor("#66C4CDE0"));
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        b2.setBackgroundResource(R.drawable.shape);
                        capitales.setTextColor(Color.parseColor("#C4CDE0"));
                        break;
                    }
                }

                return false;
            }
        });
        b2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent in2 = new Intent(IknowActivity.this,jeuxcapitale.class);
				startActivity(in2);
			}
		});

        b3 = (LinearLayout) findViewById(R.id.linearLayout4);
        b3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        b3.setBackgroundResource(R.drawable.shapetr);
                        recherche.setTextColor(Color.parseColor("#66C4CDE0"));
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        b3.setBackgroundResource(R.drawable.shape);
                        recherche.setTextColor(Color.parseColor("#C4CDE0"));
                        break;
                    }
                }

                return false;
            }
        });
        b3.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent in2 = new Intent(IknowActivity.this,recherche.class);
                startActivity(in2);
            }
        });
        
        
    }
}