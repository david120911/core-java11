import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class RepeatedGreeter extends Greeter {

    @Override
    public void greet(ActionEvent event) {
     var timer = new Timer(1000,super::greet);
     timer.start();
    }

    public static void main(String[] args) throws IOException {
        Greeter greeter = new RepeatedGreeter();
        greeter.greet(new ActionEvent(" that ",0," ok "));
        System.in.read();
    }
}
