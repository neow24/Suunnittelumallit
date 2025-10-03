package iterator;

public class RingIterator implements java.util.Iterator<Integer> {
    private Node current;

    public RingIterator(Ring ring) {
        this.current = ring.getHead();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        int data = current.getData();
        current = current.getNext();
        return data;
    }
}
