package leaning.rpc.Server;



import leaning.rpc.service.Imp.StudentServiceImp;
import leaning.rpc.service.StudentService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 接收客户端请求
 */
public class Server {
    private ServerSocket serverSocket;
    private int servPort;

    public Server(int port) throws IOException {
        this.servPort = port;
        serverSocket = new ServerSocket(this.servPort);

    }

    public void start() {
        //线程池
        //corePoolSize	int	核心线程池大小
        //maximumPoolSize	int	最大线程池大小
        //keepAliveTime	long	线程最大空闲时间
        //unit	TimeUnit	时间单位
        //workQueue	BlockingQueue<Runnable>	线程等待队列
        //threadFactory	ThreadFactory	线程创建工厂
        //handler	RejectedExecutionHandler	拒绝策略
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10,
                200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        while (true) {
            try {
                Socket sock = serverSocket.accept();
                ServerService service = new ServerService(sock);
                //注册服务
                service.registerService(StudentService.class, StudentServiceImp.class);
                threadPool.execute(service);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
