import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFileData {
    private DataСonsumer consumer;
     ReadingFileData(DataСonsumer consumer) {
         this.consumer = consumer;
     }

    public void readFileData(File file) {
        try (BufferedReader bufferedReader = new BufferedReader (new FileReader(file))){
            String textLine;
            while ((textLine = bufferedReader.readLine()) != null) {
                consumer.getReadData(textLine);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}