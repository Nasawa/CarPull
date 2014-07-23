package com.anigeek.carpull.app;

import android.view.ViewGroup;
import android.view.animation.AnimationSet;

/**
 * Created by Christopher on 7/18/2014.
 */
public class GreenParams
{
	public GreenParams( AnimationSet animationSet, ViewGroup root, int offset )
	{
		this.animationSet = animationSet;
		this.root = root;
		this.offset = offset;
	}
	public AnimationSet animationSet;
	public ViewGroup root;
	public int offset;
}
