import java.util.*;

public class Main {
    public static void main(String[] args) {
        String direcoryName = "./src/songs";
        String fileName = "./src/songs/it_sings_about.txt";

        Collection fileСollection = new FileDirectoryManager().getListFiles(direcoryName);

        WordFrequencyHandler wordFrequentHandler = new WordFrequencyHandler();
        new CollectionReaderManager(new FileReaderManager(wordFrequentHandler))
                .readFilesData(fileСollection);

        CollectionTransmitter topLIst = wordFrequentHandler.getTopFrequentWords(10);
        new FileWriterManager().writeMapCollectionToFile(topLIst, fileName);
    }
}
