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

import com.ashish.alegria.GridViewActivity;
import com.ashish.alegria.helper.AppConstant;
import com.ashish.alegria.helper.Utils;
import com.ashish.alegria.R;

public class ImageAdapter extends BaseAdapter {
	private Activity mActivity;

	public ImageAdapter(Activity mActivity) {
		this.mActivity = mActivity;
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
	private Integer[] mThumbIds = { R.drawable.g1, R.drawable.g2,
			R.drawable.g3, R.drawable.g4, R.drawable.g5, R.drawable.g6,
			R.drawable.g7, R.drawable.g8, R.drawable.g9, R.drawable.g10,
			R.drawable.g11 };

	class OnImageClickListener implements OnClickListener {

		int _postion;

		// constructor
		public OnImageClickListener(int position) {
			this._postion = position;
		}

		@Override
		public void onClick(View v) {

			String titles[] = mActivity.getResources().getStringArray(
					R.array.titles_gallery);
			String links[] = mActivity.getResources().getStringArray(
					R.array.links_gallery);

			// on selecting grid view image
			// launch full screen activity
			Intent i = new Intent(mActivity, GridViewActivity.class);
			i.putExtra("Title", titles[_postion]);
			i.putExtra("Link", links[_postion]);

			mActivity.startActivity(i);
		}

	}
}
