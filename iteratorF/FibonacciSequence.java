package iteratorF;

import java.math.BigInteger;

public class FibonacciSequence implements Sequence {
    private final int maxElements;

    public FibonacciSequence(int maxElements) {
        this.maxElements = maxElements;
    }

    BigInteger computeNext(BigInteger previous, BigInteger current) {
        return previous.add(current);
    }

    @Override
    public java.util.Iterator<BigInteger> iterator() {
        return new FibonacciIterator(this, maxElements);
    }
}
