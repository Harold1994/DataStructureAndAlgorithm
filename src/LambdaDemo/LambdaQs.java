package LambdaDemo;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;

interface Eatable{
    void tastes();
}

interface Flyable{
    void fly(String weather);
}

interface Addable{
    int add(int a, int b);
        }

public class LambdaQs {
    public void eat(Eatable e){
        System.out.println(e);
        e.tastes();
    }

    public void fly(Flyable f){
        System.out.println("正在驾驶: " + f);
        f.fly("[晴日]");
    }

    public void test(Addable add){
        System.out.println("5 + 3 = " + add.add(5,3));
    }

    public static void main(String[] args) {
        LambdaQs l = new LambdaQs();
        l.eat(() -> System.out.println("Apple"));
        l.fly((weather -> System.out.println("today the weathere is" + weather)));
        l.test((a,b) -> a+b);
    }

}
