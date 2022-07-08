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

    public List<WordFrequencyDto> sortByDecreasingFrequency() {
        List<WordFrequencyDto> list = new LinkedList<>();

        for (Map.Entry<String, Integer> item : mapWords.entrySet()) {
            list.add(new WordFrequencyDto(item.getKey(), item.getValue()));
        }

        Collections.sort(list, (WordFrequencyDto item1, WordFrequencyDto item2) -> {
            return (item2.getFrequency()).compareTo(item1.getFrequency());
        });

        return list;
    }

    public List<WordFrequencyDto> getTopFrequentWords(int wordCount) {
        List<WordFrequencyDto> list = sortByDecreasingFrequency();
        return list.subList(0, wordCount);
    }

}
