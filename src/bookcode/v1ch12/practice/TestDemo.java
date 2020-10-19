package bookcode.v1ch12.practice;

public class TestDemo {

    public static void main(String[] args) {
        Runnable runnable = ()->{
            System.out.println("test run ");
        };

        var t = new Thread(runnable);
        t.start();


    }

}
