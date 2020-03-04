package Day1;

public class Day1 {
    public static void main(String[] args) {

//        main6();          //Пример свича
//        main5();          //Перегрузка
//        isPositive(6);    //Больше нуля
//        main1();          //ПринтЛн
//        main0();          //Числа с подчеркиванием



    }

//*******   Свич   *******
    public enum Day { Mon, Tue, Wed, Thu, Fri, Sat, Sun, }

    public static void main6() {
        a:for(Day d:Day.values()){
            b:switch (d){
                case Thu:
                   break a;
        default:
            System.out.println(d);
            while(true){
                break;
                }
            }
        }
}
    
//*******   Перегрузка   *******
    public static void main5() {
//        varArg();
//        varArg("один");
//        varArg("один", "два");
        intArg(1);
        intArg(2, 3);
        intArg(2, 3, 4);
        intArg(2, 3, 4, 5);
    }

    static void varArg(String... s) {
        System.out.println(s.getClass().getName());
        
        for (String arg : s) {
            System.out.println(arg);
        }
    }
    static void intArg(int... s) {
        System.out.println(s.getClass().getName());

        for (int arg : s) {
            System.out.println(arg);
        }
    }

//*******   Больше нуля   *******
    public static boolean isPositive(int arg) {
        boolean bi = arg > 0;
        return bi;
    }
    
//*******   Список   символов *******
    public static void printChar(int srt) {
        for (int i = srt; i < srt + 30; i++) {
            System.out.println(i + "" + (char) 9 + (char) i);
        }
//        int i = 0;
//        int b = 1;
//        i += b;
//        System.out.println(i);
    }

//*******   ПринтЛн   *******
    public static void main1() {
        System.out.println();
        Day1 instance = new Day1();
        instance.mi();
        Day1.ms();
        instance.xmi();
//        System.out.println((String) null);
//        System.out.println("" + null);
    }

    static void ms() {
        System.out.println("MS");
    }

    void xmi() {
        mi();
    }

    void mi() {
        System.out.println("MI");
    }


//1*******  Числа с подчеркиванием *******
    void main0() {
        System.out.println("Привет " + 12_______333_333_333L);
    }
}