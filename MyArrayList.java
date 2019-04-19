package pavelGo;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private T[] arr;
    private int size;

    public MyArrayList() {
        arr = (T[]) new Object[size];
    }

    public MyArrayList(T[] arr) {
        this.arr = arr;
        size = arr.length;
    }

    @Override
    public void add(T value) {
        if (size < arr.length) {
            arr[size] = value;
        } else {
            T[] newArr;
            if (size == 0) {
                newArr = (T[]) new Object[1];
            } else {
                newArr = (T[]) new Object[arr.length * 2];
            }
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            newArr[size] = value;
            arr = newArr;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index == (size - 1)) {
            add(value);
        } else {
            int sizeArr;
            if (size < arr.length) {
                sizeArr = this.arr.length;
            } else {
                sizeArr = this.size * 2;
            }
            if (size == 0) {
                sizeArr = 1;
            }
            T[] newArr = (T[]) new Object[sizeArr];
            int element = 0;
            for (int i = 0; i < this.size + 1; i++) {
                if (i == index) {
                    newArr[i] = value;
                } else {
                    newArr[i] = arr[element];
                    element++;
                }
            }
            size++;
            arr = Arrays.copyOf(newArr, newArr.length);
        }
    }


    @Override
    public void addAll(MyList list) {
        if (list.size() == 1) {
            add((T) list.get(0));
        } else if (list.size() != 0) {
            int sizeArr = this.size + list.size();
            int element = 0;
            if (sizeArr < arr.length) {
                for (int i = arr.length - 1; i < sizeArr; i++) {
                    arr[i] = (T) list.get(element);
                    element++;
                }
            } else {
                T[] newArr = (T[]) new Object[sizeArr];
                for (int i = 0; i < arr.length; i++) {
                    newArr[element] = arr[i];
                    element++;
                }
                for (int i = 0; i < list.size(); i++) {
                    newArr[element] = (T) list.get(i);
                    element++;
                }
                arr = newArr;
            }
            size = sizeArr;
        }
    }

    @Override
    public T get(int index) {
        return arr[index];
    }

    @Override
    public void set(T value, int index) {
        this.arr[index] = value;
    }

    @Override
    public T remove(int index) {
        if (index != (size)) {
            T[] newArr = (T[]) new Object[size];
            int element = 0;
            for (int i = 0; i < this.size; i++) {
                if (i != index) {
                    newArr[element] = arr[i];
                    element++;
                }
            }
            size--;
            arr = newArr;
        }
        return arr[index];
    }

    @Override
    public T remove(T value) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (value.equals(arr[i])) {
                index = i;
                break;
            }
        }
        return remove(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        arr = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        try {
            result.append(arr[0].toString());
            for (int i = 1; i < size; i++) {
                result.append(", ").append(arr[i]);
            }
        } catch (Exception e) {
        }
        return result.toString();
    }

}
