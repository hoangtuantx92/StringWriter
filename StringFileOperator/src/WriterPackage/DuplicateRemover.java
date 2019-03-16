package WriterPackage;

import java.util.HashSet;
import java.util.Set;

interface DuplicateRemover {
    static String convert(String content) {
        String[] arrayContent = content.split(" ");
        Set<String> uniqueUsers = new HashSet<String>();
        for (int i = 0; i < arrayContent.length; i++) {
            if (!uniqueUsers.add(arrayContent[i]))
                arrayContent[i] = "";
        }
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < arrayContent.length; i++) {
            strBuilder.append(arrayContent[i]);
            strBuilder.append(" ");
        }
        return String.valueOf(strBuilder);
    }
}
