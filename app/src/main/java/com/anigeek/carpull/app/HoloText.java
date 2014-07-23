package com.anigeek.carpull.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;


/**
 * TODO: document your custom view class.
 */
public class HoloText extends TextView
{
	public HoloText( Context context, String text )
	{
		super( context );
		this.setText( text );
		this.setTextColor( Color.parseColor( "#33b5e5" ) );
		this.setTextSize( TypedValue.COMPLEX_UNIT_DIP, 50 );
	}

	public HoloText( Context context, String text , String color)
	{
		super( context );
		this.setText( text );
		this.setTextColor( Color.parseColor( color ) );
		this.setTextSize( TypedValue.COMPLEX_UNIT_DIP, 50 );
	}

	public HoloText( Context context, String text , float size)
	{
		super( context );
		this.setText( text );
		this.setTextColor( Color.parseColor( "#33b5e5" ) );
		this.setTextSize( TypedValue.COMPLEX_UNIT_DIP, size );
	}

	public HoloText( Context context, String text , String color, float size)
	{
		super( context );
		this.setText( text );
		this.setTextColor( Color.parseColor( color ) );
		this.setTextSize( TypedValue.COMPLEX_UNIT_DIP, size );
	}
}
