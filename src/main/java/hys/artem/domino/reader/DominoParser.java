package hys.artem.domino.reader;

import hys.artem.domino.domain.Domino;

/**
 * Created by artem on 12/13/15.
 */
public interface DominoParser {
    public Domino parseFromLine(String line,int dominoId);
}
