package hys.artem.domino;

import hys.artem.domino.domain.BacktrackMatrix;
import hys.artem.domino.domain.DominoChain;
import hys.artem.domino.graph.Graph;
import hys.artem.domino.solver.Backtrack;
import hys.artem.domino.solver.GraphBuilder;
import hys.artem.domino.solver.MatrixBuilder;
import hys.artem.domino.writer.ConsoleWriter;
import hys.artem.domino.domain.Dominos;
import hys.artem.domino.reader.FileReader;

/**
 * Created by artem on 13/12/15.
 */
public class Main {

    public static void main(String[] args ){

        long startTime = System.currentTimeMillis();
        if(args.length == 0){
            System.out.println("Please provide path to input file.");
            System.out.println("Valid start command: \"java -jar domino.jar input.in \" for embedded input file");
            System.out.println("Or use absolute path ");
            System.exit(0);
        }
        FileReader reader = new FileReader();
        Dominos dominos =  reader.readSource(args[0]);
        Graph graph =  GraphBuilder.buildGraph(dominos);
        BacktrackMatrix btMat = MatrixBuilder.buildTypedBacktrackMatrix(graph);
        DominoChain chain = new Backtrack().trace(btMat);
        ConsoleWriter.write(chain);


        System.out.print("Elapsed time: " + String.valueOf(System.currentTimeMillis() - startTime));

    }
}
