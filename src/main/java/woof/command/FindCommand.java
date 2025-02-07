package woof.command;

import woof.gui.Ui;
import woof.task.TaskList;

public class FindCommand extends Command {
    public FindCommand(String[] inputs) {
        super(inputs);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws Exception {
        ui.displayFind(TaskList.find(inputs[0]));

    }
}
