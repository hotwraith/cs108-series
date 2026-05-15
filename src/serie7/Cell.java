package serie7;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public final class Cell extends AbstractSubject implements Observer {
    private static final String COLUMN_NAME = "ABCDEFGHI";
    private final int column, row;

    private String contentString;
    private List<Cell> arguments;
    private IntBinaryOperator operator;
    private int value;

    public Cell(int column, int row, int initialValue) {
        this.column = column;
        this.row = row;
        this.contentString = String.valueOf(initialValue);
        this.arguments = List.of();
        this.operator = (x, y) -> initialValue;
        this.value = initialValue;
        subscribe(arguments);
        notifyAllObservers();
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getName() {
        return String.valueOf(COLUMN_NAME.charAt(column)) + (row + 1);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        value = newValue;
        notifyAllObservers();
    }

    public String getFormulaString() {
        return contentString;
    }

    public void setFormula(String newContentString,
                           List<Cell> newArguments,
                           IntBinaryOperator newOperator) {
        contentString = newContentString;
        arguments = newArguments;
        operator = newOperator;
        subscribe(newArguments);
        updateContent();
    }

    private void updateContent() {
        int arg0 = arguments.size() > 0 ? arguments.get(0).getValue() : 0;
        int arg1 = arguments.size() > 1 ? arguments.get(1).getValue() : 0;

        setValue(operator.applyAsInt(arg0, arg1));
    }

    private void subscribe(List<Cell> newArguments) {
        for(Cell cell : arguments) {
            cell.deleteObserver(this);
        }
        this.arguments = newArguments;
        for(Cell cell : newArguments) {
            if((this.observers != null && this.observers.length > 0) && Arrays.asList(this.observers).contains(cell)) {
                setError();
                setValue(0);
                arguments = List.of();
                operator = (x, y) -> 0;
                this.observers = new Observer[]{observers[0]};
                cell.setError();
                cell.setValue(0);
                cell.arguments = List.of();
                cell.operator = operator;
                cell.observers = new Observer[]{cell.observers[0]};
                break;
            } else {
                cell.addObserver(this);
            }
        }
    }

    public void setError() {
        contentString = "#ERROR#";
    }

    public boolean isError() {
        return String.valueOf(contentString).equals("#ERROR#");
    }

    @Override
    public void newValue() {
        updateContent();
    }
}
