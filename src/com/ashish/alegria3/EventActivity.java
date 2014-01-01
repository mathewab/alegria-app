package com.ashish.alegria3;

import java.util.List;
import java.util.Locale;

import com.ashish.alegria3.AlegriaBody.AboutMeFragment;
import com.ashish.alegria3.AlegriaBody.DummySectionFragment;
import com.ashish.alegria3.AlegriaBody.EventsFragment;
import com.ashish.alegria3.AlegriaBody.SectionsPagerAdapter;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class EventActivity extends FragmentActivity {

	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;
	static String value;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_event);
		
		XmlPullFeedParser xpp = new XmlPullFeedParser(this);
		
		List<Event> events = xpp.parse();
		
		Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("EventCode");
        }
        Event selectedEvent = new Event();
        
	        for(Event item : events) {
	        	if(item.getEventId().equalsIgnoreCase(value)){
	        		selectedEvent = item;
	        	}
	        }
		
		TextView tv_date_text = (TextView) this.findViewById(R.id.tv_date_text);
		TextView tv_rules_text = (TextView) this.findViewById(R.id.tv_rules_text);
		TextView tv_title_event = (TextView) this.findViewById(R.id.tv_title_event);

		tv_date_text.setText(selectedEvent.getEventId());
		tv_title_event.setText(selectedEvent.getTitle());
		tv_rules_text.setText(selectedEvent.getRules().toString());
		
		
	}

}
