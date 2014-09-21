
import java.io.File;
import java.io.IOException;

public class CSVReader {
  public CSVReader(String filename) throws IOException {
    if (!new File(filename).exists())
      throw new IOException();
  }

  public boolean hasNext() {
    return false;
  }
  
  public void next() throws IOException {
  }
}

