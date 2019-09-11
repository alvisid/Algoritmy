import HW_8.Item;

import java.awt.event.ItemEvent;

public class DZ {
    public static void main(String[] args) {
        ChainHashTable hashTable = new ChainHashTable(5);
        Item item1 = new Item("Oleg", 26);
        Item item2 = new Item("Irina", 36);
        Item item3 = new Item("Pavel", 18);

        hashTable.add(item1);
        hashTable.add(item2);
        hashTable.add(item3);

        System.out.println("After insert:");
        hashTable.display();
        System.out.println("After remove:");
        hashTable.remove(item1);
        hashTable.display();
        System.out.println("Find Pavel: " + hashTable.find(item3.getId()));

        System.out.println("size is " + hashTable.getSize());
        System.out.println("Finish");
    }
}
