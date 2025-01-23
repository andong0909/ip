import java.util.Scanner;

public class Woof {
    private static TaskList taskList = new TaskList();
    public static void main(String[] args) {
        // Greeting
        System.out.println("""
                Woof! Woof! I am your paw-sonsal chatbot!
                What can Woof do for you?
                """);

        // Echo
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println("Aww byebye. Don't forget to come back soon");
                break;
            } else if (input.equals("list")) {
                System.out.println(taskList.print());
            } else {
                taskList.addTask(input);
                System.out.println("added: " + input);
            }
        }

        sc.close();
    }
}
