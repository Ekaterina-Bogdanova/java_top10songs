import java.io.File;
import java.util.Collection;

public class ReadingFilesCollectionData extends ReadingFileData {
    ReadingFilesCollectionData(DataСonsumer consumer) {
        super(consumer);
    }
    public void readFilesData(Collection<File> collection) {
        for(File file : collection){
            readFileData(file);
        }

    }

}
