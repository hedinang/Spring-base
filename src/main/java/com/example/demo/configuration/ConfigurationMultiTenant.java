//package com.example.demo.configuration;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Configuration
//@EnableAsync
//@EnableAspectJAutoProxy
//public class ConfigurationMultiTenant {
//    public static final List<String> listTenantName = new ArrayList<String>();
//
//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        AbstractRoutingDataSource dataSource = new TenantAwareRoutingSource();
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put("db_default", defaultDataSource());
//        listTenantName.add("db_default");
//        targetDataSources.put("db_ha-noi", ontDataSource());
//        listTenantName.add("db_ha-noi");
//        targetDataSources.put("db_bac-ninh", stbDataSource());
//        listTenantName.add("db_bac-ninh");
//        targetDataSources.put("db_ca-mau", defaultDataSource());
//        listTenantName.add("db_ca-mau");
//        dataSource.setTargetDataSources(targetDataSources);
//        dataSource.afterPropertiesSet();
//        return dataSource;
//    }
//
//    public DataSource defaultDataSource() {
//        return DataSourceBuilder
//                .create()
//                .username("one-service-tr069")
//                .password("one@2019")
//                .url("jdbc:mysql://one-mariadb:3306/one-service-tr069?useSSL=false&useUnicode=yes&characterEncoding=UTF-8")
//                .driverClassName("com.mysql.jdbc.Driver")
//                .build();
//    }
//
//    public DataSource stbDataSource() {
//        return DataSourceBuilder
//                .create()
//                .username("one-service-tr069-stb")
//                .password("one@2019")
//                .url("jdbc:mysql://one-mariadb:3306/one-service-tr069-stb?useSSL=false&useUnicode=yes&characterEncoding=UTF-8")
//                .driverClassName("com.mysql.jdbc.Driver")
//                .build();
//    }
//
//    public DataSource ontDataSource() {
//        return DataSourceBuilder
//                .create()
//                .username("one-service-tr069-ont")
//                .password("one@2019")
//                .url("jdbc:mysql://one-mariadb:3306/one-service-tr069-ont?useSSL=false&useUnicode=yes&characterEncoding=UTF-8")
//                .driverClassName("com.mysql.jdbc.Driver")
//                .build();
//    }
//
//    public class TenantAwareRoutingSource extends AbstractRoutingDataSource {
//        @Override
//        protected Object determineCurrentLookupKey() {
//            Map<String, String> tenant = ThreadLocalStorage.getTenantName();
//            String tenantName = tenant.get("db");
//            if ((tenantName != null) && (ConfigurationMultiTenant.listTenantName.contains(tenantName))) {
//                return tenantName;
//            }
//            return "db-default";
//        }
//    }
//
//    @Bean
//    public PlatformTransactionManager platformTransactionManager(EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//
//}
