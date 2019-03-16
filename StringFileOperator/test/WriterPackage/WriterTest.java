package WriterPackage;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public interface WriterTest {
    String getContents(Writer writer) throws IOException;

    Writer getWriter() throws IOException;

    @Test
    default void Canary(){
        assertTrue(true);
    }

    @Test
    default void writerOneTime() throws IOException {
        Writer writer = getWriter();
        writer.write("this is a string");
        assertEquals("this is a string",getContents(writer));
    }

    @Test
    default void writeTwoTime() throws IOException {
        Writer writer = getWriter();
        writer.write("this is a string");
        writer.write("this is a second string");
        assertEquals("this is a stringthis is a second string", getContents(writer));
    }

    @Test
    default void writeTwiceWithCloseCallInBetween() throws IOException {
        Writer writer = getWriter();
        writer.write("this is a string");
        writer.close();
        writer.write("this is a second string");
        assertEquals("this is a string", getContents(writer));
    }

    @Test
    default void writeToAClosedFile() throws IOException {
       Writer writer = getWriter();
       writer.close();
       writer.write("This should not appear, as the file is closed.");
       assertEquals("", getContents(writer));
    }
}
