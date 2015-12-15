package hys.artem.domino.solver;

import hys.artem.domino.domain.BacktrackMatrix;
import hys.artem.domino.domain.Domino;
import hys.artem.domino.domain.SimpleMatrix;
import hys.artem.domino.graph.Graph;
import hys.artem.domino.graph.Node;
import hys.artem.domino.writer.ConsoleWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by artem on 12/12/15.
 */
public class MatrixBuilder {

    final static Logger log = LoggerFactory.getLogger(MatrixBuilder.class);

    /**
     * Builds boolean matrix based on graph
     * @param graph
     * @return {@link hys.artem.domino.domain.SimpleMatrix} with boolean values
     * on intersections of {@link }hys.artem.domino.domain.Domino} 'first' and 'second' fields.
     */
    public static SimpleMatrix buildMatrix(Graph graph){
        int matrixSize = graph.getVertexNum();
        SimpleMatrix simpleMatrix = new SimpleMatrix(matrixSize);
        for(int i = 0; i < matrixSize ; i++){
            Node from = graph.get(i);
            log.info(from.toString());
            if(from == null)
                continue;
            for(int j = 0; j < matrixSize; j++){
                Node to = graph.get(j);
                if(to == null)
                    continue;
                if(to.getDomino().connects(from.getDomino()) && i!=j) {
                    simpleMatrix.put(i, j,true);
                }
            }
        }
        return simpleMatrix;
    }



    // TODO : uncouple types so method builds generic backtrack matrix
    public static BacktrackMatrix buildTypedBacktrackMatrix(Graph graph) {
        BacktrackMatrix matrix = new BacktrackMatrix(Domino.DOMINO_COMBINATIONS);
        for(Map.Entry<Integer,Node> entry : graph.getGraph().entrySet()){
            Node node = entry.getValue();
            Domino domino = node.getDomino();
            int first = domino.getFirst();
            int second = domino.getSecond();
            matrix.put(first, second, domino);
            log.info("martix[" + first + ":" + second + "]=" + matrix.get(first,second));
            log.info("martix[" + second + ":" + first + "]=" + matrix.get(second,first));
            ConsoleWriter.write(matrix);
        }
        return matrix;
    }


}
