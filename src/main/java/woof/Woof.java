package woof;

import woof.storage.Storage;
import woof.command.Command;
import woof.parser.Parser;
import woof.task.TaskList;
import woof.ui.Ui;

/**
 * The main class for the Woof project. Woof is a task management application that allows users
 * to add, delete, mark, and list various kinds of tasks.
 */

public class Woof {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    /**
     * Entry point for the Woof project.
     *
     * @param args Command-line inputs that are passed to the project to process.
     */
    public static void main(String[] args) {
        new Woof("data/tasks.txt").run();
    }

    /**
     * Constructs a new instance of the Woof project, with a specified file path. It is set to be "data/tasks.txt"
     * in the entry point.
     *
     * @param filePath The path to the file where the tasks are stored locally.
     */
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

    /**
     * Runs the Woof project. After displaying welcome message, it generally follows a cycle of reading user's inputs
     * via CLI, processing and executing the actions with a fun and friendly tone and saves the tasks locally.
     * The project will continue running until an exit command is successfully called.
     */
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
        ui.close();
    }
}
