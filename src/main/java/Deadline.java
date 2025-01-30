import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDate deadline;

    public Deadline(String string, String deadline) throws IllegalDateException {
        super(string);
        try {
            this.deadline = LocalDate.parse(deadline);
        } catch (DateTimeParseException e) {
            throw new IllegalDateException("");
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: "
                + deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    public String getType() {
        return "deadline";
    }

    @Override
    public String print() {
        return String.format("D | %s | %s", super.print(),
                deadline.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
