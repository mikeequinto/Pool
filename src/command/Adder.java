package command;

public class Adder extends AbstractCalculator{

    @Override
    public Integer calculate(Integer arg1, Integer arg2) {
        return arg1 + arg2;
    }
}
