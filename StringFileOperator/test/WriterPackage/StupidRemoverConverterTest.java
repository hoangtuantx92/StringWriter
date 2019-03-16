package WriterPackage;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface StupidRemoverConverterTest {
    String getContents(Writer writer) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    Writer getWriter(Function<String, String>... converter) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    @Test
    default void stupidRemoverAndUpperConvertsion() throws IOException {
        Writer writer = getWriter(content -> StupidRemoverConverter.convert(content));
        writer.write("this string is stupid");
        assertEquals("this string is s*****", getContents(writer));
    }
}
