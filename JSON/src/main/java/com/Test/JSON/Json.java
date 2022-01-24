package com.Test.JSON;

import org.json.JSONArray;
import org.json.JSONObject;

public class Json {
	public static void main(String[] args) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("부산", "21도");
		jsonObj.put("서울", "25도");
		jsonObj.put("제주", "23도");
		System.out.println(jsonObj);
		
		JSONObject jObj = new JSONObject();//JSON객체 생성
		JSONArray jArr = new JSONArray();//JSON배열 생성
		jObj.put("language", jArr); //객체에 배열 추가
		
		JSONObject temp = new JSONObject();//JSON객체1 생성
		temp.put("name", "HTML");
		temp.put("category", "web");
		temp.put("developer", "W3C");
		jArr.put(temp); //배열에 JSON객체1 추가
		
		JSONObject temp1 = new JSONObject();//JSON객체2 생성
		temp1.put("name", "CSS");
		temp1.put("category", "web");
		temp1.put("developer", "W3C");
		jArr.put(temp1); //배열에 JSON객체2 추가
		
		JSONObject temp2 = new JSONObject();//JSON객체3 생성
		temp2.put("name", "Java");
		temp2.put("category", "applicaation");
		temp2.put("developer", "Oracle");
		jArr.put(temp2); //배열에 JSON객체3 추가
		
		JSONObject temp3 = new JSONObject();//JSON객체3 생성
		temp3.put("name", "Python");
		temp3.put("category", "applicaation");
		temp3.put("developer", "Python");
		jArr.put(temp3); //배열에 JSON객체4 추가
		
		System.out.println(jObj);
	}
}
