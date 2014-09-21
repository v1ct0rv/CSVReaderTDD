import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class CSVReaderTest {

    /**
     * Prueba la no existencia del archivo
     */
    @Test
    public void testArchivoNoExiste() {
        String fileName = "noexisto.csv";
        File file = new File(fileName);
        if (file.exists())
            file.delete();
        try {
            new CSVReader(fileName);
            fail("Se esperaba un IOException por la no existencia del archivo");
        } catch (IOException e) {
            // Es correcto. Se espera que se dispare esta excepción
        }
    }
}
