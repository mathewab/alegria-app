package com.ashish.alegria3;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.view.ViewGroup.LayoutParams;
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

		public static Intent getOpenFacebookIntent(Context context) {

			try {
				context.getPackageManager().getPackageInfo(
						"com.facebook.katana", 0);
				return new Intent(Intent.ACTION_VIEW,
						Uri.parse("fb://profile/128797447271799"));
			} catch (Exception e) {
				return new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://www.facebook.com/pillaisalegria"));
			}
		}

		public static Intent getOpenTwitterIntent(Context context) {
			Intent intent = null;
			try {
				// get the Twitter app if possible
				context.getPackageManager().getPackageInfo(
						"com.twitter.android", 0);
				intent = new Intent(Intent.ACTION_VIEW,
						Uri.parse("twitter://user?user_id=992773777"));
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			} catch (Exception e) {
				// no Twitter app, revert to browser
				intent = new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://twitter.com/pillaisalegria"));
			}
			return intent;
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
				Intent ifb = getOpenFacebookIntent(this.getActivity()
						.getApplicationContext());
				// ifb.setData(Uri.parse(fb));
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
				Intent itw = getOpenTwitterIntent(this.getActivity()
						.getApplicationContext());
				// itw.setData(Uri.parse(tw));
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

			gridview = (GridView) rootView.findViewById(R.id.gridViewGallery);

			InitilizeGridLayout();

			gridview.setAdapter(new ImageAdapter(this.getActivity()));
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
					R.id.bn_sg17, R.id.bn_w01, R.id.bn_w02, R.id.bn_w03,
					R.id.bn_w04, R.id.bn_w05, R.id.bn_w06, R.id.bn_w07,
					R.id.bn_w08, R.id.bn_w09, R.id.bn_w10, R.id.bn_w11,
					R.id.bn_w12, R.id.bn_w13, R.id.bn_w14, R.id.bn_w15,
					R.id.bn_w16, R.id.bn_w17 };

			Resources r = getResources();
			float padding = TypedValue.applyDimension(
					TypedValue.COMPLEX_UNIT_DIP, AppConstant.GRID_PADDING,
					r.getDisplayMetrics());

			Utils utils = new Utils(this.getActivity());
			int columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) * padding)) / AppConstant.NUM_OF_COLUMNS);
			
			for (Integer i : buttons) {
				Button temp = (Button) rootView.findViewById(i);
				LayoutParams params = temp.getLayoutParams();
				params.width = columnWidth;
				params.height = columnWidth;
				temp.setLayoutParams(params);
				int pad = (int) padding;
				temp.setPadding(pad, pad,pad, pad);
				temp.setOnClickListener(this);
			}

			return rootView;
		}

		@Override
		public void onClick(View v) {
			Intent intent;
			intent = new Intent("com.ashish.alegria3.EVENTACTIVITY");
			intent.putExtra("EventCode", "");

			switch (v.getId()) {
			case R.id.bn_mgt1: 	intent.putExtra("EventCode", "M01"); 	break;
			case R.id.bn_mgt2: 	intent.putExtra("EventCode", "M02"); 	break;
			case R.id.bn_mgt3: 	intent.putExtra("EventCode", "M03"); 	break;
			case R.id.bn_mgt4: 	intent.putExtra("EventCode", "M04"); 	break;
			case R.id.bn_mgt5: 	intent.putExtra("EventCode", "M05"); 	break;
			case R.id.bn_mgt6: 	intent.putExtra("EventCode", "M06"); 	break;
			case R.id.bn_mgt7: 	intent.putExtra("EventCode", "M07"); 	break;
			case R.id.bn_mgt8: 	intent.putExtra("EventCode", "M08"); 	break;
			case R.id.bn_mgt9: 	intent.putExtra("EventCode", "M09"); 	break;

			case R.id.bn_in1: 	intent.putExtra("EventCode", "I01"); 	break;
			case R.id.bn_in2: 	intent.putExtra("EventCode", "I02"); 	break;
			case R.id.bn_in3: 	intent.putExtra("EventCode", "I03"); 	break;
			case R.id.bn_in4: 	intent.putExtra("EventCode", "I04"); 	break;
			case R.id.bn_in5: 	intent.putExtra("EventCode", "I05"); 	break;
			case R.id.bn_in6: 	intent.putExtra("EventCode", "I06"); 	break;

			case R.id.bn_l1: 	intent.putExtra("EventCode", "LA01"); 	break;
			case R.id.bn_l2: 	intent.putExtra("EventCode", "LA02"); 	break;
			case R.id.bn_l3: 	intent.putExtra("EventCode", "LA03"); 	break;
			case R.id.bn_l4: 	intent.putExtra("EventCode", "LA04"); 	break;
			case R.id.bn_l5: 	intent.putExtra("EventCode", "LA05"); 	break;
			case R.id.bn_l6: 	intent.putExtra("EventCode", "LA06"); 	break;

			case R.id.bn_pa01: 	intent.putExtra("EventCode", "PA01"); 	break;
			case R.id.bn_pa02: 	intent.putExtra("EventCode", "PA02"); 	break;
			case R.id.bn_pa03: 	intent.putExtra("EventCode", "PA03"); 	break;
			case R.id.bn_pa04: 	intent.putExtra("EventCode", "PA04"); 	break;
			case R.id.bn_pa05: 	intent.putExtra("EventCode", "PA05"); 	break;
			case R.id.bn_pa06: 	intent.putExtra("EventCode", "PA06"); 	break;
			case R.id.bn_pa07: 	intent.putExtra("EventCode", "PA07"); 	break;
			case R.id.bn_pa08: 	intent.putExtra("EventCode", "PA08"); 	break;
			case R.id.bn_pa09: 	intent.putExtra("EventCode", "PA09"); 	break;
			case R.id.bn_pa10: 	intent.putExtra("EventCode", "PA10"); 	break;
			case R.id.bn_pa11: 	intent.putExtra("EventCode", "PA11"); 	break;

			case R.id.bn_sg01: 	intent.putExtra("EventCode", "S01"); 	break;
			case R.id.bn_sg02: 	intent.putExtra("EventCode", "S02"); 	break;
			case R.id.bn_sg03: 	intent.putExtra("EventCode", "S03"); 	break;
			case R.id.bn_sg04: 	intent.putExtra("EventCode", "S04"); 	break;
			case R.id.bn_sg05: 	intent.putExtra("EventCode", "S05"); 	break;
			case R.id.bn_sg06: 	intent.putExtra("EventCode", "S06"); 	break;
			case R.id.bn_sg07: 	intent.putExtra("EventCode", "S07"); 	break;
			case R.id.bn_sg08: 	intent.putExtra("EventCode", "S08"); 	break;
			case R.id.bn_sg09: 	intent.putExtra("EventCode", "S09"); 	break;
			case R.id.bn_sg10: 	intent.putExtra("EventCode", "S10"); 	break;
			case R.id.bn_sg11: 	intent.putExtra("EventCode", "S11"); 	break;
			case R.id.bn_sg12: 	intent.putExtra("EventCode", "S12"); 	break;
			case R.id.bn_sg13: 	intent.putExtra("EventCode", "S13"); 	break;
			case R.id.bn_sg14: 	intent.putExtra("EventCode", "S14"); 	break;
			case R.id.bn_sg15: 	intent.putExtra("EventCode", "S15"); 	break;
			case R.id.bn_sg16: 	intent.putExtra("EventCode", "S16"); 	break;
			case R.id.bn_sg17: 	intent.putExtra("EventCode", "S17"); 	break;
			
			case R.id.bn_te01: 	intent.putExtra("EventCode", "T01"); 	break;
			case R.id.bn_te02: 	intent.putExtra("EventCode", "T02"); 	break;
			case R.id.bn_te03: 	intent.putExtra("EventCode", "T03"); 	break;
			case R.id.bn_te04: 	intent.putExtra("EventCode", "T04"); 	break;
			case R.id.bn_te05: 	intent.putExtra("EventCode", "T05"); 	break;
			case R.id.bn_te06: 	intent.putExtra("EventCode", "T06"); 	break;
			case R.id.bn_te07: 	intent.putExtra("EventCode", "T07"); 	break;
			case R.id.bn_te08: 	intent.putExtra("EventCode", "T08"); 	break;
			case R.id.bn_te09: 	intent.putExtra("EventCode", "T09"); 	break;
			case R.id.bn_te10: 	intent.putExtra("EventCode", "T10"); 	break;
			case R.id.bn_te11: 	intent.putExtra("EventCode", "T11"); 	break;
			case R.id.bn_te12: 	intent.putExtra("EventCode", "T12"); 	break;
			case R.id.bn_te13: 	intent.putExtra("EventCode", "T13"); 	break;
			case R.id.bn_te14: 	intent.putExtra("EventCode", "T14"); 	break;
			case R.id.bn_te15: 	intent.putExtra("EventCode", "T15"); 	break;
			
			case R.id.bn_w01: 	intent.putExtra("EventCode", "W01"); 	break;
			case R.id.bn_w02: 	intent.putExtra("EventCode", "W02"); 	break;
			case R.id.bn_w03: 	intent.putExtra("EventCode", "W03"); 	break;
			case R.id.bn_w04: 	intent.putExtra("EventCode", "W04"); 	break;
			case R.id.bn_w05: 	intent.putExtra("EventCode", "W05"); 	break;
			case R.id.bn_w06: 	intent.putExtra("EventCode", "W06"); 	break;
			case R.id.bn_w07: 	intent.putExtra("EventCode", "W07"); 	break;
			case R.id.bn_w08: 	intent.putExtra("EventCode", "W08"); 	break;
			case R.id.bn_w09: 	intent.putExtra("EventCode", "W09"); 	break;
			case R.id.bn_w10: 	intent.putExtra("EventCode", "W10"); 	break;
			case R.id.bn_w11: 	intent.putExtra("EventCode", "W11"); 	break;
			case R.id.bn_w12: 	intent.putExtra("EventCode", "W12"); 	break;
			case R.id.bn_w13: 	intent.putExtra("EventCode", "W13"); 	break;
			case R.id.bn_w14: 	intent.putExtra("EventCode", "W14"); 	break;
			case R.id.bn_w15: 	intent.putExtra("EventCode", "W15"); 	break;
			case R.id.bn_w16: 	intent.putExtra("EventCode", "W16"); 	break;
			case R.id.bn_w17: 	intent.putExtra("EventCode", "W17"); 	break;			
			
			case R.id.bn_fa01:
				intent.putExtra("EventCode", "FA01");
				break;
			case R.id.bn_fa02:
				intent.putExtra("EventCode", "FA02");
				break;
			case R.id.bn_fa03:
				intent.putExtra("EventCode", "FA03");
				break;
			case R.id.bn_fa04:
				intent.putExtra("EventCode", "FA04");
				break;
			case R.id.bn_fa05:
				intent.putExtra("EventCode", "FA05");
				break;
			case R.id.bn_fa06:
				intent.putExtra("EventCode", "FA06");
				break;
			case R.id.bn_fa07:
				intent.putExtra("EventCode", "FA07");
				break;
			case R.id.bn_fa08:
				intent.putExtra("EventCode", "FA08");
				break;
			case R.id.bn_fa09:
				intent.putExtra("EventCode", "FA09");
				break;

			}
			this.startActivity(intent);

		}
	}

}
