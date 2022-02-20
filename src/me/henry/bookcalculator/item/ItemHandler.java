package me.henry.bookcalculator.item;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.henry.bookcalculator.io.Reader;
import me.henry.bookcalculator.io.Writers;
import me.henry.bookcalculator.json.PropertyHandler;

import java.io.File;
import java.util.ArrayList;

public class ItemHandler {
    public static ArrayList<Item> items = new ArrayList<>();

    public static void loadItems() {
        File itemLoc = new File("./items.json");
        if(itemLoc.exists()) {
            JsonObject obj = new JsonParser().parse(Reader.readJson(itemLoc)).getAsJsonObject();
            for(String item : PropertyHandler.getAllProperties(obj)) {
                items.add(new Item(item, ItemType.valueOf(obj.get(item).toString().replace("\"", ""))));
            }
        } else {
            System.out.println("File not found: items.json");
        }
    }

    public static void saveItems() {
        JsonObject obj = new JsonObject();

        for(Item item : items) {
            obj.add(item.getName(), new JsonParser().parse(item.getType().toString()));
        }

        Writers.writeFile(new File("./items.json"), obj.toString());
    }
}
