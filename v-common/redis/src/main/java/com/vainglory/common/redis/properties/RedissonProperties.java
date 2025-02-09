package com.vainglory.common.redis.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.redisson.config.ReadMode;
import org.redisson.config.SubscriptionMode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Redisson 配置属性
 *
 */
@Data
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {

    /**
     * redis缓存key前缀
     */
    private String keyPrefix;

    /**
     * 线程池数量,默认值 = 当前处理核数量 * 2
     */
    private int threads;

    /**
     * Netty线程池数量,默认值 = 当前处理核数量 * 2
     */
    private int nettyThreads;

    /**
     * 单机服务配置
     */
    private SingleServerConfig singleServerConfig;

    /**
     * 集群服务配置
     */
    private ClusterServersConfig clusterServersConfig;

    @Data
    @NoArgsConstructor
    public static class SingleServerConfig {

        /**
         * 客户端名称
         */
        private String clientName;

        /**
         * 最小空闲连接数
         */
        private int connectionMinimumIdleSize;

        /**
         * 连接池大小
         */
        private int connectionPoolSize;

        /**
         * 连接空闲超时，单位：毫秒
         */
        private int idleConnectionTimeout;

        /**
         * 命令等待超时，单位：毫秒
         */
        private int timeout;

        /**
         * 发布和订阅连接池大小
         */
        private int subscriptionConnectionPoolSize;

    }

    @Data
    @NoArgsConstructor
    public static class ClusterServersConfig {

        /**
         * 客户端名称
         */
        private String clientName;

        /**
         * master最小空闲连接数
         */
        private int masterConnectionMinimumIdleSize;

        /**
         * master连接池大小
         */
        private int masterConnectionPoolSize;

        /**
         * slave最小空闲连接数
         */
        private int slaveConnectionMinimumIdleSize;

        /**
         * slave连接池大小
         */
        private int slaveConnectionPoolSize;

        /**
         * 连接空闲超时，单位：毫秒
         */
        private int idleConnectionTimeout;

        /**
         * 命令等待超时，单位：毫秒
         */
        private int timeout;

        /**
         * 发布和订阅连接池大小
         */
        private int subscriptionConnectionPoolSize;

        /**
         * 读取模式
         */
        private ReadMode readMode;

        /**
         * 订阅模式
         */
        private SubscriptionMode subscriptionMode;

    }

}




/**
 * redis集群配置 yml
 *
 * --- # redis 集群配置(单机与集群只能开启一个另一个需要注释掉)
 * spring.data:
 *   redis:
 *     cluster:
 *       nodes:
 *         - 192.168.0.100:6379
 *         - 192.168.0.101:6379
 *         - 192.168.0.102:6379
 *     # 密码
 *     password:
 *     # 连接超时时间
 *     timeout: 10s
 *     # 是否开启ssl
 *     ssl.enabled: false
 *
 * redisson:
 *   # 线程池数量
 *   threads: 16
 *   # Netty线程池数量
 *   nettyThreads: 32
 *   # 集群配置
 *   clusterServersConfig:
 *     # 客户端名称
 *     clientName: ${ruoyi.name}
 *     # master最小空闲连接数
 *     masterConnectionMinimumIdleSize: 32
 *     # master连接池大小
 *     masterConnectionPoolSize: 64
 *     # slave最小空闲连接数
 *     slaveConnectionMinimumIdleSize: 32
 *     # slave连接池大小
 *     slaveConnectionPoolSize: 64
 *     # 连接空闲超时，单位：毫秒
 *     idleConnectionTimeout: 10000
 *     # 命令等待超时，单位：毫秒
 *     timeout: 3000
 *     # 发布和订阅连接池大小
 *     subscriptionConnectionPoolSize: 50
 *     # 读取模式
 *     readMode: "SLAVE"
 *     # 订阅模式
 *     subscriptionMode: "MASTER"
 */

