import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Originator {
    private List<Integer> numbers = new ArrayList<>();

    public void addNumber(Integer number) {
        numbers.add(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static class Memento {
        private final List<Integer> state;

        private Memento(List<Integer> state) {
            this.state = new ArrayList<>(state);
        }

        private List<Integer> getState() {
            return state;
        }
    }

    public Memento getMemento() {
        return new Memento(numbers);
    }

    public void setMemento(Memento memento) {
        numbers = new ArrayList<>(memento.getState());
    }
}

class Caretaker {
    private final Originator originator;
    private Originator.Memento snapshot = null;

    Caretaker(Originator originator) {
        this.originator = originator;
    }

    public void save() {
        snapshot = originator.getMemento();
    }

    public void restore() {
        if (snapshot != null) {
            originator.setMemento(snapshot);
        }
    }
}