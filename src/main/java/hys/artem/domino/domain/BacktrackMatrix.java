package hys.artem.domino.domain;

/**
 * Matrix represented by two dimensional array populated with
 * {@link hys.artem.domino.domain.Domino} elements.
 */
public class BacktrackMatrix implements Matrix<Domino>{

    private TwoDimensionalArrayList<Domino> matrix ;
    private Integer elementNum = 0;

    public BacktrackMatrix(int size){
        matrix = new TwoDimensionalArrayList<>(size);
    }

    public void put(Integer x, Integer y,Domino element){
        matrix.add(x, y, element);
        matrix.add(y, x, element);
        elementNum = elementNum + 1;
    }

    public Domino get(Integer x, Integer y){
        if(this.matrix.get(x) == null )
            return null;
        return this.matrix.get(x).get(y);
    }

    private void remove(int x, int y){
        this.matrix.get(x).set(y, null);
    }

    public Domino getAndRemove(int x, int y){
        Domino dom = get(x,y);
        if(dom != null){
            elementNum = elementNum - 1;
            remove(x,y);
            remove(y,x);
        }
        return dom;
    }

    public boolean isEmpty(){return  elementNum == 0;}


}
