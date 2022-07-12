class WordFrequencyDto {
    private String word;
    private Integer frequency;

    public WordFrequencyDto(String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public Integer getFrequency() {
        return frequency;
    }
}
