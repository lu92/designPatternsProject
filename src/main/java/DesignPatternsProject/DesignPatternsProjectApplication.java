package DesignPatternsProject;

import DesignPatternsProject.entities.personalData.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import DesignPatternsProject.repositories.PrivelegeRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class DesignPatternsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsProjectApplication.class, args);
    }
}

@Component
class MyRunner implements CommandLineRunner{

    @Autowired
    public PrivelegeRepository privelegeRepository;

    @Override
    public void run(String... strings) throws Exception {
//        privelegeRepository.save(new Privilege("mordering"));
//        System.out.println("Size = " + privelegeRepository.count());
    }
}







