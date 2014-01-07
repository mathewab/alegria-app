package com.ashish.alegria.helper;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
 
public class Utils {
 
    private Context _context;
    private String base_path = "http://www.alegria.mes.ac.in/gallery/images/";
 
    // constructor
    public Utils(Context context) {
        this._context = context;
    }
    
    // Reading file paths from SDCard
    public ArrayList<String> getFilePaths(String contextPath) {
        ArrayList<String> filePaths = new ArrayList<String>();
 
/*        File directory = new File(
                android.os.Environment.getExternalStorageDirectory()
                        + File.separator + AppConstant.PHOTO_ALBUM);
 
        // check for directory
        if (directory.isDirectory()) {
            // getting list of file paths
            File[] listFiles = directory.listFiles();
 
            // Check for count
            if (listFiles.length > 0) {
 
                // loop through all files
                for (int i = 0; i < listFiles.length; i++) {
 
                    // get file path
                    String filePath = listFiles[i].getAbsolutePath();
 
                    // check for supported file extension
                    if (IsSupportedFile(filePath)) {
                        // Add image path to array list
                        filePaths.add(filePath);
                    }
                }
            } else {
                // image directory is empty
                Toast.makeText(
                        _context,
                        AppConstant.PHOTO_ALBUM
                                + " is empty. Please load some images in it !",
                        Toast.LENGTH_LONG).show();
            }
 
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(_context);
            alert.setTitle("Error!");
            alert.setMessage(AppConstant.PHOTO_ALBUM
                    + " directory path is not valid! Please set the image directory name AppConstant.java class");
            alert.setPositiveButton("OK", null);
            alert.show();
        }
        
 */
        for(int i =1; i<=15; i++) {
        	filePaths.add(base_path+contextPath+"/"+i+".jpg");
        }


        return filePaths;
    }
    public static void CopyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
              int count=is.read(bytes, 0, buffer_size);
              if(count==-1)
                  break;
              os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }
    // Check supported file extensions
    private boolean IsSupportedFile(String filePath) {
        String ext = filePath.substring((filePath.lastIndexOf(".") + 1),
                filePath.length());
 
        if (AppConstant.FILE_EXTN
                .contains(ext.toLowerCase(Locale.getDefault())))
            return true;
        else
            return false;
 
    }
 
    /*
     * getting screen width
     */
    public int getScreenWidth() {
        int columnWidth;
        WindowManager wm = (WindowManager) _context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
 
        final Point point = new Point();
        try {
            display.getSize(point);
        } catch (java.lang.NoSuchMethodError ignore) { // Older device
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        columnWidth = point.x;
        return columnWidth;
    }
}
