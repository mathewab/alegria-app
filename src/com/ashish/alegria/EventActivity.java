package com.ashish.alegria;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ashish.alegria.AlegriaBody.SectionsPagerAdapter;
import com.ashish.alegria.R;

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
		TextView tv_head_text = (TextView) this.findViewById(R.id.tv_head_text);
		TextView tv_rate_text = (TextView) this.findViewById(R.id.tv_rate_text);
		//TextView tv_duration_text = (TextView) this.findViewById(R.id.tv_duration_text);
		TextView tv_rules_text = (TextView) this.findViewById(R.id.tv_rules_text);
		TextView tv_title_event = (TextView) this.findViewById(R.id.tv_title_event);
		TextView tv_time_text = (TextView) this.findViewById(R.id.tv_time_text);
		TextView tv_description = (TextView) this.findViewById(R.id.tv_description);

		tv_description.setText(selectedEvent.getDesc());
		tv_date_text.setText(selectedEvent.getEventDate());
		tv_title_event.setText(selectedEvent.getTitle());
		tv_rules_text.setText(selectedEvent.getRules());
		tv_rate_text.setText(selectedEvent.getRate());
		//tv_duration_text.setText(selectedEvent.getDuration());
		tv_head_text.setText(selectedEvent.getEventHead() + " " + selectedEvent.getHeadcontact());
		tv_time_text.setText(selectedEvent.getTime());
		
	}

}
