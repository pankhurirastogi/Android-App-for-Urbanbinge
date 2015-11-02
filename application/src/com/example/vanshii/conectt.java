package com.example.vanshii;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;






import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class conectt extends Activity {
	/*this class is responsible for establishing the connection getting the json
	 * parsing it .and showing the content in list view.
	 * @pankhuri
	 */
	JSONArray data;
	TextView tv;
	JSONObject ob;
	ImageView iv;
	Context c;
	Button load_img;
	ImageView img;
	Bitmap bitmap;
	ProgressDialog pDialog;
	ListView listview;
	ListViewAdapter adapter;
	String want;
	
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		c=this;
		
		setContentView(R.layout.list_main);
		    Intent in=getIntent();
		    Bundle b=in.getExtras();
		    String cityy=b.getString("cityy");
		    String category=b.getString("category");
		   // Toast.makeText(conectt.this,cityy,Toast.LENGTH_LONG).show();
		     want="https://www.urbanbinge.com/events/"+cityy+"/"+category;
		   //Toast.makeText(conectt.this,want ,Toast.LENGTH_LONG).show();
		    
		    
		
		new A().execute();
	}

	private class A extends AsyncTask<Void, Void, Void> {
		String content="",alldata="";
		
		@Override
		protected void onPreExecute() {
			//Toast.makeText(c,"Getting data", Toast.LENGTH_LONG).show();
			super.onPreExecute();
		}
		@Override
		protected Void doInBackground(Void... params) {
			
			HttpClient client =new DefaultHttpClient();
			HttpGet get=new HttpGet(want);
			try {
				HttpResponse rs=client.execute(get);
				InputStream is=rs.getEntity().getContent();
				BufferedReader br=new BufferedReader(new InputStreamReader(is)); 
				String s;
				while((s=br.readLine())!=null){
					content+=s;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			if(content=="")
				content="no content";
			Bitmap bitmap = null;
			//Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();
			List<Eventss> le=new ArrayList<Eventss>();
			
				try {
					//Toast.makeText(conectt.this,content, Toast.LENGTH_LONG).show();
					data=new JSONArray(content);
				
					
					for (int i=0;i<data.length();i++){
					ob=data.getJSONObject(i);
					Eventss eventss=new Eventss();
					
					eventss.id =ob.getString("id");
					eventss.eventTitle=ob.getString("eventTitle");
					eventss.eventVenue=ob.getString("eventVenue");
					eventss.startDate=ob.getString("startDate");
					eventss.eventDiscription=ob.getString("eventDescription");
					eventss.costIncludes=ob.getString("costincludes");
					//eventss.secialInstructions=ob.getString("specialInstructions");
					//JSONObject user=ob.getJSONObject("user");
				    
					JSONArray eventimages=ob.getJSONArray("eventimages");
					
					   if(eventimages!=null)
					   {
						  JSONObject e=eventimages.getJSONObject(1);
						  EventImage ee=new EventImage();
						  ee.imageId=e.getString("imageId");
						  ee.imageURL="https://www.urbanbinge.com"+e.getString("imageURL");
						  eventss.ei=ee;
						  
					   }
			
					 
					
					
					
										le.add(eventss);//le is the array list that will have all the events object.
					
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
			}
				
				
			listview=(ListView)findViewById(R.id.listview);
			adapter = new ListViewAdapter(conectt.this, le);
			listview.setAdapter(adapter);
			
			
				

								//Toast.makeText(conectt.this, "pankhuri",Toast.LENGTH_LONG).show();
			super.onPostExecute(result);
		}
	}
	
}
