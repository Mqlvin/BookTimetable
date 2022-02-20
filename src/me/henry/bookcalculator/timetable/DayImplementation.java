package me.henry.bookcalculator.timetable;

import me.henry.bookcalculator.item.ItemType;

import java.util.ArrayList;

public interface DayImplementation {
    public void setDayItems(ArrayList<ItemType> types);
    public ArrayList<ItemType> getDayItems();

    public void generateDayItems();
}
