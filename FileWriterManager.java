import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class FileWriterManager {

    public boolean writeMapCollectionToFile(CollectionTransmitter transmitter, String pathTofile){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathTofile, false))){
            File file = new File(pathTofile);
            Collection<Map.Entry<String, Integer>> collection = transmitter.getData();

            for (Map.Entry<String, Integer> item : collection) {
                bw.write(String.format("%s %d\n", item.getKey(), item.getValue()));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return true;
    }
}
