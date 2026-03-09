public class DoublyNode<E> {
    private E data;
    private DoublyNode<E> next;
    private DoublyNode<E> prev;

    public DoublyNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DoublyNode<E> getNext() {
        return next;
    }

    public void setNext(DoublyNode<E> next) {
        this.next = next;
    }

    public DoublyNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DoublyNode<E> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
