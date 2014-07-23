package com.anigeek.carpull.app;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.widget.EditText;

/**
 * Created by Christopher on 7/18/2014.
 */
public class HoloEdit extends EditText
{
	public HoloEdit( Context context)
	{
		super( context );
		this.setTextColor( Color.parseColor( "#33b5e5" ) );
		this.setTextSize( TypedValue.COMPLEX_UNIT_DIP, 50 );
	}

	public HoloEdit( Context context, String text )
	{
		super( context );
		this.setText( text );
		this.setTextColor( Color.parseColor( "#33b5e5" ) );
		this.setTextSize( TypedValue.COMPLEX_UNIT_DIP, 50 );
	}

	public HoloEdit( Context context, String text , String color)
	{
		super( context );
		this.setText( text );
		this.setTextColor( Color.parseColor( color ) );
		this.setTextSize( TypedValue.COMPLEX_UNIT_DIP, 50 );
	}

	public HoloEdit( Context context, String text , float size)
	{
		super( context );
		this.setText( text );
		this.setTextColor( Color.parseColor( "#33b5e5" ) );
		this.setTextSize( TypedValue.COMPLEX_UNIT_DIP, size );
	}

	public HoloEdit( Context context, String text , String color, float size)
	{
		super( context );
		this.setText( text );
		this.setTextColor( Color.parseColor( color ) );
		this.setTextSize( TypedValue.COMPLEX_UNIT_DIP, size );
	}
}
