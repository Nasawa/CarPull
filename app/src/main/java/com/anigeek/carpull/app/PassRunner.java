package com.anigeek.carpull.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import java.util.regex.Pattern;

/**
 * Created by Christopher on 7/18/2014.
 */
public class PassRunner implements Runnable
{
	private String text = null;
	private AnimationSet animationSet;
	private ViewGroup root;
	private Context context;
	private int code = 0;

	private static final int EDIT_TEXT = 1;
	private static final int NUM_COUNTER = 2;
	private static final int EDIT_TEXT_AND_NUM = 3;
	private static final int BUTTON = 4;
	private static final int BUTTON_GROUP = 5;
	private static final int EDIT_TEXT_WITH_LABEL = 6;
	private static final int NUM_COUNTER_WITH_LABEL = 7;

	/*public PassRunner(ViewGroup root)
	{
		root.
	}*/

	public PassRunner(Context c, ViewGroup r, String t, AnimationSet a)
	{
		context = c;
		root = r;
		text = t;
		animationSet = a;
	}

	public PassRunner(Context c, ViewGroup r, int i, AnimationSet a)
	{
		context = c;
		root = r;
		code = i;
		animationSet = a;
	}

	public PassRunner(Context c, ViewGroup r, String t, int i, AnimationSet a)
	{
		context = c;
		root = r;
		text = t;
		code = i;
		animationSet = a;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void run()
	{
		HoloText h;
		HoloEdit he;
		Button b;
		LinearLayout linLay;
		NumberPicker n;
		String[] t;
		switch (code)
		{
			case 0:
				if(text != null)
				{
					h = new HoloText( context, text );
					root.addView( h );
					h.startAnimation( animationSet );
				}
				else if(text == null)
				{
					root.startAnimation( animationSet );
					animationSet.setAnimationListener( new Animation.AnimationListener()
					{
						public void onAnimationStart( Animation animation ){}
						public void onAnimationEnd( Animation animation ){root.removeAllViews();}
						public void onAnimationRepeat( Animation animation ){}
					} );
				}
				break;

			case EDIT_TEXT:
				he = new HoloEdit( context );
				root.addView( he );
				he.startAnimation( animationSet );
				break;

			case NUM_COUNTER:
				n = new NumberPicker( context );
				t = text.split( Pattern.quote( "***" ));
				n.setMinValue( Integer.parseInt( t[0] ) );
				n.setMaxValue( Integer.parseInt( t[1] ) );
				root.addView( n );
				n.startAnimation( animationSet );
				break;

			/*case EDIT_TEXT_AND_NUM:
				linLay = new LinearLayout( context );
				linLay.setOrientation( LinearLayout.HORIZONTAL );

				he = new HoloEdit( context );
				he.setLayoutParams( new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT,
						0.25f));

				n = new NumberPicker( context );
				n.setMaxValue( 10 );
				n.setMinValue(  0 );
				n.setLayoutParams( new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT,
						0.75f));

				linLay.addView( he );
				linLay.addView( n );
				root.addView( linLay );
				linLay.startAnimation( animationSet );
				break;*/

			case BUTTON:
				b = new Button(context);
				b.setText(text == null ? "submit" : text);
				root.addView( b );
				b.startAnimation( animationSet );
				break;

			case BUTTON_GROUP://Strings counted and separated by '***'
				t = text.split( Pattern.quote( "***" ));
				linLay = new LinearLayout( context );
				linLay.setOrientation( LinearLayout.HORIZONTAL );
				float weight = (float)((100 / t.length) * 0.01);
				for(String info : t)
				{
					b = new Button(context);
					b.setLayoutParams( new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.MATCH_PARENT,
					        LinearLayout.LayoutParams.WRAP_CONTENT,
					        weight));
					b.setText(info);
					linLay.addView( b );
				}
				root.addView( linLay );
				linLay.startAnimation( animationSet );
				break;

			case EDIT_TEXT_WITH_LABEL:
				h = new HoloText( context, text );
				he = new HoloEdit( context );
				linLay = new LinearLayout( context );
				linLay.setOrientation( LinearLayout.HORIZONTAL );

				h.setLayoutParams( new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT,
						0.50f));

				he.setLayoutParams( new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT,
						0.50f));

				linLay.addView( h );
				linLay.addView( he );
				root.addView( linLay );
				linLay.startAnimation( animationSet );
				break;

			case NUM_COUNTER_WITH_LABEL:
				t = text.split( Pattern.quote( "***" ) );
				h = new HoloText( context, t[0] );
				n = new NumberPicker( context );
				n.setMinValue( Integer.parseInt( t[1] ) );
				n.setMaxValue( Integer.parseInt( t[2] ) );
				linLay = new LinearLayout( context );
				linLay.setOrientation( LinearLayout.HORIZONTAL );

				h.setLayoutParams( new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT,
						0.50f));

				n.setLayoutParams( new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT,
						0.50f));

				linLay.addView( h );
				linLay.addView( n );
				root.addView( linLay );
				linLay.startAnimation( animationSet );
				break;
			default:
				break;

		}
	}
}
