package Packgae_Day10;

/**
 * @Author 王嗣鑫
 * @Date 2020/8/7 1:37
 * @Version 1.0
 */
import javax.swing.*;
import java.util.ArrayList;

/**
 类说明文档
 @author wangsixin
 @version 1.0
 */

//父类(抽象类)
abstract class Human{

    String name;
    int age;

    int chan = 100;

    Human(){
        System.out.println("父类无参构造函数被调用");
    }

    Human(int age, String name){
        this.age = age;
        this.name = name;
    }

    public static void Drink(){
        System.out.println("在喝水");
    }

    //抽象方法
    public abstract void Study();

}

//子类
class Student extends Human {

    String SchoolNum;

    static int chan = 200;

    //	super关键字调用父类有参数构造函数
    Student(int age, String name){
        super(age,name);
    }

    public static void Drink(){
        System.out.println("在喝饮料");
    }


    //重写抽象函数
    public void Study(){
        System.out.println(this.age + "岁的" + this.name + "在背古诗");
    }
}

abstract class Figure{

    String name; //图形名称

    public Figure(String name){
        this.name = name;
    }

    public abstract void getArea(); //计算面积抽象函数
    public abstract void getLength(); //计算周长抽象函数

}

class Circle extends Figure {
    double r; //半径
    public static final double PI = 3.14; //不能被改写的常量

    public Circle(String name, double r){
        super(name);
        this.r = r;
    }

    //重写抽象函数
    public void getArea(){
        System.out.println(name + "的面积为: " + PI*r*r);
    }

    public void getLength(){
        System.out.println(name + "的周长为: " + PI*r*2);
    }

    //特有方法
    public void Angle(){
        System.out.println(name + "角度为360度");
    }

}

class Rectangle extends Figure {
    double h; //长
    double w; //宽

    public Rectangle(String name, double h, double w){
        super(name);
        this.h = h;
        this.w = w;
    }

    //重写抽象函数
    public void getArea(){
        System.out.println(name + "的面积为: " + h*w);
    }

    public void getLength(){
        System.out.println(name + "的周长为: " + (h+w)*2);
    }

    //特有方法
    public void LengthNum(){
        System.out.println(name + "有4条边");
    }
}

//成员内部类
class Outer{
    int i = 10;

    //成员内部类
    class Inter{
        int i = 100;

        void Print(){
            System.out.println("Inter i = " + i); //同名成员变量，默认访问内部类成员变量
            System.out.println("Outer i = " + Outer.this.i); //强制访问外部类的方式
        }
    }

    //非静态成员内部类
    static class Inter1{
        static int i = 100;

        void Print(){
            System.out.println("打印 = " + i);
        }
    }

    void test(){

        //局部内部类
        class InterP{
            void print(){
                System.out.println("调用局部类方法");
            }

        }


        //非静态局部内部类的使用方式
        InterP p1 = new InterP();
        p1.print();

    }
}

//继承关系匿名内部类

abstract class Animal{
    public abstract Animal run();
    public abstract void sleep();
}

class Dog{

    String name;

    Dog(String name){
        this.name = name;
    }

    public void print(){
        //需求：继承Animal类，调用run方法
        new Animal(){ //匿名内部类(继承Animal并重写run、sleep方法)

            public Animal run(){
                System.out.println(name + "在跑！！！");
                return this;
            }

            public void sleep(){
                System.out.println(name + "在睡觉！！！");
            }

            public void bite(){
                System.out.println(name + "在咬人！！！");
            }

        }.run().sleep(); //访问两个方法的第一种形式，第一个方法返回父类，然后第二个方法接着访问




        //访问两个方法的第二种形式，根据多态思想，用父类变量接收匿名内部类
        Animal a = new Animal(){ //匿名内部类(继承Animal并重写run、sleep方法)

            public Animal run(){
                System.out.println(name + "在跑！！！");
                return this;
            }

            public void sleep(){
                System.out.println(name + "在睡觉！！！");
            }

            public void bite(){
                System.out.println(name + "在咬人！！！");
            }

        };
        a.run();
        a.sleep();

    }
}

//实现关系匿名内部类
interface Dao{
    public void add();
}

