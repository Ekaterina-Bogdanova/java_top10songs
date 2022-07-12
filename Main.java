import java.util.*;

public class Main {
    public static void main(String[] args) {
        String direcoryName = "./src/songs";
        String fileName = "./src/songs/it_sings_about.txt";

        Collection fileСollection = new FileDirectoryManager().getListFiles(direcoryName);

        WordFrequencyHandler wordFrequentHandler = new WordFrequencyHandler();
        new DirectoryReader(new ReadingService(wordFrequentHandler))
                .readFilesData(fileСollection);

        List<WordFrequencyDto> topLIst = wordFrequentHandler.getTopFrequentWords(10);
        new WritingService().writeMapCollectionToFile(topLIst, fileName);
    }
}
