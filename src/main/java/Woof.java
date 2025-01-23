import java.util.Scanner;

public class Woof {
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
                System.out.println("Aww byebye. Don't forget to come back soon!");
                break;

            } else if (input.equals("list")) {
                System.out.println(TaskList.print());

            } else if (input.startsWith("mark")) {
                try {
                    if (TaskList.size() == 0) {
                        throw new IllegalStateException("WERWER! You have no tasks yet!");
                    }

                    if (input.trim().length() < 5) {
                        throw new IllegalArgumentException(
                                "WERWER! You must input the index of the task you want to mark!");
                    }

                    String index = input.substring(5).trim();
                    if (index.isEmpty()) {
                        throw new IllegalArgumentException(
                                "WERWER! You must input the index of the task you want to mark!");
                    }

                    int i = Integer.parseInt(index);
                    if (i < 0 || i > TaskList.size()) {
                        throw new IndexOutOfBoundsException("WERWER! The index you have entered is out of bounds!");
                    }

                    TaskList.mark(index);
                    System.out.println("Woof! Good Job on completing:\n" + TaskList.get(index));

                } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException
                         | MarkedErrorException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input.startsWith("unmark")) {
                try {
                    if (TaskList.size() == 0) {
                        throw new IllegalStateException("WERWER! You have no tasks yet!");
                    }

                    if (input.trim().length() < 5) {
                        throw new IllegalArgumentException(
                                "WERWER! You must input the index of the task you want to unmark!");
                    }

                    String index = input.substring(7).trim();
                    if (index.isEmpty()) {
                        throw new IllegalArgumentException(
                                "WERWER! You must input the index of the task you want to unmark!");
                    }

                    int i = Integer.parseInt(index);
                    if (i < 0 || i > TaskList.size()) {
                        throw new IndexOutOfBoundsException("WERWER! The index you have entered is out of bounds!");
                    }

                    TaskList.unmark(index);
                    System.out.println("Woof! Made a mistake? I have unmarked:\n" + TaskList.get(index));

                } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException
                         | UnmarkedErrorException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input.startsWith("delete")) {
                try {
                    if (TaskList.size() == 0) {
                        throw new IllegalStateException("WERWER! You have no tasks yet!");
                    }

                    if (input.trim().length() < 5) {
                        throw new IllegalArgumentException(
                                "WERWER! You must input the index of the task you want to unmark!");
                    }

                    String index = input.substring(7).trim();
                    if (index.isEmpty()) {
                        throw new IllegalArgumentException(
                                "WERWER! You must input the index of the task you want to unmark!");
                    }

                    int i = Integer.parseInt(index);
                    if (i < 0 || i > TaskList.size()) {
                        throw new IndexOutOfBoundsException("WERWER! The index you have entered is out of bounds!");
                    }

                    TaskList.delete(index);
                    System.out.println("Woof! Less Work! I have deleted:\n" + TaskList.get(index));
                    System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
                } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input.startsWith("todo")) {
                if (input.trim().length() < 5) {
                    System.out.println("WERWER! Content of todo cannot be empty!");
                } else {
                    TaskList.addTodo(input.substring(5).trim());
                    System.out.println("Woof! successfully added: " + TaskList.getLast());
                    System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
                }

            } else if (input.startsWith("deadline")) {
                String[] parts = input.split("deadline|/by");
                if (parts.length < 3) {
                    System.out.println("""
                WERWER! Something in deadline is missing!
                Follow this template woof: deadline (your task) /by (deadline)
                """);
                } else {
                    TaskList.addDeadline(parts[1].trim(), parts[2].trim());
                    System.out.println("Woof! successfully added: " + TaskList.getLast());
                    System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
                }

            } else if (input.startsWith("event")) {
                String[] parts = input.split("event|/from|/to");
                if (parts.length < 4) {
                    System.out.println("""
                WERWER! Something in event is missing!
                Follow this template woof: event (your task) /from (start time) /to (end time)
                """);
                } else {
                    TaskList.addEvent(parts[1].trim(), parts[2].trim(), parts[3].trim());
                    System.out.println("Woof! successfully added: " + TaskList.getLast());
                    System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
                }

            } else {
                System.out.println("woof woof woof?");

            }
        }

        sc.close();
    }
}
