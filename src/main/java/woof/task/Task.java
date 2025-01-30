package woof.task;

import woof.exception.MarkedErrorException;
import woof.exception.UnmarkedErrorException;

public class Task {
    private boolean isDone;
    private String task;

    public Task(String task) {
        this.task = task;
        this.isDone = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (isDone) {
            sb.append("X");
        } else {
            sb.append(" ");
        }
        sb.append("] ").append(task);
        return sb.toString();
    }

    public void markAsDone() throws MarkedErrorException {
        if (isDone) {
            throw new MarkedErrorException();
        }
        isDone = true;
    }

    public void unmarkAsDone() throws UnmarkedErrorException {
        if (!isDone) {
            throw new UnmarkedErrorException();
        }
        isDone = false;
    }

    public String print() {
        return String.format("%d | %s", isDone ? 1 : 0, task);
    };
}
