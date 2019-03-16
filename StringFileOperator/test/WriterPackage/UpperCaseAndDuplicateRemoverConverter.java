package WriterPackage;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface UpperCaseAndDuplicateRemoverConverter {
    String getContents(Writer writer) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    Writer getWriter(Function<String, String>... converter) throws IOException;

    @SuppressWarnings({"unchecked", "varargs"})
    @Test
    default void writeAStringWithUpperCaseAndDuplicateRemoverConverter() throws IOException {
        Writer writer = getWriter(content -> UpperCaseConverter.convert(content), content ->DuplicateRemover.convert(content));
        writer.write("this string will remove some string");
        assertEquals("THIS STRING WILL REMOVE SOME  ", getContents(writer));
    }
}
