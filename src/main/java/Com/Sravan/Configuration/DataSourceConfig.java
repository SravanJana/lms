package Com.Sravan.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource(value = "classpath:db.properties")
public class DataSourceConfig {

    @Value("${db_username}")
    String username;

    @Value("${db_password}")
    String password;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource hikariConfig = new ComboPooledDataSource();
        hikariConfig.setDriverClass("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://mysql-3074c864-spring-boot-mysql.i.aivencloud.com:19025/lms");
        hikariConfig.setUser(username);
        hikariConfig.setPassword(password);
        System.out.println("*********************************");
        System.out.println("hello world");


        hikariConfig.setMinPoolSize(5);
        hikariConfig.setAcquireIncrement(5);
        hikariConfig.setMaxPoolSize(20);
        hikariConfig.setMaxIdleTime(300);

        return hikariConfig;
    }

}
