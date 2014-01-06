package com.ashish.gallery.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.ashish.alegria3.R;
import com.ashish.alegria3.gallery.helper.AppConstant;
import com.ashish.alegria3.gallery.helper.Utils;

public class SponsorAdapter extends BaseAdapter {
	private Activity mActivity;

	public SponsorAdapter(Activity mActivity) {
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
		imageView.setBackgroundResource(R.drawable.button_shape);
		imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}

	// references to our images
	private Integer[] mThumbIds = { R.drawable.sponsor0, R.drawable.sponsor1,
			R.drawable.sponsor2, R.drawable.sponsor3, R.drawable.sponsor4, R.drawable.sponsor5,
			R.drawable.sponsor6, R.drawable.sponsor7, R.drawable.sponsor8, R.drawable.sponsor9,
			R.drawable.sponsor10, R.drawable.sponsor12 };


	
}
