package Day4;

public class Day4 {

    public static void main(String[] args) {

        try {
            try {
                double ff = -10. / 0;
                System.out.println(ff + " " + (int) ff);
                int ii = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
                throw new Throwable();
            } finally {
                System.out.println("finally");
            }
        } catch (Throwable e) {
            System.out.println(e);
        }

    }

}
