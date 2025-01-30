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

    public String getType() {
        return "event";
    }

    @Override
    public String print() {
        return String.format("E | %s | %s | %s", super.toString(), from, to);
    }
}
