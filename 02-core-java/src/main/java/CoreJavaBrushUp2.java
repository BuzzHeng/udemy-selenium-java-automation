import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp2 {
    public static void main(String[] args){

        printFirstEvenAndBreak();

        //ArrayList: dynamic size, object only, useful methods
        ArrayList<String> a = new ArrayList();      //new operator to allocate memory for object a
        a.add("rahul");
        a.add("shetty");
        a.add("Udemy");
        a.add("Selenium");
        System.out.println(a.get(3));

        for(int i =0; i<a.size(); i++)
        {
            System.out.println(a.get(i));
        }
        System.out.println("===========");

        for(String val : a)
        {
            System.out.println(val);
        }
        // item is present in ArrayList
        System.out.println(a.contains("selenium"));

        //Convert array to List to use method.
        String[] name = {"Rahul", "Shetty", "Udemy"};
        List<String> nameArrayList = Arrays.asList(name);
        nameArrayList.contains("selenium");
    }

    public static void printFirstEvenAndBreak()
    {
        //Check if array has multiple of 2

        //Array
        int[] arr = {1,2,4,5,6,8,9,10,122};

        //For Loop
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] % 2 == 0) //Conditional Statement (if-else), Modulus %
            {
                System.out.println(arr[i]);
                break;          //Break statement
            }
            else
            {
                System.out.println(arr[i] + " is not multiple of 2");
            }
        }
    }
}
