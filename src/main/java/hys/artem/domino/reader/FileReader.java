package hys.artem.domino.reader;

import hys.artem.domino.domain.Domino;
import hys.artem.domino.domain.Dominos;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artem on 12/12/15.
 */
public class FileReader implements Reader<Dominos,String> {

    /**
     * Reads source that assumed to be text file.
     * Depending on file extension obtains parser( available formats - .in, .csv)
     * and processes line by line creating {@link hys.artem.domino.domain.Dominos} object
     * @param path Path to source file
     * @return {@link hys.artem.domino.domain.Dominos}
     */
    public Dominos readSource(String path){
        System.out.println("Reading dominos from: " + path);
        DominoParser parser = ParserFactory.getParser(path);
        ArrayList<String> lines = new ArrayList<>(readLines(path));
        Dominos dominos = parseLines(lines,parser);
        return dominos;
    }

    private Dominos parseLines(ArrayList<String> lines,DominoParser parser) {
        Dominos dominos = new Dominos();
        Integer index = 0;
        for(String line : lines){
            line = line.trim();
            if(!line.isEmpty()) {
                Domino domino = parser.parseFromLine(line, ++index);
                dominos.add(domino);
            }
        }
        return dominos;
    }

    private List<String> readLines(String pathToFile) {
        List<String> lines = new ArrayList<String>();
        Path file = FileSystems.getDefault().getPath(pathToFile);
        try{
              lines =  Files.readAllLines(file, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return lines;
    }
}
