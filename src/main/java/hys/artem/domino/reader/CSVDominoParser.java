package hys.artem.domino.reader;

import hys.artem.domino.domain.Domino;

/**
 * Created by artem on 12/13/15.
 */
public class CSVDominoParser implements DominoParser {

    private static String MULTIPLE_DIGITS_ONLY = "[^0-9,]";

    /**
     *
     * @param line String to parse
     * @param dominoId Id if domino
     * @return parsed Domino
     */
    @Override
    public Domino parseFromLine(String line, int dominoId) {
        String[] values = line.replaceAll(MULTIPLE_DIGITS_ONLY,"").split(",");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[1]);
        return new Domino(dominoId,first,second);
    }
}
