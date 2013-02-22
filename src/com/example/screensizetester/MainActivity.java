package com.example.screensizetester;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		determineSizes();
		determineDensity();
		determineWidthAndHeight();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void determineSizes()
	{
		TextView etSize = (TextView) findViewById(R.id.tvSize);
		String text = "";
		int screenSize = getResources().getConfiguration().screenLayout;
		
		if ((screenSize & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE)
		{
			text = "XLarge";
		}
		else if ((screenSize & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE)
		{
			text = "Large";
		}
		else if ((screenSize & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL)
		{
			text = "Normal";
		}
		else if ((screenSize & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL)
		{
			text = "Small";
		}
		else
		{
			text = "Undefined";
		}
		
		etSize.setText(text);
	}

	private void determineDensity()
	{
		TextView etDensity = (TextView) findViewById(R.id.tvDensity);
		String text = "";
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int density = metrics.densityDpi;
		
		if (density == DisplayMetrics.DENSITY_XXHIGH)
		{
			text = "XXHDPI";
		}
		else if (density == DisplayMetrics.DENSITY_XHIGH)
		{
			text = "XHDPI";
		}
		else if (density == DisplayMetrics.DENSITY_HIGH)
		{
			text = "HDPI";
		}
		else if (density == DisplayMetrics.DENSITY_MEDIUM)
		{
			text = "MDPI";
		}
		else if (density == DisplayMetrics.DENSITY_TV)
		{
			text = "TVDPI";
		}
		else if (density == DisplayMetrics.DENSITY_LOW)
		{
			text = "LDPI";
		}
		else
		{
			text = "Undefined density";
		}
		
		text += ", value: " + String.valueOf(density);
		etDensity.setText(text);
	}
	
	private void determineWidthAndHeight()
	{
		TextView etWidth = (TextView) findViewById(R.id.tvWidth);
		TextView etHeight = (TextView) findViewById(R.id.tvHeight);
		
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		etWidth.setText(String.valueOf(dm.widthPixels));
		etHeight.setText(String.valueOf(dm.heightPixels));
	}
}
