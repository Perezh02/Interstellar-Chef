package com.interstellarchef.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    public static final LocationOld EMPTY_INVENTORY = new LocationOld(
            "Empty Inventory",
            "This is an empty inventory",
            new HashMap<>(),
            new LinkedList<>(),
            new Character[0]
    );

    public static final LocationOld NEW_INVENTORY = new LocationOld(
            "New Inventory",
            "This is the new inventory",
            new HashMap<>(),
            new LinkedList<>(),
            new Character[0]
    );
    public static final HashMap<String, String> ACTION_RESPONSE = new HashMap<>() {{
        put("get", "You put the object in your inventory.");
    }};

    public static final Item INITIAL_EQUIPPED_ITEM = new Item(
            "Suit",
            "A nice suit, might make you look dapper!",
            ACTION_RESPONSE
    );

    public static final Item NEW_ITEM = new Item(
            "Tortillas",
            "A pack of delicious tortillas for us to eat.",
            ACTION_RESPONSE
    );

    PlayerOld player;
    LocationOld inventory;
    List<Item> items;

    Item item;

    @BeforeEach
    public void initEach() {
        items = new LinkedList<>();
        inventory = EMPTY_INVENTORY;
        item = INITIAL_EQUIPPED_ITEM;
        player = new PlayerOld(inventory, item);
    }

    @Test
    void getInventory_ReturnsPlayerInventory() {
        assertEquals(player.getInventory(), EMPTY_INVENTORY);
    }

    @Test
    void setInventory_SetsPlayerInventory() {
        player.setInventory(NEW_INVENTORY);
        assertEquals(player.getInventory(), NEW_INVENTORY);
    }

    @Test
    void getEquippedItem_ReturnsEquippedItem() {
        assertEquals(player.getEquippedItem(), INITIAL_EQUIPPED_ITEM);
    }

    @Test
    void setEquippedItem_SetsPlayerEquippedItem() {
        player.setEquippedItem(NEW_ITEM);
        assertEquals(player.getEquippedItem(), NEW_ITEM);
    }

    @Test
    void printEquippedItem_PrintsEquippedItemIfItemEquipped() {
        assertEquals(player.printEquippedItem(), INITIAL_EQUIPPED_ITEM.getName());
    }
}
