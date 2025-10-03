package iterator;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);

        try {
            
            SimpleCollection ring = new Ring();
            ring.add(17);
            ring.add(3);
            ring.add(-2);
            ring.add(0);

            java.util.Iterator<Integer> iterator = ring.iterator();

            while (iterator.hasNext()) {
                System.out.println("In turn: " + iterator.next());
                if (s.nextLine().equals("q")) break;
            }
            
        } finally { s.close(); }
    }
}
