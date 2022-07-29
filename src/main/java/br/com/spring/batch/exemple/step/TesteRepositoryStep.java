package br.com.spring.batch.exemple.step;

import br.com.spring.batch.exemple.domain.Client;
import br.com.spring.batch.exemple.writer.RepositoryItemWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TesteRepositoryStep {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean(name = "repositoryStep")
    public Step repositoryStep(@Qualifier("repositoryItemReader") RepositoryItemReader repositoryItemReader, @Autowired RepositoryItemWriter repositoryItemWriter){
        return stepBuilderFactory
                .get("simpleStepReaderFile")
                .<Client, Client>chunk(1)
                .reader(repositoryItemReader)
                .writer(repositoryItemWriter)
                .build();
    }
}
