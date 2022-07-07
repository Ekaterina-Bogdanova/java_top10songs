import java.util.*;

public class WordStat implements DataСonsumer{
    private Map<String, Integer> mapWords = new HashMap<>();

    @Override
    public void getReadData(String str) {
        addWordsFromString(str);
    };

    public void addWordsFromString(String str) {
        String[] words = str.toLowerCase().replaceAll("[^a-zа-яё\\s]", "").split("\\s+");

        for (String word : words) {
            mapWords.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);
        }
    }

    public List<Map.Entry<String, Integer>> sortByDecreasingFrequency() {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(mapWords.entrySet());

        Collections.sort(list, (Map.Entry<String, Integer> item1, Map.Entry<String, Integer> item2) -> {
                return (item2.getValue()).compareTo(item1.getValue());
        });

        return list;
    }

    public List<Map.Entry<String, Integer>> getTopFrequentWords(int wordCount) {
        List<Map.Entry<String, Integer>> topList = sortByDecreasingFrequency();
        return topList.subList(0, wordCount);
    }

}
