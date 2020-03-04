package Day2;

import java.util.*;
import java.util.regex.*;

public class Day2 {
    public static void main(String[] args) {

      regExp();  
        
        
        
        
/*
// ***********   Из сканнера   ***************
        Day2.fromScanner();

// ***********  Про стринг   ***************
        Day2.aboutString();

// ***********  Двумерный массив   ***************
        int aa[][] = {{21,22,23},{24,25},{}};
        aa[2] = new int[]{29,28,21,27,};
        jaggetArray(aa);
        
// ***********   Циклы   ***************
        int ii[]={11, 12, 13, 14, 15};
        cycleExmpl(ii);
*/
    }
    
    
    public static void regExp() {
        // TODO code application logic here
        Pattern pattern = Pattern.compile("[0-9]{3}");    
        Matcher matcher = pattern.matcher("Это строка 123 и число 321");   
        while (matcher.find()) {    
            System.out.println("I found( "+matcher.group()+" )starting at "+    
            matcher.start()+" and ending at "+matcher.end());    
        }
    }    
    
// ***********   Из сканнера   ***************
    public static void fromScanner() {
        Scanner scanner = new Scanner(System.in, "CP1251");  
        while (scanner.hasNext())
            if (scanner.hasNextInt()){
               System.out.println("Integer " + scanner.nextInt() ); 
            } else if (scanner.hasNextBoolean() ){
                System.out.println("Boolean " + scanner.nextBoolean() );
                break;
            }else
                System.out.println(">" + scanner.next());
        scanner.close();
    }
    
// ***********   Про стринг   ***************
    public static void aboutString() {
        System.out.println("New" == "New");             //true
        System.out.println("New" == new String("New")); //false
        
        System.out.println("\n**********        ***********\n");

        // Вариант 1 
        String str1 = "New1";
        for (int i = 0; i < str1.length(); i++) {
            System.out.println(str1.charAt(i));
        }
        
        System.out.println("\n**********        ***********\n");
        
        // Вариант 2
        String str2 = "New2";
        char str3[] = str2.toCharArray();
        Arrays.sort(str3);
        
        for (int i = 0; i < str3.length; i++) {
            System.out.println(str3[i]);
        }
        
        System.out.println("\n**********        ***********\n");

        for (char i : str2.toCharArray()) {
            System.out.println(i);
        }

    }

    
// ***********   Двумерный массив   ***************
    public static void jaggetArray(int aa[][]) {
        System.out.println("Type: " + aa.getClass().getName());
        
        Arrays.parallelSort(aa[2]);
        for(int a[]: aa){
            for(int ii : a)
              System.out.print(ii + " ");
            System.out.println();
        }
    }

// ***********   Циклы   ***************
    public static void cycleExmpl(int[] ii) {
        a:while(true){
            do{
                for(;;){
                    for(var jj:ii)
                         System.out.println(jj);
                    break a;
                }
            }while(true);
        }
    }  
}
