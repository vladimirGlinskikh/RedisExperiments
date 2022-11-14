package kz.zhelezyaka.redisexperiment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisExperimentApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisExperimentApplication.class, args);
    }
}
