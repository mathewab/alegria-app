package com.ashish.alegria3;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashish.alegria3.gallery.helper.AppConstant;
import com.ashish.alegria3.gallery.helper.Utils;
import com.ashish.gallery.fragment.ImageAdapter;

public class AlegriaBody extends FragmentActivity {

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

		setContentView(R.layout.activity_alegria_body);

		// Show the Up button in the action bar.
		// getActionBar().setDisplayHomeAsUpEnabled(true);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager_body);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment;
			if (position == 0) {
				return new AboutMeFragment();
			} else if (position == 1) {
				return new EventsFragment();
			} else if (position == 2) {
				return new GalleryFragment();
			} else if (position == 3) {
				return new ContactUsFragment();
			} else {
				// getItem is called to instantiate the fragment for the given
				// page.
				// Return a DummySectionFragment (defined as a static inner
				// class
				// below) with the page number as its lone argument.
				fragment = new DummySectionFragment();
				Bundle args = new Bundle();
				args.putInt(DummySectionFragment.ARG_SECTION_NUMBER,
						position + 1);
				fragment.setArguments(args);
			}
			return fragment;

		}

		@Override
		public int getCount() {
			// Show 4 total pages.
			return 4;
		}

		@SuppressLint("DefaultLocale")
		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section4).toUpperCase(l);
			case 3:
				return getString(R.string.title_section3).toUpperCase(l);

			}
			return null;
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

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_alegria_body_dummy, container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

	public static class ContactUsFragment extends Fragment implements
			OnClickListener {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public ContactUsFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.contact_us_fragment,
					container, false);

			ImageView iv_fb = (ImageView) rootView.findViewById(R.id.bn_fb);

			iv_fb.setOnClickListener(this);

			ImageView iv_map = (ImageView) rootView.findViewById(R.id.maps_img);
			iv_map.setOnClickListener(this);
			ImageView iv_twi = (ImageView) rootView
					.findViewById(R.id.bn_twitter);
			iv_twi.setOnClickListener(this);
			ImageView iv_ins = (ImageView) rootView.findViewById(R.id.bn_ins);
			iv_ins.setOnClickListener(this);
			ImageView iv_uto = (ImageView) rootView.findViewById(R.id.bn_utube);
			iv_uto.setOnClickListener(this);

			return rootView;
		}

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.maps_img:
				String map = "https://maps.google.co.in/maps?f=d&source=s_q&hl=en&geocode=%3BCccmoaV-1eUzFRjEIQEdbddbBCn_____ROjnOzFi_i3lFtLPkQ&q=Pillai%27s+Institute+of+Information+Technology,+Engineering,+Media+Studies+%26+Research,+Composite+College+Campus+10,+Sector+16,+New+Panvel,+Navi+Mumbai,+Maharashtra&aq=0&oq=pillai&sll=18.815427,76.775144&sspn=9.557646,19.753418&ie=UTF8&hq=Pillai%27s+Institute+of+Information+Technology,+Engineering,+Media+Studies+%26+Research,+Composite+College+Campus+10,+Sector+16,+New+Panvel,&hnear=Navi+Mumbai,+Thane,+Maharashtra&t=m&ll=19.002887,73.129978&spn=0.081153,0.137329&z=13&vpsrc=6&iwloc=A&daddr=Pillai+Institute+of+Information+Technology,+Dr.+K.+M.+Vasudevan+Pillais+Campus+,+Sector+16,+New+Panvel,+Navi+Mumbai,,+Panvel,+Maharashtra+410206";
				Intent imap = new Intent(Intent.ACTION_VIEW);
				imap.setData(Uri.parse(map));
				this.startActivity(imap);
				break;
			case R.id.bn_fb:
				String fb = "https://www.facebook.com/pillaisalegria";
				Intent ifb = new Intent(Intent.ACTION_VIEW);
				ifb.setData(Uri.parse(fb));
				startActivity(ifb);
				break;
			case R.id.bn_ins:
				String ins = "http://instagram.com/pillaisalegria#";
				Intent ints = new Intent(Intent.ACTION_VIEW);
				ints.setData(Uri.parse(ins));
				startActivity(ints);
				break;
			case R.id.bn_utube:
				String ut = "https://www.youtube.com/user/pillaisalegria‎";
				Intent iut = new Intent(Intent.ACTION_VIEW);
				iut.setData(Uri.parse(ut));
				startActivity(iut);
				break;
			case R.id.bn_twitter:
				String tw = "https://twitter.com/PillaisAlegria";
				Intent itw = new Intent(Intent.ACTION_VIEW);
				itw.setData(Uri.parse(tw));
				startActivity(itw);
				break;

			}

		}
	}

	public static class AboutMeFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public AboutMeFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.about_me_fragment,
					container, false);
			return rootView;
		}
	}

	public static class GalleryFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		GridView gridview;
		
		public GalleryFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.gallery_fragment,
					container, false);
			
			
			gridview = (GridView) rootView
					.findViewById(R.id.gridViewGallery);
			
			InitilizeGridLayout();

			gridview.setAdapter(new ImageAdapter(this.getActivity()));
			return rootView;
		}
	    private void InitilizeGridLayout() {
	        Resources r = getResources();
	        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
	                AppConstant.GRID_PADDING, r.getDisplayMetrics());
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

	public static class EventsFragment extends Fragment implements
			OnClickListener {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public EventsFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.events_fragment,
					container, false);

			Integer[] buttons = { R.id.bn_mgt1, R.id.bn_mgt2, R.id.bn_mgt3,
					R.id.bn_mgt4, R.id.bn_mgt5, R.id.bn_mgt6, R.id.bn_mgt7,
					R.id.bn_mgt8, R.id.bn_mgt9, R.id.bn_fa01, R.id.bn_fa02,
					R.id.bn_fa03, R.id.bn_fa04, R.id.bn_fa05, R.id.bn_fa06,
					R.id.bn_fa07, R.id.bn_fa08, R.id.bn_fa09, R.id.bn_te01,
					R.id.bn_te02, R.id.bn_te03, R.id.bn_te04, R.id.bn_te05,
					R.id.bn_te06, R.id.bn_te07, R.id.bn_te08, R.id.bn_te09,
					R.id.bn_te10, R.id.bn_te11, R.id.bn_te12, R.id.bn_te13,
					R.id.bn_te14, R.id.bn_te15, R.id.bn_in1, R.id.bn_in2,
					R.id.bn_in3, R.id.bn_in4, R.id.bn_in5, R.id.bn_in6,
					R.id.bn_pa01, R.id.bn_pa02, R.id.bn_pa03, R.id.bn_pa04,
					R.id.bn_pa05, R.id.bn_pa06, R.id.bn_pa07, R.id.bn_pa08,
					R.id.bn_pa09, R.id.bn_pa10, R.id.bn_pa11, R.id.bn_l1,
					R.id.bn_l2, R.id.bn_l3, R.id.bn_l4, R.id.bn_l5, R.id.bn_l6,
					R.id.bn_sg01, R.id.bn_sg02, R.id.bn_sg03, R.id.bn_sg04,
					R.id.bn_sg05, R.id.bn_sg06, R.id.bn_sg07, R.id.bn_sg08,
					R.id.bn_sg09, R.id.bn_sg10, R.id.bn_sg11, R.id.bn_sg12,
					R.id.bn_sg13, R.id.bn_sg14, R.id.bn_sg15, R.id.bn_sg16,
					R.id.bn_sg17 };
			
			for (Integer i : buttons) {
				Button temp = (Button) rootView.findViewById(i);
				temp.setOnClickListener(this);
			}

		/*	Button bn_mgt1 = (Button) rootView.findViewById(R.id.bn_mgt1);
			Button bn_mgt2 = (Button) rootView.findViewById(R.id.bn_mgt2);
			Button bn_mgt3 = (Button) rootView.findViewById(R.id.bn_mgt3);
			Button bn_mgt4 = (Button) rootView.findViewById(R.id.bn_mgt4);
			Button bn_mgt5 = (Button) rootView.findViewById(R.id.bn_mgt5);
			Button bn_mgt6 = (Button) rootView.findViewById(R.id.bn_mgt6);
			Button bn_mgt7 = (Button) rootView.findViewById(R.id.bn_mgt7);
			Button bn_mgt8 = (Button) rootView.findViewById(R.id.bn_mgt8);
			Button bn_mgt9 = (Button) rootView.findViewById(R.id.bn_mgt9);

			Button bn_fa01 = (Button) rootView.findViewById(R.id.bn_fa01);
			Button bn_fa02 = (Button) rootView.findViewById(R.id.bn_fa02);
			Button bn_fa03 = (Button) rootView.findViewById(R.id.bn_fa03);
			Button bn_fa04 = (Button) rootView.findViewById(R.id.bn_fa04);
			Button bn_fa05 = (Button) rootView.findViewById(R.id.bn_fa05);
			Button bn_fa06 = (Button) rootView.findViewById(R.id.bn_fa06);
			Button bn_fa07 = (Button) rootView.findViewById(R.id.bn_fa07);
			Button bn_fa08 = (Button) rootView.findViewById(R.id.bn_fa08);
			Button bn_fa09 = (Button) rootView.findViewById(R.id.bn_fa09);

			bn_mgt1.setOnClickListener(this);
			bn_mgt2.setOnClickListener(this);
			bn_mgt3.setOnClickListener(this);
			bn_mgt4.setOnClickListener(this);
			bn_mgt5.setOnClickListener(this);
			bn_mgt6.setOnClickListener(this);
			bn_mgt7.setOnClickListener(this);
			bn_mgt8.setOnClickListener(this);
			bn_mgt9.setOnClickListener(this);

			bn_fa01.setOnClickListener(this);
			bn_fa02.setOnClickListener(this);
			bn_fa03.setOnClickListener(this);
			bn_fa04.setOnClickListener(this);
			bn_fa05.setOnClickListener(this);
			bn_fa06.setOnClickListener(this);
			bn_fa07.setOnClickListener(this);
			bn_fa08.setOnClickListener(this);
			bn_fa09.setOnClickListener(this);
*/
			return rootView;
		}

		@Override
		public void onClick(View v) {
			Intent intent;
			intent = new Intent("com.ashish.alegria3.EVENTACTIVITY");
			intent.putExtra("EventCode", "");

			switch (v.getId()) {
			case R.id.bn_mgt1:
				System.out.println("Button clicked");
				break;

			case R.id.bn_mgt2:
				intent.putExtra("EventCode", "MGT101");
				break;
			case R.id.bn_mgt3:
				intent.putExtra("EventCode", "MGT102");
				break;

			case R.id.bn_fa01:
				intent.putExtra("EventCode", "FA101");
				break;
			case R.id.bn_fa02:
				intent.putExtra("EventCode", "FA102");
				break;
			case R.id.bn_fa03:
				intent.putExtra("EventCode", "FA103");
				break;
			case R.id.bn_fa04:
				intent.putExtra("EventCode", "FA104");
				break;
			case R.id.bn_fa05:
				intent.putExtra("EventCode", "FA105");
				break;
			case R.id.bn_fa06:
				intent.putExtra("EventCode", "FA106");
				break;
			case R.id.bn_fa07:
				intent.putExtra("EventCode", "FA107");
				break;
			case R.id.bn_fa08:
				intent.putExtra("EventCode", "FA108");
				break;
			case R.id.bn_fa09:
				intent.putExtra("EventCode", "FA109");
				break;

			}
			this.startActivity(intent);

		}
	}

}
