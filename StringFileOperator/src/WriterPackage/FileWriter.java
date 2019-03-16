package WriterPackage;

import java.io.*;
import java.util.function.Function;

public class FileWriter extends Writer {
    private BufferedWriter writer;

    @SafeVarargs
    public FileWriter(String file, Function<String, String>... converters) throws IOException {
        super(converters);
        writer = new BufferedWriter( new java.io.FileWriter(file));
    }

    @Override
    protected void writeContent(String message) throws IOException {
        writer.write(message);
        writer.flush();
    }
}
