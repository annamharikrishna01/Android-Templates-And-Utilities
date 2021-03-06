package com.example.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Window;
import com.example.R;


public class ExampleActivity extends SherlockFragmentActivity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_example);
	}
	
	
	private void startWebActivity(String url)
	{
		try
		{
			Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url));
			startActivity(intent);
		}
		catch(android.content.ActivityNotFoundException e)
		{
			// can't start activity
		}
	}
	
	
	private void startMarketActivity()
	{
		try
		{
			Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(getString(R.string.app_uri)));
			startActivity(intent);
		}
		catch(android.content.ActivityNotFoundException e)
		{
			// can't start activity
		}
	}
	
	
	private void startMapCoordinatesActivity(double lat, double lon, String label)
	{
		try
		{
			StringBuilder builder = new StringBuilder();
			builder.append("geo:");
			builder.append(lat);
			builder.append(",");
			builder.append(lon);
			builder.append("?z=16"); // zoom value: 2..23
			builder.append("&q="); // query allows to show pin
			builder.append(Uri.encode(lat + "," + lon + "(" + label + ")"));
			
			Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(builder.toString()));
			startActivity(intent);
		}
		catch(android.content.ActivityNotFoundException e)
		{
			// can't start activity
		}
	}
	
	
	private void startMapSearchActivity(String query)
	{
		try
		{
			StringBuilder builder = new StringBuilder();
			builder.append("geo:0,0?q=");
			builder.append(Uri.encode(query));
			
			Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(builder.toString()));
			startActivity(intent);
		}
		catch(android.content.ActivityNotFoundException e)
		{
			// can't start activity
		}
	}
	
	
	private void startSmsActivity(String phoneNumber, String text)
	{
		try
		{
			Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
			intent.setType("vnd.android-dir/mms-sms");
			intent.putExtra("address", phoneNumber);
			intent.putExtra("sms_body", text);
			startActivity(intent);
		}
		catch(android.content.ActivityNotFoundException e)
		{
			// can't start activity
		}
	}
	
	
	private void startShareActivity(String chooserTitle, String subject, String text)
	{
		try
		{
			Intent intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
			intent.putExtra(android.content.Intent.EXTRA_TEXT, text);
			startActivity(Intent.createChooser(intent, chooserTitle));
		}
		catch(android.content.ActivityNotFoundException e)
		{
			// can't start activity
		}
	}
	
	
	private void startEmailActivity(String chooserTitle, String[] emailList, String subject, String text)
	{
		try
		{
			Intent intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setType("plain/text");
			intent.putExtra(android.content.Intent.EXTRA_EMAIL, emailList);
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
			intent.putExtra(android.content.Intent.EXTRA_TEXT, text);
			startActivity(Intent.createChooser(intent, chooserTitle));
		}
		catch(android.content.ActivityNotFoundException e)
		{
			// can't start activity
		}
	}
	
	
	private void startCalendarActivity(String title, String description, long beginTime, long endTime)
	{
		try
		{
			Intent intent = new Intent(android.content.Intent.ACTION_EDIT);
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra("title", title);
			intent.putExtra("description", description);
			intent.putExtra("beginTime", beginTime); // time in milliseconds
			intent.putExtra("endTime", endTime);
			startActivity(intent);
		}
		catch(android.content.ActivityNotFoundException e)
		{
			// can't start activity
		}
	}
	
	
	private void startCallActivity(String phoneNumber)
	{
		try
		{
			StringBuilder builder = new StringBuilder();
			builder.append("tel:");
			builder.append(phoneNumber);
			
			Intent intent = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse(builder.toString()));
			startActivity(intent);
		}
		catch(android.content.ActivityNotFoundException e)
		{
			// can't start activity
		}
	}
	
	
	private void startSettingsActivity()
	{
		try
		{
			startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
		}
		catch(android.content.ActivityNotFoundException e)
		{
			// can't start activity
		}
	}
}
