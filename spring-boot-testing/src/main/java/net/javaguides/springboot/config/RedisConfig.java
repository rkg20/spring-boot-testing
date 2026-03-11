package net.javaguides.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;


@Component
@ConfigurationProperties( prefix = "spring.data.redis")
public class RedisConfig {
    
    public String host;

    public String port;

    public String username;

    public String password;


    // @Bean
    // public LettuceConnectionFactory lettuceConnectionFactory(
    //         @Value("${spring.data.redis.host}") String host,
    //         @Value("${spring.data.redis.port}") int port,
    //         @Value("${spring.data.redis.username}") String username,
    //         @Value("${spring.data.redis.password}") String password) {

            

    //         var clientConfig = LettuceClientConfiguration.builder()
    //             .useSsl()
    //             .sslOptions(io.lettuce.core.SslOptions.builder()
    //                     .trustManager(io.netty.handler.ssl.util.InsecureTrustManagerFactory.INSTANCE)
    //                     .build())
    //             .commandTimeout(java.time.Duration.ofSeconds(5))
    //             .build();


    //         var standalone = new org.springframework.data.redis.connection.RedisStandaloneConfiguration(host, port);
    //     standalone.setUsername(username);
    //     standalone.setPassword(org.springframework.data.redis.connection.RedisPassword.of(password));

    //     return new org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory(standalone, clientConfig);

    // }



    // @Bean
    // RedisConnectionFactory redisConnectionFactory(){
    //     return new LettuceConnectionFactory("valkey-server-lineacr-4144.c.aivencloud.com",13189);
    // }

    // @Bean
    // RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
    //     RedisTemplate<String,Object> template=new RedisTemplate<>();
    //     template.setConnectionFactory(redisConnectionFactory);
    //     return template;
    // }


    // @Bean
    // StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
    //     return new StringRedisTemplate(redisConnectionFactory);
    // }

}
