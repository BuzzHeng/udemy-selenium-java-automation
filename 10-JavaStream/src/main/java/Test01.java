import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    //Count number of names starting with Alphabet A
    @Test
    public void regular(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("don");
        names.add("ram");
        names.add("Alexy");
        names.add("Adam");
        int count =0;
        for(int i=0; i<names.size();i++){
            String actual = names.get(i);
            if(actual.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter(){
        ArrayList<String> names=new ArrayList<String>();
        names.add("Abhijeet");
        names.add("don");
        names.add("ram");
        names.add("Alexy");
        names.add("Adam");
        // stream() - create stream
        // filter() - intermediate operation
        // count() - terminal operation

        // inter opr will not work without terminal opr.
        // terminal opr will only execute if inter opr (filter) returns true.
        // We can create stream
        // how to use filter in stream API
        Long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);
        long d = Stream.of("Abhijeet","don","ram","Alexy","Adam").filter(s1->
        {
            return s1.startsWith("A");
            //return false;
        }).count();
        System.out.println(d);
        // Print all names of ArrayList
        names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
    }

    @Test
    public void streamMap(){
        // Print names with last letter "a" with uppercase
        Stream.of("Abhijeet","Don","Rama","Alexy","Adam").filter(s->s.endsWith("a")).map(String::toUpperCase)
                .forEach(System.out::println);

        // Print names with first letter as "a" with uppercase and sorted
        // Convert array to ArrayList by using Arrays.asList()
        List<String> nameList = Arrays.asList("Abhijeet","Don","Rama","Alexy","Adam");
        nameList.stream().filter(s->s.startsWith("A"))
                .sorted()
                .map(s->s.toUpperCase())
                .forEach(System.out::println);


        ArrayList<String> names1=new ArrayList<String>();
        names1.add("man");
        names1.add("Don");
        names1.add("women");

        //Merging 2 different list
        Stream<String> newStream = Stream.concat(nameList.stream(), names1.stream());
        //newStream.forEach(System.out::println);
        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect(){
        // list
        // new list
        // new list

        List<String> ls = Stream.of("Abhijeet","Don","Rama","Alexy","Adam")
                .filter(s->s.endsWith("a"))
                .map(s->s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(ls.get(0));

        List<Integer> values = Arrays.asList(3,2,4,5,1,6,1,2,6);
        //print unique number from array
        //sort array - 3rd Index - 1, 2, 3, 4, 5, 6
        //values.stream().distinct().forEach(s->System.out.println(s));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println((li.get(2)));
    }
}
