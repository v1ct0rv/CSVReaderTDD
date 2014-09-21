
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
  
  public void next() throws IOException {
    readNextLine();
  }

  void readNextLine() throws IOException {
    currentLine = reader.readLine();
  }
}

