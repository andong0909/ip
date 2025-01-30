public class ListCommand extends Command {
    public ListCommand() {
        super();
    }

    public void execute(TaskList tasks, Ui ui) {
        ui.displayTaskList();
    }
}
