package HW_8;

public class Item {

    private String label;
    private final int id;

    public Item(String Label, int id) {
        this.label = label;
        this.id = id;
    }
    @Override
    public String toString() {
        return label;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        return label != null ? label.equals(item.label) : item.label == null;
    }

    @Override
    public int hashCode() {
        return id;
    }

//    public Item(String irina, int i) {
//
//    }
//
//    public Item getId() {
//        return null;
//    }
}
