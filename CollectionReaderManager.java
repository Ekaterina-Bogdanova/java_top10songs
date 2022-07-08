import java.io.File;
import java.util.Collection;

public class CollectionReaderManager {
    private FileReaderManager manager;

    public CollectionReaderManager(FileReaderManager manager) {
        this.manager = manager;
    }
    public void readFilesData(Collection<File> collection) {
        for(File file : collection){
            manager.readFileData(file);
        }
    }
}