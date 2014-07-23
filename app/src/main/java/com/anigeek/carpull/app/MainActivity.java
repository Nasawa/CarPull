package com.anigeek.carpull.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity
{
	public static Context context;
	public static LinearLayout root;
	public static int animationStep = -1;
	public static AnimationSet animationSet, slideAnimation;
	public static Handler h;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
		context = this;
		root = (LinearLayout)findViewById( R.id.root );

		animInit();

		GreenColor gc = new GreenColor( context, root, 1500, 500, animationSet );

		String[] strarr = {"Hello, I'm CarPull.", "Let's get you set up.", "This should just take a moment..."};

		gc.postString( strarr );
		gc.clearScreen( new GreenParams( slideAnimation, null, 0 ) );
		gc.postString( "Who is the first passenger?" );
		gc.postEditTextWithLabel( "Name:" );
		gc.postString( "How big is their vehicle?" );
		gc.postNumCounterWithLabel( 10, "# Seats:" );
		gc.postButtonGroup( "All Done***Add Passenger" );
		gc.reset();

		/*LinearLayout lLay = (LinearLayout)root.getChildAt( 4 );

		View tempButton = (View) lLay.getChildAt( 1 );

		tempButton.setOnClickListener( new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Toast.makeText( context, "moo", Toast.LENGTH_LONG ).show();
			}
		});*/


	}


	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate( R.menu.main, menu );
		return true;
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if( id == R.id.action_settings )
		{
			return true;
		}
		return super.onOptionsItemSelected( item );
	}

	public void animInit()
	{
		AlphaAnimation alphaAnimation = new AlphaAnimation( 0, 1 );
		TranslateAnimation translateAnimation = new TranslateAnimation( 0, 0, 100, 0 );

		animationSet = new AnimationSet( true );
		animationSet.addAnimation( alphaAnimation );
		animationSet.addAnimation( translateAnimation );
		animationSet.setStartOffset( 0 );
		animationSet.setInterpolator( new DecelerateInterpolator() );
		animationSet.setDuration( 1000 );

		AlphaAnimation slideAlpha = new AlphaAnimation( 1, 0 );
		TranslateAnimation slideTranslate = new TranslateAnimation( 0, -500, 0, 0 );

		slideAnimation = new AnimationSet( true );
		slideAnimation.addAnimation( slideAlpha );
		slideAnimation.addAnimation( slideTranslate );
		slideAnimation.setStartOffset( 0 );
		slideAnimation.setInterpolator( new DecelerateInterpolator(  ) );
		slideAnimation.setDuration( 1000 );
	}
}
