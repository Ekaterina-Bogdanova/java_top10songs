import java.util.*;

public class Main {
    public static void main(String[] args) {
        String direcoryName = "./src/songs";
        String fileName = "./src/songs/it_sings_about.txt";

        Collection fileСollection = new GettingListOfFiles().getListFiles(direcoryName);

        WordStat frequentWordStat = new WordStat();
        new ReadingFilesCollectionData(frequentWordStat).readFilesData(fileСollection);

        List<Map.Entry<String, Integer>> topLIst = frequentWordStat.getTopFrequentWords(10);
        new WritingDataToFile().writeMapCollectionToFile(topLIst, fileName);
    }




}
