package hys.artem.domino.domain;

import java.util.LinkedList;

/**
 * Created by artem on 12/12/15.
 */
public class DominoChain implements Cloneable{

    LinkedList<Domino> chain = new LinkedList<Domino>();

    public DominoChain(){}
    public DominoChain(LinkedList<Domino> list){
        this.chain=list;
    }
    public boolean connects(Domino domino){
        return isEmpty() ||
                chain.getFirst().connects(domino) || chain.getLast().connects(domino);
    }

    public void link(Domino newDomino){
        if(isEmpty())
            chain.addFirst(newDomino);
        else if(chain.getFirst().connects(newDomino)){
            Domino head = chain.getFirst();
            if(head.getFirst() == newDomino.getFirst())
                newDomino.rotate();
            chain.addFirst(newDomino);
        }
        else if(chain.getLast().connects(newDomino)){
            Domino tail = chain.getLast();
            if(tail.getSecond() == newDomino.getSecond())
                newDomino.rotate();
            chain.addLast(newDomino);
        }
    }

    public void unlink(Domino domino){
        this.chain.remove(domino);
    }

    public boolean longerThan(DominoChain chain){
        return this.chain.size() > chain.getLength();
    }

    public int getLength(){
        return chain.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(Domino dom : chain){
            sb.append( dom.getFirst()).append(":").append(dom.getSecond()).append(" - ");
        }
        sb.append(" ]");
        return sb.toString();
    }

    public boolean isEmpty(){
        return this.chain.size() == 0;
    }

    public static DominoChain clone(DominoChain other){
        LinkedList<Domino> newDominos = (LinkedList<Domino>)other.chain.clone();
        DominoChain newChain = new DominoChain(newDominos);
        return newChain;
   }

   public void sort(){
       Domino prev = chain.get(0);
        for(int i = 1 ; i< chain.size(); i++){
            Domino current = chain.get(i);
            if(prev.getSecond() != current.getFirst())
                current.rotate();
            prev = current;
        }
   }
}
