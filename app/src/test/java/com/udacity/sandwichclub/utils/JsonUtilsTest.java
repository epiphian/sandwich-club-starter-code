package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class JsonUtilsTest {

    @Test
    public void parseNotFullSandwichJson(){
        //Prepare
        String noPlaceOfOriginSandwichJson = "{" +
                "\"name\":{\"mainName\":\"Ham and cheese sandwich\",\"alsoKnownAs\":[]}," +
                "\"placeOfOrigin\":\"\"," +
                "\"description\":\"A ham and cheese sandwich is a common type of sandwich. " +
                "It is made by putting cheese and sliced ham between two slices of bread. " +
                "The bread is sometimes buttered and/or toasted. " +
                "Vegetables like lettuce, tomato, onion or pickle slices can also be included. " +
                "Various kinds of mustard and mayonnaise are also common.\"," +
                "\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\"," +
                "\"ingredients\":[\"Sliced bread\",\"Cheese\",\"Ham\"]}";

        String mainName = "Ham and cheese sandwich";
        String description = "A ham and cheese sandwich is a common type of sandwich. " +
                "It is made by putting cheese and sliced ham between two slices of bread. " +
                "The bread is sometimes buttered and/or toasted. " +
                "Vegetables like lettuce, tomato, onion or pickle slices can also be included. " +
                "Various kinds of mustard and mayonnaise are also common.";
        String image = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG";
        List<String> ingredients = Arrays.asList("Sliced bread", "Cheese", "Ham");
        String placeOfOrigin = "";
        List<String> alsoKnownAs = new ArrayList<>();

        //Act
        Sandwich sandwich = JsonUtils.parseSandwichJson(noPlaceOfOriginSandwichJson);

        //Assert
        assertEquals("wrong main name", mainName, sandwich.getMainName());
        assertEquals("wrong also known as", alsoKnownAs, sandwich.getAlsoKnownAs());
        assertEquals("wrong description", description, sandwich.getDescription());
        assertEquals("wrong image string", image, sandwich.getImage());
        assertEquals("wrong place of origin", placeOfOrigin, sandwich.getPlaceOfOrigin());
        assertEquals("wrong ingredients", ingredients, sandwich.getIngredients());

    }

    @Test
    public void parseFullSandwichJson(){
        String fullySpecifiedSandwichJson = "{" +
                "\"name\":{\"mainName\":\"Club sandwich\",\"alsoKnownAs\":[\"Steamed bao\",\"Pork belly bun\"]}," +
                "\"placeOfOrigin\":\"United States\"," +
                "\"description\":\"A club sandwich, also called a clubhouse sandwich, is a sandwich " +
                "of bread (occasionally toasted), sliced cooked poultry, fried bacon, lettuce, tomato, " +
                "and mayonnaise. It is often cut into quarters or halves and held together by cocktail " +
                "sticks. Modern versions frequently have two layers which are separated by " +
                "an additional slice of bread.\"," +
                "\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Club_sandwich.png/800px-Club_sandwich.png\"," +
                "\"ingredients\":[\"Toasted bread\",\"Turkey or chicken\",\"Bacon\",\"Lettuce\"," +
                "\"Tomato\",\"Mayonnaise\"]}";

        String placeOfOrigin = "United States";
        List<String> alsoKnownAs = Arrays.asList("Steamed bao", "Pork belly bun");

        Sandwich sandwich = JsonUtils.parseSandwichJson(fullySpecifiedSandwichJson);

        assertEquals("wrong place of origin", placeOfOrigin, sandwich.getPlaceOfOrigin());
        assertEquals("wrong also known as", alsoKnownAs, sandwich.getAlsoKnownAs());
    }


}