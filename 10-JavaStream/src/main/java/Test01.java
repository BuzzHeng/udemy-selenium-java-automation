import org.testng.annotations.Test;

import java.util.ArrayList;
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
    }
}
