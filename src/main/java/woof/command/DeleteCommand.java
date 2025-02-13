package woof.command;

import woof.gui.Ui;
import woof.task.TaskList;

/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    public DeleteCommand(String[] inputs) {
        super(inputs);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws Exception {
        int index = this.parseIndex(inputs[0]);
        TaskList.delete(index);
        ui.displayTaskDeleted(TaskList.get(index), TaskList.size());
    }
}
