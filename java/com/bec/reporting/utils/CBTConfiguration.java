/*
 * Copyright Benchmark Education Company
 *
 * (C) Copyright BEC - All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant here to is,
 *          and remains, the property of Benchmark.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Benchmark. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Benchmark.
 *
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 * Revision History
 * ========================================================================
 * DATE				: PROGRAMMER  : DESCRIPTION
 * ========================================================================
 * JAN 25 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.utils;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CBTConfiguration {
	public static String score = null;
	public static String sessionId=null;
	private String username,authkey;
	private String apiUrl = "crossbrowsertesting.com/api/v3/selenium";
	
	/**
	 * This method will convert @ symbol to %40 which is used in making hub url
	 * @param username
	 * @param authkey
	 */
	public CBTConfiguration(String username, String authkey) {
		// for java URL's must be character encoded. If you use 
		// your email, let's replace that character

		if (username.contains("@")) {
			username = username.replace("@", "%40");
		} 
		this.username = username;
		this.authkey = authkey;
	}
	
	/**
	 * This method is used to set score value as pass or fail 
	 * @param score
	 */
	public void setScore(String score) {
		String url = "https://" + apiUrl + "/" + CBTConfiguration.sessionId;
		String payload = "{\"action\": \"set_score\", \"score\": \"" + score + "\"}";
		makeRequest("PUT", url,payload);
	}
	
	/**
	 *This method is used to take snapshot while executing scenario on CBT 
	 */
	public void takeSnapshot() {
		if (CBTConfiguration.sessionId != null) {
			String url = "https://" + apiUrl + "/" + CBTConfiguration.sessionId + "/snapshots";
			String payload = "{\"selenium_test_id\": \"" + CBTConfiguration.sessionId + "\"}";
			makeRequest("POST",url,payload);
		}
	}
	
	/**
	 * This method used to set Description on CBT
	 * @param desc
	 */
	public void setDescription(String desc) {
		String url = "https://" + apiUrl + "/" + CBTConfiguration.sessionId;
		String payload = "{\"action\": \"set_description\", \"description\": \"" + desc + "\"}";
		makeRequest("PUT", url,payload);
	}
	
	/**
	 * This method is used to make request using api url, payload and request method
	 * @param requestMethod
	 * @param apiUrl
	 * @param payload
	 */
	private void makeRequest(String requestMethod, String apiUrl, String payload) {
		URL url;
		String auth = "";

        if (username != null && authkey != null) {
            auth = "Basic " + Base64.encodeBase64String((username+":" + authkey).getBytes());
        }
        try {
            url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", auth);
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
            osw.write(payload);
            osw.flush();
            osw.close();
            conn.getResponseMessage();
        } catch (Exception e) {
        	log.error(e.getMessage());
        }
	}
	
	/**
	 * This method is used to create Url using username and authkey of CBT
	 * @return url
	 */
	public URL getHubUrl() {
		URL hubUrl = null;
		try {
			hubUrl = new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub");
		} catch (MalformedURLException e) {
			log.error("Invalid HUB URL");
		}
		return hubUrl;
	}
}
