import java.util.Scanner;

public class Ui {
    private static final String DIVIDER = "____________________________________________________________";
    private final Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showLine() {
        System.out.println(DIVIDER);
    }

    public void showWelcome() {
        System.out.println("""
                Woof! Woof! I am your paw-sonsal chatbot!
                What can Woof do for you?"""
        );
    }

    public void showError(String error) {
        System.out.println(error);
    }

    public void displayTaskList() {
        System.out.println(TaskList.print());
    }

    public void displayTaskAdded(String task, int totalTasks) {
        System.out.println("Woof! successfully added: " + task);
        System.out.println("Woof! You have " + totalTasks + " tasks now.");
    }

    public void displayTaskMarked(String task) {
        System.out.println("Woof! Good Job on completing:\n" + task);
    }

    public void displayTaskUnmarked(String task) {
        System.out.println("Woof! Made a mistake? I have unmarked:\n" + task);
    }

    public void displayTaskDeleted(String task, int totalTasks) {
        System.out.println("Woof! Less Work! I have deleted:\n" + task);
        System.out.println("Woof! You have " + totalTasks + " tasks now.");
    }

    public void displayTasksCleared() {
        System.out.println("Woof! You have cleared all tasks!");
    }

    public void displayGoodbye() {
        System.out.println("""
                Woof! Thank you for using me!
                Hope to see you again soon!""");
    }

    public void close() {
        sc.close();
    }
}
