package hys.artem.domino.reader;

/**
 * Created by artem on 12/13/15.
 */
public interface Reader<T,S> {

    public T readSource(S source);
}
