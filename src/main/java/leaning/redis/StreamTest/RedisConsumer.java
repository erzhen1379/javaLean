package leaning.redis.StreamTest;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.StreamEntry;
import redis.clients.jedis.StreamEntryID;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class RedisConsumer {
    private static final String _STREAM_KEY = "mq2"; // 流 key
    private static final String _GROUP_NAME = "g12"; // 分组名称
    private static final String _CONSUMER_NAME = "c1"; // 消费者 1 的名称
    private static final String _CONSUMER2_NAME = "c2"; // 消费者 2 的名称


    public static void main(String[] args) {

        // 消费者 1
        new Thread(() -> consumer()).start();
        // 消费者 2
        new Thread(() -> consumer2()).start();
    }

    /**
     * 消费者 1
     */
    public static void consumer() {
        Jedis jedis = new Jedis("localhost", 6379);
        // 消费消息
        while (true) {
            // 读取消息
            Map.Entry<String, StreamEntryID> entry = new AbstractMap.SimpleImmutableEntry<>(_STREAM_KEY,
                    new StreamEntryID().UNRECEIVED_ENTRY);
            // 阻塞读取一条消息（最大阻塞时间120s）
            List<Map.Entry<String, List<StreamEntry>>> list = jedis.xreadGroup(_GROUP_NAME, _CONSUMER_NAME, 1,
                    120 * 1000, true, entry);
            if (list != null && list.size() == 1) {
                // 读取到消息
                Map<String, String> content = list.get(0).getValue().get(0).getFields(); // 消息内容
                System.out.println("Consumer 1 读取到消息 ID：" + list.get(0).getValue().get(0).getID() +
                        " 内容：" + new Gson().toJson(content));
            }
        }
    }

    /**
     * 消费者 2
     */
    public static void consumer2() {
        Jedis jedis = new Jedis("localhost", 6379);
        // 消费消息
        while (true) {
            // 读取消息
            Map.Entry<String, StreamEntryID> entry = new AbstractMap.SimpleImmutableEntry<>(_STREAM_KEY,
                    new StreamEntryID().UNRECEIVED_ENTRY);
            // 阻塞读取一条消息（最大阻塞时间120s）
            List<Map.Entry<String, List<StreamEntry>>> list = jedis.xreadGroup(_GROUP_NAME, _CONSUMER2_NAME, 1,
                    120 * 1000, true, entry);
            if (list != null && list.size() == 1) {
                // 读取到消息
                Map<String, String> content = list.get(0).getValue().get(0).getFields(); // 消息内容
                System.out.println("Consumer 2 读取到消息 ID：" + list.get(0).getValue().get(0).getID() +
                        " 内容：" + new Gson().toJson(content));
            }
        }
    }
}
