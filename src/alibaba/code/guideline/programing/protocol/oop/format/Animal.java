package alibaba.code.guideline.programing.protocol.oop.format;

public class Animal {
    private String name ;

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
