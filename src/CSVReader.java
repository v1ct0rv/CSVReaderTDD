import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    private BufferedReader reader;
    private String currentLine;

    public CSVReader(String filename) throws IOException {
        if (!new File(filename).exists())
            throw new IOException();
        reader = new BufferedReader(new FileReader(filename));
        readNextLine();
    }

    public boolean hasNext() {
        return currentLine != null;
    }

    public List<String> next() throws IOException {
        String[] columns = currentLine.split(",");
        for (int i = 0; i < columns.length; i++) {
            columns[i] = columns[i].trim();
        }
        readNextLine();
        return Arrays.asList(columns);
    }

    void readNextLine() throws IOException {
        currentLine = reader.readLine();
    }
}
