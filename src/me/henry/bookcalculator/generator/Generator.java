package me.henry.bookcalculator.generator;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import me.henry.bookcalculator.Main;
import me.henry.bookcalculator.item.Item;
import me.henry.bookcalculator.item.ItemHandler;
import me.henry.bookcalculator.item.ItemType;
import me.henry.bookcalculator.json.PropertyHandler;
import me.henry.bookcalculator.timetable.Day;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Generator {
    public static void generateDayItems() {
        JsonObject obj = new JsonObject();

        Day day = new Day();
        day.generateDayItems();

        for(Item item : ItemHandler.items) {
            if(Day.dayTypes.contains(item.getType())) {
                JsonArray arr = new JsonArray();
                if(obj.has(item.getType().toString())) {
                    arr = obj.getAsJsonArray(item.getType().toString());
                    obj.remove(item.getType().toString());
                }
                arr.add(item.getName());
                obj.add(item.getType().toString(), arr);
            }
        }

        System.out.println("=-=-= You will need: =-=-=");
        for(String property : PropertyHandler.getAllProperties(obj)) {
            System.out.println("=-=-= " + property + " =-=-=");
            ArrayList<String> itemsNeeded = new Gson().fromJson(obj.getAsJsonArray(property), new TypeToken<ArrayList<String>>(){}.getType());
            for(String item : itemsNeeded) {
                System.out.println(" -> " + item);
            }
            System.out.println("");
        }
    }
}
