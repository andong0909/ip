import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Storage {

    private static final String FILE_PATH = "data/tasks.txt";

    public static void loadTasks() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                return;
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] split = line.split(" \\| ");
                String command = split[0];
                boolean isCompleted = split[1].equals("1");
                switch (command) {
                case "T":
                    TaskList.addTodo(split[2]);
                    break;
                case "D":
                    TaskList.addDeadline(split[2], split[3]);
                    break;
                case "E":
                    TaskList.addEvent(split[2], split[3], split[4]);
                    break;
                default:
                    System.out.println("WERWER! I don't recognise this task: " + command);
                    continue;
                }

                if (isCompleted) {
                    TaskList.mark(TaskList.size());
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("WERWER! It seems that you don't have the required file!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveTasks() {
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            for (int i = 1; i <= TaskList.size(); i++) {
                fw.write(TaskList.getTask(i).print() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("WERWER! Failed to save: " + e.getMessage());
        }
    }
}
