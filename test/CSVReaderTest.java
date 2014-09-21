import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CSVReaderTest {
    private String filename;
    private BufferedWriter writer;

    /**
     * Creamos un archivo.
     * 
     * @throws IOException
     */
    @Before
    public void setUp() throws IOException {
        filename = "CSVReaderTest.tmp.csv";
        writer = new BufferedWriter(new FileWriter(filename));
    }

    /**
     * Borramos el Archivo.
     */
    @After
    public void tearDown() {
        new File(filename).delete();
    }

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
        // Verificamos que no tenga registros.
        CSVReader reader = getReaderAndCloseWriter();
        assertTrue(!reader.hasNext());
    }

    @Test
    public void testLeerUnSoloRegistro() throws IOException {
        // Creamos un archivo con un registro
        writer.write("registro unico", 0, 14);
        writer.write("\r\n", 0, 2);

        CSVReader reader = getReaderAndCloseWriter();
        // Verificamos que tenga registros.
        assertTrue(reader.hasNext());
        // Leemos el siguiente registro
        List<String> columns = reader.next();
        assertEquals(1, columns.size());
        assertEquals("registro unico", columns.get(0));
        // Verificamos que no tenga registros.
        assertTrue(!reader.hasNext());
        // Borramos el Archivo
    }

    CSVReader getReaderAndCloseWriter() throws IOException {
        writer.close();
        return new CSVReader(filename);
    }

}
