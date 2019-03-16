package WriterPackage;

import java.io.IOException;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class Writer {
    Function<String, String> converter;
    boolean open = true;

    @SafeVarargs
    public Writer(Function<String, String>... converters) {
        converter = Stream.of(converters)
                .reduce(Function.identity(), Function::andThen);
    }

  public void write(String message) throws IOException {
         if(isOpen()) {
           writeContent(converter.apply(message));
         }
 }
    protected abstract void writeContent(String message) throws IOException;

    public boolean isOpen() { return open; }

    void close() {
        open  = false;
    }
}
