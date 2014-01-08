package com.ashish.alegria;

import java.util.Locale;

import com.ashish.alegria.adapter.CategoryAdapter;
import com.ashish.alegria.adapter.SponsorAdapter;
import com.ashish.alegria.helper.AppConstant;
import com.ashish.alegria.helper.Utils;
import com.ashish.alegria.R;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.TextView;

public class EventCategoryActivity extends FragmentActivity {



	
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		
		setContentView(R.layout.activity_event_category);
		
		int _postion = 0;
		Bundle extras = getIntent().getExtras();
		if (extras != null)
			_postion = extras.getInt("position");
		
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager(), this);

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager.setCurrentItem(_postion, Boolean.TRUE);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event_category, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		String titles[];
		public SectionsPagerAdapter(FragmentManager fm, Activity mActivity) {
			super(fm);
			titles = mActivity.getResources().getStringArray(
					R.array.titles_categories);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return titles.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			return (titles[position]).toUpperCase(l);
			/*switch (position) {
			case 0:
				return getString(R.string.title_category1).toUpperCase(l);
			case 1:
				return getString(R.string.title_category2).toUpperCase(l);
			case 2:
				return getString(R.string.title_category3).toUpperCase(l);
			}
			return null;*/
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public GridView gridview;
		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
		//	Integer[] temp = {R.layout.fragment_event_category_dummy, R.layout.fragment_alegria_body_mgt, R.layout.fragment_event_category_dummy};
			
			View rootView = inflater.inflate(
					R.layout.fragment_event_category_dummy, container, false);
		//	Integer[] gv = {R.id.gridView_events, R.id.gridView_events_mgt, R.id.gridView_events};
		//	Log.d("com.ashish.alegria",getArguments().getInt(ARG_SECTION_NUMBER)+" "+temp[getArguments().getInt(ARG_SECTION_NUMBER)-1]+" "+gv[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
			gridview = (GridView) rootView.findViewById(R.id.gridView_events);
			
			InitilizeGridLayout();

			gridview.setAdapter(new CategoryAdapter(this.getActivity(), getArguments().getInt(
					ARG_SECTION_NUMBER)));
			
			
			return rootView;
		}
		
		private void InitilizeGridLayout() {
			Resources r = getResources();
			float padding = TypedValue.applyDimension(
					TypedValue.COMPLEX_UNIT_DIP, AppConstant.GRID_PADDING,
					r.getDisplayMetrics());
			Utils utils = new Utils(this.getActivity());

			int columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) * padding)) / AppConstant.NUM_OF_COLUMNS);

			gridview.setNumColumns(AppConstant.NUM_OF_COLUMNS);
			gridview.setColumnWidth(columnWidth);
			gridview.setStretchMode(GridView.NO_STRETCH);
			gridview.setPadding((int) padding, (int) padding, (int) padding,
					(int) padding);
			gridview.setHorizontalSpacing((int) padding);
			gridview.setVerticalSpacing((int) padding);
		}
	}

}
