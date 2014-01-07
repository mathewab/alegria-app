package com.ashish.alegria;

import com.ashish.alegria.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;




/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class Home extends Activity  {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		

        setContentView(R.layout.activity_home);

        final View contentView = findViewById(R.id.imgLogo);

        // Set up the user interaction to manually show or hide the system UI.
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	Intent i = new Intent("com.ashish.alegria3.ALEGRIABODY");
				startActivity(i);
            }
        });



    }

    


    

    
}
