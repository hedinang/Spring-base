package com.example.demo.configuration;

//import com.example.demo.core.kafka.KafkaFactory;
//import com.example.demo.core.rabbitMq.RabbitMQFactory;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.example.demo.core.redis.CtmRedisTemplate;
import com.example.demo.core.redis.RedisFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
@EnableSwagger2
@Configuration
public class ConfigurationBean {
    //    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate template = new RabbitTemplate(new RabbitMQFactory().connectionFactory());
//        return template;
//    }
//
//    @Bean
//    public KafkaTemplate<Integer, String> kafkaTemplate() {
//        return new KafkaTemplate(new KafkaFactory().producerFactory());
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
//        factory.setConsumerFactory(new KafkaFactory().consumerFactory());
//        return factory;
//    }
//
//
//

    @Bean
    public CtmRedisTemplate getCtmRedisTemplate() {
        CtmRedisTemplate template = new CtmRedisTemplate();
        template.setConnectionFactory(new RedisFactory().jedisConnectionFactory());
        return template;
    }

    @Bean
    public Docket api() {
        //Adding Header
        ParameterBuilder aParameterBuilder1 = new ParameterBuilder();
        aParameterBuilder1.name("headerName").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        ParameterBuilder aParameterBuilder2 = new ParameterBuilder();
        aParameterBuilder2.name("testHeader").modelRef(new ModelRef("string")).parameterType("header").required(false).build();

        List<Parameter> aParameters = new ArrayList<>();
        aParameters.add(aParameterBuilder1.build());
        aParameters.add(aParameterBuilder2.build());
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.endpoint"))
                .paths(PathSelectors.regex("/.*")).build().apiInfo(apiInfo())
                .globalOperationParameters(aParameters);
    }
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors
//                        .basePackage("com.example.demo.endpoint"))
//                .paths(PathSelectors.regex("/.*"))
//                .build().apiInfo(apiEndPointsInfo());
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Endpoint API of System")
                .description("Giao diện api endpoint của hệ thống")
                .contact(new Contact("Trần Trí Dũng", "", "tridunga1@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
}
