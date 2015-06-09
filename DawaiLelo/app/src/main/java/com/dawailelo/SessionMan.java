package com.dawailelo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SessionMan {

//	private String sessionId;
//	private String username;
//	private String userid;
//	private String userimage;

	private static final String TAG = "SessionMan";
	
	// KEYS
	private static final String SESSIONID = "SESSIONID";
	private static final String USERNAME = "USERNAME";
	private static final String USERID = "USERID";
	private static final String USERIMAGE = "USERIMAGE";

	private static Context context;

	// PREFS
	private static final String PREFS = "USERPREFS";
	SharedPreferences sp;
	Editor e;

	public SessionMan(Context context) {
		super();
		this.context = context;
		sp = context.getSharedPreferences(PREFS, 0);
		e = sp.edit();

//		//SESSIONID
//		if (sp.contains(SESSIONID)) {
//			sessionId = sp.getString(SESSIONID, getDEFAULTSESSIONID());
//		} else {
//			sessionId = getDEFAULTSESSIONID();
//		}
//
//		//USERNAME
//		if (sp.contains(USERNAME)) {
//			username = sp.getString(USERNAME, getDEFAULTUSERNAME());
//		} else {
//			username = getDEFAULTUSERNAME();
//		}
//		
//		//USERID
//		if (sp.contains(USERID)) {
//			userid = sp.getString(USERID, getDEFAULTUSERID());
//		} else {
//			userid = getDEFAULTUSERID();
//		}
//		
//		//USERIMAGE
//		if (sp.contains(USERIMAGE)) {
//			userimage = sp.getString(USERIMAGE, getDEFAULTUSERIMAGE());
//		} else {
//			userimage = getDEFAULTUSERIMAGE();
//		}
		
//		sessionId = sp.getString(SESSIONID, getDEFAULTSESSIONID());
//		username = sp.getString(USERNAME, getDEFAULTUSERNAME());
//		userid = sp.getString(USERID, getDEFAULTUSERID());
//		userimage = sp.getString(USERIMAGE, getDEFAULTUSERIMAGE());

	}

	public String getSessionId() {
		//SESSIONID
		if (sp.contains(SESSIONID)) {
			return sp.getString(SESSIONID, getDEFAULTSESSIONID());
		} else {
			return getDEFAULTSESSIONID();
		}
	}

	public String getUsername() {
		//USERNAME
		if (sp.contains(USERNAME)) {
			return sp.getString(USERNAME, getDEFAULTUSERNAME());
		} else {
			return getDEFAULTUSERNAME();
		}
	}

	public String getUserid() {
		//USERID
		if (sp.contains(USERID)) {
			return sp.getString(USERID, getDEFAULTUSERID());
		} else {
			return getDEFAULTUSERID();
		}
	}

	public String getUserimage() {		
		//USERIMAGE
		if (sp.contains(USERIMAGE)) {
			return sp.getString(USERIMAGE, getDEFAULTUSERIMAGE());
		} else {
			return getDEFAULTUSERIMAGE();
		}
	}

	public void setSessionId(String sessionId) {
//		this.sessionId = sessionId;
		e.putString(SESSIONID, sessionId);
		e.commit();
	}

	public void setUsername(String username) {
//		this.username = username;
		e.putString(USERNAME, username);
		e.commit();
	}

	public void setUserid(String userid) {
//		this.userid = userid;
		e.putString(USERID, userid);
		e.commit();
	}

	public void setUserimage(String userimage) {
//		this.userimage = userimage;
		e.putString(USERIMAGE, userimage);
		e.commit();
	}

	public static String getDEFAULTSESSIONID() {
		return context.getResources().getString(R.string.default_sessionid);
	}

	public static String getDEFAULTUSERNAME() {
		return context.getResources().getString(R.string.default_username);
	}

	public static String getDEFAULTUSERID() {
		return context.getResources().getString(R.string.default_userid);
	}

	public static String getDEFAULTUSERIMAGE() {
		return context.getResources().getString(R.string.default_image);
	}
	
	public void closeTheSession()
	{
		e.remove(SESSIONID);
		e.remove(USERID);
		e.remove(USERIMAGE);
		e.remove(USERNAME);
		e.commit();
	}
	
	public boolean isSessionAlive()
	{
		if(sp.getAll().size()==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
