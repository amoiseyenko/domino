package hys.artem.domino.domain;

import java.util.ArrayList;

class TwoDimensionalArrayList<T> extends ArrayList<ArrayList<T>> {
    public TwoDimensionalArrayList(int initialCapacity) {
        super(initialCapacity);
        for (int j = 0; j < initialCapacity; j ++ ) {
            ArrayList<T> innerList = new ArrayList<T>(initialCapacity);
            for (int i = 0; i < initialCapacity; i ++ ) {
                innerList.add(null);
            }
            this.add(innerList);
        }
    }

    public void add(int x, int y, T element) {
        this.get(x).set(y, element);
    }
}