import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WritingService {
    public boolean writeMapCollectionToFile(List<WordFrequencyDto> listDto, String pathTofile){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathTofile, false))){
            File file = new File(pathTofile);

            for (WordFrequencyDto item : listDto) {
                bw.write(String.format("%s %d\n", item.getWord(), item.getFrequency()));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return true;
    }
}
