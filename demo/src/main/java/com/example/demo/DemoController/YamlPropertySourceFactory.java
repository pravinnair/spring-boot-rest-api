package com.example.demo.DemoController;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

public class YamlPropertySourceFactory
        implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name,
                                                  EncodedResource encodedResource)
throws IOException{
//        we used YamlPropertiesFactoryBean to convert the resources in YAML format
//        to the java.util.Properties object
        YamlPropertiesFactoryBean factoryBean=new YamlPropertiesFactoryBean();
        factoryBean.setResources(encodedResource.getResource());
        Properties properties=factoryBean.getObject();
        return new PropertiesPropertySource(encodedResource.getResource().getFilename(),properties);
    }
}
