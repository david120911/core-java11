package alibaba.code.guideline.programing.protocol.control.code;

import java.io.File;

public class ControlCodeTest {


    /***
     *
     * (七) 控制语句
     * 1. 【强制】在一个 switch 块内，每个 case 要么通过 break/return
     * 等来终止，要么注释说明程序将继续执行到哪一个 case 为止;在一个 switch
     * 块内，都必须包含一个 default 语句并且 放在最后，即使它什么代码也没有。
     */

    // 这个平时写代码都是这么写的


    /**
     * 2. 【强制】在 if/else/for/while/do 语句中必须使用大括号。
     * 即使只有一行代码，避免使用 单行的形式:if (condition) statements;
     */


    // 写代码就是这么写的  完全同意单行代码也要用大括号

    /**
     * 3. 【推荐】表达异常的分支时，少用 if-else 方式，这种方式可以改写成:
     * if (condition) { ...
     * return obj; }
     * // 接着写 else 的业务逻辑代码;
     * <p>
     * 说明:如果非得使用 if()...else if()...else...方式表达逻辑，
     * 【强制】避免后续代码维护困难，请勿超过 3 层。
     * 正例:逻辑上超过 3 层的 if-else 代码可以使用卫语句，
     * 或者状态模式来实现。卫语句示例 如下:
     * public void today() { if (isBusy()) {
     * System.out.println(“change time.”); return;
     * }
     * if (isFree()) {
     * System.out.println(“go to travel.”);
     * return; }
     * System.out.println(“stay at home to learn Alibaba Java Coding Guideline.”);
     * return; }
     */

    public void today() {
        if (isBusy()) {
            System.out.println("change time.");
            return;
        }

        if (isFree()) {
            System.out.println("go to travel.");
            return;
        }

        System.out.println("stay at home to learn Alibaba Java Coding Guideline.");
        return;
    }

    private boolean isFree() {
        return false;
    }

    private boolean isBusy() {
        return false;
    }


    /**
     * 今天看公司的代码规范文档，看到这么一条规则：
     * if语句使用“卫语句 ”减少层级嵌套。
     * 一脸的大写的懵逼，“卫语句”是什么东东？赶紧找度妈。
     * 卫语句就是把复杂的条件表达式拆分成多个条件表达式，比如一个很复杂的表达式，
     * 嵌套了好几层的if - then-else语句，转换为多个if语句，实现它的逻辑，这多条的if语句就是卫语句.
     * 简单的例子如下：
     * if（obj != null）{
     * doSomething();
     * }
     * 转换成卫语句以后的代码如下：
     * if(obj == null){
     * return;
     * }
     * doSomething()
     */

    public void ifElse(Object object) {
        if (object != null) {
            doSomething();
        }

        if (object == null) {
            return;
        }
        doSomething();
    }

    private void doSomething() {
    }


    /**
     * 4. 【推荐】除常用方法(如 getXxx/isXxx)等外，不要在条件判断中执行其它复杂的语句，将复
     * 杂逻辑判断的结果赋值给一个有意义的布尔变量名，以提高可读性。
     * 说明:很多 if 语句内的逻辑相当复杂，阅读者需要分析条件表达式的最终结果，才能明确什么
     * <p>
     * 样的条件执行什么样的语句，那么，如果阅读者分析逻辑表达式错误呢?
     * 正例:
     * //伪代码如下
     * <p>
     * final boolean existed = (file.open(fileName, "w") != null) && (...) || (...);
     * if (existed) {
     * ...
     * }
     * 反例:
     * <p>
     * if ((file.open(fileName, "w") != null) && (...) || (...)) { ...
     * }
     */

    public void exist() {
        //正例
        File file = new File("");
        final boolean existed = (file.mkdir()) && (file.isDirectory()) || (file.canWrite());
        if (existed) {
            // todo
        }


        //反例
        if ((file.mkdir()) && (file.isDirectory()) || (file.canWrite())) {
            //todo
        }
    }


    /**
     * 5. 【推荐】循环体中的语句要考量性能，以下操作尽量移至循环体外处理，如定义对象、变量、
     * 获取数据库连接，进行不必要的 try-catch 操作(这个 try-catch 是否可以移至循环体外)。
     */


    // 说的对 有看到在循环体内查询数据库的


    /** 6. 【推荐】接口入参保护，这种场景常见的是用于做批量操作的接口。
     */



    //其实就是参数校验吧

    /**
     * 最近学习《阿里巴巴java开发手册》
     * 第七章控制语句中，第6点提到了入参保护，原文如下：
     * 6. 【推荐】接口入参保护，这种场景最常见的是用于做批量操作的接口。
     * 工作中很少提到“入参保护”这个词，更多的是“参数校验”的说法；谈下个人对接口入参保护的理解：
     * 1、接口入参保护，“保护”的是服务端应用，即接口提供方，
     * 最常见的做法就是校验入参的有效值范围和设置批量操作白名单；
     * 　　比如，接口入参中包含日期时，校验日期必须在N天范围内，或者请求返回的记录总数
     * 必须在X条以内（比如10W条，否则缩小请求查询的记录范围），
     * 或者请求返回的记录必须分页查询返回；
     *
     * 开发手册中，尤其提到的场景就是批量操作，因为批量操作非常耗时耗资源（
     * 服务端），批量操作的批量数应该有上限，而不是无限的。
     * 假如客户端请求一次批量操作10W笔转账订单，服务器应该果断拒绝，
     * 而不是忠实执行，会对服务端造成严重影响的批量请求，
     * 服务器端应做好保护性编程，必要时应直接失败，
     * 并在Result中返回明确的errorCode和errorMsg;
     * 　　而且，对应批量操作，实际应用中还会配置批量操作白名单！
     * 2、入参保护，一般都是通过卫语句实现：if（请求记录>10000条） return；直接返回。
     *
     *
     */



    /**7. 【参考】下列情形，需要进行参数校验:
     * 1) 调用频次低的方法。
     * 2) 执行时间开销很大的方法。此情形中，参数校验时间几乎可以忽略不计，但如果因为参
     * 数错误导致中间执行回退，或者错误，那得不偿失。
     * 3) 需要极高稳定性和可用性的方法。
     * 4) 对外提供的开放接口，不管是RPC/API/HTTP接口。
     * 5) 敏感权限入口。
     *
     */

    // 校验越多 出现错误的几率会越小


    /**
     * 8. 【参考】下列情形，不需要进行参数校验:
     * 1) 极有可能被循环调用的方法。但在方法说明里必须注明外部参数检查要求。
     * 2) 底层调用频度比较高的方法。毕竟是像纯净水过滤的最后一道，
     * 参数错误不太可能到底
     * 层才会暴露问题。一般 DAO 层与 Service 层都在同一个应用中，
     * 部署在同一台服务器中，所 以 DAO 的参数校验，可以省略。
     * 3) 被声明成private只会被自己代码所调用的方法，
     * 如果能够确定调用方法的代码传入参 数已经做过检查或者肯定不会有问题，
     * 此时可以不校验参数。
     */

     // 说的很对啊

    
}
