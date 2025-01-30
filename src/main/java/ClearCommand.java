public class ClearCommand extends Command {
    public ClearCommand() {
        super();
    }

    public void execute(TaskList tasks, Ui ui) {
        TaskList.clear();
        ui.displayTasksCleared();
    }
}
