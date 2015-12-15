package hys.artem.domino.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by artem on 12/10/15.
 */
public class Dominos {

    private List<Domino> elements = new ArrayList<Domino>(28);

    public Dominos(){}

    public Dominos(List<Domino> elements) {
        this.elements = elements;
    }

    public List<Domino> get(){
        return elements;
    }

    public void add(Domino domino){ elements.add(domino); }

    public void add(Integer index, Domino newDomino){
        elements.add(index,newDomino);
    }

    public void shuffle(){
        Collections.shuffle(elements);
    }

}
