package lesson_5.HW_5;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Item> list = new ArrayList<>();
        list.add(new Item("Book", 1, 600));
        list.add(new Item("Binoculars", 2, 5000));
        list.add(new Item("first_aid_kit", 3, 1500));
        list.add(new Item("Notebook", 2, 40000));
        list.add(new Item("Bowler_hut", 2, 500));
        Backpack backpack = new Backpack(5);
        backpack.calcBestSet(list);
        list = backpack.getBestSet();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name + " " + list.get(i).price);
        }
        System.out.println("Count: " + backpack.count);
    }
}
