import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;
import javax.swing.Timer;

public class LambdaTest {

    public static void main(String[] args) {


        var planets = new String[]{
                "Mercury","Venus",
                "Earth","Mars",
                "Jupiter","Saturn"
                ,"Uranus","Neptune"
        };
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted in dictionary order ");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length  ");
//        Arrays.sort(planets,(String first,String second) -> first.length()-second.length());
        Arrays.sort(planets,(String first,String second) -> {return first.length() -second.length(); });
        System.out.println(Arrays.toString(planets));

//        var timer = new Timer(
//                1000, event ->
//             System.out.println("the time is " + new Date()));
//        timer.start();


//        var timer2 = new Timer(1000,event-> System.out.println(event +  " ok "));
//        timer2.start();

        var timer3 = new Timer(1000, System.out::println);
        timer3.start();


        JOptionPane.showMessageDialog(null,"quit program?");

// 终于搞定  用java-version 11 然后javac java命令搞定





        System.exit(0);
    }

}