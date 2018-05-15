package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();

        String mainName;
        List<String> alsoKnownAs;
        String placeOfOrigin;
        String description;
        String image;
        List<String> ingredients;

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.getJSONObject("name");

            mainName = name.getString("mainName");
            placeOfOrigin = jsonObject.getString("placeOfOrigin");
            description = jsonObject.getString("description");
            image = jsonObject.getString("image");
            alsoKnownAs = getListFormJsonArray(name.getJSONArray("alsoKnownAs"));
            ingredients = getListFormJsonArray(jsonObject.getJSONArray("ingredients"));

            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }

    private static List<String> getListFormJsonArray(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<>();

        int length = jsonArray.length();
        for(int i = 0; i < length; i++){
            list.add(jsonArray.getString(i));
        }

        return list;
    }
}