class Manage{

    public void print(){

        //创建匿名接口实现类对象
        new Dao(){
            //实现接口定义的方法
            public void add(){
                System.out.println("添加成功!!!!");
            }

        }.add();
    }

}

public class Test10{

    /**
     main说明文档
     */

    public static void main(String[] args) throws Exception{

        System.out.println("\n======多态======\n");

        Human h = new Student(12,"多多"); //父类引用变量指向子类对象

        System.out.println("chan = " + h.chan); //显示父类成员变量的值

        h.Drink(); //非静态成员函数，访问子类，静态成员函数，访问父类

        h.Study(); //父类中的抽象方法，则访问子类重写方法

        System.out.println("\n======多态应用：一个函数打印圆形与矩形的周长与面积======\n");

        Figure c = new Circle("圆形",2.5);

        Figure r = new Rectangle("矩形",5,8);

        printFig(c);

        printFig(r);

        System.out.println("\n======多态应用：一个函数返回多个类型图形======\n");

        Figure f = getFig(0);
        f.getLength();
        f.getArea();

        Figure f1 = getFig(1);
        f1.getLength();
        f1.getArea();

        System.out.println("\n======多态应用：通过强制类型转换，访问子类特有方法======\n");

        getSpecial(c);

        getSpecial(r);

        System.out.println("\n======成员内部类======\n");

        Outer.Inter a = new Outer().new Inter(); //非静态内部类对象的创建方式

        a.Print();

        Outer.Inter1 bb = new Outer.Inter1(); //静态内部类对象的创建方式

        bb.Print();

        Outer o = new Outer();

        o.test();

        System.out.println("\n======匿名内部类======\n");

        Dog d = new Dog("狗");
        d.print();

        Manage m = new Manage();
        m.print();

        //将匿名内部类作为实参传递
        getInterface(new Dao(){
            public void add(){
                System.out.println("aaaaa添加成功!!!!");
            }
        });

        System.out.println("\n======Throwable======\n");
        Throwable tt = new Throwable("数组超边界");
        String s1 = tt.toString();
        String s2 = tt.getMessage();
        System.out.println("toString: " + s1);
        System.out.println("getMessage: " + s1);

        printthrow();

        System.out.println("\n======捕获异常处理======\n");

        int[] arr  = null;
        div(3,2,arr);

        System.out.println("\n======抛出异常======\n");

        //调用声明抛出异常的方法时，调用者需要进行捕获异常处理或继续抛出
        try {
            div1(3,0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //界面
        System.out.println("QQ主界面");
        JFrame frame = new JFrame("QQ程序");
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void div(int a, int b,int[] arr){
        int c = 0;
        try {
            c = a/b; //这句异常 下句不再执行
            System.out.println("数组长度等于: " + arr.length);
        }catch (ArithmeticException e){ //多个catch可以捕获多种异常
            e.printStackTrace();
            System.out.println("除数不能为0！");
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("空指针！");
        }

        System.out.println("c = " + c);
    }

    //    抛出异常
    public static void div1(int a, int b) throws Exception,ArithmeticException{
        int c = 0;
        if (b==0){
            throw new Exception("异常：除数为0");
        }
        System.out.println("c = " + c);
    }


    public  static  void printthrow(){
        Throwable tt = new Throwable("数组超边界");
        tt.printStackTrace(); //打印异常信息并定位错误位置
    }



    //匿名内部类重要应用：当函数形参为接口或抽象类时，需要传给函数的是接口或抽象类的实现，这是可以用匿名内部类
    public static void getInterface(Dao d){
        d.add();
    }

    public static void printFig(Figure f){
        f.getLength();
        f.getArea();
    }

    public static Figure getFig(int a){
        if (a == 0){
            return new Circle("圆形",2.5);
        }
        else{
            return new Rectangle("矩形",5,8);
        }
    }

    //一个调用子类特有方法
    public static void getSpecial(Figure f){
        if (f instanceof Circle){ //判断属于哪个类
            Circle c = (Circle) f; //类型强转换
            c.Angle();

        }
        else{
            Rectangle r = (Rectangle) f;
            r.LengthNum();
        }
    }
}

