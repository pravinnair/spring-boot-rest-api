package com.example.demo.DemoController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value="classpath:application.yml",
factory = YamlPropertySourceFactory.class)
public class DemoController {
    @Value("${spring.profiles.active}")
    private String springProfiles;

    @GetMapping("/demoYaml")
    public void demoController(){
        System.out.println("SpringProfiles"+ springProfiles);
    }
}
