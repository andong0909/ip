package woof.command;

import woof.ui.Ui;
import woof.task.TaskList;

public class AddEventCommand extends Command {
    public AddEventCommand(String[] inputs) {
        super(inputs);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws Exception {
        TaskList.addEvent(inputs[0], inputs[1], inputs[2]);
        ui.displayTaskAdded(TaskList.getLast(), TaskList.size());
    }
}
