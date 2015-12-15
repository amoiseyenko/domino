package hys.artem.domino.solver;

import hys.artem.domino.domain.BacktrackMatrix;
import hys.artem.domino.domain.Domino;
import hys.artem.domino.domain.DominoChain;
import hys.artem.domino.writer.ConsoleWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by artem on 12/12/15.
 */
public class Backtrack {

    final Logger log = LoggerFactory.getLogger(Backtrack.class);
    DominoChain currentChain = new DominoChain();
    DominoChain longestChain = new DominoChain();

    /**
     *
     * @param @{link hys.artem.domino.domain.BacktrackMatrix}
     * @return longest chain found in matrix
     */
    public DominoChain trace(BacktrackMatrix matrix) {
        for (int i = 0; i < Domino.DOMINO_COMBINATIONS; i++) {
            buildLongestChain(i, matrix);
        }
        return longestChain;
    }

    /**
     *
     * @param i index of row to start from.
     * @param matrix {@link hys.artem.domino.domain.BacktrackMatrix}
     */
    private void buildLongestChain(Integer i, BacktrackMatrix matrix) {

        for (int j = 0; j < Domino.DOMINO_COMBINATIONS; j++) {
            Domino domino = matrix.getAndRemove(i, j);
            if (domino != null) {
                log.info("Got domino: " + domino);
                ConsoleWriter.write(matrix);
                if (currentChain.connects(domino)) {
                    log.info("Add  " + domino);
                    currentChain.link(domino);
                    if (currentChain.longerThan(longestChain)) {
                         log.info("Longest chain candidate:" + currentChain);
                         longestChain = DominoChain.clone(currentChain);
                    }
                        buildLongestChain(j, matrix);
                }
                if (matrix.isEmpty()) {
                    return;
                }
                currentChain.unlink(domino);
                log.info("Detach: " + domino);
                log.info("Longest chain: " + longestChain);
                matrix.put(i, j, domino);
                ConsoleWriter.write(matrix);
            }
        }
    }

}
