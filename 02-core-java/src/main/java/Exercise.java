public class Exercise {
    public static void main(String[] args){

        int[] numbers = {1,2,3,4,5};

        System.out.println(numbers[0]);   // First Element
        System.out.println(numbers[4]);   // Last Element

        for(int i=numbers.length-1; i >= 0; i--)
        {
            System.out.println(numbers[i]);
        }

        int totalNumbers=0;
        for(int i: numbers)
        {
            totalNumbers += i;
        }
        System.out.println(totalNumbers);

    }
}