import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;


public class ShortLister {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        File selectedFile;
        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            fileChooser.setCurrentDirectory(workingDirectory);

            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                selectedFile = fileChooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE)) ;
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                ShortWordFilter filter = new ShortWordFilter();
                String line = "";

                System.out.println("Short words (less than 5 characters):");
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+"); // Split the line into words
                    for (String word : words) {
                        if (filter.accept(word)) {
                            System.out.println(word);
                        }
                    }
                }
                reader.close();
                System.out.println("\nData file read!");
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!!!");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
