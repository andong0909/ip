package woof.command;

import woof.ui.Ui;
import woof.task.TaskList;

public class AddTodoCommand extends Command {
    public AddTodoCommand(String[] inputs) {
        super(inputs);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        TaskList.addTodo(inputs[0]);
        ui.displayTaskAdded(TaskList.getLast(), TaskList.size());
    }
}
