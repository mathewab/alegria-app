package com.ashish.gallery.fragment;

import com.ashish.alegria3.FullScreenViewActivity;
import com.ashish.alegria3.GridViewActivity;
import com.ashish.alegria3.R;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

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
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			imageView = new ImageView(mActivity);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(mThumbIds[position]);
        imageView.setOnClickListener(new OnImageClickListener(position));
		return imageView;
	}

	// references to our images
	private Integer[] mThumbIds = { R.drawable.alegria_logo,
			R.drawable.g1, R.drawable.g2,
			R.drawable.g3, R.drawable.g4,
			R.drawable.g5, R.drawable.g6,
			R.drawable.g7, R.drawable.g8,
			R.drawable.g9,R.drawable.g10,
			R.drawable.g11, R.drawable.g12,
			R.drawable.g13
			};
	
    class OnImageClickListener implements OnClickListener {
    	 
        int _postion;
 
        // constructor
        public OnImageClickListener(int position) {
            this._postion = position;
        }
 
        @Override
        public void onClick(View v) {
            // on selecting grid view image
            // launch full screen activity
        	
            Intent i = new Intent(mActivity, GridViewActivity.class);
         i.putExtra("position", _postion);
           mActivity.startActivity(i);        
           }
 
    }
}
