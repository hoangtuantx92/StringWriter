package WriterPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import static java.util.stream.Collectors.joining;
import org.junit.jupiter.api.AfterEach;

public class FileWriterTest implements WriterTest, LowerCaseConverterTest, UpperCaseConverterTest, DuplicateRemoverTest,
        StupidRemoverConverterTest, LowerCaseAndStupidRemoverConverter, UpperCaseAndDuplicateRemoverConverter, LowerCaseStupidAndDuplicateRemoverConverter {
    private static final String TEST_FILE = "file.txt";

    @Override
    public String getContents(Writer ignore) throws IOException {
        return Files.lines(Paths.get(TEST_FILE))
                .collect(joining(""));
    }

    @Override
    public Writer getWriter(Function<String, String>[] converter) throws IOException {
        return new FileWriter(TEST_FILE, converter);
    }

    @Override
    public FileWriter getWriter() throws IOException {
        return new FileWriter(TEST_FILE);
    }    
    
    @AfterEach
    void removeFile() {
      new java.io.File(TEST_FILE).delete();
    }

}
