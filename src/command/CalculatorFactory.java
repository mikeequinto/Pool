package command;

public class CalculatorFactory {

    AbstractCalculator create(CommandType type){

        switch (type){
            case ADD : return new Adder();
            case MULT : return new Multiplier();
            default: throw new IllegalArgumentException("Unknown command type");
        }
    }
}
