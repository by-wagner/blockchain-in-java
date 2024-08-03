import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Originator {
    private int[][] array;

    public Originator(int[][] array) {
        this.array = deepCopy(array);
    }

    public void setNumber(int position, int number) {
        array[position / array[0].length][position % array[0].length] = number;
    }

    public int[][] getArray() {
        return deepCopy(array);
    }

    public Memento getMemento() {
        return new Memento(deepCopy(array));
    }

    public void setMemento(Memento memento) {
        this.array = deepCopy(memento.getArray());
    }

    private int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    static class Memento {
        private final int[][] array;

        public Memento(int[][] array) {
            this.array = array;
        }

        private int[][] getArray() {
            return array;
        }
    }
}

class Caretaker {
    private final Originator originator;
    private Originator.Memento snapshot = null;

    public Caretaker(Originator originator) {
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