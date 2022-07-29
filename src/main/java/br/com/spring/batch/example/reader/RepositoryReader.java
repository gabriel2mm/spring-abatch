package br.com.spring.batch.example.reader;

import br.com.spring.batch.example.domain.Client;
import br.com.spring.batch.example.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class RepositoryReader {

    private final ClientRepository repository;

    @Bean(name = "repositoryItemReader")
    RepositoryItemReader<Client> repositoryItemReader() {
        RepositoryItemReader<Client> repositoryItemReader = new RepositoryItemReader<>();
        repositoryItemReader.setRepository(repository);
        repositoryItemReader.setMethodName("findAll");
        repositoryItemReader.setPageSize(10);
        final HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        repositoryItemReader.setSort(sorts);
        return repositoryItemReader;
    }

}
