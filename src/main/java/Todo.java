public class Todo extends Task {
    public Todo(String string) {
        super(string);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String print() {
        return String.format("T | %s", super.print());
    }
}
