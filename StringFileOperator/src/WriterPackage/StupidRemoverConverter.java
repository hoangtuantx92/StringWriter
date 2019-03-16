package WriterPackage;

interface StupidRemoverConverter {
    static String convert (String content) {
      return content.replace("stupid","s*****");
    }
}
