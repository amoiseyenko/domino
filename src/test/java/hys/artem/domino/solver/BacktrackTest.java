package hys.artem.domino.solver;

import hys.artem.domino.domain.BacktrackMatrix;
import hys.artem.domino.domain.Domino;
import hys.artem.domino.domain.Dominos;
import hys.artem.domino.graph.Graph;
import hys.artem.domino.reader.FileReader;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class BacktrackTest  {

    private static Dominos orderedDominoeList;
    private static String orderedDominoeListPath = "testInput.in";

    @BeforeClass
    public static void setUp(){
        orderedDominoeList = new FileReader().readSource(orderedDominoeListPath);
        assertNotNull(orderedDominoeList);
        assertEquals(orderedDominoeList.get().size(),28);
    }
    int dominos = 6;
    @Test
    public void testGraph() throws Exception {
        List<Domino> aList = getConnectingDominoList(dominos);
        assertEquals(aList.size(),dominos);
        Graph graph = GraphBuilder.buildGraph(new Dominos(aList));
        assertEquals(graph.getGraph().size(),aList.size());
    }

    @Test
    public void testBacktrackMatrix() throws Exception{
        List<Domino> aList = getConnectingDominoList(dominos);
        assertEquals(aList.size(),dominos);
        Graph graph = GraphBuilder.buildGraph(new Dominos(aList));
        BacktrackMatrix matrix = MatrixBuilder.buildTypedBacktrackMatrix(graph);
        for(Domino dom : aList) {
            Domino t = matrix.get(dom.getFirst(),dom.getSecond());
            assertEquals(dom,t);
        }
    }



    /**
     *
     * @param quantity number of domino in resulting array
     * @return array of @Domino that guaranteed to connect
     */
    public List<Domino> getConnectingDominoList(int quantity) {
        ArrayList<Domino> tList = new ArrayList(Arrays.asList(new Domino[orderedDominoeList.get().size()]));
        List<Domino> result = new ArrayList<>();
        Collections.copy(tList, orderedDominoeList.get());
        Collections.shuffle(tList);
        int index = 0;
        Domino prev = tList.get(index++);
        while(true) {
            if(index > tList.size())
                index = 0;
            if (result.size() == quantity)
                break;
            Domino current = tList.get(index++);
            if(current.connects(prev)) {
                result.add(current);
                prev = current;
                index = index +1;
            }
        }
        return result;
    }
}