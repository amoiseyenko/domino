package hys.artem.domino.solver;

import hys.artem.domino.domain.Domino;
import hys.artem.domino.domain.Dominos;
import hys.artem.domino.graph.Graph;
import hys.artem.domino.graph.Node;

/**
 * Created by artem on 12/12/15.
 */
public class GraphBuilder {

    /**
     * Traverses {@link hys.artem.domino.domain.Dominos } and
     * builds graph depending on elements that can be connected
     * @param {@link hys.artem.domino.domain.Dominos}
     * @return {@link hys.artem.domino.graph.Graph} with
     * {@link hys.artem.domino.graph.Node} if 2 or more of them
     * can be connected
     */
    public static Graph buildGraph(Dominos dominos) {
        Integer dominosLength = dominos.get().size();
        Graph graph = new Graph(dominos);
        for (int i = 0; i < dominosLength; i++) {
            Node node = graph.get(i);
            Domino dom = node.getDomino();
            for (int j = 0; j < dominosLength; j++) {
                Node connectedNode =  graph.get(j);
                Domino nextDomino = connectedNode.getDomino();
                if (nextDomino != dom && dom.connects(nextDomino)) {
                    node.addConnection(connectedNode);
                }
            }
        }
        return graph;
    }



}
