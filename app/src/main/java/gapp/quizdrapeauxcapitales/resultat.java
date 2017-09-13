package gapp.quizdrapeauxcapitales;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class resultat extends Activity {
	Db db;
	 RelativeLayout lyt ;
	 LinearLayout precedent;
	 LinearLayout layout;
	 ImageView img;
	 TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7;
	 public static int id= 1;
	 
	 public static int[] mesFlags = new int[]{
 		R.drawable.drap1, R.drawable.drap2, R.drawable.drap3, R.drawable.drap4, R.drawable.drap5, 
 		R.drawable.drap6, R.drawable.drap7, R.drawable.drap8, R.drawable.drap9, R.drawable.drap10,
 		R.drawable.drap11, R.drawable.drap12, R.drawable.drap13, R.drawable.drap14, R.drawable.drap15,
 		R.drawable.drap16, R.drawable.drap17, R.drawable.drap18, R.drawable.drap19, R.drawable.drap20,
 		R.drawable.drap21, R.drawable.drap22, R.drawable.drap23, R.drawable.drap24, R.drawable.drap25,
 		R.drawable.drap26, R.drawable.drap27, R.drawable.drap28, R.drawable.drap29, R.drawable.drap30,
 		R.drawable.drap31, R.drawable.drap32, R.drawable.drap33, R.drawable.drap34, R.drawable.drap35,
 		R.drawable.drap36, R.drawable.drap37, R.drawable.drap38, R.drawable.drap39, R.drawable.drap40,
 		R.drawable.drap41, R.drawable.drap42, R.drawable.drap43, R.drawable.drap44, R.drawable.drap45,
 		R.drawable.drap46, R.drawable.drap47, R.drawable.drap48, R.drawable.drap49, R.drawable.drap50,
 		R.drawable.drap51, R.drawable.drap52, R.drawable.drap53, R.drawable.drap54, R.drawable.drap55,
 		R.drawable.drap56, R.drawable.drap57, R.drawable.drap58, R.drawable.drap59, R.drawable.drap60,
 		R.drawable.drap61, R.drawable.drap62, R.drawable.drap63, R.drawable.drap64, R.drawable.drap65,
 		R.drawable.drap66, R.drawable.drap67, R.drawable.drap68, R.drawable.drap69, R.drawable.drap70,
 		R.drawable.drap71, R.drawable.drap72, R.drawable.drap73, R.drawable.drap74, R.drawable.drap75,
 		R.drawable.drap76, R.drawable.drap77, R.drawable.drap78, R.drawable.drap79, R.drawable.drap80,
 		R.drawable.drap81, R.drawable.drap82, R.drawable.drap83, R.drawable.drap84, R.drawable.drap85,
 		R.drawable.drap86, R.drawable.drap87, R.drawable.drap88, R.drawable.drap89, R.drawable.drap90,
 		R.drawable.drap91, R.drawable.drap92, R.drawable.drap93, R.drawable.drap94, R.drawable.drap95,
 		R.drawable.drap96, R.drawable.drap97, R.drawable.drap98, R.drawable.drap99, R.drawable.drap100,
 		R.drawable.drap101, R.drawable.drap102, R.drawable.drap103, R.drawable.drap104, R.drawable.drap105, 
 		R.drawable.drap106, R.drawable.drap107, R.drawable.drap108, R.drawable.drap109, R.drawable.drap110,
 		R.drawable.drap111, R.drawable.drap112, R.drawable.drap113, R.drawable.drap114, R.drawable.drap115,
 		R.drawable.drap116, R.drawable.drap117, R.drawable.drap118, R.drawable.drap119, R.drawable.drap120,
 		R.drawable.drap121, R.drawable.drap122, R.drawable.drap123, R.drawable.drap124, R.drawable.drap125,
 		R.drawable.drap126, R.drawable.drap127, R.drawable.drap128, R.drawable.drap129, R.drawable.drap130,
 		R.drawable.drap131, R.drawable.drap132, R.drawable.drap133, R.drawable.drap134, R.drawable.drap135,
 		R.drawable.drap136, R.drawable.drap137, R.drawable.drap138, R.drawable.drap139, R.drawable.drap140,
 		R.drawable.drap141, R.drawable.drap142, R.drawable.drap143, R.drawable.drap144, R.drawable.drap145,
 		R.drawable.drap146, R.drawable.drap147, R.drawable.drap148, R.drawable.drap149, R.drawable.drap150,
 		R.drawable.drap151, R.drawable.drap152, R.drawable.drap153, R.drawable.drap154, R.drawable.drap155,
 		R.drawable.drap156, R.drawable.drap157, R.drawable.drap158, R.drawable.drap159, R.drawable.drap160,
 		R.drawable.drap161, R.drawable.drap162, R.drawable.drap163, R.drawable.drap164, R.drawable.drap165,
 		R.drawable.drap166, R.drawable.drap167, R.drawable.drap168, R.drawable.drap169, R.drawable.drap170,
 		R.drawable.drap171, R.drawable.drap172, R.drawable.drap173, R.drawable.drap174, R.drawable.drap175,
 		R.drawable.drap176, R.drawable.drap177, R.drawable.drap178, R.drawable.drap179, R.drawable.drap180,
 		R.drawable.drap181, R.drawable.drap182, R.drawable.drap183, R.drawable.drap184, R.drawable.drap185,
 		R.drawable.drap186, R.drawable.drap187, R.drawable.drap188, R.drawable.drap189, R.drawable.drap190,
 		R.drawable.drap191, R.drawable.drap192, R.drawable.drap193, R.drawable.drap194, R.drawable.drap195,
 		R.drawable.drap196, R.drawable.drap197, R.drawable.drap198, R.drawable.drap199, R.drawable.drap200,
 		R.drawable.drap201, R.drawable.drap202, R.drawable.drap203, R.drawable.drap204, R.drawable.drap205,
 		R.drawable.drap206 };
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultat);
        
        txt1 = (TextView) findViewById(R.id.textView10);
        txt2 = (TextView) findViewById(R.id.textView11);
        txt3 = (TextView) findViewById(R.id.textView12);
        txt4 = (TextView) findViewById(R.id.textView13);
        txt5 = (TextView) findViewById(R.id.textView14);
        txt6 = (TextView) findViewById(R.id.textView15);
        txt7 = (TextView) findViewById(R.id.textView1);
        
        layout = (LinearLayout) findViewById(R.id.linearLayout1);
        lyt = (RelativeLayout) findViewById(R.id.relativeLayout1);
        img = (ImageView) findViewById(R.id.imageView1);
    	
        db = new Db(this);
        db.open();
        img.setImageResource(mesFlags[id-1]);
        txt7.setText(db.getName(id));
        txt6.setText(db.getSurface(id)+" Km²");
        txt5.setText(db.getPop(id)+" Mln");
        txt4.setText(db.getCont(id));
        txt3.setText(db.getLan(id));
        txt2.setText(db.getMonn(id));
        txt1.setText(db.getCapital(id));
        
   
        
        db.close();
        precedent = (LinearLayout) findViewById(R.id.precedent);
        precedent.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			finish();
				
			}
		});
        
        
        
        

}}
