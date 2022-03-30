package br.com.spring.batch.exemple;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableBatchProcessing
@SpringBootApplication(scanBasePackages = "br.com.*, br.com.spring.batch.exemple.*")
public class MsSpringBatchApplication implements CommandLineRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(MsSpringBatchApplication.class, args);
        configurableApplicationContext.close();
    }

    @Override
    public void run(String... args) throws Exception {
//        Resource resource = new PathResource("ms-spring-batch\\src\\main\\resources\\dados\\Teste.txt");
//
//        StringBuffer text = new StringBuffer(1000000);
//        for(int i=0; i< 1000000; i++)
//            text.append(MessageFormat.format("Texto {0} \n", i));
//
//        BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile()));
//        writer.write(text.toString());
//        writer.close();
    }
}
