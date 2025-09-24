package adapter;

public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter adapter = new CalendarToNewDateAdapter(
            java.util.Calendar.getInstance());

        System.out.println(adapter);

        adapter.setDay(15);
        adapter.setMonth(8);
        adapter.setYear(2022);

        System.out.println(adapter);

        adapter.advanceDays(10);

        System.out.println(adapter);
        
        adapter.advanceDays(500);

        System.out.println(adapter);
    }
}
