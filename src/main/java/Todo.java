public class Todo extends Task {
    public Todo(String string) {
        super(string);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String getType() {
        return "todo";
    }

    @Override
    public String print() {
        return String.format("T | %s", super.print());
    }
}
