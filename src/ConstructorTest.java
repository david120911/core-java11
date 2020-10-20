
// 构造器引用

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConstructorTest {

    public static void main(String[] args) {


        var planets = new String[]{
                "Mercury","Venus",
                "Earth","Mars",
                "Jupiter","Saturn"
                ,"Uranus","Neptune"
        };

        ArrayList<String> names =new ArrayList<>( Arrays.asList(planets));
        System.out.println(names);
       Stream<Person> stream =  names.stream().map(Person::new);

    }

}
