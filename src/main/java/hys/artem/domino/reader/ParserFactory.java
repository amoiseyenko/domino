package hys.artem.domino.reader;

/**
 * Created by artem on 12/13/15.
 */
public class ParserFactory {

    /**
     *
     * Depending on @param value obtains parser for input source
     * @return implementation of {@link hys.artem.domino.reader.DominoParser}
     */
    public static DominoParser getParser(String source){
        String extension = source.substring(source.length()-3);
        switch(extension){
            case ".in" : return new SimpleDominoParser();
            case "csv" : return new CSVDominoParser();
            default: throw new IllegalStateException(" Unknown input source ");
        }
    }
}
