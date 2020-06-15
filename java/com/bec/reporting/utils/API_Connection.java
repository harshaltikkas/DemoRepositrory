package com.bec.reporting.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import com.bec.reporting.steps.FlyInMenuBehaviourSteps;
import com.google.common.base.Verify;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class API_Connection {
	public static Properties prop;

	/*
	 * API Methods Here
	 */

	/**
	 * This method is used to get the Token value from API
	 * 
	 * @return
	 */
	public static String getToken() {
		log.info("Get Access token");
		String token = "";
		try {
			prop = FileRead.readProperties();
			String apiUrl;
			String payload = "{\n" + "  \"username\": \"" + FlyInMenuBehaviourSteps.uname + "\",\n"
					+ "  \"password\": \"" + FlyInMenuBehaviourSteps.passwd + "\",\n" + "  \"realm\": \""
					+ FlyInMenuBehaviourSteps.realm + "\"\n" + "}";

			/*
			 * String payload = "{\n" + "  \"username\": \"Failly353175\",\n" +
			 * "  \"password\": \"password\",\n" + "  \"realm\": \"sulphur\"\n" + "}";
			 */

			if (prop.getProperty("app_env").equalsIgnoreCase("staging")
					|| prop.getProperty("app_env").equalsIgnoreCase("prod")) {
				apiUrl = prop.getProperty("stg_atlantis_api_url");
			} else {
				apiUrl = prop.getProperty("atlantis_api_url");
			}
			Response response = RestAssured.given().header("Content-Type", "application/json").body(payload)
					.post(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				token = new JsonPath(response.asString()).getString("token");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		log.info("Retrived Access Token Successfully");
		return token;
	}

	/**
	 * This method is used to get District ID based on default api
	 * 
	 * @return
	 */
	public static String getUserRole() {
		String user_role = "",apiUrl="";
		try {					
			prop = FileRead.readProperties();
			if (prop.getProperty("app_env").equalsIgnoreCase("staging")
					|| prop.getProperty("app_env").equalsIgnoreCase("prod")) {
				apiUrl = prop.getProperty("stg_apiURL") + "/user/skus?values=X58691,X69071,X70225";
			} else {
				apiUrl = prop.getProperty("apiURL") + "/user/skus?values=X58691,X69071,X70225";
			}
			
			
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.contentType("application/json").get(apiUrl);

			if (response.getStatusCode() != 200) {
				log.info("Error occurred in getting User Role. status code : " + response.getStatusCode());
				return null;
			} else {
				user_role = (String) new JsonPath(response.asString()).get("role");
			}
		} catch (Exception e) {
			log.error("Unable to get logged in user role...");
			UtilityMethods.processException(e);
		}
		return user_role;
	}

	/**
	 * This method is used to get District ID based on default api
	 * 
	 * @return
	 */
	public static Integer getDistrictId() {
		Integer districtId = 0;
		try {
			prop = FileRead.readProperties();
			String payload = "{\"termId\":" + "null" + ",\"isDistrictEnabled\":" + true + "}";
			String apiUrl = prop.getProperty("apiURL") + "/universalselector/default";
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.contentType("application/json").body(payload).post(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred in getDistrictId. status code : " + response.getStatusCode());
				return null;
			} else {
				districtId = Integer.parseInt(
						(String) new JsonPath(response.asString()).getList("value.schoolList.districtId").get(0));
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return districtId;
	}

	/**
	 * This method is used to get District ID based on default api
	 * 
	 * @return
	 */
	public static List<String> getDistrictWiseLatestTermDateRangeUsingAPI(int districtId) {
		List<String> list = new ArrayList<String>();
		try {
			prop = FileRead.readProperties();
			String apiUrl = prop.getProperty("apiURL") + "/universalselector/datetab";
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.get(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				list.add(new JsonPath(response.asString()).getList("value.termStartDate").get(0).toString());
				list.add(new JsonPath(response.asString()).getList("value.termEndDate").get(0).toString());
				list.add(new JsonPath(response.asString()).getList("value.termName").get(0).toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return list;
	}

	/**
	 * This method is used to get School ID by School Name
	 * 
	 * @param schoolName
	 * @return
	 */
	public static Integer getSchoolIDBySchoolName(String schoolName) {
		Integer schoolID = 0;
		try {
			prop = FileRead.readProperties();
			String apiUrl = prop.getProperty("apiURL") + "/schools?page=0&size=10000&direction=ASC";
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.get(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				List<Object> schoolnameslist = new JsonPath(response.asString()).getList("value.name");
				List<Object> schoolidlist = new JsonPath(response.asString()).getList("value.id");
				Verify.verify(schoolnameslist.contains(schoolName));
				schoolID = Integer.parseInt(schoolidlist.get(schoolnameslist.indexOf(schoolName)).toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return schoolID;
	}

	/**
	 * This method is used to get All School
	 * 
	 * @param schoolName
	 * @return
	 */
	public static Map<String, Integer> getAllSchoolNames() {
		Map<String, Integer> schoolMap = new TreeMap<String, Integer>();
		try {
			prop = FileRead.readProperties();
			String apiUrl = prop.getProperty("apiURL") + "/schools?page=0&size=10000&direction=ASC";
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.get(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				List<Object> value = new JsonPath(response.asString()).getList("value.name");
				for (int i = 0; i < value.size(); i++) {
					schoolMap.put(String.valueOf(new JsonPath(response.asString()).getList("value.name").get(i)),
							Integer.parseInt(new JsonPath(response.asString()).getList("value.id").get(i).toString()));
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return schoolMap;
	}

	/**
	 * This method is used to get All Classes by SchoolName
	 * 
	 * @param schoolName
	 * @return
	 */
	public static Map<String, Integer> getAllClassesNamesBySchoolName(Integer schoolId) {
		Map<String, Integer> classMap = new TreeMap<String, Integer>();
		try {
			prop = FileRead.readProperties();
			String apiUrl = prop.getProperty("apiURL") + "/classes?schoolId=" + schoolId + "&districtId="
					+ getDistrictId();
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.get(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				List<Object> value = new JsonPath(response.asString()).getList("value.name");
				for (int i = 0; i < value.size(); i++) {
					classMap.put(String.valueOf(new JsonPath(response.asString()).getList("value.name").get(i)),
							Integer.parseInt(new JsonPath(response.asString()).getList("value.id").get(i).toString()));
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return classMap;
	}

	/**
	 * This method is used to return first alpha school
	 * 
	 * @return
	 */
	public static String getFirstAlphaSchoolName() {
		String schoolName = "";
		try {
			schoolName = getAllSchoolNames().keySet().stream().findFirst().get();
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return schoolName;
	}

	/**
	 * This method is used to return first alpha class based on first alpha school
	 * 
	 * @return
	 */
	public static String getFirstAlphaClassNameBySchoolName(Integer schoolId) {
		String className = "";
		try {
			className = getAllClassesNamesBySchoolName(schoolId).keySet().stream().findFirst().get();
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return className;
	}

	/**
	 * This method is used to return all the student list based on school name and
	 * class name
	 * 
	 * @param schoolName
	 * @param className
	 * @return
	 */
	public static Map<String, Integer> getAllStudentsByClassNameAndSchoolName(Integer schoolId, Integer classId) {
		Map<String, Integer> studentMap = new TreeMap<String, Integer>();
		try {
			prop = FileRead.readProperties();
			String apiUrl = prop.getProperty("apiURL") + "/students?schoolId=" + schoolId + "&districtId="
					+ getDistrictId() + "&classId=" + classId;
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.get(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				List<Object> value = new JsonPath(response.asString()).getList("value.name");
				for (int i = 0; i < value.size(); i++) {
					studentMap.put(String.valueOf(new JsonPath(response.asString()).getList("value.name").get(i)),
							Integer.parseInt(new JsonPath(response.asString()).getList("value.id").get(i).toString()));
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return studentMap;
	}

	/**
	 * This method is used to return class ID based on school name and class name
	 * 
	 * @param schoolName
	 * @param className
	 * @return
	 */
	public static Integer getClassIDBySchoolIdAndClassName(Integer schoolId, String className) {
		Integer classID = 0;
		try {
			prop = FileRead.readProperties();
			String apiUrl = prop.getProperty("apiURL") + "/classes?schoolId=" + schoolId + "&districtId="
					+ getDistrictId();
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.get(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				List<Object> classNamesList = new JsonPath(response.asString()).getList("value.name");
				List<Object> classIdList = new JsonPath(response.asString()).getList("value.id");
				Verify.verify(classNamesList.contains(className));
				classID = Integer.parseInt(classIdList.get(classNamesList.indexOf(className)).toString());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return classID;
	}

	/**
	 * This method is used to return the first alpha student based on last name
	 * 
	 * @return
	 */
	public static String getFirstAlphaLastNameStudentByAlphaClassAndSchoolName(int classId, int schoolId,
			int getDistrictId) {
		String studentName = "";
		Map<String, Integer> studentMap = new TreeMap<String, Integer>();
		try {
			prop = FileRead.readProperties();
			String apiUrl = prop.getProperty("apiURL") + "/students?schoolId=" + schoolId + "&districtId="
					+ getDistrictId + "&classId=" + classId;
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.get(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				List<Object> value = new JsonPath(response.asString()).getList("value.name");
				for (int i = 0; i < value.size(); i++) {
					studentMap.put(String.valueOf(new JsonPath(response.asString()).getList("value.name").get(i)),
							Integer.parseInt(new JsonPath(response.asString()).getList("value.id").get(i).toString()));
				}
				studentName = studentMap.keySet().stream().findFirst().get() + " " + "("
						+ studentMap.get(studentMap.keySet().toArray()[0]) + " )";
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return studentName;
	}

	/**
	 * This method is used to return the student name based on student id
	 * 
	 * @return
	 */
	public static String getStudentNameByStudentId(Integer schoolId, Integer classId, Integer studentId) {
		String studentName = "";
		try {
			prop = FileRead.readProperties();
			String apiUrl = prop.getProperty("apiURL") + "/students?schoolId=" + schoolId + "&districtId="
					+ getDistrictId() + "&classId=" + classId;
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.get(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				List<Object> studentNamesList = new JsonPath(response.asString()).getList("value.name");
				List<Object> studentIdList = new JsonPath(response.asString()).getList("value.id");
				Verify.verify(studentIdList.contains(String.valueOf(studentId)));
				studentName = studentNamesList.get(studentIdList.indexOf(String.valueOf(studentId))).toString();
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return studentName;
	}

	/**
	 * This method is used to get Standards Information's short value using api
	 * 
	 * @return
	 */
	public static Map<String, String> getStandardsInfo_Short_Value_UsingAPI(String ids[], Float score[],
			Float max_score[], String questions[]) {

		Map<String, String> bigMap = new LinkedHashMap<String, String>();

		try {
			prop = FileRead.readProperties();
			String stndrd_id = "";
			List<String> temp_list = new ArrayList<String>();

			for (int i = 0; i < ids.length; i++) {
				stndrd_id += "\"" + ids[i] + "\",";
			}
			stndrd_id = stndrd_id.substring(0, stndrd_id.length() - 1);
			String payload = "{\n \"ids\":[ " + stndrd_id + "]}";
			String apiUrl = prop.getProperty("apollo_api_URL") + "/tags/ids";
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.contentType("application/json").body(payload).post(apiUrl);

			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				temp_list = (new JsonPath(response.asString()).get("shortvalue"));

				if (temp_list.contains("DOK 3") && temp_list.contains("DOK 2")) {
					Collections.swap(temp_list, temp_list.indexOf("DOK 3"), temp_list.indexOf("DOK 2"));
				}

				if (temp_list.contains("Listen to a Story")
						&& temp_list.contains("Listen to a Classroom Conversation")) {
					temp_list.remove("Listen to a Classroom Conversation");
					temp_list.add(temp_list.indexOf("Listen to a Story"), "Listen to a Classroom Conversation");
				}

				for (int i = 0; i < temp_list.size(); i++) {
					questions[i] = questions[i].replace(" ", "\n");
					bigMap.put(temp_list.get(i) + "_" + Math.round((score[i] / max_score[i]) * 100), questions[i]);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			UtilityMethods.processException(e);
		}
		return bigMap;
	}

	/**
	 * This method is used to get View Details
	 * 
	 * @return
	 */
	public static Map<Integer, String> getViewDetails() {
		Map<Integer, String> map = new Hashtable<Integer, String>();
		try {
			prop = FileRead.readProperties();
			String apiUrl = prop.getProperty("apollo_api_URL") + "/standards/metadata";
			Response response = RestAssured.given().header("Authorization", "Bearer " + FlyInMenuBehaviourSteps.token)
					.get(apiUrl);
			if (response.getStatusCode() != 200) {
				log.info("Error occurred. status code : " + response.getStatusCode());
				return null;
			} else {
				int length = new JsonPath(response.asString()).getList("setid").size();
				for (int i = 0; i < length; i++) {
					map.put(Integer.parseInt(new JsonPath(response.asString()).getList("setid").get(i).toString()),
							new JsonPath(response.asString()).getList("setname").get(i).toString());
				}
			}
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		return map;
	}

	public static void main(String args[]) {
		getViewDetails();
	}
}
