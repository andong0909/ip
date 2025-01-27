public class Event extends Task {
    private String from;
    private String to;

    public Event(String string, String from, String to) {
        super(string);
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
