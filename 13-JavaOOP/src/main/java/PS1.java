import org.testng.annotations.Test;

public class PS1 extends PS{

    @Test
    public void testRun(){
        PS2 ps2 = new PS2(3);   //Parameterized constructor

        int a = 3;
        doThis();

        //PS2 utility class for addition subtraction
        System.out.println(ps2.increment());
        System.out.println(ps2.decrement());

        //As a senior engineer, asked to create utility class for multiplication
        // PS3 created as utility class for multiply
        //PS3 ps3 = new PS3(3);
        System.out.println(ps2.multiplyThree());
        //Senior manager reject this request, he wanted to only use from PS2 utility class
        //Therefore PS2 have to inherit from PS3 and to invoke parent constructor using super(a);
    }
}
