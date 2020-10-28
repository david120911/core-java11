package alibaba.code.guideline.programing.protocol.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentTest {


    /**
     *
     * (六) 并发处理
     * 1. 【强制】获取单例对象需要保证线程安全，其中的方法也要保证线程安全。
     * 说明:资源驱动类、工具类、单例工厂类都需要注意。
     */

    // 这个一般是双层锁保护线程安全  例子写了很多遍 就不写了
    // 单例的关键点是 构造方法私有化 自己控制实例化才能单例

    /**
     * 2. 【强制】创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。
     * 正例:
     * public class TimerTaskThread extends Thread { public TimerTaskThread() {
     * super.setName("TimerTaskThread"); ... }
     */


    // 正例

    class TimerThread extends Thread{
        public TimerThread() {
            super.setName("TimerThread");
        }
    }

    /**
     * 3. 【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。
     * 说明:使用线程池的好处是减少在创建和销毁线程上所花的时间以及系统资源的开销，
     * 解决资 源不足的问题。如果不使用线程池，有可能造成系统创建大量同类线程而
     * 导致消耗完内存或者 “过度切换”的问题。
     */

    // 这里借鉴dubbo设置线程池




    /**
     *
     * 4. 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor
     * 的方式，这样 的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
     * 说明:Executors 返回的线程池对象的弊端如下:
     * 1)FixedThreadPool 和 SingleThreadPool:
     * 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
     * 2)CachedThreadPool 和 ScheduledThreadPool:
     * 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
     */

    //3 4 说的是一个意思。见EagerThreadPool.java 和 EagerThreadPoolExecutor.java
    // 参考的是dubbo 不完善 ，后续完善


    /**
     * 5.【强制】SimpleDateFormat 是线程不安全的类，一般不要定义为static变量，如果定义为
     * static，必须加锁，或者使用 DateUtils 工具类。
     * 正例:注意线程安全，使用 DateUtils。亦推荐如下处理:
     * private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() { @Override
     * protected DateFormat initialValue() {
     * return new SimpleDateFormat("yyyy-MM-dd");
     * } };
     * 说明:如果是 JDK8 的应用，可以使用 Instant 代替 Date，LocalDateTime 代替 Calendar，
     * DateTimeFormatter 代替 Simpledateformatter，
     * 官方给出的解释:simple beautiful strong immutable thread-safe。
     *
     */


    // 正例
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

//    private static final ThreadLocal<DateTimeFormatter> df2 = new ThreadLocal<>(){
//        @Override
//        protected DateTimeFormatter initialValue() {
//            return new DateTimeFormatter("yyyy-MM-dd");
//        }
//    };

    /**
     *
     *
     * 6. 【强制】高并发时，同步调用应该去考量锁的性能损耗。能用无锁数据结构，就不要用锁;能
     * 锁区块，就不要锁整个方法体;能用对象锁，就不要用类锁。
     * 说明:尽可能使加锁的代码块工作量尽可能的小，避免在锁代码块中调用 RPC 方法。
     *
     *
     */

    // 这个原则说的很好 ，具体的实现 暂时不做


    /**
     *
     * 7. 【强制】对多个资源、数据库表、对象同时加锁时，需要保持一致的加锁顺序，否则可能会造
     * 成死锁。
     * 说明:线程一需要对表 A、B、C 依次全部加锁后才可以进行更新操作，那么线程二的加锁顺序
     * 也必须是 A、B、C，否则可能出现死锁。
     */


    // 加锁顺序 避免死锁，这个自然。

    /**
     * 8. 【强制】并发修改同一记录时，避免更新丢失，需要加锁。要么在应用层加锁，要么在缓存加
     * 锁，要么在数据库层使用乐观锁，使用 version 作为更新依据。 说明:如果每次访问冲突概率小于
     * 20%，推荐使用乐观锁，否则使用悲观锁。乐观锁的重试次 数不得小于 3 次。
     *
     */

    // 乐观锁是用version作为控制



    /**
     * 9. 【强制】多线程并行处理定时任务时，Timer 运行多个 TimeTask 时，只要其中之一没有捕获
     * 抛出的异常，其它任务便会自动终止运行，使用 ScheduledExecutorService 则没有这个问题。
     *
     */

    // 所以要尽量用Java的并发工具包


    /**
     * 10. 【推荐】使用 CountDownLatch 进行异步转同步操作，每个线程退出前必须调用
     * countDown 方法，线程执行代码注意 catch 异常，确保 countDown 方法可以执行，
     * 避免主线程无法执行 至 await 方法，直到超时才返回结果。
     * 说明:注意，子线程抛出异常堆栈，不能在主线程 try-catch 到。
     *
     */

    // 是这样吗？后续要多看dubbo的源代码  要多看几次
    private void countDown() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        try {

            // 执行业务？
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
        countDownLatch.await();
    }


    /**
     * 11. 【推荐】避免 Random 实例被多线程使用，虽然共享该实例是线程安全的，但会因竞争同一
     * seed 导致的性能下降。
     * 说明:Random 实例包括 java.util.Random 的实例或者 Math.random()的方式。
     * 正例:在 JDK7 之后，可以直接使用 API ThreadLocalRandom，而在 JDK7 之前，
     * 需要编码保 证每个线程持有一个实例。
     *
     */

    Random random = new Random();
    private void random(){
        random.nextInt();
        ThreadLocalRandom.current().nextInt();
    }



    /**
     *
     * 12. 【推荐】在并发场景下，通过双重检查锁(double-checked locking)实现延迟初始化的优
     * 化问题隐患(可参考 The "Double-Checked Locking is Broken" Declaration)，推荐问
     * 题解决方案中较为简单一种(适用于 JDK5 及以上版本)，将目标属性声明为 volatile 型。
     * 反例:
     * class Foo {
     * private Helper helper = null; public Helper getHelper() {
     * if (helper == null) synchronized(this) { if (helper == null)
     * helper = new Helper();
     * }
     * return helper; }
     * // other functions and members...
     * }
     *
     */


    // 双重检查这个 已经做了多次 就不做了  关键点是volatile 双重检查锁


    /**
     *
     * 13. 【参考】volatile 解决多线程内存不可见问题。对于一写多读，是可以解决变量同步问题，
     * 但是如果多写，同样无法解决线程安全问题。如果是 count++操作，使用如下类实现: AtomicInteger
     * count = new AtomicInteger(); count.addAndGet(1); 如果是 JDK8，推
     * 荐使用 LongAdder 对象，比 AtomicLong 性能更好(减少乐观锁的重试次数)。
     *
     */

    private void countAdd(){
        AtomicInteger count = new AtomicInteger();
        count.addAndGet(1);
        //JDK8 AtomicLong
        AtomicLong atomicLong = new AtomicLong();
        atomicLong.addAndGet(1);
    }


    // 写代码多借鉴别人的 就像学习数学 看例题做作业。这点很重要。借鉴。

    /**
     *
     * 14. 【参考】 HashMap 在容量不够进行 resize 时由于高并发可能出现死链，导致 CPU 飙升，在
     * 开发过程中可以使用其它数据结构或加锁来规避此风险。
     */


    //用concurrentHashMap
    // 这里要注意到hashmap的数据结构的思路


    /**
     * 15. 【参考】ThreadLocal 无法解决共享对象的更新问题，ThreadLocal 对象建议使用 static
     * 修饰。这个变量是针对一个线程内所有操作共有的，所以设置为静态变量，所有此类实例共享
     * 此静态变量 ，也就是说在类第一次被使用时装载，只分配一块存储空间，所有此类的对象(只
     * 要是这个线程内定义的)都可以操控这个变量。
     *
     * */


    //


}
