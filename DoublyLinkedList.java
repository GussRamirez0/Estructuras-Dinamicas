public class DoublyLinkedList<E> {
    private DoublyNode<E> head;
    private DoublyNode<E> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtBeginning(E data) {
        DoublyNode<E> newNode = new DoublyNode<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void insertAtEnd(E data) {
        DoublyNode<E> newNode = new DoublyNode<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public void insertAtPosition(E data, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Posición inválida");
        }
        if (position == 0) {
            insertAtBeginning(data);
        } else if (position == size) {
            insertAtEnd(data);
        } else {
            DoublyNode<E> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            DoublyNode<E> newNode = new DoublyNode<>(data);
            DoublyNode<E> nextNode = current.getNext();
            newNode.setNext(nextNode);
            newNode.setPrev(current);
            current.setNext(newNode);
            nextNode.setPrev(newNode);
            size++;
        }
    }

    public void traverseForward() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.print("Recorrido hacia adelante: ");
        DoublyNode<E> current = head;
        while (current != null) {
            System.out.print(current.getData() + " <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void traverseBackward() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.print("Recorrido hacia atrás: ");
        DoublyNode<E> current = tail;
        while (current != null) {
            System.out.print(current.getData() + " <-> ");
            current = current.getPrev();
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean searchByValue(E value) {
        DoublyNode<E> current = head;
        while (current != null) {
            if (current.getData().equals(value)) {
                System.out.println("Elemento " + value + " encontrado en la lista.");
                return true;
            }
            current = current.getNext();
        }
        System.out.println("Elemento " + value + " no encontrado en la lista.");
        return false;
    }

    public DoublyNode<E> searchByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango. La lista tiene " + size + " elementos.");
        }
        DoublyNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        System.out.println("Elemento en índice " + index + ": " + current.getData());
        return current;
    }

    public void deleteFromBeginning() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
        System.out.println("Elemento eliminado del inicio.");
    }

    public void deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
        System.out.println("Elemento eliminado del final.");
    }

    public void deleteFromPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Posición inválida");
        }
        if (position == 0) {
            deleteFromBeginning();
        } else if (position == size - 1) {
            deleteFromEnd();
        } else {
            DoublyNode<E> current = head;
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
            DoublyNode<E> prevNode = current.getPrev();
            DoublyNode<E> nextNode = current.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
            size--;
            System.out.println("Elemento en posición " + position + " eliminado.");
        }
    }

    public boolean deleteByValue(E value) {
        if (isEmpty()) {
            return false;
        }
        DoublyNode<E> current = head;
        while (current != null) {
            if (current.getData().equals(value)) {
                if (head == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.getNext();
                    head.setPrev(null);
                } else if (current == tail) {
                    tail = tail.getPrev();
                    tail.setNext(null);
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                size--;
                System.out.println("Elemento " + value + " eliminado.");
                return true;
            }
            current = current.getNext();
        }
        System.out.println("Elemento " + value + " no encontrado.");
        return false;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (DoublyNode<E> x = head; x != null; x = x.getNext()) {
            result[i++] = x.getData();
        }
        return result;
    }

    public void clear() {
        head = tail = null;
        size = 0;
        System.out.println("Lista vaciada.");
    }
}
