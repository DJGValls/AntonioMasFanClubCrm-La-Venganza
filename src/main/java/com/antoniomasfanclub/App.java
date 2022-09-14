package com.antoniomasfanclub;

import com.antoniomasfanclub.model.CLI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        new CLI().runCRM();
    }
}
