package woof.command;

import woof.ui.Ui;
import woof.task.TaskList;

public class AddDeadlineCommand extends Command {
    public AddDeadlineCommand(String[] inputs) {
        super(inputs);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws Exception {
        TaskList.addDeadline(inputs[0], inputs[1]);
        ui.displayTaskAdded(TaskList.getLast(), TaskList.size());
    }
}
