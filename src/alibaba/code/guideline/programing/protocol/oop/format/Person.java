package alibaba.code.guideline.programing.protocol.oop.format;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {


    //wrong
    public Person() {
        setAge(12);
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Person(Integer weight, Integer age) {
        this.weight = weight;
        this.age = age;
    }


    //right
    public void init() {
        setAge(12);
    }

    public void loveSports() {

    }

    public void loveSports(String sportsName) {

    }

    public void loveSports(String sportsName, Integer sportAge) {

    }


    public Date gmtCreate() {
        return new Date();
    }


    private Integer weight;
    private Integer age;
    private final String gender = "man";




    public String getGender() {
        return gender;
    }
    public Integer getWeight() {
        return weight;
    }




    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



    @Override
    public String toString() {
        return super.toString() + "Person{" +
                "age=" + age +
                '}';
    }
}
