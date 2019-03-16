package WriterPackage;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface LowerCaseAndStupidRemoverConverter {
    String getContents(Writer writer) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    Writer getWriter(Function<String, String>... converter) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    @Test
    default void writeAStringWithLowerConverterAndStupidRemoverConverter() throws IOException {
        Writer writer = getWriter(content -> LowerCaseConverter.convert(content), content ->StupidRemoverConverter.convert(content));
        writer.write("THIS STUPID STRING WILL CONVERT TO LOWER CASE");
        assertEquals("this s***** string will convert to lower case", getContents(writer));
    }
}
