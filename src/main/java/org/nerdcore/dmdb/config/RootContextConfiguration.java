package org.nerdcore.dmdb.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Hashtable;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EntityScan("org.nerdcore.dmdb.entity")
public class RootContextConfiguration {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("MySQLPass");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dmdb");
        return dataSource;
    }

    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        Map<String, Object> properties = new Hashtable<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(this.dataSource());
        factoryBean.setJpaVendorAdapter(adapter);
        factoryBean.setJpaPropertyMap(properties);
        factoryBean.setPackagesToScan("org.nerdcore.dmdb.entity");
        return factoryBean;
    }

    @Bean(name="transactionManager")
    public PlatformTransactionManager jpaTransactionManager(){
        return new JpaTransactionManager(this.entityManagerFactory().getObject());
    }

}
