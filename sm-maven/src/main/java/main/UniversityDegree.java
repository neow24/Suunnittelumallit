package main;

public class UniversityDegree {

    public static int lorem(String s) {
        if (s == null) throw new NullPointerException();

        // if (s == "BSc") {
        //     return 4;
        // } else if (s == "MSc") {
        //     return 6;
        // } else if (s == "PhD") {
        //     return 3;
        // } else {
        //     return -1;
        // }

        switch (s) {
            case "BSc": return  4;
            case "MSc": return  6;
            case "PhD": return  3;
            default:    return -1;
        }
    }

    public static void main(String[] args) {
        // new lorem().lorem(null);
        System.out.println(lorem("BSc"));
        System.out.println(lorem("MSc"));
        System.out.println(lorem("PhD"));
        System.out.println(lorem("ipsum"));
    }
}
