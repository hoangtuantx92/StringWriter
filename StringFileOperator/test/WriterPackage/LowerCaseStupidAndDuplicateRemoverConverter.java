package WriterPackage;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface LowerCaseStupidAndDuplicateRemoverConverter {
    String getContents(Writer writer) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    Writer getWriter(Function<String, String>... converter) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    @Test
    default void writeAStringWithLowerCaseStupidAndDuplicateRemoverConverter() throws IOException {
        Writer writer = getWriter(content -> LowerCaseConverter.convert(content), content ->StupidRemoverConverter.convert(content), content ->DuplicateRemover.convert(content));
        writer.write("THIS STUPID STRING WILL CONVERT TO LOWER CASE INTO SOME STRING");
        assertEquals("this s***** string will convert to lower case into some  ", getContents(writer));
    }
}
