package alibaba.code.guideline.programing.protocol.comments;


/**
 * 人员类
 * author:david
 * date:20201028
 */
public class Person {

    /**
     * 人名 唯一性 不可更改
     */
    private String name;

    public String getName() {
        return name;
    }

    /**
     * 名字只能设置一次
     * @param name
     */
    public void setName(String name) {
        //设置名字
        this.name = name;
    }
}
