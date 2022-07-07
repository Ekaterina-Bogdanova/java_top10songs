import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class WritingDataToFile {

    public boolean writeMapCollectionToFile(Collection<Map.Entry<String, Integer>> collection, String PathTofile){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PathTofile, false))){
            File file = new File(PathTofile);

            for (Map.Entry<String, Integer> item : collection) {
                bw.write(item.getKey() + " " + item.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return true;
    }
}
