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
 * JAN 03 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileRead {

	static Properties properties= new Properties();
	
	public static FileInputStream readFile(String file) throws FileNotFoundException {
		return new FileInputStream(new File(file));
	}
	
	/**
	 * This is used to read content from configuration.properties file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Properties readProperties() throws FileNotFoundException, IOException {
		
		properties.load(readFile("src/main/resources/configuration.properties"));
		return properties;
	}

	/**
	 * This will return Report configuration template file path
	 * @return
	 */
	public static String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
