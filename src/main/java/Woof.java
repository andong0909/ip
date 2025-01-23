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
                System.out.println(TaskList.print());
            } else if (input.startsWith("mark")) {
                String index = input.substring(5);
                try {
                    TaskList.mark(index);
                } catch (MarkedErrorException e) {
                    System.out.println(e.getMessage());
                    exceptionThrown = true;
                }
                if (!exceptionThrown) {
                    System.out.println("Woof! Good Job on completing:\n" + TaskList.get(index));
                }
            } else if (input.startsWith("unmark")) {
                String index = input.substring(7);
                try {
                    TaskList.unmark(index);
                } catch (UnmarkedErrorException e) {
                    System.out.println(e.getMessage());
                    exceptionThrown = true;
                }
                if (!exceptionThrown) {
                    System.out.println("Woof! Made a mistake? I have unmarked:\n" + TaskList.get(index));
                }
            } else if (input.startsWith("todo")) {
                TaskList.addTodo(input.substring(5).trim());
                System.out.println("Woof! successfully added: " + TaskList.getLast());
                System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
            } else if (input.startsWith("deadline")) {
                String[] parts = input.split("deadline|/by");
                TaskList.addDeadline(parts[1].trim(), parts[2].trim());
                System.out.println("Woof! successfully added: " + TaskList.getLast());
                System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
            } else if (input.startsWith("event")) {
                String[] parts = input.split("event|/from|/to");
                TaskList.addEvent(parts[1].trim(), parts[2].trim(), parts[3].trim());
                System.out.println("Woof! successfully added: " + TaskList.getLast());
                System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
            } else {
                System.out.println("blah blah blah");
            }
        }

        sc.close();
    }
}
