public class ChangeNumberToWord {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 14 == 0) {
                System.out.println("TwoSeven");
            } else if (i % 2 == 0) {
                System.out.println("Two");
            } else if (i % 7 == 0) {
                System.out.println("Seven");
            } else {
                System.out.println(i);
            }
        }
    }

}