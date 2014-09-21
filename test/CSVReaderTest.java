import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class CSVReaderTest {

    /**
     * Prueba la no existencia del archivo
     * @throws IOException 
     */
    @Test(expected=IOException.class)
    public void testArchivoNoExiste() throws IOException {
        String fileName = "noexisto.csv";
        File file = new File(fileName);
        if (file.exists())
          file.delete();
        new CSVReader(fileName);
    }
}
