import java.io.*;
import java.util.*;

public class WorkWhithMap {
    private Map<String, Integer> mapWords = new HashMap<>();
    private List<Map.Entry<String, Integer>> topList;

    public void getMapFromFiles(String path) {
        File dir = new File(path);
        Map<String, Integer> mapWords = new HashMap<>();

        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                if (item.isFile()) {
                    readFile(item);
                }
            }
        }
    }

    public  void readFile(File f) {

        try (BufferedReader br = new BufferedReader (new FileReader(f))){
            String text;
            while ((text = br.readLine()) != null) {
                addWordsToMap(text);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void addWordsToMap(String str) {
        String[] words = str.toLowerCase().replaceAll("[^a-zа-яё\\s]", "").split("\\s+");

        for (String word : words) {
            mapWords.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);
        }
    }

    public void sortMapWords() {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(mapWords.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> m1,
                               Map.Entry<String, Integer> m2) {
                return (m2.getValue()).compareTo(m1.getValue());
            }
        });

        topList = list.subList(0, 10);
    }

    public void writeListToFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))){
            File file = new File(fileName);

            for (Map.Entry<String, Integer> item : topList) {
                bw.write(item.getKey() + " " + item.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        System.out.println("Файл \"it_sings_about.txt\" записан!");
    }

}
