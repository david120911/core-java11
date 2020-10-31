package alibaba.code.guideline.exception.handle.logging;

public class HandleLogging {


    /**
     *
     * (二) 日志规约
     *
     *1. 【强制】应用中不可直接使用日志系统(Log4j、Logback)中的
     * API，而应依赖使用日志框架
     * SLF4J 中的 API，使用门面模式的日志框架，
     * 有利于维护和各个类的日志处理方式统一。
     * import org.slf4j.Logger;
     * import org.slf4j.LoggerFactory;
     * private static final Logger logger = LoggerFactory.getLogger(Abc.class);
     *
     *
     *
     */

    // log4j logback slf4j 区别

    /**   这一段来自网络资料 而不是java手册
     -总结：
     slf4j是java的一个日志门面，实现了日志框架一些通用的api，log4j和logback是具体的日志框架。
     他们可以单独的使用，也可以绑定slf4j一起使用。
     单独使用。分别调用框架自己的方法来输出日志信息。
     绑定slf4j一起使用。调用slf4j的api来输入日志信息，具体使用与底层日志框架无关（需要底层框架的配置文件）
     显然这里我们不推荐单独使用日志框架。假设项目中已经使用了log4j，而我们此时加载了一个类库，而这个类库依赖另一个日志框架。
     这个时候我们就需要维护两个日志框架，这是一个非常麻烦的事情。而使用了slf4j就不同了，
     由于应用调用的抽象层的api，与底层日志框架是无关的，因此可以任意更换日志框架。

     使用slf4j绑定日志系统的优势
     软件工程的角度。抽象，解耦，便于维护。可以参考一下上面的例子。
     语法设计角度。slf4j有{}占位符，而log4j需要用“+”来连接字符串，既不利于阅读，同时消耗了内存（heap memory）。
     */


    /**
     * 2. 【强制】日志文件推荐至少保存 15 天，因为有些异常具备以“周”为频次发生的特点。
     *
     */

    // 为何不是一个月？两个月


    /**
     * 3. 【强制】应用中的扩展日志(如打点、临时监控、访问日志等)命名方式:
     * appName_logType_logName.log。
     * logType:日志类型，推荐分类有 stats/desc/monitor/visit 等;
     * logName:日志描述。这种命名的好处:通过文件名就可知
     * 道日志文件属于什么应用，什么类型，什么目的，也有利于归类查找。
     *
     * 正例:mppserver 应用中单独监控时区转换异常，如:
     * mppserver_monitor_timeZoneConvert.log
     * 说明:推荐对日志进行分类，如将错误日志和业务日志分开存放，便于开发人员查看，也便于
     * 通过日志对系统进行及时监控。
     *
     *
     */
// 日志 记录

    /**
     * 4. 【强制】对 trace/debug/info 级别的日志输出，
     * 必须使用条件输出形式或者使用占位符的方 式。
     * 说明:logger.debug("Processing trade with id: " + id +
     * " symbol: " + symbol); 如果日志级别是 warn，上述日志不会打印，
     * 但是会执行字符串拼接操作，如果 symbol 是对象， 会执行
     * toString()方法，浪费了系统资源，执行了上述操作，最终日志却没有打印。 正例:(条件)
     * if (logger.isDebugEnabled()) {
     * logger.debug("Processing trade with id: " + id + " symbol: " + symbol);
     * }
     * 正例:(占位符)
     * logger.debug("Processing trade with id: {} symbol : {} ", id, symbol);
     * */

    //占位符的输出更容易理解


    /**
     *
     * 5. 【强制】避免重复打印日志，浪费磁盘空间，务必在 log4j.xml 中设置
     * additivity=false。 正例:<logger name="com.taobao.dubbo.config" additivity="false">
     *
     */
// 节约空间

    /**
     *
     * 6. 【强制】异常信息应该包括两类信息:案发现场信息和异常堆栈信息。
     * 如果不处理，那么通过 关键字 throws 往上抛出。
     * 正例:logger.error(各类参数或者对象toString + "_" + e.getMessage(), e);
     *
     *
     */

// 案发现场 各类参数或对象toString
    // 异常堆栈信息 e.getMessage()


    /**
     *
     * 7. 【推荐】谨慎地记录日志。生产环境禁止输出 debug 日志;
     * 有选择地输出 info 日志;如果使 用 warn 来记录刚上线时的业务行为信息，
     * 一定要注意日志输出量的问题，避免把服务器磁盘 撑爆，并记得及时删除这些观察日志。
     * 说明:大量地输出无效日志，不利于系统性能提升，也不利于快速定位错误点。
     * 记录日志时请 思考:这些日志真的有人看吗?看到这条日志你能做什么?能不能给问题排查带来好处?
     *
     */
// 日志有用吗？日志能够删除吗？

    /**
     *
     * 8. 【参考】可以使用 warn 日志级别来记录用户输入参数错误的情况，避免用户投诉时，
     * 无所适 从。注意日志输出的级别，error 级别只记录系统逻辑出错、异常等重要的错误信息。
     * 如非必 要，请不要在此场景打出 error 级别。
     *
     */
    // 日志问题
}
