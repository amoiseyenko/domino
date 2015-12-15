package hys.artem.domino.writer;

import hys.artem.domino.domain.*;
import hys.artem.domino.graph.Graph;
import hys.artem.domino.graph.Node;

import java.util.Map;

/**
 * Created by artem on 12/12/15.
 */
public class ConsoleWriter {

    public static void write(Dominos dominos){
        for(Domino domino : dominos.get()){
            System.out.println(domino);
        }
    }

    public static void write(Graph graph){
        for(Map.Entry<Integer,Node> entry : graph.getGraph().entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static void write(SimpleMatrix simpleMatrix){
        int size = simpleMatrix.getSize();
        System.out.println("__________________________");
        for(int i = 0 ; i < size; i++){
            for(int j = 0 ; j < size; j++){
                System.out.print(simpleMatrix.get(i,j) + " ");
            }
            System.out.println("");
        }
        System.out.println("__________________________");
    }

    public static void write(BacktrackMatrix matrix){
         for(int i = 0 ; i < Domino.DOMINO_COMBINATIONS; i++){
             for(int j = 0 ; j < Domino.DOMINO_COMBINATIONS ; j++){
                 Domino dom = matrix.get(i,j);
                 if(dom == null)
                     System.out.print("[ : ]");
                 else {
                       System.out.print("[" + dom.getFirst() + ":" + dom.getSecond() + "]");
                 }
             }
             System.out.println("");
         }
    }

    public static void write(DominoChain chain){
        chain.sort();
        System.out.println("-------------");
        System.out.println("Chain length: " + chain.getLength());
        System.out.println(chain);
        System.out.println("-------------");
    }

}
