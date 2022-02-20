package me.henry.bookcalculator;

import me.henry.bookcalculator.generator.Generator;
import me.henry.bookcalculator.item.Item;
import me.henry.bookcalculator.item.ItemHandler;
import me.henry.bookcalculator.timetable.Day;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static Integer weekNumber = 2;

    public static void main(String[] args) {
        ItemHandler.loadItems();
        Generator.generateDayItems();
    }
}
