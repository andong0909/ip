package woof.command;

import woof.ui.Ui;
import woof.task.TaskList;

public class ListCommand extends Command {
    public ListCommand() {
        super();
    }

    public void execute(TaskList tasks, Ui ui) {
        ui.displayTaskList();
    }
}
