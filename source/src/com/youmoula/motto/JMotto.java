package com.youmoula.motto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class JMotto extends Plugin{
	 
    public static final String ACTION = "actiona";
    String pName = this.getClass().getPackage().getName();
    
    @Override
    public PluginResult execute(String action, JSONArray data, String callbackId) {
        PluginResult result = null; 
        JSONObject jsonObj = new JSONObject();//可以返回给JS的JSON数据
        if(ACTION.equals(action)){
            try {
                //String testData1 = data.getString(0);//JS中传来的JSON格式的数据
                Log.e("test!!!", "This is testData1 ");
                jsonObj.put("mottos", "dkifo");
                //jsonObj.put("testData1", testData1 + " after Plugin");
                //jsonObj.put("testData2", testData2 + " after Plugin");
                this.copy("mottos.dbs","/data/data/"+pName+"/app_database/");
                jsonObj=motolist();
                result = new PluginResult(PluginResult.Status.OK,jsonObj);
            } catch (Exception e) {
                e.printStackTrace();
            } 
             
        }
         
        return result;
    }
    
	public JSONObject motolist(){
    	JSONObject jsb=new JSONObject();
    	StringBuilder res=new StringBuilder("");
//    	try {
//			this.copy("mottos.dbs","/data/data/"+pName+"/app_database/");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
    	//List<String> lmt=new ArrayList<String>();
    	Cursor c=null;Cursor cc=null;
		database=android.database.sqlite.SQLiteDatabase.openDatabase("/data/data/"+pName+"/app_database/mottos.dbs", null, 0);
		
		StringBuilder strSql=new StringBuilder();
		strSql.append("select MTYPE_ID,MTYPE_NAME from MOTTO_TYPE ");
		strSql.append(" where IS_DELETED=0 and MTYPE_ISROOT=1 GROUP BY MTYPE_NAME ");
		//Log.e("table1", "select");
		c=database.rawQuery(strSql.toString(), null);
		
		try {
			
			//Log.e("table1", "column:"+c.getColumnName(0)+c.getColumnName(1));
		c.moveToFirst();
		while(!c.isAfterLast())
		{
			
			res.append(c.getInt(0)+"|+|");
			res.append(c.getString(1)+"|+|");
			
			StringBuilder strSql2=new StringBuilder();
			strSql2.append("select MOTTO_ID,MOTTO_CON from MOTTO_CON ");
			strSql2.append(" where MTYPE_ID="+c.getInt(0)+" and IS_DELETED=0 ");
			cc=database.rawQuery(strSql2.toString(),null);
			
			cc.moveToFirst();
			//Log.e("table1", "row"+c.getString(1));
			while(!cc.isAfterLast())
			{

				//Log.e("table2", "childrow"+cc.getString(1));
				res.append(cc.getInt(0)+"|-|");
				res.append(cc.getString(1));
				cc.moveToNext();
				if(!cc.isAfterLast())
				{
					res.append("||");
				}
			}
			
			//res.append("}]");
			cc.close();
			//lmt.add(item);
			c.moveToNext();
			if(!c.isAfterLast())
			{
				res.append("|*|");
			}
		}
		c.close();
		database.close();

			jsb.put("mottos", res.toString());
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsb;
    }
    
    //Copy Paste this function in the class where you used above part
	void copy(String file, String folder) throws IOException 
    {
        File CheckDirectory;
        CheckDirectory = new File(folder);
        if (!CheckDirectory.exists())
        { 
           CheckDirectory.mkdir();
        }

        InputStream in =this.ctx.getAssets().open(file); //.cordova.getActivity()
        OutputStream out = new FileOutputStream(folder+file);

       // Transfer bytes from in to out
       byte[] buf = new byte[1024];
       int len; while ((len = in.read(buf)) > 0) out.write(buf, 0, len);
       in.close(); out.close();            
   }
    
    private SQLiteDatabase database;
	public PluginResult mottos()
    {
    	PluginResult result=null;//new PluginResult(Status.OK, data);
    	JSONObject jobj=null;//new JSONObject();
    	Cursor c=null;
    	try{
    		//Cursor cfy=new Cursor();
    		database=android.database.sqlite.SQLiteDatabase.openDatabase("mottos.db", null, 1);
    		c=database.rawQuery("SELECT * FROM MOTTO", null);
    		while(c.moveToNext())
    		{
    			
    		}
    		database.close();
    		jobj=new JSONObject();
    		jobj.put("_prefix_",1560);
    		
    		result = new PluginResult(PluginResult.Status.OK, jobj);
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return result;
    }
 
}