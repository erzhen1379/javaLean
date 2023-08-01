package leaning.redis.StreamTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.StreamEntryID;
import redis.clients.jedis.exceptions.JedisDataException;

import java.util.HashMap;
import java.util.Map;

public class RedisProducer {
    private static final String _STREAM_KEY = "mq2"; // 流 key
    private static final String _GROUP_NAME = "g12"; // 分组名称
    private static final String _CONSUMER_NAME = "c1"; // 消费者 1 的名称
    private static final String _CONSUMER2_NAME = "c2"; // 消费者 2 的名称

    public static void main(String[] args) throws InterruptedException {
        // 生产者
        producer();
        // 创建消费组
        createGroup(_STREAM_KEY, _GROUP_NAME);
    }

    /**
     * 创建消费分组
     *
     * @param stream    流 key
     * @param groupName 分组名称
     */
    public static void createGroup(String stream, String groupName) {
        Jedis jedis = new Jedis("localhost", 6379);
        // 检查消费者组是否已经存在
        if (!jedis.exists("group:" + groupName)) {
            // 创建新的消费者组
            try {
                jedis.xgroupCreate(stream, groupName, new StreamEntryID(), true);
            } catch (JedisDataException e) {
                // 消费者组已经存在
                System.out.println("Consumer group " + groupName + " already exists.");
            }
        }
    }

    /**
     * 生产者
     */
    public static void producer() throws InterruptedException {
        Jedis jedis = new Jedis("localhost", 6379);
        Map<String, String> map = new HashMap<>();

        int count = 0;
        while (true) {
            // 添加消息 1
            count++;
            map.put("c1 key : " + count, "value : " + count);
            StreamEntryID id = jedis.xadd(_STREAM_KEY, null, map);
            Thread.sleep(1000);
            System.out.println("消息添加成功 ID：" + id);
            // 添加消息 2
            Map<String, String> map2 = new HashMap<>();
            map2.put("--c2-- key : " + count, "value : " + count);
            StreamEntryID id2 = jedis.xadd(_STREAM_KEY, null, map2);
            System.out.println("消息添加成功 ID：" + id2);
        }


    }
}
