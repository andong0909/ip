import woof.storage.Storage;
import woof.command.Command;
import woof.parser.Parser;
import woof.task.TaskList;
import woof.ui.Ui;

public class Woof {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    public static void main(String[] args) {
        new Woof("data/tasks.txt").run();
    }

    public Woof(String filePath) {
        ui = new Ui();
        storage = new Storage();
        try {
            taskList = new TaskList(storage.loadTasks(filePath));
        } catch (Exception e) {
            ui.showError(e.getMessage());
            taskList = new TaskList();
        }
    }
    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui);
                Storage.saveTasks("data/tasks.txt");
                isExit = c.isExit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }
}
