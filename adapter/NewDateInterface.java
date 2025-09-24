package adapter;

public interface NewDateInterface {
    int getDay();
    int getMonth();
    int getYear();
    void setDay(int day);
    void setMonth(int month);
    void setYear(int year);
    void advanceDays(int days);
}
