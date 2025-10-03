package iteratorF;

import java.math.BigInteger;

public class FibonacciIterator implements java.util.Iterator<BigInteger> {
    private final FibonacciSequence sequence;
    private int remaining;
    private BigInteger prev = new BigInteger("0");
    private BigInteger curr = new BigInteger("1");

    public FibonacciIterator(FibonacciSequence sequence, int maxElements) {
        this.sequence = sequence;
        this.remaining = maxElements;
    }

    @Override
    public boolean hasNext() {
        return remaining != 0;
    }

    @Override
    public BigInteger next() {
        BigInteger nextPrev = curr;
        BigInteger nextCurr = sequence.computeNext(prev, curr);
        prev = curr;
        curr = nextCurr;
        remaining--;
        return nextPrev;
    }
}
