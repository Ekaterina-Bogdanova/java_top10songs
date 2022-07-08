import java.util.*;

public class WordFrequencyHandler implements LineHandler {
    private Map<String, Integer> mapWords = new HashMap<>();

    @Override
    public void handle(String line) {
        addWordsFromString(line);
    };

    private void addWordsFromString(String str) {
        String[] words = str.toLowerCase().replaceAll("[^a-zа-яё\\s]", "").split("\\s+");

        for (String word : words) {
            mapWords.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);
        }
    }

    public CollectionTransmitter sortByDecreasingFrequency() {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(mapWords.entrySet());

        Collections.sort(list, (Map.Entry<String, Integer> item1, Map.Entry<String, Integer> item2) -> {
                return (item2.getValue()).compareTo(item1.getValue());
        });

        return new CollectionTransmitter(list);
    }

    public CollectionTransmitter getTopFrequentWords(int wordCount) {
        List<Map.Entry<String, Integer>> list = (List)sortByDecreasingFrequency().getData();
        return new CollectionTransmitter(list.subList(0, wordCount));
    }

}
