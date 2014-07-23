package com.anigeek.carpull.app;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;

/**
 * Created by Christopher on 7/18/2014.
 */
public class GreenColor
{
	private Context context;
	private ViewGroup root;
	private int offset, baseOffset, oDelay;
	private AnimationSet animationSet;
	private static Handler h;


	public static final int EDIT_TEXT = 1;
	public static final int NUM_COUNTER = 2;
	public static final int EDIT_TEXT_AND_NUM = 3;
	public static final int BUTTON = 4;
	public static final int BUTTON_GROUP = 5;
	public static final int EDIT_TEXT_WITH_LABEL = 6;
	public static final int NUM_COUNTER_WITH_LABEL = 7;


	public GreenColor(Context c, ViewGroup root, int oDelay)
	{
		init( c, root, oDelay );
	}

	public GreenColor(Context c, ViewGroup root, int oDelay, int baseOffset)
	{
		init( c, root, oDelay );
		this.baseOffset = baseOffset;
		this.offset = baseOffset;
	}

	public GreenColor(Context c, ViewGroup root, int oDelay, AnimationSet animationSet)
	{
		init( c, root, oDelay );
		this.animationSet = animationSet;
	}

	public GreenColor(Context c, ViewGroup root, int oDelay, int baseOffset, AnimationSet animationSet)
	{
		init( c, root, oDelay );
		this.baseOffset = baseOffset;
		this.offset = baseOffset;
		this.animationSet = animationSet;
	}

	public void reset()
	{
		//h.postDelayed( new PassRunner(context), offset );
		offset = baseOffset;
	}

	public void clearScreen()
	{
		h.postDelayed( new PassRunner(context, root, null, animationSet), offset += oDelay );
	}

