package com.ashish.alegria3.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

import com.ashish.alegria3.Event;

public abstract class BaseFeedParser implements FeedParser {

    // names of the XML tags
    protected static final String EVENT_DATE = "date";
    protected static final  String RULE = "rule";
    protected static final  String RATE = "rule";
    protected static final  String EVENT_TIME = "time";
    protected static final  String EVENT_DURATION = "duration";
    protected static final  String TITLE = "title";
    protected static final  String EVENT = "event";
    
    public URL feedUrl;
    public Activity mAcivity;

    protected BaseFeedParser(String feedUrl){
        try {
            this.feedUrl = new URL(feedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    protected BaseFeedParser(Activity mActivity){
        this.mAcivity = mActivity;
    }

    protected InputStream getInputStream() {
        try {
            return feedUrl.openConnection().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*
     * To get the XML from a local file in assets
     */
    protected InputStream getInputStream(String XML_name) {
    	AssetManager assetManager = mAcivity.getAssets();
        try {
            return assetManager.open(XML_name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

interface FeedParser {
    List<Event> parse();
}