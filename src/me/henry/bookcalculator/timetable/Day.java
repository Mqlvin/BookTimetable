package me.henry.bookcalculator.timetable;

import com.google.gson.Gson;
import me.henry.bookcalculator.item.ItemType;

import java.util.ArrayList;

public class Day implements DayImplementation {
    public static ArrayList<ItemType> dayTypes = new ArrayList<>();

    @Override
    public void setDayItems(ArrayList<ItemType> types) {
        dayTypes = types;
    }

    @Override
    public ArrayList<ItemType> getDayItems() {
        return dayTypes;
    }

    @Override
    public void generateDayItems() {
        ArrayList<String> lessons = Timetable.readTimetable();
        if(lessons == null) {
            System.out.println("Day does not exist.");
            System.exit(-1);
        }
        for(String lesson : lessons) {
            try {
                dayTypes.add(ItemType.valueOf(lesson.toUpperCase()));
            } catch(IllegalArgumentException e) {
                System.out.println("Unknown subject: " + lesson);
            }
        }
    }
}
