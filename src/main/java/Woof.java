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
            boolean exceptionThrown = false;

            if (input.equals("bye")) {
                System.out.println("Aww byebye. Don't forget to come back soon");
                break;
            } else if (input.equals("list")) {
                System.out.println(taskList.print());
            } else if (input.startsWith("mark")) {
                String index = input.substring(5);
                try {
                    taskList.mark(index);
                } catch (MarkedErrorException e) {
                    System.out.println(e.getMessage());
                    exceptionThrown = true;
                }
                if (!exceptionThrown) {
                    System.out.println("Woof! Good Job on completing: \n" + taskList.get(index));
                }
            } else if (input.startsWith("unmark")) {
                String index = input.substring(7);
                try {
                    taskList.unmark(index);
                } catch (UnmarkedErrorException e) {
                    System.out.println(e.getMessage());
                    exceptionThrown = true;
                }
                if (!exceptionThrown) {
                    System.out.println("Woof! Made a mistake? I have unmarked: \n" + taskList.get(index));
                }
            } else {
                taskList.addTask(input);
                System.out.println("added: " + input);
            }
        }

        sc.close();
    }
}
