package leaning.socket;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClientTest extends Socket {
    private  final String SERVER_IP="localhost";
    private final int SERVER_PORT=9019;
    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;

    //创建客户端，并指定接收的服务端IP和端口号
    public SocketClientTest() throws IOException {
        this.client=new Socket(SERVER_IP,SERVER_PORT);
        System.out.println("成功连接服务端..."+SERVER_IP);
    }

    //向服务端传输文件
    public void sendFile(String url) throws IOException {
        File file=new File(url);
        try {
            fis = new FileInputStream(file);
            //BufferedInputStream bi=new BufferedInputStream(new InputStreamReader(new FileInputStream(file),"GBK"));
         //   client.setSoTimeout(500);
            dos = new DataOutputStream(client.getOutputStream());//client.getOutputStream()返回此套接字的输出流
            //文件名、大小等属性
            dos.writeUTF(file.getName());
            dos.flush();
            dos.writeLong(file.length());
            dos.flush();
            // 开始传输文件
            System.out.println("======== 开始传输文件 ========");
            byte[] bytes = new byte[1024];
            int length = 0;

            while ((length = fis.read(bytes, 0, bytes.length)) != -1) {
                dos.write(bytes, 0, length);
                dos.flush();
            }
            System.out.println("======== 文件传输成功 ========");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("客户端文件传输异常");
        }finally{
            fis.close();
            dos.close();
        }
    }
    public static void main(String[] args) {
        try {
            SocketClientTest client = new SocketClientTest(); // 启动客户端连接

            client.client.setSoTimeout(500);
            Thread.sleep(50000);
            client.sendFile("/tmp/hadoop-3.1.1.tar.gz"); // 传输文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

