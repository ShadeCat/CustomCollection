import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {

    private int size;
    private final int startCapacity = 10;
    private final double overrideCapacityCoefficient = 1.5;

    private Object[] elementData = new Object[startCapacity];

    @Override
    public boolean add(final E e) {
        if (e == null) {
            throw new IllegalArgumentException("Не может быть пустое значение(?)");
        }
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * overrideCapacityCoefficient));
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = false;
        if (this.size == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public boolean contains(final Object o) {
        boolean isContains = false;
        for (int i = 0; i < this.size; i++) {
            if (this.elementData[i].equals(o)) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    @Override
    public Object[] toArray() {
        Object[] copiedArray = new Object[this.size];
        System.arraycopy(this.elementData, 0, copiedArray, 0, this.size);
        return copiedArray;
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        System.arraycopy(this.elementData, 0, a, 0, Math.min(a.length, this.size));
        return a;
    }

    @Override
    public boolean remove(final Object o) {
        boolean isRemoved = false;
        if (this.contains(o)) {
            for (int i = 0; i < this.size; i++) {
                if (!isRemoved) {
                    if (this.elementData[i].equals(o)) {
                        isRemoved = true;
                    }
                }
                if (isRemoved) {
                    this.elementData[i] = this.elementData[i + 1];
                }
            }
            this.size -= 1;
        }
        return isRemoved;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        boolean isAllFound = true;
        for (Object item : c) {
            isAllFound = this.contains(item);
        }
        return isAllFound;
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        boolean isAdd = true;
        for (E item : c) {
            isAdd = this.add(item);
        }
        return isAdd;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        boolean isRemoved = false;
        for (Object item : c) {
            while (this.contains(item)) {
                isRemoved = this.remove(item);
            }
        }
        return isRemoved;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        boolean isRemoved = false;
        MyCollection<Object> toRemove = new MyCollection<>();
        for (int i = 0; i < this.size; i++) {
            for (Object example : c) {
                if (example.equals(this.elementData[i])) {
                    toRemove.add(this.elementData[i]);
                    break;
                }
            }
        }
        if (toRemove.size > 0) {
            isRemoved = true;
            this.removeAll(toRemove);
        }

        return isRemoved;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    public void reverse() { //любителям на собесах заставлять переворачивать массив в блокноте посвящается
        for (int i = 0; i < this.size / 2; i++) {
            Object tmp = this.elementData[i];
            this.elementData[i] = this.elementData[this.size - i - 1];
            this.elementData[this.size - i - 1] = tmp;
        }
    }

    private class MyIterator<T> implements Iterator<T> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            return (T) elementData[cursor++];
        }

        @Override
        public void remove() {
            if (this.cursor == 0) {
                throw new IllegalStateException();
            } else {
                for (int i = cursor; i < size; i++) {
                    elementData[cursor] = elementData[cursor++];
                }
                size -= 1;
                this.cursor = -1;
            }
        }

    }
}
