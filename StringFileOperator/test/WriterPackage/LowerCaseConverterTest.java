package WriterPackage;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.assertEquals;

interface LowerCaseConverterTest {

    String getContents(Writer writer) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    Writer getWriter(Function<String, String>... converter) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    @Test
    default void writeAStringWithLowerConversion() throws IOException {
        Writer writer = getWriter(content -> LowerCaseConverter.convert(content));
        writer.write("THIS STRING WILL CONVERT TO LOWER CASE");
        assertEquals("this string will convert to lower case", getContents(writer));
    }
}
