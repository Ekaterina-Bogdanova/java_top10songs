import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileDirectoryManager {

    public List<File> getListFiles(String pathToDirectory) {
        File directory = new File(pathToDirectory);
        List<File> listFiles = new ArrayList<File>();

        if (directory.isDirectory()) {

            for (File item : directory.listFiles()) {
                if (item.isFile()) {
                    listFiles.add(item);
                }
            }
        }

        return listFiles;
    }
}