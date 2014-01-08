package com.ashish.alegria.adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ashish.alegria.EventActivity;
import com.ashish.alegria.EventCategoryActivity;
import com.ashish.alegria.R;
import com.ashish.alegria.helper.AppConstant;
import com.ashish.alegria.helper.Utils;

public class CategoryAdapter extends BaseAdapter {
	private Activity mActivity;
	int _category;
	private String[] _titles;
	private Integer[] codes_category = { R.array.codes_mgt_events,
			R.array.codes_fa_events, R.array.codes_pa_events, R.array.codes_in_events, R.array.codes_wk_events,
			R.array.codes_la_events, R.array.codes_sg_events, R.array.codes_tech_events};
	
	public CategoryAdapter(Activity mActivity, int category) {
		this.mActivity = mActivity;
		this._category = category;
		switch (category) {
		case 0:
			mThumbIds = categories;
			_titles = mActivity.getResources().getStringArray(
					R.array.titles_categories);			break;
		case 1:
			_titles = mgt;
			break;
		case 2:
			_titles = fa;
			break;
		case 3:
			_titles = pa;
			break;
		case 4:
			_titles = in;
			break;
		case 5:
			_titles = wk;
			break;
		case 6:
			_titles = la;
			break;
		case 7:
			_titles = sg;
			break;
		case 8:
			_titles = te;
			break;
		}
	}

	public int getCount() {
		if(_category == 0)
		return mThumbIds.length;
		else 
			return _titles.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		
	    LayoutInflater inflater = LayoutInflater.from(mActivity);
	    RelativeLayout rel;
		ImageView imageView;
		TextView textView;
		Resources r = mActivity.getResources();
		float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				AppConstant.GRID_PADDING, r.getDisplayMetrics());
		Utils utils = new Utils(mActivity);
		int columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) * padding)) / AppConstant.NUM_OF_COLUMNS);

		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			rel = (RelativeLayout)inflater.inflate(R.layout.gridviewitem, null, true);
			rel.setLayoutParams(new GridView.LayoutParams(columnWidth,
					columnWidth));
			
	        //convertView = inflater.inflate(R.layout.gridviewitem, null, true);


		} else {
			rel = (RelativeLayout) convertView;
		}
		imageView = (ImageView) rel.findViewById(R.id.iv_gvitem);
		textView = (TextView) rel.findViewById(R.id.tv_gvitem);

		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		if (_category == 0) {
		imageView.setImageResource(mThumbIds[position]); }
		//imageView.setBackgroundResource(R.drawable.button_background);
		Typeface type = Typeface.createFromAsset(mActivity.getAssets(),"samarn.ttf"); 
		textView.setTypeface(type);
		textView.setText(_titles[position]);
		rel.setOnClickListener(new OnImageClickListener(position));
		return rel;
	}

	// references to our images
	private Integer[] mThumbIds;
	private Integer[] categories = { R.drawable.finearts, R.drawable.finearts,R.drawable.finearts,R.drawable.finearts ,
			R.drawable.finearts,R.drawable.finearts,R.drawable.finearts,R.drawable.finearts};

	private String[] pa = { "Bring it on",
			"Foot Loose",
			"Stomp The Floor",
			"In Sync",
			"Reinventing Traditions",
			"Kalakshetra",
			"Vocalize",
			"Rap-Shap.!!",
			"Beats and Chords",
			"I, Me, Myself",
			"Take-1"
	};
	private String[] la = {		
			"Words Worth",
			"Right to Write",
			"Battle of the Words",
			"Me Marathi",
			"Spell to Win",
			"Relay writing"};
			private String[] fa = {		

			"Artistic Fantasy Painting",
			"Poster Mania",
			"Art of Colours",
			"Intricate Patterns",
			"Nail Fantasy",
			"Blot The Tee",
			"Mask Me",
			"Bodygraphy",
			"Tooning Around"};
			private String[] in = {		

			"Strut It or Shut It",
			"Mr & Ms Alegria",
			"Reel Stories",
			"Hocus Focus",
			"PTV Rowdies",
			"The Hunter Games"};
			private String[] sg = {		

			"CS 1.6",
			"DOTA",
			"FIFA'11 Lan Gaming",
			"NFS Most Wanted",
			"Futsal Boys",
			"Futsal Girls",
			"Basketball",
			"Box Cricket",
			"Volleyball",
			"Throwball (Girls)",
			"Tug of War",
			"Chess",
			"Table Tennis",
			"Carrom",
			"Neo Cricket",
			"10m Air Rifle Shooting",
			"Sports Freak"};
			private String[] te = {		

			"Death race",
			"Time Chase",
			"Can You Follow Me",
			"Xtreme Fighters",
			"Machine Premier League",
			"Bhool Bhulaiyya",
			"Robo- Decathlon",
			"TPP",
			"Web Hunt",
			"Code Master",
			"Junkyard Wars",
			"Tech Roadies 2.0",
			"Mock Interviews",
			"Robo Pirates",
			"3D Modelling"};
			private String[] mgt = {		

			"Khiladi No 1",
			"Finto Parliamento",
			"Vyapaar",
			"Analyse This",
			"Share-e-Bazaar",
			"Ad-o-Mania",
			"Bazaar",
			"Jumble Gamble",
			"Hisssssss…" };
			private String[] wk = {		

			"Photography and Filmmaking",
			"Pottery on a wheel",
			"Architecture model making",
			"Warli Painting",
			"Clay modelling",
			"Waste paper modelling",
			"Dramatics",
			"Metal foil workshop",
			"Atmaraksha",
			"Wood carving",
			"Calligraphy",
			"Origamy and paper furniture making",
			"Salsa",
			"Death Race",
			"Time Chase",
			"Can You Follow Me ",
			"Robo Pirates"



};



	class OnImageClickListener implements OnClickListener {

		int _postion;

		// constructor
		public OnImageClickListener(int position) {
			this._postion = position;
		}

		@Override
		public void onClick(View v) {

			if (_category == 0) {
				Intent i = new Intent(mActivity, EventCategoryActivity.class);
				i.putExtra("position", _postion);
				mActivity.startActivity(i);
			}

			else {
				String codes[] = mActivity.getResources().getStringArray(
						codes_category[_category - 1]);

				// on selecting grid view image
				// launch full screen activity
				Intent i = new Intent(mActivity, EventActivity.class);
				i.putExtra("EventCode", codes[_postion]);

				mActivity.startActivity(i);
			}
		}

	}
}
