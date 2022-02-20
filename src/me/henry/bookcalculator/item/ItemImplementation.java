package me.henry.bookcalculator.item;

public interface ItemImplementation {
    public void setName(String name);
    public void setType(ItemType type);

    public String getName();
    public ItemType getType();
}
