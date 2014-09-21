import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class CSVReaderTest {

    /**
     * Prueba la no existencia del archivo
     * 
     * @throws IOException
     */
    @Test(expected = IOException.class)
    public void testArchivoNoExiste() throws IOException {
        String filename = "noexisto.csv";
        File file = new File(filename);
        if (file.exists())
            file.delete();
        new CSVReader(filename);
    }

    @Test
    public void testCreacionArchivoVacio() throws IOException {
        // Creamos un archivo
        String filename = "CSVReaderTest.tmp.csv";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.close();

        // Verificamos que no tenga registros.
        CSVReader reader = new CSVReader(filename);
        assertTrue(!reader.hasNext());
        new File(filename).delete();
    }

    @Test
    public void testLeerUnSoloRegistro() throws IOException {
        // Creamos un archivo con un registro
        String filename = "CSVReaderTest.tmp.csv";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("registro unico", 0, 14);
        writer.write("\r\n", 0, 2);
        writer.close();

        CSVReader reader = new CSVReader(filename);
        // Verificamos que tenga registros.
        assertTrue(reader.hasNext());
        // Leemos el siguiente registro
        reader.next();
        // Verificamos que no tenga registros.
        assertTrue(!reader.hasNext());

        // Borramos el Archivo
        new File(filename).delete();
    }

}
