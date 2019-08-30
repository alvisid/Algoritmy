package lesson_5.HW_5;

/*Написать программу «Задача о рюкзаке» с помощью рекурсии.*/

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    public int count = 0;
    private int maxWeight;
    private int maxPrice;
    private List<Item> bestItems = null;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int calcWeight(List<Item> items) {
        int sumWeight = 0;
        for (Item item : items) {
            sumWeight += item.weight;
        }
        return sumWeight;
    }

    private int calcPrice(List<Item> items) {
        int sumPrice = 0;
        for (Item item : items) {
            sumPrice += item.price;
        }
        return sumPrice;
    }

    private void bestSet(List<Item> items) {
        if (bestItems == null) {
            if (calcWeight(items) <= maxWeight) {
                bestItems = items;
                maxPrice = calcPrice(items);
            }
        } else {
            if (calcWeight(items) <= maxWeight && calcPrice(items) > maxPrice) {
                bestItems = items;
                maxPrice = calcPrice(items);
            }
        }
    }

    public void calcBestSet(List<Item> items) {
        if (items.size() > 0) {
            bestSet(items);
            count++;
        }
        for (int i = 0; i < items.size(); i++) {
            List<Item> list = new ArrayList<>(items);
            list.remove(i);
            calcBestSet(list);
        }
    }

    public List<Item> getBestSet() {
        return bestItems;
    }
}
