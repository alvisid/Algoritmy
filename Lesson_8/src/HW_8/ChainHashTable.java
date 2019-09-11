package HW_8;

import HW_8.Item;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChainHashTable {

    private LinkedList<Item>[] hashArr;
    private int size;

    public ChainHashTable(int size) {
        this.size = size;
        this.hashArr = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashArr[i] = new LinkedList<>();
        }
    }

    public boolean add(Item item){
        int hashValue = new hashFunc(item);
        return hashArr[hashValue].add(item);
    }

    public boolean remove(Item item) {
        int hashValue = hashFunc(item);
        return hashArr[hashValue].remove(item);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            String chain = hashArr[i].stream().map(Item::toString).collect(Collectors.joining(" -> ", "Row: [", "]"));

            System.out.println(chain);
        }
    }

    public Item find(int id) {
        int hashValue = hashFunc(id);
        for (Item item : hashArr[hashValue]) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public int getSize() {
        return Stream.of(hashArr).mapToInt(LinkedList:: size).sum();
    }

    private int hashFunc(Item item) {
        return hashFunc(item.hashCode());
    }

    private int hashFunc(int id) {
        return id % size;
    }

    private class hashFunc {
        public hashFunc(Item item) {
        }
    }

//    private class hashFunc {
//        public hashFunc(Item item) {
//        }
//    }
}
