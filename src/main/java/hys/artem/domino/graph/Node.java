package hys.artem.domino.graph;

import hys.artem.domino.domain.Domino;

import java.util.ArrayList;

/**
 * Created by artem on 12/12/15.
 */
public class Node {

    private Domino domino;
    private ArrayList<Node> connectsTo = new ArrayList<Node>();

    public Node(Domino domino){ this.domino = domino;}

    public void addConnection(Node node){
        connectsTo.add(node);
    }

    public Domino getDomino() {
        return domino;
    }

    public void setDomino(Domino domino) {
        this.domino = domino;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Node{id=" + getDomino().getId() + " ");
        sb.append(domino);
        sb.append("},connectsTo={");
        for(Node node : connectsTo){
            sb.append(node.getDomino() + ",");
        }
        sb.append("}}");
        return sb.toString();
    }


}
