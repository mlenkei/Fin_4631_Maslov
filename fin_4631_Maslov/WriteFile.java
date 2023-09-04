import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFile {
    public static void creatingFile(String text, String name) {
        boolean indicatorFile = false;
        String str = "";
        if (Files.exists(Path.of(name + ".txt"))) {
            str = readFile(name);
            if (!str.contains(text)) {
                indicatorFile = true;
                writerFile(name, text, indicatorFile);
                System.out.println("Data successfully added");
            } else {
                System.out.println("The data exists");
            }
        } else {
            writerFile(name, text, indicatorFile);
            System.out.println("File " + name + ".txt successfully created");
        }
    }

    public static String readFile(String name) {
        try (FileReader reader = new FileReader(name + ".txt")) {
            int c;
            StringBuilder str = new StringBuilder();
            while ((c = reader.read()) != -1) {
                str.append((char) c);
            }
            return str.toString();
        } catch (IOException e) {
            throw new RuntimeException("File reading error " + e);
        }
    }

    public static void writerFile(String name, String text, boolean indicator) {
        try (FileWriter writer = new FileWriter(name + ".txt", indicator)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            throw new RuntimeException("File writing error" + e);
        }
    }
}