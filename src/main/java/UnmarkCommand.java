public class UnmarkCommand extends Command {
    public UnmarkCommand(String[] inputs) {
        super(inputs);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws Exception {
        int index = Integer.parseInt(inputs[0]);
        TaskList.unmark(index);
        ui.displayTaskUnmarked(TaskList.get(index));
    }
}
