package cn.itcast.object;

/**
 * @Author 王嗣鑫
 * @Date 2020/8/8 1:16
 * @Version 1.0
 */
class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //    重写toString()方法，使其满足打印需求
    @Override
    public String toString(){
        return "姓名：" + this.name + "|年龄：" + this.age;
    }

    @Override
    public boolean equals(Object o){
        Person p = (Person)o;
        return this.age == p.age;
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("o.toString() = " + o.toString());
        System.out.println(o);

        Person ww = new Person("王嗣鑫", 29);
        Person ll = new Person("梁倩倩", 28);
        System.out.println("ll = " + ll); //println调用toString方法
        System.out.println("ww = " + ww);
        System.out.println("ww = " + ww);
        System.out.println("ll与ww是否为同一个对象：" + ww.equals(ll));
        System.out.println("ww的哈希码：" + ww.hashCode());

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");

        System.out.println("s1=s2? " + (s1==s2)); //在字符串常量池中地址相同
        System.out.println("s2=s3? " + (s2==s3)); //一个指向字符串常量值地址，一个指向堆内存地址
        System.out.println("s3=s4? " + (s3==s4)); //堆内存中地址不同
        System.out.println("equals: s3=s4? " + (s3.equals(s4))); //String类对equals方法进行了重写，判断的是字符串的内容

        String s5 = null;
        equalstest(s5);

    }
    public static void  equalstest(String s){
        if ("中国".equals(s)){  //一般这么写，避免传入空字符串时程序报错
            System.out.println("正确");
        }
        else{
            System.out.println("错误");
        }
    }
}
