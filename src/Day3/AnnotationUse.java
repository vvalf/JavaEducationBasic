/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

/**
 *
 * @author Student1
 */
public class AnnotationUse {
    
    @NewAnnotationType public void m1(){System.out.println("Method ");}
    @NewAnnotationType(value=true)public void m2(){}
    @NewAnnotationType(true)public static void m3(){}


    @Todo public void m4(){}
}

