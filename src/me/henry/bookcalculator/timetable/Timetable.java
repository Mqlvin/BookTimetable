package me.henry.bookcalculator.timetable;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import me.henry.bookcalculator.Main;
import me.henry.bookcalculator.io.Reader;

import java.io.File;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Timetable {
    public static ArrayList<String> readTimetable() {
        File timetableLoc = new File("./timetable.json");
        JsonObject obj = new JsonObject();
        if(timetableLoc.exists()) {
            obj = new JsonParser().parse(Reader.readJson(new File("./timetable.json"))).getAsJsonObject();
        } else {
            System.out.println("File not found: timetable.json");
            System.out.println("Exiting!");
            System.exit(-1);
        }

        return new Gson().fromJson(obj.getAsJsonArray(new SimpleDateFormat("EEEE").format(new Date()).substring(0, 3).toLowerCase() + Main.weekNumber), new TypeToken<ArrayList<String>>(){}.getType());

        /*
        Mon
        Tue
        Wed
        Thu
        Fri
        Sat
        Sun
         */
    }
}
