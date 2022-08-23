

public class Tester
{
     public static void main(String[] args) {
          T2 myT2 = new T2();  
     }                                 
}

class T1 {
     T1() {
          System.out.println("T1");
     }
}

class T2 extends T1 {
     T2() {
          //super(); 
          System.out.println("T2");
          T2.T3 inner = new T2.T3();
     }
     static class T3 {  
          T3() {
               System.out.println("T3");
          }
     }
}
