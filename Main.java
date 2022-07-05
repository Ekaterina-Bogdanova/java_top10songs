public class Main {
    public static void main(String[] args) {
        String direcoryName = "./src/songs";
        String fileName = "./src/songs/it_sings_about.txt";

        WorkWhithMap wm1 = new WorkWhithMap();
        wm1.getMapFromFiles(direcoryName);
        wm1.sortMapWords();
        wm1.writeListToFile(fileName);
    }

}
