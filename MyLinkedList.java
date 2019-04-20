package pavelGo;

public class MyLinkedList<T> implements MyList<T> {

    private Node firstNode;
    private Node lastNode;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            firstNode = new Node(null, null, value);
            lastNode = firstNode;
        } else if (size == 1) {
            lastNode = new Node(firstNode, null, value);
            firstNode.next = lastNode;
        } else {
            Node currentNode = new Node(lastNode, null, value);
            lastNode.next = currentNode;
            lastNode = currentNode;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index == 0) {
            Node currNode = new Node(null, firstNode, value);
            firstNode.prev = currNode;
            firstNode = currNode;

        } else if (index == 1) {
            Node currNode = new Node(firstNode, firstNode.next, value);
            firstNode.next = currNode;
            currNode.prev = currNode;
        } else if (index == size) {
            add(value);
            size--;
        } else {
            int i = 0;
            Node indexNode = firstNode;
            while (i != index) {
                indexNode = indexNode.next;
                i++;
            }
            Node currNode = new Node(indexNode.prev, indexNode, value);
            currNode.prev.next = currNode;
            currNode.next.prev = currNode;
        }
        size++;
    }

    @Override
    public void addAll(MyList<T> list) {
        MyLinkedList<T> linkedlist = (MyLinkedList<T>) list;
        this.lastNode.next = linkedlist.firstNode;
        linkedlist.firstNode.prev = this.lastNode;
        lastNode = linkedlist.lastNode;
        this.size += linkedlist.size;
    }

    @Override
    public T get(int index) {
        int i = 0;
        Node indexNode = firstNode;
        while (i != index) {
            indexNode = indexNode.next;
            i++;
        }
        return indexNode.value;
    }

    @Override
    public void set(T value, int index) {
        int i = 0;
        Node indexNode = firstNode;
        while (i != index) {
            indexNode = indexNode.next;
            i++;
        }
        indexNode.value = value;
    }

    @Override
    public T remove(int index) {
        int i = 0;
        Node indexNode = firstNode;
        while (i != index) {
            indexNode = indexNode.next;
            i++;
        }
        if (index == 0) {
            firstNode = indexNode.next;
            firstNode.prev = null;
            size--;
            return indexNode.value;
        } else if (index == (size - 1)) {
            lastNode = indexNode.prev;
            lastNode.next = null;
            size--;
            return indexNode.value;
        }
        indexNode.prev.next = indexNode.next;
        indexNode.next.prev = indexNode.prev;
        size--;
        return indexNode.value;
    }

    @Override
    public T remove(T t) {
        int i = 0;
        Node indexNode = firstNode;
        while (!(t.equals(indexNode.value))) {
            indexNode = indexNode.next;
            i++;
        }
        if (i == 0) {
            firstNode = indexNode.next;
            return indexNode.value;
        } else if (i == (size - 1)) {
            lastNode = indexNode.prev;
            indexNode.prev.next = null;
            return indexNode.value;
        }
        indexNode.prev.next = indexNode.next;
        indexNode.next.prev = indexNode.prev;
        size--;
        return indexNode.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
        lastNode = null;
    }

    @Override
    public String toString() {
        Node currentNode = firstNode;
        StringBuilder result = new StringBuilder(currentNode.value.toString());
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            result.append(", ").append(currentNode.value.toString());
        }
        return result.toString();
    }

    class Node {
        Node prev;
        Node next;
        T value;

        public Node(Node prev, Node next, T value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
