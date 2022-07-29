package br.com.spring.batch.example.writer;

import br.com.spring.batch.example.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class RepositoryItemWriter implements ItemWriter<Client> {

    @Override
    public void write(List<? extends Client> list) throws Exception {
        list.stream().forEach(item -> { log.info(item.getName());});
    }
}
