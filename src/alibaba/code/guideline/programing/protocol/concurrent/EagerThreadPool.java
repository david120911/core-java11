package alibaba.code.guideline.programing.protocol.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class EagerThreadPool {


    public Executor getExecutor(){
        String name = "";
        int cores = 8;
        int threads = 8 ;
        int queues = 8;
        int alive = 8;


        EagerThreadPoolExecutor eagerThreadPoolExecutor =
                new EagerThreadPoolExecutor(cores,threads,alive, TimeUnit.MILLISECONDS,
                        null,null,null);
        return eagerThreadPoolExecutor;

    }
}
