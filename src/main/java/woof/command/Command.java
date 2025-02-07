package woof.command;

import woof.gui.Ui;
import woof.task.TaskList;

public abstract class Command {
    protected final String[] inputs;

    public Command(String[] inputs) {
        this.inputs = inputs;
    }

    public Command() {
        this.inputs = new String[0];
    }

    public abstract void execute(TaskList tasks, Ui ui) throws Exception;

    public boolean isExit() {
        return false;
    }
}
