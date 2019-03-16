package WriterPackage;

import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.util.function.Function;

public class StringWriterTest implements WriterTest, LowerCaseConverterTest, UpperCaseConverterTest, DuplicateRemoverTest,
        StupidRemoverConverterTest, LowerCaseAndStupidRemoverConverter, UpperCaseAndDuplicateRemoverConverter, LowerCaseStupidAndDuplicateRemoverConverter {

    @BeforeEach
    public void init(){
        StringWriter.contents = new StringBuilder();
    }

    @Override
    public String getContents(Writer writer) {
        return StringWriter.getContents();
    }

    @Override
    public Writer getWriter(Function<String, String>[] converter) throws IOException {
        return new StringWriter(converter);
    }

    @Override
    public StringWriter getWriter() {
        return new StringWriter();
    }
}
