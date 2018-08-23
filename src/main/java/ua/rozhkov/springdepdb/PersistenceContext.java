/*
package ua.rozhkov.springdepdb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ua.rozhkov.springdepdb.DAO")
public class PersistenceContext {

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("ua.rozhkov.springdepdb");

            */
/*Properties jpaProperties = new Properties();

            //Configures the used database dialect. This allows Hibernate to create SQL
            //that is optimized for the used database.
            jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

            //Specifies the action that is invoked to the database when the Hibernate
            //SessionFactory is created or closed.
            jpaProperties.put("hibernate.hbm2ddl.auto", "create");

            //Configures the naming strategy that is used when Hibernate creates
            //new database objects and schema elements
            jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");

            //If the value of this property is true, Hibernate writes all SQL
            //statements to the console.
            jpaProperties.put("hibernate.show_sql",
                    env.getRequiredProperty("hibernate.show_sql")
            );

            //If the value of this property is true, Hibernate will format the SQL
            //that is written to the console.
            jpaProperties.put("hibernate.format_sql",
                    env.getRequiredProperty("hibernate.format_sql")
            );

            entityManagerFactoryBean.setJpaProperties(jpaProperties);*//*


        return entityManagerFactoryBean;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    //Add the other beans here
}

*/
