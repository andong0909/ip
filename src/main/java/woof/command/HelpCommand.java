package woof.command;

import woof.gui.Ui;
import woof.task.TaskList;

public class HelpCommand extends Command {
    public HelpCommand() {
        super();
    }

    public void execute(TaskList tasks, Ui ui) {
        ui.displayHelp();
    }
}
