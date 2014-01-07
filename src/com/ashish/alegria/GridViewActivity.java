package com.ashish.alegria;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.TextView;

import com.ashish.alegria.adapter.gallery.GridViewImageAdapter;
import com.ashish.alegria.helper.AppConstant;
import com.ashish.alegria.helper.Utils;
import com.ashish.alegria.R;
 
public class GridViewActivity extends Activity {
 
    private Utils utils;
    private ArrayList<String> imagePaths = new ArrayList<String>();
    private GridViewImageAdapter adapter;
    private GridView gridView;
    private int columnWidth;
    private String path;
 
    public String getPath() {
		return path;
	}

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_grid_view);
 
        gridView = (GridView) findViewById(R.id.grid_view);
 
        utils = new Utils(this);
 
        // Initilizing Grid View
        InitilizeGridLayout();
        
        
        String title = "";
		Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString("Title");
            path = extras.getString("Link");
        }
        
        // loading all image paths from internet
        imagePaths = utils.getFilePaths(path);

        
        TextView tv_title = (TextView) findViewById(R.id.tv_title_event_gv);
        
        tv_title.setText(title);
        
        // Gridview adapter
        adapter = new GridViewImageAdapter(GridViewActivity.this, imagePaths, path,
                columnWidth);
 
        // setting grid view adapter
        gridView.setAdapter(adapter);
    }
 
    private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                AppConstant.GRID_PADDING, r.getDisplayMetrics());
 
        columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) * padding)) / AppConstant.NUM_OF_COLUMNS);
 
        gridView.setNumColumns(AppConstant.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding,
                (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }
 
}