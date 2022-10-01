package baseball.model;

public class Game {
    private Status status;
    private Computer computer;

    public Game(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public enum Status {
        PLAYING, EXIT, INIT, END
    }
}
