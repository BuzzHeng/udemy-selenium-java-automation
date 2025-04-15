public class CoreJavaBrushUp1 {
    public static void main(String[] args){

        //Java Variable and Data Types
        int myNum = 1;
        String website = "Chat GPT";
        char letter = 'r';
        double dec = 5.99;
        boolean myCard = true;

        System.out.println(myNum+" is the value stored in myNum variable");
        System.out.println(website);

        ArrayDemo.declareSizeWithNewOperator();
        ArrayDemo.declareWithInitialization();

        forLoopDemo.loopIntArrayWithIndex();
        forLoopDemo.loopStringArrayWithIndex();
        forLoopDemo.loopStringArrayForEach();
    }

    public static class ArrayDemo {
        public static void declareSizeWithNewOperator()
        {
            int[] arr = new int[5]; // Create an array of size 5 with default values 0.
            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 3;
            arr[3] = 4;
            arr[4] = 5;
            System.out.println("Manual assignment - Index 2: " + arr[2]);
        }

        public static void declareWithInitialization()
        {
            int[] arr2 = {1, 2, 3, 4, 5};
            System.out.println("Inline initialization - Index 2: " + arr2[2]);
        }
    }

    public static class forLoopDemo{
        public static void loopIntArrayWithIndex()
        {
            //start; stop; step
            int[] arr1 = {1,2,3,4,5};
            for(int i = 0; i < arr1.length; i++)
            {
                System.out.println(arr1[i]);
            }
        }

        public static void loopStringArrayWithIndex()
        {
            String[] name = {"AI","Change","The", "World"};
            for(int i=0; i<name.length; i++)
            {
                System.out.println(name[i]);      // i is the index, name[i] is the value
            }
        }

        public static void loopStringArrayForEach()
        {
            String[] name = {"AI","Change","The", "World"};
            for(String i : name)
            {           //For each string i in array name
                System.out.println(i);      // i is the value directly
            }
        }
    }
}

