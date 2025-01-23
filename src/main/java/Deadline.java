public class Deadline extends Task {
    private String deadline;

    public Deadline(String string, String deadline) {
        super(string);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}
