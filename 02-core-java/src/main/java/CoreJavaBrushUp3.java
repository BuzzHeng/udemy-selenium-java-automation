public class CoreJavaBrushUp3 {
    public static void main(String[] args){

        //String is an object that represent a string of character.
        //2 way to define string, literal or new operator.

        //1. String Literal
        String s1 = "Lee Yuan Heng";
        String s5 = "hello";

        //2. New memory allocate operator
        String s2 = new String("Welcome");
        String s3 = new String("Welcome");


        String s = "Lee Yuan Heng";
        String[] splittedString = s.split("Yuan");
        System.out.println(splittedString[0]);
        System.out.println(splittedString[1]);
        System.out.println(splittedString[0].trim());
        System.out.println(splittedString[1].trim());

        for(int i = 0; i<s.length(); i++)
        {
            System.out.println(s.charAt(i));
        }

        //Famous interview qns, print string in reverse
        for(int i = s.length() - 1; i>=0; i--)
        {
            System.out.println(s.charAt(i));
        }

    }

}
