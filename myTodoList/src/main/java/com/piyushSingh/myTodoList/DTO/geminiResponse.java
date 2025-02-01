package com.piyushSingh.myTodoList.DTO;

import org.springframework.stereotype.Component;
import org.json.JSONArray;
import org.json.JSONObject;

@Component
public class geminiResponse {
    public static String input(String inputText) {
        JSONObject json = new JSONObject();
        JSONArray contentsArray = new JSONArray();
        JSONObject contentObject = new JSONObject();
        JSONArray partsArray = new JSONArray();
        JSONObject partObject = new JSONObject();

        partObject.put("text", inputText);
        partsArray.put(partObject);
        contentObject.put("parts", partsArray);
        contentsArray.put(contentObject);
        json.put("contents", contentsArray);

        return json.toString(2);
    }

    public static String extract(JSONObject jsonInput) {
        JSONArray candidates = jsonInput.getJSONArray("candidates");
        JSONObject firstCandidate = candidates.getJSONObject(0);
        JSONObject content = firstCandidate.getJSONObject("content");
        JSONArray parts = content.getJSONArray("parts");

        return parts.getJSONObject(0).getString("text");
    }
}