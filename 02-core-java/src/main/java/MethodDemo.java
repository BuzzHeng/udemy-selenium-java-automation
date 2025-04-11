public class MethodDemo {
    public static void main(String[] args)
    {
        MethodDemo d = new MethodDemo();
        String name = d.getData();
        System.out.println(name);
        MethodDemo2 d1 = new MethodDemo2();
        d1.getUserData();
        getData2();
    }

    // static keyword will move method to class level
    public String getData(){
        System.out.println("Hello World no static keyword");
        return "Yuan Heng Lee";
    }

    public static String getData2(){
        System.out.println("Hello World with static keyword");
        return "Yuan Heng Lee";
    }
}
