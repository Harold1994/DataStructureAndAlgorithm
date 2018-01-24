package LambdaDemo;

interface Displayable{
    void display();
    default int add(int a, int b){
        return a+b;
    }
}
public class LambdaAndInner {
    private int age = 12;
    private static String name = "GAROLD";
    public void test(){
        String book = "123";
        Displayable dis = ()->{
           System.out.println("book field var is :" + book);
            System.out.println("book age var is :" + age);

            System.out.println("book name var is :" + name);
        };
        dis.display();

    }

    public static void main(String[] args) {
        LambdaAndInner lambdaAndInner  = new LambdaAndInner();
        lambdaAndInner.test();
    }
}
