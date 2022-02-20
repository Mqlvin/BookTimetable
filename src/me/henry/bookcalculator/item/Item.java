package me.henry.bookcalculator.item;

public class Item implements ItemImplementation {
    private String name = "";
    private ItemType type = ItemType.UNKNOWN;

    public Item(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public String getName() {
        if(this.name != null) {
            return this.name;
        }
        return null;
    }

    @Override
    public ItemType getType() {
        if(this.type != null) {
            return this.type;
        }
        return null;
    }
}
