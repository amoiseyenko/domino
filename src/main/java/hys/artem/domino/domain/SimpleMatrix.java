package hys.artem.domino.domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by artem on 12/12/15.
 */
public class SimpleMatrix implements Matrix<Boolean>{

    private boolean[][] matrix ;
    private int size;
    public SimpleMatrix(int size){
        this.size = size;
        this.matrix = new boolean[size][size];
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void put(Integer i, Integer j,Boolean object){
        this.matrix[i][j] = object.booleanValue();
    }

    public Boolean get(Integer i, Integer j){
        return new Boolean(this.matrix[i][j]);
    }

    public int getSize(){ return  this.size; }
}
