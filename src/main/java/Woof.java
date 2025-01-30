import java.util.Scanner;

public class Woof {
    private static enum Command {
        EXIT, LIST_ALL, MARK, UNMARK, REMOVE, CREATE_TODO, CREATE_DEADLINE, CREATE_EVENT
    }

    private Command parseCommand(String input) {
        input = input.trim();
        if (input.contains(" ")) {
            String[] parts = input.split(" ", 2);
            // MARK
            return switch (parts[0].toLowerCase()) {
                case "mark" -> Command.MARK;
                case "unmark" -> Command.UNMARK;
                case "delete" -> Command.REMOVE;
                case "todo" -> Command.CREATE_TODO;
                case "deadline" -> Command.CREATE_DEADLINE;
                case "event" -> Command.CREATE_EVENT;
                case "list" -> Command.LIST_ALL;
                default -> throw new IllegalArgumentException("woof woof woof?");
            };
        } else {
            if (input.equalsIgnoreCase("bye")) {
                return Command.EXIT;
            } else if (input.equalsIgnoreCase("list")) {
                return Command.LIST_ALL;
            } else {
                throw new IllegalArgumentException("woof woof woof?");
            }
        }
    }

    private static void greet() {
        System.out.println("""
                Woof! Woof! I am your paw-sonsal chatbot!
                What can Woof do for you?""");
    }

    private static void goodbye() {
        System.out.println("""
                Woof! Thank you for using me!
                Hope to see you again soon!""");
    }

    private static String[] validateArgs(Command c, String input) throws Exception {
        // LIST_ALL
        if (c == Command.LIST_ALL) {
            return new String[1];
        }
        String leftover = input.split(" ", 2)[1];
        switch (c) {
            case MARK:
                // fall over

            case UNMARK:
                // fall over

            case REMOVE:
                if (TaskList.size() == 0) {
                    throw new IllegalStateException("WERWER! You have no tasks yet!");
                }
                String index = leftover.trim();
                if (!isPositiveInteger(index)) {
                    throw new NumberFormatException("WERWER! Make sure you have input a valid index!");
                }
                int i = Integer.parseInt(index);
                if (i > TaskList.size()) {
                    throw new IndexOutOfBoundsException("WERWER! The index you have entered is too large!");
                }
                return new String[] { index };
            case CREATE_TODO:
                String description = leftover.trim();
                if (description.isEmpty()) {
                    throw new IllegalArgumentException("WERWER! Content of todo cannot be empty!");
                }
                return new String[] { description };

            case CREATE_DEADLINE:
                if (!input.contains("/by")) {
                    throw new IllegalArgumentException("""
                WERWER! Something in deadline is missing!
                Follow this template woof: deadline (your task) /by (deadline)""");
                }
                String[] parts = leftover.split("/by");
                if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                    throw new IllegalArgumentException("""
                WERWER! Something in deadline is missing!
                Follow this template woof: deadline (your task) /by (deadline)""");
                }
                return parts;

            case CREATE_EVENT:
                if (!input.contains("/from") || !input.contains("/to")) {
                    throw new IllegalArgumentException("""
                WERWER! Something in event is missing!
                Follow this template woof: event (your task) /from (start time) /to (end time)""");
                }
                parts = leftover.split("/from|/to");
                if (parts.length != 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()
                        || parts[2].trim().isEmpty()) {
                    throw new IllegalArgumentException("""
                WERWER! Something in event is missing!
                Follow this template woof: event (your task) /from (start time) /to (end time)""");
                }
                return parts;

            default:
                throw new IllegalArgumentException("woof woof woof?");
        }
    }

    private static void handleCommand(Command c, String[] splitInput) throws Exception {
        switch (c) {
            case LIST_ALL:
                System.out.println(TaskList.print());
                break;

            case MARK:
                int index = Integer.parseInt(splitInput[0]);
                TaskList.mark(index);
                System.out.println("Woof! Good Job on completing:\n" + TaskList.get(index));
                break;

            case UNMARK:
                index = Integer.parseInt(splitInput[0]);
                TaskList.unmark(index);
                System.out.println("Woof! Made a mistake? I have unmarked:\n" + TaskList.get(index));
                break;

            case REMOVE:
                index = Integer.parseInt(splitInput[0]);
                TaskList.delete(index);
                System.out.println("Woof! Less Work! I have deleted:\n" + TaskList.get(index));
                System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
                break;

            case CREATE_TODO:
                TaskList.addTodo(splitInput[0]);
                System.out.println("Woof! successfully added: " + TaskList.getLast());
                System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
                break;

            case CREATE_DEADLINE:
                TaskList.addDeadline(splitInput[0], splitInput[1]);
                System.out.println("Woof! successfully added: " + TaskList.getLast());
                System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
                break;

            case CREATE_EVENT:
                TaskList.addEvent(splitInput[0], splitInput[1], splitInput[2]);
                System.out.println("Woof! successfully added: " + TaskList.getLast());
                System.out.println("Woof! You have " + TaskList.size() + " tasks now.");
                break;
        }
    }

    private static boolean isPositiveInteger(String s) {
        return s.matches("\\d+") && Integer.parseInt(s) > 0;
    }

    public static void main(String[] args) {
        greet();
        Storage.loadTasks();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("bye")) {
            try {
                Command c = new Woof().parseCommand(input);
                handleCommand(c, validateArgs(c, input));
                Storage.saveTasks();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                input = sc.nextLine();
            }
        }

        goodbye();

        sc.close();
    }
}
