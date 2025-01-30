package woof.ui;

import woof.task.TaskList;

import java.util.Scanner;

public class Ui {
    private static final String DIVIDER = "____________________________________________________________";
    private final Scanner sc;

    /**
     * Constructs a new Ui instance with a scanner initialised
     */
    public Ui() {
        sc = new Scanner(System.in);
    }

    /**
     * Reads a command from the user.
     *
     * @return The command entered by user as a string.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Displays a divider line to separate sections of the output.
     */
    public void showLine() {
        System.out.println(DIVIDER);
    }

    /**
     * Displays a welcome message when the application starts.
     */
    public void showWelcome() {
        System.out.println("""
                Woof! Woof! I am your paw-sonsal chatbot!
                What can Woof do for you?"""
        );
    }

    /**
     * Displays an error message to the user.
     *
     * @param error The error message to display.
     */
    public void showError(String error) {
        System.out.println(error);
    }

    /**
     * Displays the list of tasks to the user.
     */
    public void displayTaskList() {
        System.out.println(TaskList.print());
    }

    /**
     * Displays a message confirming that a task has been added.
     *
     * @param task        The task that was added.
     * @param totalTasks  The total number of tasks after adding the new task.
     */
    public void displayTaskAdded(String task, int totalTasks) {
        System.out.println("Woof! successfully added: " + task);
        System.out.println("Woof! You have " + totalTasks + " tasks now.");
    }

    /**
     * Displays a message confirming that a task has been marked as done.
     *
     * @param task The task that was marked as done.
     */
    public void displayTaskMarked(String task) {
        System.out.println("Woof! Good Job on completing:\n" + task);
    }

    /**
     * Displays a message confirming that a task has been unmarked.
     *
     * @param task The task that was unmarked.
     */
    public void displayTaskUnmarked(String task) {
        System.out.println("Woof! Made a mistake? I have unmarked:\n" + task);
    }

    /**
     * Displays a message confirming that a task has been deleted.
     *
     * @param task        The task that was deleted.
     * @param totalTasks  The total number of tasks after deleting the task.
     */
    public void displayTaskDeleted(String task, int totalTasks) {
        System.out.println("Woof! Less Work! I have deleted:\n" + task);
        System.out.println("Woof! You have " + totalTasks + " tasks now.");
    }

    /**
     * Displays a message confirming that all tasks have been cleared.
     */
    public void displayTasksCleared() {
        System.out.println("Woof! You have cleared all tasks!");
    }

    /**
     * Displays a goodbye message when the application exits.
     */
    public void displayGoodbye() {
        System.out.println("""
                Woof! Thank you for using me!
                Hope to see you again soon!""");
    }

    /**
     * Closes the scanner used for reading user input.
     */
    public void close() {
        sc.close();
    }
}
