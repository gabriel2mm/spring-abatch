package br.com.spring.batch.exemple.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorConfiguration {

    private static final Integer NUMBER_OF_THREADS= 4;

    @Bean(name = "taskExecutor")
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(NUMBER_OF_THREADS);
        threadPoolExecutor.setQueueCapacity(NUMBER_OF_THREADS);
        threadPoolExecutor.setMaxPoolSize(NUMBER_OF_THREADS);
        return threadPoolExecutor;
    }
}
