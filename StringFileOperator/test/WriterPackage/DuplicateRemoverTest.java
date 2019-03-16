package WriterPackage;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface DuplicateRemoverTest {
    String getContents(Writer writer) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    Writer getWriter(Function<String, String>... converter) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    @Test
    default void removeDuplicateAndToUpper() throws IOException {
        Writer writer = getWriter(content -> DuplicateRemover.convert(content));
        writer.write("this string will remove a string");
        assertEquals("this string will remove a  ", getContents(writer));
    }
}
