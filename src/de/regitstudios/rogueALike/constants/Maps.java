package de.regitstudios.rogueALike.constants;

import de.regitstudios.rogueALike.objects.Map;
import de.regitstudios.rogueALike.objects.item.Item;
import de.regitstudios.rogueALike.objects.item.items.*;

import java.util.ArrayList;
import java.util.Arrays;

public interface Maps {

    //Items for Maps
    ArrayList<Item> ITEMS_START_MAP = new ArrayList<Item>(Arrays.asList(
            new DoorItem(10, 11),
            new KeyItem(2, 3),
            new ChestItem(0, 0, new RedGemItem(), true),
            new ChestItem(1, 0, new KeyItem(), true),
            new ChestItem(2, 0, new BombItem(), true),
            new BootItem(22, 23),
            new GreenGemItem(5, 5),
            new BlueGemItem(6, 5),
            new RedGemItem(7, 5),
            new BombItem(8, 5),
            new ArrowItem(9, 5),
            new HeartContainerItem(10, 5),
            new PlantItem(20, 20)
    ));

    ArrayList<Item> ITEMS_MAIN_MAP = new ArrayList<Item>(Arrays.asList(
            new ChestItem(3,1, new RedGemItem(), true),
            new BombItem(2, 1),
            new RedGemItem(4, 1),
            new BlueGemItem(5, 1),
            new GreenGemItem(6, 1),
            new KeyItem(7, 1)
    ));

    //Maps
    Map START_MAP = new Map("world01.txt", ITEMS_START_MAP, 50, 50);
    Map MAIN_MAP = new Map("world02.txt", ITEMS_MAIN_MAP, 12 ,12);
}
