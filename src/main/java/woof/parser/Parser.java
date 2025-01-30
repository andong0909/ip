package woof.parser;

import woof.command.*;
import woof.task.TaskList;

public class Parser {
    public static Command parse(String input) throws Exception {
        input = input.trim();
        if (input.contains(" ")) {
            String[] parts = input.split(" ", 2);
            // MARK
            return switch (parts[0].toLowerCase()) {
                case "mark" -> parseMark(parts[1]);
                case "unmark" -> parseUnmark(parts[1]);
                case "delete" -> parseDelete(parts[1]);
                case "todo" -> parseCreateTodo(parts[1]);
                case "deadline" -> parseCreateDeadline(parts[1]);
                case "event" -> parseCreateEvent(parts[1]);
                default -> throw new IllegalArgumentException("woof woof woof?");
            };
        } else {
            if (input.equalsIgnoreCase("bye")) {
                return new ExitCommand();
            } else if (input.equalsIgnoreCase("list")) {
                return new ListCommand();
            } else if (input.equalsIgnoreCase("clear")) {
                return new ClearCommand();
            } else {
                throw new IllegalArgumentException("woof woof woof?");
            }
        }
    }

    public static Command parseCreateTodo(String description) throws Exception {
        description = description.trim();
        if (description.isEmpty()) {
            throw new IllegalArgumentException("WERWER! Content of todo cannot be empty!");
        }
        return new AddTodoCommand(new String[] { description });
    }

    public static Command parseCreateDeadline(String input) throws Exception {
        if (!input.contains("/by")) {
            throw new IllegalArgumentException("""
                WERWER! Something in deadline is missing!
                Follow this template woof: deadline (your task) /by (deadline)""");
        }
        String[] parts = input.split("/by");
        if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new IllegalArgumentException("""
                WERWER! Something in deadline is missing!
                Follow this template woof: deadline (your task) /by (deadline)""");
        }
        return new AddDeadlineCommand(parts);
    }

    public static Command parseCreateEvent(String input) throws Exception {
        if (!input.contains("/from") || !input.contains("/to")) {
            throw new IllegalArgumentException("""
                WERWER! Something in event is missing!
                Follow this template woof: event (your task) /from (start time) /to (end time)""");
        }
        String[] parts = input.split("/from|/to");
        if (parts.length != 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()
                || parts[2].trim().isEmpty()) {
            throw new IllegalArgumentException("""
                WERWER! Something in event is missing!
                Follow this template woof: event (your task) /from (start time) /to (end time)""");
        }
        return new AddEventCommand(parts);
    }

    public static Command parseMark(String index) throws Exception {
        validateInt(index);
        return new MarkCommand(new String[] { index });
    }

    public static Command parseUnmark(String index) throws Exception {
        validateInt(index);
        return new UnmarkCommand(new String[] { index });
    }

    public static Command parseDelete(String index) throws Exception {
        validateInt(index);
        return new DeleteCommand(new String[] { index });
    }

    public static void validateInt(String index) throws Exception {
        if (TaskList.size() == 0) {
            throw new IllegalStateException("WERWER! You have no tasks yet!");
        }
        index = index.trim();
        if (!isPositiveInteger(index)) {
            throw new NumberFormatException("WERWER! Make sure you have input a valid index!");
        }
        int i = Integer.parseInt(index);
        if (i > TaskList.size()) {
            throw new IndexOutOfBoundsException("WERWER! The index you have entered is too large!");
        }
    }

    private static boolean isPositiveInteger(String s) {
        return s.matches("\\d+") && Integer.parseInt(s) > 0;
    }
}
