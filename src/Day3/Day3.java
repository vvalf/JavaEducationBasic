package Day3;

import java.lang.reflect.Method;

public class Day3 {

//*******   Метаклассы   *******
    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException {
        Class cl = Class.forName("Day3.NewAnnotationType");
        Method[] methods = cl.getDeclaredMethods();
        for (Method md : methods) {
            if (md.isAnnotationPresent(NewAnnotationType.class)) {
                System.out.println("Method " + md.getName() + " test status "
                        + md.getAnnotation(NewAnnotationType.class).value());
            } else {
                System.out.println("Method " + md.getName() + " has no test annotation");
            }
        }

        /*
//*******   Аннотации   *******
//        @NewAnnotationType public void m1(){System.out.println("Method ");}
        
//*******   Позднее связывание и виртуальные методы   *******
        P2 p2 = new C2();
        p2.print();
        p2.clone();

//*******   Очередность вызова конструктороа и иниацилизатора класса   *******
        C1 cc = new C1();
         */
    }
}

class P2 implements Cloneable {

//    @Deprecated
    void print() {
        System.out.println("P2 ");
    }

    P2() {
        print();
    }

    @Override
    protected P2 clone() throws CloneNotSupportedException {
        return (P2) super.clone();
    }

}

class C2 extends P2 {

    void print() {
        System.out.println("C2 ");
    }
}

//*******   Очередность вызова конструктороа и иниацилизатора класса   *******
class P1 {

    P1() {                                                         //конструктор
        System.out.println("P1 ");
    }
}

class C1 extends P1 {

    {
//        @Deprecated
        long startTime = System.nanoTime();
        System.out.println("I1 " + (System.nanoTime() - startTime));
        System.out.println("I1 " + (System.nanoTime() - startTime));
    }

//    @Deprecated
    long startTime = System.nanoTime();

    C1() {                                                         //конструктор
        System.out.println("C1 " + (System.nanoTime() - startTime));
    }

}
