import java.io.File;
import java.util.Collection;

public class DirectoryReader {
    private ReadingService readingService;

    public DirectoryReader(ReadingService readingService) {
        this.readingService = readingService;
    }
    public void readFilesData(Collection<File> collection) {
        for(File file : collection){
            readingService.readFileData(file);
        }
    }
}