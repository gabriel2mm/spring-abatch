package br.com.spring.batch.example.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class TesteRepositoryJob {

    private final JobBuilderFactory jobBuilderFactory;

    @Bean(name = "repositoryJob")
    public Job repositoryJob(@Qualifier("repositoryStep") Step repositoryStep){
        return jobBuilderFactory
                .get("job-repository")
                .incrementer(new RunIdIncrementer())
                .start(repositoryStep)
                .build();
    }
}
