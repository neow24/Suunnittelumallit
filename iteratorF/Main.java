package iteratorF;

import java.math.BigInteger;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence s = new FibonacciSequence(10000);
        Iterator<BigInteger> i = s.iterator();
        while (i.hasNext()) System.out.println(i.next() + "\n");
        
        // s = new FibonacciSequence(100);
        // i = s.iterator();
        // while (i.hasNext()) System.out.println(i.next());
    }
}
