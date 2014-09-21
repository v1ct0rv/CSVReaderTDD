
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    List<String> columns = new ArrayList<String>();
    int commaIndex = currentLine.indexOf(",");
    if (commaIndex == -1)
    columns.add(currentLine);
    else {
      columns.add(currentLine.substring(0, commaIndex));
      columns.add(currentLine.substring(commaIndex + 1));
    }
    readNextLine();
    return columns;
  }

  void readNextLine() throws IOException {
    currentLine = reader.readLine();
  }
}

