package woof.command;

import woof.ui.Ui;
import woof.task.TaskList;

public class MarkCommand extends Command {
    public MarkCommand(String[] inputs) {
        super(inputs);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws Exception {
        int index = Integer.parseInt(inputs[0]);
        TaskList.mark(index);
        ui.displayTaskMarked(TaskList.get(index));
    }
}
