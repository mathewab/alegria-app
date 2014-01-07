package com.ashish.alegria;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import com.ashish.alegria.adapter.gallery.FullScreenImageAdapter;
import com.ashish.alegria.helper.Utils;
import com.ashish.alegria.R;

public class FullScreenViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_full_screen_view);

        Utils utils = new Utils(this);
        String path = "";
		Bundle extras = getIntent().getExtras();
        if (extras != null) {
            path = extras.getString("Link");
        }
        
      
		ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(new FullScreenImageAdapter(this, utils.getFilePaths(path)));	
		mViewPager.setCurrentItem(extras.getInt("position"), Boolean.TRUE);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.full_screen_view, menu);
		return true;
	}

}