	public void clearScreen(GreenParams gp)
	{
		h.postDelayed(
			new PassRunner(
				context,
				gp.root == null ? root : gp.root,
				null,
				gp.animationSet == null ? animationSet : gp.animationSet
		),
            gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}

	public void postString(String[] str)
	{
		for(String s : str)
			postString( s );
	}
	
	public void postString(String str)
	{
		h.postDelayed( new PassRunner(context, root, str, animationSet), offset += oDelay );
	}

	public void postString(String str, GreenParams gp)
	{
		h.postDelayed(
				new PassRunner(
						context,
						gp.root == null ? root : gp.root,
						str,
						gp.animationSet == null ? animationSet : gp.animationSet
				),
				gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}

	public void postNumCounter(int max)
{
	h.postDelayed( new PassRunner(context, root, "0***" + max, NUM_COUNTER, animationSet), offset += oDelay );
}

	public void postNumCounter(int min, int max)
	{
		h.postDelayed( new PassRunner(context, root, min + "***" + max, NUM_COUNTER, animationSet), offset += oDelay );
	}

	public void postNumCounter(int max, GreenParams gp)
	{
		h.postDelayed(
				new PassRunner(
						context,
						gp.root == null ? root : gp.root,
						"0***" + max,
						NUM_COUNTER,
						gp.animationSet == null ? animationSet : gp.animationSet
				),
				gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}

	public void postNumCounter(int min, int max, GreenParams gp)
	{
		h.postDelayed(
				new PassRunner(
						context,
						gp.root == null ? root : gp.root,
						min + "***" + max,
						NUM_COUNTER,
						gp.animationSet == null ? animationSet : gp.animationSet
				),
				gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}

	public void postNumCounterWithLabel(int max, String str)
	{
		h.postDelayed( new PassRunner(context, root, str + "***" + "0***" + max, NUM_COUNTER_WITH_LABEL, animationSet),
		               offset += oDelay );
	}

	public void postNumCounterWithLabel(int min, int max, String str)
	{
		h.postDelayed( new PassRunner(context, root, str + "***" + min + "***" + max, NUM_COUNTER_WITH_LABEL, animationSet),
		               offset += oDelay );
	}

	public void postNumCounterWithLabel(int max, String str, GreenParams gp)
	{
		h.postDelayed(
				new PassRunner(
						context,
						gp.root == null ? root : gp.root,
						str + "***" + "0***" + max,
						NUM_COUNTER_WITH_LABEL,
						gp.animationSet == null ? animationSet : gp.animationSet
				),
				gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}

	public void postNumCounterWithLabel(int min, int max, String str, GreenParams gp)
	{
		h.postDelayed(
				new PassRunner(
						context,
						gp.root == null ? root : gp.root,
						str + "***" + min + "***" + max,
						NUM_COUNTER_WITH_LABEL,
						gp.animationSet == null ? animationSet : gp.animationSet
				),
				gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}

	public void postEditText()
	{
		h.postDelayed( new PassRunner(context, root, "", EDIT_TEXT, animationSet), offset += oDelay );
	}

	public void postEditText(String str)
	{
		h.postDelayed( new PassRunner(context, root, str, EDIT_TEXT, animationSet), offset += oDelay );
	}

	public void postEditText(String str, GreenParams gp)
	{
		h.postDelayed(
				new PassRunner(
						context,
						gp.root == null ? root : gp.root,
						str,
						EDIT_TEXT,
						gp.animationSet == null ? animationSet : gp.animationSet
				),
				gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}

	public void postEditTextWithLabel(String str)
	{
		h.postDelayed( new PassRunner(context, root, str, EDIT_TEXT_WITH_LABEL, animationSet), offset += oDelay );
	}

	public void postEditTextWithLabel(String str, GreenParams gp)
	{
		h.postDelayed(
				new PassRunner(
						context,
						gp.root == null ? root : gp.root,
						str,
						EDIT_TEXT_WITH_LABEL,
						gp.animationSet == null ? animationSet : gp.animationSet
				),
				gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}

	/*public void postEditTextAndNum()
	{
		h.postDelayed( new PassRunner(context, root, "", EDIT_TEXT_AND_NUM, animationSet), offset += oDelay );
	}

	public void postEditTextAndNum(String str)
	{
		h.postDelayed( new PassRunner(context, root, str, EDIT_TEXT_AND_NUM, animationSet), offset += oDelay );
	}

	public void postEditTextAndNum(String str, GreenParams gp)
	{
		h.postDelayed(
				new PassRunner(
						context,
						gp.root == null ? root : gp.root,
						str,
						EDIT_TEXT_AND_NUM,
						gp.animationSet == null ? animationSet : gp.animationSet
				),
				gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}*/

	public void postButton(String str)
	{
		h.postDelayed( new PassRunner(context, root, str, BUTTON, animationSet), offset += oDelay );
	}

	public void postButton(String str, GreenParams gp)
	{
		h.postDelayed(
				new PassRunner(
						context,
						gp.root == null ? root : gp.root,
						str,
						BUTTON,
						gp.animationSet == null ? animationSet : gp.animationSet
				),
				gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}

	public void postButtonGroup(String str)
	{
		h.postDelayed( new PassRunner(context, root, str, BUTTON_GROUP, animationSet), offset += oDelay );
	}

	public void postButtonGroup(String str, GreenParams gp)
	{
		h.postDelayed(
				new PassRunner(
						context,
						gp.root == null ? root : gp.root,
						str,
						BUTTON_GROUP,
						gp.animationSet == null ? animationSet : gp.animationSet
				),
				gp.offset == 0 ? (offset += oDelay) : gp.offset );
	}

	
	private void init(Context c, ViewGroup r, int del)
	{
		context = c;
		root = r;
		delays(del);
		h = new Handler();
	}

	private void delays(int delay)
	{
		offset = delay;
		baseOffset = delay;
		oDelay = delay;
	}

	public AnimationSet getAnimationSet()
	{
		return animationSet;
	}
	public void setAnimationSet( AnimationSet animationSet )
	{
		this.animationSet = animationSet;
	}
	public int getoDelay()
	{
		return oDelay;
	}
	public void setoDelay( int oDelay )
	{
		this.oDelay = oDelay;
	}
	public int getBaseOffset()
	{
		return baseOffset;
	}
	public void setBaseOffset( int baseOffset )
	{
		this.baseOffset = baseOffset;
	}
	public int getOffset()
	{
		return offset;
	}
	public void setOffset( int offset )
	{
		this.offset = offset;
	}
	public ViewGroup getRoot()
	{
		return root;
	}
	public void setRoot( ViewGroup root )
	{
		this.root = root;
	}
}
