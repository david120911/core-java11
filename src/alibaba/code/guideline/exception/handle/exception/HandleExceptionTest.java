package alibaba.code.guideline.exception.handle.exception;

public class HandleExceptionTest {

    /****
     *
     *
     * 二、异常日志
     * (一) 异常处理
     * 1. 【强制】Java 类库中定义的一类 RuntimeException 可以通过预先检查进行规避，而不应该 通过catch 来处理，比如:IndexOutOfBoundsException，NullPointerException等等。 说明:无法通过预检查的异常除外，如在解析一个外部传来的字符串形式数字时，通过 catch NumberFormatException 来实现。
     * 正例:if (obj != null) {...}
     * 反例:try { obj.method() } catch (NullPointerException e) {...}
     * 2. 【强制】异常不要用来做流程控制，条件控制，因为异常的处理效率比条件分支低。
     * 3. 【强制】对大段代码进行 try-catch，这是不负责任的表现。catch 时请分清稳定代码和非稳 定代码，稳定代码指的是无论如何不会出错的代码。对于非稳定代码的 catch 尽可能进行区分 异常类型，再做对应的异常处理。
     * 4. 【强制】捕获异常是为了处理它，不要捕获了却什么都不处理而抛弃之，如果不想处理它，请 将该异常抛给它的调用者。最外层的业务使用者，必须处理异常，将其转化为用户可以理解的 内容。
     * 5. 【强制】有 try 块放到了事务代码中，catch 异常后，如果需要回滚事务，一定要注意手动回 滚事务。
     * 6. 【强制】finally 块必须对资源对象、流对象进行关闭，有异常也要做 try-catch。 说明:如果 JDK7 及以上，可以使用 try-with-resources 方式。
     * 7. 【强制】不能在 finally 块中使用 return，finally 块中的 return 返回后方法结束执行，不 会再执行 try 块中的 return 语句。
     * 8. 【强制】捕获异常与抛异常，必须是完全匹配，或者捕获异常是抛异常的父类。 说明:如果预期对方抛的是绣球，实际接到的是铅球，就会产生意外情况。
     * 9. 【推荐】方法的返回值可以为 null，不强制返回空集合，或者空对象等，必须添加注释充分 说明什么情况下会返回 null 值。调用方需要进行 null 判断防止 NPE 问题。 说明:本手册明确防止 NPE 是调用者的责任。即使被调用方法返回空集合或者空对象，对调用 者来说，也并非高枕无忧，必须考虑到远程调用失败、序列化失败、运行时异常等场景返回 null 的情况。
     * 10. 【推荐】防止 NPE，是程序员的基本修养，注意 NPE 产生的场景: 1)返回类型为基本数据类型，return 包装数据类型的对象时，自动拆箱有可能产生 NPE。
     * 反例:public int f() { return Integer 对象}， 如果为 null，自动解箱抛 NPE。
     *
     * 2) 数据库的查询结果可能为null。
     * 3) 集合里的元素即使isNotEmpty，取出的数据元素也可能为null。 4) 远程调用返回对象时，一律要求进行空指针判断，防止NPE。
     * 5) 对于Session中获取的数据，建议NPE检查，避免空指针。
     * 6) 级联调用obj.getA().getB().getC();一连串调用，易产生NPE。
     * 正例:使用 JDK8 的 Optional 类来防止 NPE 问题。
     * 11.【推荐】定义时区分unchecked/checked 异常，避免直接抛出newRuntimeException()， 更不允许抛出 Exception 或者 Throwable，应使用有业务含义的自定义异常。推荐业界已定义 过的自定义异常，如:DAOException / ServiceException等。
     * 12. 【参考】在代码中使用“抛异常”还是“返回错误码”，对于公司外的 http/api 开放接口必须 使用“错误码”;而应用内部推荐异常抛出;跨应用间 RPC 调用优先考虑使用 Result 方式，封 装 isSuccess()方法、“错误码”、“错误简短信息”。
     * 说明:关于 RPC 方法返回方式使用 Result 方式的理由:
     * 1)使用抛异常返回方式，调用方如果没有捕获到就会产生运行时错误。
     * 2)如果不加栈信息，只是new自定义异常，加入自己的理解的error message，对于调用 端解决问题的帮助不会太多。如果加了栈信息，在频繁调用出错的情况下，数据序列化和传输 的性能损耗也是问题。
     * 13.【参考】避免出现重复的代码(Don’t Repeat Yourself)，即DRY原则。 说明:随意复制和粘贴代码，必然会导致代码的重复，在以后需要修改时，需要修改所有的副 本，容易遗漏。必要时抽取共性方法，或者抽象公共类，甚至是共用模块。 正例:一个类中有多个 public 方法，都需要进行数行相同的参数校验操作，这个时候请抽取:
     * private boolean checkParam(DTO dto) {...}
     *
     *
     *
     *
     *
     *
     *
     */




    public static void main(String[] args) {

    }

}