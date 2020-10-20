import java.awt.event.ActionEvent;
import java.time.Instant;

public class Greeter {

    public void greet(ActionEvent event){
        System.out.println("Hello , the time is " + Instant.ofEpochMilli(event.getWhen()));
    }
}
