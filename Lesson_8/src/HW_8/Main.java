package HW_8;

public class Main {
    public static void main(String[] args) {
        HashTable<K, V> hashTable = new HashTable<K, V>(23);
        Item item3 = new Item("Irina", 36);
        Item item2 = new Item("Pavel", 18);
        Item item1 = new Item("Oleg", 25);

        hashTable.add(item1);
        hashTable.add(item2);
        hashTable.add(item3);

        System.out.println("Find 26 = " + hashTable.find(26));
    }
}
