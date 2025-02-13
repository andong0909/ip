package woof.command;

import woof.gui.Ui;
import woof.task.TaskList;

/**
 * Represents a command to exit the program.
 */
public class ExitCommand extends Command {
    public ExitCommand() {
        super();
    }

    public void execute(TaskList tasks, Ui ui) {
        ui.displayGoodbye();
    }
}
