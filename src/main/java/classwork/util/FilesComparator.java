package classwork.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesComparator {

    public static boolean CompareFiles(String fileOne, String fileTwo){
        try {
            List<String> listOne = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "\\" + fileOne), StandardCharsets.UTF_8);
            List<String> listTwo = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "\\" + fileTwo), StandardCharsets.UTF_8);
            if (listOne.size() != listTwo.size()){
                return false;
            }
            for (int i = 0; i < listOne.size(); i++) {
                if (!listOne.get(i).equals(listTwo.get(i))) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
