package com.ashish.alegria3;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.ashish.alegria3.gallery.adapter.FullScreenImageAdapter;
import com.ashish.alegria3.gallery.helper.Utils;

public class FullScreenViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_screen_view);

        Utils utils = new Utils(this);

		ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(new FullScreenImageAdapter(this, utils.getFilePaths()));	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.full_screen_view, menu);
		return true;
	}

}
