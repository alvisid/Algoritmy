package HW_8;

public class HashTable<K, V> {

    private Item[] hashArr;
    private int size;
    private int currentSize;

    public HashTable(int size) {
        this.size = size;
        this.hashArr = new Item[size];
        this.currentSize = 0;
    }

    public boolean add(Item item) {
        int hashValue = hashFunc(item);

        int count = 0;
        while(hashArr[hashValue] != null) {
            if (count > size)
                break;

            hashValue += hashValue + getStep(item);
            hashValue %= size;

            count++;
        }

        if (count > size) {
            return false;
        } else {
            hashArr[hashValue] = item;
            currentSize++;
            return true;
        }
    }

    private int getStep(Item item) {
        return getStep(item.getId());
    }

    protected int getStep(int id){
        return 1;
    }

    public boolean remove(Item item) {
        int hashValue = hashFunc(item);

        int count = 0;
        while (hashArr[hashValue] != null) {
            if (count > size) {
                break;
            }
            if (hashArr[hashValue].equals(item)){
                hashArr[hashValue] = null;
                currentSize--;
                return true;
            }

            hashValue += hashValue + getStep(item);
            hashValue %= size;

            count++;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++){
            System.out.println(hashArr[i]);
        }
    }

    public Item find(int id) {
        int hashValue = hashFunc(id);

        int count = 0;
        while (hashArr[hashValue] != null) {
            if (count > size)
                break;
            if (hashArr[hashValue].getId() == id) {
                return hashArr[hashValue];
            }
            hashValue += hashValue + getStep(id);
            hashValue %= size;

            count++;
        }
        return null;
    }

    public int getSize() {
        return currentSize;
    }

    private int hashFunc(Item item) {
        return hashFunc(item.hashCode());
    }

    private int hashFunc(int id) {
        return id % size;
    }

    private int getPrime(int min) {
        for (int i = min + 1; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }
    private boolean isPrime(int n) {
            for (int j = 2; (j * j <= n); j++){
                if (n % j == 0) {
                }
                return false;
            }
        return true;
    }
}
