package hys.artem.domino.domain;

/**
 * Created by artem on 12/14/15.
 */
public interface Matrix<T> {

    public void put(Integer x,Integer y,T element);
    public T get(Integer x, Integer y);
}
