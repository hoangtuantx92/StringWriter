package WriterPackage;


import java.util.function.Function;

public class StringWriter extends Writer {
    public static StringBuilder contents = new StringBuilder();

    @SafeVarargs
    public StringWriter(Function<String, String>... converters) {
        super(converters);
    }

    @Override
    protected void writeContent(String message) {
        contents.append(message);
    }

    public static String getContents() {
        return contents.toString();
    }
}



