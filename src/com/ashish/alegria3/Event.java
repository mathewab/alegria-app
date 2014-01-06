package com.ashish.alegria3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event implements Comparable<Event>{

	private String eventId;
	private String eventDate;
	private String time;
	private String	rate;
	private String duration;
	private String rules;
	private String eventHead;
	private String title;
	private String desc;
	private String venue;
	private String headcontact;
	
	static SimpleDateFormat FORMATTER = 
	        new SimpleDateFormat("dd-MM-yyyy");
	static SimpleDateFormat TIMEFORMATTER = 
	        new SimpleDateFormat("HH:mm");
	
	
	
	public Event() {
		super();
		rules = "Information not availaible";
		eventId = "Information not availaible";
		eventDate = "Information not availaible";
		time = "Information not availaible";
		rate = "Information not availaible";
		duration = "Information not availaible";
		eventHead  = "Information not availaible";
		title = "Information not availaible";
		desc = "Information not availaible";

	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getHeadcontact() {
		return headcontact;
	}

	public void setHeadcontact(String headcontact) {
		this.headcontact = headcontact;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getEventId() {
		return eventId;
	}


	public void setEventId(String eventId) {
		this.eventId = eventId;
	}


	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getRules() {
		return rules;
	}


	public void setRules(String rules) {
		this.rules = rules;
	}


	public String getEventHead() {
		return eventHead;
	}


	public void setEventHead(String eventHead) {
		this.eventHead = eventHead;
	}


	@Override
	public int compareTo(Event arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
