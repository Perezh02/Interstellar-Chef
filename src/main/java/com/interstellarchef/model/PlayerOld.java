package com.interstellarchef.model;

public class PlayerOld {
    private Item equippedItem;
    private LocationOld inventory;

    public PlayerOld(LocationOld inventory) {
        this.inventory = inventory;

    }

    public PlayerOld(LocationOld inventory, Item equippedItem) {
        this.inventory = inventory;
        this.equippedItem = equippedItem;
    }

    public LocationOld getInventory() {
        return inventory;
    }

    public void setInventory(LocationOld inventory) {
        this.inventory = inventory;
    }

    public Item getEquippedItem() {
        return equippedItem;
    }

    public void setEquippedItem(Item equippedItem) {
        this.equippedItem = equippedItem;
    }

    public String equipItem(String itemName) {
        String result = "";
        Item previouslyEquippedItem = null;
        for (Item item : inventory.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                if (equippedItem != null) {
                    previouslyEquippedItem = equippedItem;
                }
                if (item.getActionResponse().containsKey("equip")) {
                    this.equippedItem = item;
                    System.out.println(item.getActionResponse().get("equip"));
                    result = item.getName();
                    break;
                }
            }
        }
        if (!result.equalsIgnoreCase("")) {
            inventory.removeItem(equippedItem);
        }
        if (previouslyEquippedItem != null) {
            inventory.addItem(previouslyEquippedItem);
        }

        return result;
    }

    public String printEquippedItem() {
        if (equippedItem == null) {
            return "none";
        } else {
            return equippedItem.getName();
        }
    }

}
