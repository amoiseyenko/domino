package hys.artem.domino.reader;

import hys.artem.domino.domain.Domino;

/**
 * Created by artem on 12/12/15.
 */
public class SimpleDominoParser implements  DominoParser{

    private static String DELIMITER = ":";

    /**
     *
     * @param line line with {@link hys.artem.domino.domain.Domino} values devided by semicolon
     * @param id Id of domino to be created
     * @return {@link hys.artem.domino.domain.Domino}
     */
    public Domino parseFromLine(String line, int id){
        Domino domino = new Domino();
        try {
            Integer upper = Integer.parseInt(line.substring(0, line.indexOf(DELIMITER)));
            Integer lower = Integer.parseInt(line.substring(line.indexOf(DELIMITER)+1));
            domino.setFirst(lower);
            domino.setSecond(upper);
            domino.setId(id);

        }catch(NumberFormatException exc){
            exc.printStackTrace();
            System.out.println("Unable to parse file. Line = " + line);
            System.exit(1);
        }
        return domino;

    }

}
