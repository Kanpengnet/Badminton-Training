package kbu.sineepun.kanpengnet.badmintontraining;

/**
 * Created by Admin on 5/9/2016.
 */
public class MyConstance {
    //Explicit
    private String[] videoStrings = new String[]{"save",
            "save","save","save","save"};
    private String[] pointStrings = new String[]{"20", "10", "5", "0"};

    private int[] pointInts = new  int[5];

    public int[] getPointInts() {
        return pointInts;
    }

    public void setupPointInt(int intIndex,
                              int intPoint) {
        pointInts [intIndex] = intPoint;
    }

    public String[] getPointStrings() {
        return pointStrings;
    }

    public String[] getVideoStrings() {
        return videoStrings;
    }
}//main Class
