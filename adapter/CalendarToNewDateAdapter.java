package adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    private Calendar calendar;

    public CalendarToNewDateAdapter(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    @Override public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month - 1);
    }

    @Override public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
        // this.day = calendar.get(Calendar.DAY_OF_MONTH);
        // this.month = calendar.get(Calendar.MONTH) + 1;
        // this.year = calendar.get(Calendar.YEAR);
    }

    @Override public String toString() {
        return getYear() + "." + getMonth() + "." + getDay();
    }
}
