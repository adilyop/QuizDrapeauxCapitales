package gapp.quizdrapeauxcapitales;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Db {
    private static String DB_DIR = "/data/data/gapp.quizdrapeauxcapitales/databases/";
    private static String DB_NAME = "database.sqlite";
    private static String DB_PATH = DB_DIR + DB_NAME;
    
	
	private DataBaseHelper mDbHelper;
	private SQLiteDatabase db;
	private Context context;
	

	public Db(Context context) {
		this.context=context;
		mDbHelper=new DataBaseHelper(this.context);
	}
	
	class DataBaseHelper extends SQLiteOpenHelper
	{
	    private boolean createDatabase = false;
	    @SuppressWarnings("unused")
		private boolean upgradeDatabase = false;
		Context context;
		
		
		public DataBaseHelper(Context context) {
			super(context, DB_NAME, null, 1);
			this.context=context;
		}
		
		
		
				
		public void initializeDataBase() {

	        getWritableDatabase();

	        if (createDatabase) {
	            try {
	                copyDataBase();
	            } catch (IOException e) {
	                throw new Error("Error copying database");
	            }
	        } 

	    }   
	    private void copyDataBase() throws IOException {
	        InputStream input = context.getAssets().open(DB_NAME);
	        OutputStream output = new FileOutputStream(DB_PATH);
	        
	            byte[] buffer = new byte[1024];
	            int length;

	            try {
	                while ((length = input.read(buffer)) > 0) {
	                    output.write(buffer, 0, length);
	                }
	            }
	            
	            finally {
	                try {
	                    if (output != null) {
	                        try {
	                            output.flush();
	                        } finally {
	                            output.close();
	                        }
	                }
	                } finally {
	                    if (input != null) {
	                        input.close();
	                    }
	                }
	            }
	        
	        getWritableDatabase().close();
	    }
	    public void onCreate(SQLiteDatabase db) {
	        
	        createDatabase = true;    
	    }
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        
	        upgradeDatabase = true;

	    }
	   
	    
	    public void onOpen(SQLiteDatabase db) {
	        super.onOpen(db);
	    }
	}
	
	
	public Db open()
	{
		mDbHelper.initializeDataBase();
		if(db==null)
			db=mDbHelper.getWritableDatabase();
		return this;
	}
	public void close()
	{
		db.close();
	}
	
	public String getName(int a){		
		Cursor c=db.query("datapays", new String[]{"NOM"}, "_id="+a, null, null, null, null);
		c.moveToFirst();
		String pays=String.valueOf(c.getString(0));
		return pays;
	}
	
	public String getCapital(int a){		
		Cursor c=db.query("datapays", new String[]{"CAPITALE"}, "_id="+a, null, null, null, null);
		c.moveToFirst();
		String capitale=String.valueOf(c.getString(0));
		return capitale;
	}
	public Cursor findPays(String a){		
		Cursor c=db.query("datapays", new String[]{"NOM"}, "NOM like "+"'%"+a+"%'", null, null, null, null);
		return c;
	}
	
	public Cursor findPaysAfrique(String a){		
		Cursor c=db.query("datapays", new String[]{"NOM"}, "NOM like "+"'%"+a+"%' and CONTINENT like 'Afrique'", null, null, null, null);
		return c;
	}
	
	
	
	public Cursor findPaysAsie(String a){		
		Cursor c=db.query("datapays", new String[]{"NOM"}, "NOM like "+"'%"+a+"%' and CONTINENT like 'Asie'", null, null, null, null);
		return c;
	}
	
	public Cursor findPaysEurope(String a){		
		Cursor c=db.query("datapays", new String[]{"NOM"}, "NOM like "+"'%"+a+"%' and CONTINENT like 'Europe'", null, null, null, null);
		return c;
	}
	
	public Cursor findPaysAmerique(String a){		
		Cursor c=db.query("datapays", new String[]{"NOM"}, "NOM like "+"'%"+a+"%' and CONTINENT like 'Am�rique'", null, null, null, null);
		return c;
	}
	
	public Cursor findPaysOceanie(String a){		
		Cursor c=db.query("datapays", new String[]{"NOM"}, "NOM like "+"'%"+a+"%' and CONTINENT like 'Oc�anie'", null, null, null, null);
		return c;
	}
	
	public Cursor findCap(String a){		
		Cursor c=db.query("datapays", new String[]{"CAPITALE "}, "CAPITALE like "+"'%"+a+"%'", null, null, null, null);
		return c;
	}
	
	public Cursor findCapAfrique(String a){		
		Cursor c=db.query("datapays", new String[]{"CAPITALE "}, "CAPITALE like "+"'%"+a+"%' and CONTINENT like 'Afrique'", null, null, null, null);
		return c;
	}
	
	
	
	public Cursor findCapAsie(String a){		
		Cursor c=db.query("datapays", new String[]{"CAPITALE "}, "CAPITALE like "+"'%"+a+"%' and CONTINENT like 'Asie'", null, null, null, null);
		return c;
	}
	
	public Cursor findCapEurope(String a){		
		Cursor c=db.query("datapays", new String[]{"CAPITALE "}, "CAPITALE like "+"'%"+a+"%' and CONTINENT like 'Europe'", null, null, null, null);
		return c;
	}
	
	public Cursor findCapAmerique(String a){		
		Cursor c=db.query("datapays", new String[]{"CAPITALE "}, "CAPITALE like "+"'%"+a+"%' and CONTINENT like 'Am�rique'", null, null, null, null);
		return c;
	}
	
	public Cursor findCapOceanie(String a){		
		Cursor c=db.query("datapays", new String[]{"CAPITALE "}, "CAPITALE like "+"'%"+a+"%' and CONTINENT like 'Oc�anie'", null, null, null, null);
		return c;
	}
	
	public int getId1(String a){		
		Cursor c=db.query("datapays", new String[]{"_id"}, "NOM like "+"'%"+a+"%'", null, null, null, null);
		c.moveToFirst();
		if (c.getCount() == 0){return 0;}
			int id=Integer.parseInt(c.getString(0));
			return id;
			
	}
	
	public int getId2(String a){		
		Cursor c=db.query("datapays", new String[]{"_id"}, "CAPITALE like "+"'%"+a+"%'", null, null, null, null);
		c.moveToFirst();
		if (c.getCount() == 0){return 0;}
		int id=Integer.parseInt(c.getString(0));
		return id;
		
	}
	
	public String getSurface(int a){		
		Cursor c=db.query("datapays", new String[]{"SURFACE"}, "_id= "+a, null, null, null, null);
		c.moveToFirst();
		
		String id=String.valueOf(c.getString(0));
		return id;

	}
	
	
	public String getPop(int a){		
		Cursor c=db.query("datapays", new String[]{"POPULATION"}, "_id= "+a, null, null, null, null);
		c.moveToFirst();
		
		String id=String.valueOf(c.getString(0));
		return id;

	}
	
	public String getLan(int a){		
		Cursor c=db.query("datapays", new String[]{"LANGUE"}, "_id= "+a, null, null, null, null);
		c.moveToFirst();
		
		String id=String.valueOf(c.getString(0));
		return id;

	}
	
	public String getCont(int a){		
		Cursor c=db.query("datapays", new String[]{"CONTINENT"}, "_id= "+a, null, null, null, null);
		c.moveToFirst();
		
		String id=String.valueOf(c.getString(0));
		return id;

	}
	
	
	public String getMonn(int a){		
		Cursor c=db.query("datapays", new String[]{"MONNAIE"}, "_id= "+a, null, null, null, null);
		c.moveToFirst();
		
		String id=String.valueOf(c.getString(0));
		return id;

	}
	

}