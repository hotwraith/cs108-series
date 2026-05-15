package serie7;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractSubject implements Subject {
    private Observer[] observers;

    @Override
    public void addObserver(Observer o) {
        if (observers == null) {
            observers = new Observer[]{o};
        } else {
            observers = Arrays.copyOf(observers, observers.length + 1);
        }
    }

    @Override
    public void deleteObserver(Observer o) {
        ArrayList<Observer> temp = new ArrayList<>();
        for(Observer observer : observers) {
            if (!observer.equals(o)) {
                temp.add(observer);
            }
        }
        observers = temp.toArray(new Observer[0]);
    }

    public void notifyAllObservers() {
        if(observers != null) {
            for (Observer observer : observers) {
                observer.newValue();
            }
        }
    }
}
