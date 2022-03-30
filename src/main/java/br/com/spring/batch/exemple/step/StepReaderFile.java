package br.com.spring.batch.exemple.step;

import br.com.spring.batch.exemple.configuration.TaskExecutorConfiguration;
import br.com.spring.batch.exemple.reader.CustomTextFileReader;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;

import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.task.TaskExecutor;

@Configuration
@RequiredArgsConstructor
@Import(value = TaskExecutorConfiguration.class)
public class StepReaderFile {

    private boolean batchJobState = false;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step simpleStepReaderFile(@Qualifier("taskExecutor") TaskExecutor taskExecutor)  {
        return stepBuilderFactory
                .get("simpleStepReaderFile")
                .chunk(1)
                .reader(streamReader())
                .writer(writer())
                .taskExecutor(taskExecutor)
                .build();
    }

    public ItemReader<String> streamReader(){

        if(batchJobState)
            return null;

        batchJobState = true;
        Resource resource = new FileSystemResource("ms-spring-batch\\src\\main\\resources\\dados\\Teste.txt");
        return new CustomTextFileReader(resource);
    }

    public ItemWriter<? super Object> writer()
    {
        return itens -> itens.forEach(System.out::println);
    }
}
