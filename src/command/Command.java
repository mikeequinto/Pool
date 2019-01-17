package command;

public class Command {

    private CommandType operation;
    private int arg1;
    private int arg2;

    public Command(CommandType operation, int arg1, int arg2) {
        this.operation = operation;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public CommandType getOperation() {
        return operation;
    }

    public void setOperation(CommandType operation) {
        this.operation = operation;
    }

    public int getArg1() {
        return arg1;
    }

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public int getArg2() {
        return arg2;
    }

    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }

    @Override
    public String toString() {
        return "Command{" +
                "operation=" + operation +
                ", arg1=" + arg1 +
                ", arg2=" + arg2 +
                '}';
    }
}
