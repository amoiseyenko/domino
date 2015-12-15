package hys.artem.domino.graph;

import hys.artem.domino.domain.Dominos;
import java.util.HashMap;

/**
 * Created by artem on 12/12/15.
 */
public class Graph {

    private HashMap<Integer, Node> graph = new HashMap<Integer, Node>();
    private Integer vertexes = 0;

    public Graph(Dominos dominos){
        this.vertexes = dominos.get().size();
        for(int i = 0 ; i < vertexes; i++){
            this.graph.put(i, new Node(dominos.get().get(i)));
        }
    }

    public HashMap<Integer, Node> getGraph() {
        return graph;
    }

    public Node get(int key){
        return graph.get(new Integer(key));
    }

    public int getVertexNum(){return this.vertexes;}
}
