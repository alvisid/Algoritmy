package HW_8;

import java.util.Hashtable;

public class DoubleHashTable extends Hashtable {

    private static final int DOUBLE_HASH_CONST = 5;

    public DoubleHashTable(int size) {
        super(size);
    }

    private int hashFuncDouble(int id) {
        return DOUBLE_HASH_CONST - id % DOUBLE_HASH_CONST;
    }

    protected int getStep(int id) {
        return hashFuncDouble(id);
    }
}
