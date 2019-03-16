package WriterPackage;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface UpperCaseConverterTest {

    String getContents(Writer writer) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    Writer getWriter(Function<String, String>... converter) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    @Test
    default void WriteAStringWithUpperConversion() throws IOException {
        Writer writer = getWriter(content -> UpperCaseConverter.convert(content));
        writer.write("this string will convert to upper case");
        assertEquals("THIS STRING WILL CONVERT TO UPPER CASE", getContents(writer));
    }
}
