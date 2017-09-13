package gapp.quizdrapeauxcapitales;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class recherche extends Activity {
	ImageView precedent;
	Intent in;
	RadioButton r1,r2,r3,r4,r5,r6;
	Button valider1,valider2,go;
	EditText txt1;
	Spinner spn;
	Db db;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche);
        precedent = (ImageView) findViewById(R.id.imageView2);
        valider1 = (Button) findViewById(R.id.valider1);
        valider2 = (Button) findViewById(R.id.valider2);
        r1 = (RadioButton) findViewById(R.id.radioButton1);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);
        r5 = (RadioButton) findViewById(R.id.radioButton5);
        r6 = (RadioButton) findViewById(R.id.radioButton6);
        txt1 = (EditText) findViewById(R.id.editText1);
        spn = (Spinner) findViewById(R.id.spinner1);
        go = (Button) findViewById(R.id.go);
        
        r1.setChecked(true);
        r1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				r2.setChecked(false);r3.setChecked(false);r4.setChecked(false);r5.setChecked(false);r6.setChecked(false);
			}});
        r2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				r1.setChecked(false);r3.setChecked(false);r4.setChecked(false);r5.setChecked(false);r6.setChecked(false);
			}});
        r3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				r1.setChecked(false);r2.setChecked(false);r4.setChecked(false);r5.setChecked(false);r6.setChecked(false);
			}});
        r4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				r1.setChecked(false);r2.setChecked(false);r3.setChecked(false);r5.setChecked(false);r6.setChecked(false);
			}});
        r5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				r1.setChecked(false);r2.setChecked(false);r3.setChecked(false);r4.setChecked(false);r6.setChecked(false);
			}});
        r6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				r1.setChecked(false);r2.setChecked(false);r3.setChecked(false);r4.setChecked(false);r5.setChecked(false);
			}});


		valider1.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN: {
						valider1.setBackgroundResource(R.drawable.shapevalidertr);
						break;
					}
					case MotionEvent.ACTION_UP:
					case MotionEvent.ACTION_CANCEL: {
						valider1.setBackgroundResource(R.drawable.shapevalider);
						break;
					}
				}

				return false;
			}
		});
        valider1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String s1 = String.valueOf(txt1.getText());
				if (s1.equals("")){ Toast.makeText(recherche.this,"La case est vide \n Veillez la remplire SVP",100 ).show();}
				else{
					if (r1.isChecked()){
					db=new Db(recherche.this);
			        db.open();
			       
			        Cursor c = db.findPays(""+s1);
			        if (c.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucun pays ",100 ).show();}
			        //c.moveToFirst();
			        else{go.setVisibility(Button.VISIBLE);
					int i=0;
					String[] pays = new String[c.getCount()];
					while(c.moveToNext())
			        {pays[i] = String.valueOf(c.getString(0));
						i++;}
					db.close();
					 @SuppressWarnings({ "rawtypes", "unchecked" })
					ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, pays);
				    spn.setAdapter(spinnerArrayAdapter);
				    
			        }}
					
					
			        if(r2.isChecked()){
			        	db=new Db(recherche.this);
				        db.open();
				       
				        Cursor c1 = db.findPaysAfrique(""+s1);
				        if (c1.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucun pays ",100 ).show();}
				        //c.moveToFirst();
				        else{go.setVisibility(Button.VISIBLE);
						int i=0;
						String[] pays = new String[c1.getCount()];
						while(c1.moveToNext())
				        {pays[i] = String.valueOf(c1.getString(0));
							i++;}
						db.close();
					    @SuppressWarnings({ "rawtypes", "unchecked" })
						ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, pays);
					    spn.setAdapter(spinnerArrayAdapter);
			        } }
				        
				        if(r3.isChecked()){
				        	db=new Db(recherche.this);
					        db.open();
					       
					        Cursor c2 = db.findPaysAmerique(""+s1);
					        if (c2.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucun pays ",100 ).show();}
					        //c.moveToFirst();
					        else{go.setVisibility(Button.VISIBLE);
							int i=0;
							String[] pays = new String[c2.getCount()];
							while(c2.moveToNext())
					        {pays[i] = String.valueOf(c2.getString(0));
								i++;}
							db.close();
						    @SuppressWarnings({ "rawtypes", "unchecked" })
							ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, pays);
						    spn.setAdapter(spinnerArrayAdapter);
				        }}
				        
				        if(r4.isChecked()){
				        	db=new Db(recherche.this);
					        db.open();
					       
					        Cursor c2 = db.findPaysAsie(""+s1);
					        if (c2.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucun pays ",100 ).show();}
					        //c.moveToFirst();
					        else{go.setVisibility(Button.VISIBLE);
							int i=0;
							String[] pays = new String[c2.getCount()];
							while(c2.moveToNext())
					        {pays[i] = String.valueOf(c2.getString(0));
								i++;}
							db.close();
						    @SuppressWarnings({ "rawtypes", "unchecked" })
							ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, pays);
						    spn.setAdapter(spinnerArrayAdapter);
				        }}
				        
				        if(r5.isChecked()){
				        	db=new Db(recherche.this);
					        db.open();
					       
					        Cursor c2 = db.findPaysEurope(""+s1);
					        if (c2.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucun pays ",100 ).show();}
					        //c.moveToFirst();
					        else{go.setVisibility(Button.VISIBLE);
							int i=0;
							String[] pays = new String[c2.getCount()];
							while(c2.moveToNext())
					        {pays[i] = String.valueOf(c2.getString(0));
								i++;}
							db.close();
						    @SuppressWarnings({ "rawtypes", "unchecked" })
							ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, pays);
						    spn.setAdapter(spinnerArrayAdapter);
				        }}
				        if(r6.isChecked()){
				        	db=new Db(recherche.this);
					        db.open();
					       
					        Cursor c2 = db.findPaysOceanie(""+s1);
					        if (c2.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucun pays ",100 ).show();}
					        //c.moveToFirst();
					        else{go.setVisibility(Button.VISIBLE);
							int i=0;
							String[] pays = new String[c2.getCount()];
							while(c2.moveToNext())
					        {pays[i] = String.valueOf(c2.getString(0));
								i++;}
							db.close();
						    @SuppressWarnings({ "rawtypes", "unchecked" })
							ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, pays);
						    spn.setAdapter(spinnerArrayAdapter);
				        }}
			        
			        
				
				}//else	chaine vide
			}});
		valider2.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN: {
						valider2.setBackgroundResource(R.drawable.shapevalidertr);
						break;
					}
					case MotionEvent.ACTION_UP:
					case MotionEvent.ACTION_CANCEL: {
						valider2.setBackgroundResource(R.drawable.shapevalider);
						break;
					}
				}

				return false;
			}
		});
        valider2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String s1 = String.valueOf(txt1.getText());
				if (s1.equals("")){ Toast.makeText(recherche.this,"La case est vide \n Veillez la remplire SVP",100 ).show();}
				else{
					if (r1.isChecked()){
					db=new Db(recherche.this);
			        db.open();
			       
			        Cursor c = db.findCap(""+s1);
			        if (c.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont à aucune capitale ",100 ).show();}
			        //c.moveToFirst();
			        else{go.setVisibility(Button.VISIBLE);
					int i=0;
					String[] cap = new String[c.getCount()];
					while(c.moveToNext())
			        {cap[i] = String.valueOf(c.getString(0));
						i++;}
					db.close();
					 @SuppressWarnings({ "rawtypes", "unchecked" })
					ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, cap);
				    spn.setAdapter(spinnerArrayAdapter);
			        }}
					
					
			        if(r2.isChecked()){
			        	db=new Db(recherche.this);
				        db.open();
				       
				        Cursor c1 = db.findCapAfrique(""+s1);
				        if (c1.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucune capitale ",100 ).show();}
				        //c.moveToFirst();
				        else{go.setVisibility(Button.VISIBLE);
						int i=0;
						String[] cap = new String[c1.getCount()];
						while(c1.moveToNext())
				        {cap[i] = String.valueOf(c1.getString(0));
							i++;}
						db.close();
					    @SuppressWarnings({ "rawtypes", "unchecked" })
						ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, cap);
					    spn.setAdapter(spinnerArrayAdapter);
			        } }
				        
				        if(r3.isChecked()){
				        	db=new Db(recherche.this);
					        db.open();
					       
					        Cursor c2 = db.findCapAmerique(""+s1);
					        if (c2.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucune capitale ",100 ).show();}
					        //c.moveToFirst();
					        else{go.setVisibility(Button.VISIBLE);
					        int i=0;
							String[] cap = new String[c2.getCount()];
							while(c2.moveToNext())
					        {cap[i] = String.valueOf(c2.getString(0));
								i++;}
							db.close();
						    @SuppressWarnings({ "rawtypes", "unchecked" })
							ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, cap);
						    spn.setAdapter(spinnerArrayAdapter);
				        }}
				        
				        if(r4.isChecked()){
				        	db=new Db(recherche.this);
					        db.open();
					       
					        Cursor c2 = db.findCapAsie(""+s1);
					        if (c2.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucune capitale ",100 ).show();}
					        //c.moveToFirst();
					        else{go.setVisibility(Button.VISIBLE);
							int i=0;
							String[] cap = new String[c2.getCount()];
							while(c2.moveToNext())
					        {cap[i] = String.valueOf(c2.getString(0));
								i++;}
							db.close();
						    @SuppressWarnings({ "rawtypes", "unchecked" })
							ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, cap);
						    spn.setAdapter(spinnerArrayAdapter);
				        }}
				        
				        if(r5.isChecked()){
				        	db=new Db(recherche.this);
					        db.open();
					       
					        Cursor c2 = db.findCapEurope(""+s1);
					        if (c2.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucune capitale ",100 ).show();}
					        //c.moveToFirst();
					        else{go.setVisibility(Button.VISIBLE);
							int i=0;
							String[] cap = new String[c2.getCount()];
							while(c2.moveToNext())
					        {cap[i] = String.valueOf(c2.getString(0));
								i++;}
							db.close();
						    @SuppressWarnings({ "rawtypes", "unchecked" })
							ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, cap);
						    spn.setAdapter(spinnerArrayAdapter);
				        }}
				        if(r6.isChecked()){
				        	db=new Db(recherche.this);
					        db.open();
					       
					        Cursor c2 = db.findCapOceanie(""+s1);
					        if (c2.getCount() == 0){Toast.makeText(recherche.this,"Le nom que vouz avez entrez ne correspont � aucune capitale ",100 ).show();}
					        //c.moveToFirst();
					        else{go.setVisibility(Button.VISIBLE);
							int i=0;
							String[] cap = new String[c2.getCount()];
							while(c2.moveToNext())
					        {cap[i] = String.valueOf(c2.getString(0));
								i++;}
							db.close();
						    @SuppressWarnings({ "rawtypes", "unchecked" })
							ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(recherche.this,android.R.layout.simple_spinner_dropdown_item, cap);
						    spn.setAdapter(spinnerArrayAdapter);
				        }}	
				}//else	chaine vide
			}});
		go.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN: {
						go.setBackgroundResource(R.drawable.shapenexttr);
						break;
					}
					case MotionEvent.ACTION_UP:
					case MotionEvent.ACTION_CANCEL: {
						go.setBackgroundResource(R.drawable.shapenext);
						break;
					}
				}

				return false;
			}
		});
       go.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			
			String res =spn.getSelectedItem().toString();
			db=new Db(recherche.this);
	        db.open();
	        
	        if(db.getId1(res) !=0){resultat.id = db.getId1(res);startActivity(new Intent(recherche.this,resultat.class));}
	        else {resultat.id = db.getId2(res);startActivity(new Intent(recherche.this,resultat.class));}
	        
		    //if(res.equals("")){Toast.makeText(recherche.this,"La case RESULTAT est vide ",100 ).show();}
		    
		    //
	        //resultat.id =db.getId1("Maroc");
	        //int a = db.getId1("Maroc");
	        
	        
		    db.close();
			
			
		}
	}) ;
        
      
       
        
        
        
        
precedent.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
				}});
        
        

  

}}
