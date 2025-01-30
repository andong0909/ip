package woof.command;

import woof.ui.Ui;
import woof.task.TaskList;

public class ExitCommand extends Command {
    public ExitCommand() {
        super();
    }

    public void execute(TaskList tasks, Ui ui) {
        ui.displayGoodbye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
