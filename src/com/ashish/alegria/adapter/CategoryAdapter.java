package com.ashish.alegria.adapter;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.ashish.alegria.EventActivity;
import com.ashish.alegria.EventCategoryActivity;
import com.ashish.alegria.GridViewActivity;
import com.ashish.alegria.helper.AppConstant;
import com.ashish.alegria.helper.Utils;
import com.ashish.alegria.R;

public class CategoryAdapter extends BaseAdapter {
	private Activity mActivity;
	int _category;
	public CategoryAdapter(Activity mActivity, int category) {
		this.mActivity = mActivity;
		this._category = category;
		switch(category) {
		case 0: mThumbIds = categories; break;
		case 1: mThumbIds = mgt; break;
		case 2: mThumbIds = pa; break;
		case 3: mThumbIds = fa; break ; 
		}
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		Resources r = mActivity.getResources();
		float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				AppConstant.GRID_PADDING, r.getDisplayMetrics());
		Utils utils = new Utils(mActivity);
		int columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) * padding)) / AppConstant.NUM_OF_COLUMNS);

		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			imageView = new ImageView(mActivity);
			imageView.setLayoutParams(new GridView.LayoutParams(columnWidth,
					columnWidth));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		} else {
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(mThumbIds[position]);
		imageView.setOnClickListener(new OnImageClickListener(position));
		return imageView;
	}

	// references to our images
	private Integer[] mThumbIds;
	private Integer[] categories = { R.drawable.g1, R.drawable.g2,
			R.drawable.g3, R.drawable.g4, R.drawable.g5, R.drawable.g6,
			R.drawable.g7, R.drawable.g8, R.drawable.g9, R.drawable.g10,
			R.drawable.g11 };
	
	private Integer[] mgt = { R.drawable.g1, R.drawable.g2,
			R.drawable.g3, R.drawable.g4, R.drawable.g5, R.drawable.g6,
			R.drawable.g7, R.drawable.g8, R.drawable.g9, R.drawable.g10,
			R.drawable.g11 };

	private Integer[] pa = {  R.drawable.g6,
			R.drawable.g7, R.drawable.g8, R.drawable.g9, R.drawable.g10,
			R.drawable.g11
			
	};
	
	private Integer[] fa = { R.drawable.g1, R.drawable.g2,
			R.drawable.g3, R.drawable.g4, R.drawable.g5,
			R.drawable.g11
			
	};
	private Integer[] codes_category = {
			R.array.codes_mgt_events, R.array.codes_pa_events, R.array.codes_fa_events
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
			
			else{
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
