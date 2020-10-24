package alibaba.code.guideline.programing.protocol.constant.definition;

import java.util.HashMap;

public class ConstantDefinitionTest {
    public static void main(String[] args) {
        System.out.println("constant definition ");
    }


    /**
     * 1. 【强制】不允许任何魔法值(即未经定义的常量)直接出现在代码中。
     * 反例: String key = "Id#taobao_" + tradeId;
     * cache.put(key, value);
     */
    private HashMap<String, Object> cache = new HashMap<>();

    //反例
    public void putTradeId(String tradeId, Object value) {
        String key = "Id#taobao_" + tradeId;
        cache.put(key, value);
    }

//正例

    private static final String KEY_HEAD = "Id#taobao_";

    public void putTradeId2(String tradeId, Object value) {
        String key = KEY_HEAD + tradeId;
        cache.put(key, value);
    }

/**
 2. 【强制】long 或者 Long 初始赋值时，必须使用大写的 L，不能是小写的 l，
 小写容易跟数字 1 混淆，造成误解。
 说明:Long a = 2l; 写的是数字的21，还是Long型的2?

 */
// right
private Long age = 21L;
// wrong
private Long age2 = 21l;

/**
 3. 【推荐】不要使用一个常量类维护所有常量，应该按常量功能进行归类，分开维护。
 如:缓存 相关的常量放在类:CacheConsts 下;
 系统配置相关的常量放在类:ConfigConsts 下。
 说明:大而全的常量类，非得使用查找功能才能定位到修改的常量，不利于理解和维护。

 */

//见CacheConstants.java
    // 见 ConfigConstants.java

/**
 4. 【推荐】常量的复用层次有五层:跨应用共享常量、应用内共享常量、
 子工程内共享常量、包 内共享常量、类内共享常量。
 1) 跨应用共享常量:放置在二方库中，通常是client.jar中的constant目录下。
 2) 应用内共享常量:放置在一方库的modules中的constant目录下。
 反例:易懂变量也要统一定义成应用内共享常量，两位攻城师在两个类中分别定义了表示 “是”的变量:
 类A中:public static final String YES = "yes";
 类B中:public static final String YES = "y"; A.YES.equals(B.YES)，
 预期是 true，但实际返回为 false，导致线上问题。
 3) 子工程内部共享常量:即在当前子工程的constant目录下。
 4) 包内共享常量:即在当前包下单独的constant目录下。
 5) 类内共享常量:直接在类内部private static final定义。
*/


/**
 5. 【推荐】如果变量值仅在一个范围内变化，且带有名称之外的延伸属性，定义为枚举类。下面
 正例中的数字就是延伸信息，表示星期几。
 正例:public Enum { MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);}

 */

//见 WeekDay.java
}
