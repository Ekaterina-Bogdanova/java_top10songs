import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderManager {
    private LineHandler lineHandler;
    public FileReaderManager(LineHandler lineHandler) {
         this.lineHandler = lineHandler;
     }

    public void readFileData(File file) {
        try (BufferedReader bufferedReader = new BufferedReader (new FileReader(file))){
            String textLine;
            while ((textLine = bufferedReader.readLine()) != null) {
                lineHandler.handle(textLine);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}