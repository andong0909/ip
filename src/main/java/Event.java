import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    public Event(String string, String from, String to) throws IllegalDateTimeException {
        super(string);
        try {
            this.from = LocalDateTime.parse(from, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            this.to = LocalDateTime.parse(to, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (DateTimeParseException e) {
            throw new IllegalDateTimeException("");
        }
    }

    public String toString() {
        return "[E]" + super.toString() + " (from: "
                + from.format(DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm")) + " to: "
                + to.format(DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm")) + ")";
    }

    @Override
    public String print() {
        return String.format("E | %s | %s | %s", super.print(),
                from.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                to.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}
