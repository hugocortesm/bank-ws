package mx.com.allianz.course.bankws;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySource("application.properties")
public class BankApplicationConfiguration {

	@Value("${db.databaseName}")
	private String dataBaseName;
	@Value("${db.username}")
	private String dataBaseUserName;
	@Value("${db.password}")
	private String dataBasePassword;
	@Value("${db.host}")
	private String dataBaseHost;
	@Value("${db.port}")
	private String dataBasePort;
	@Value("${db.url}")
	private String dataBaseURL;

	@Bean("dataSource")
	public DataSource getDataSource() {
		OracleDataSource dataSource = null;
		try {
			dataSource = new OracleDataSource();
			dataSource.setUser(dataBaseUserName);
			dataSource.setPassword(dataBasePassword);
			dataSource.setURL(dataBaseURL);
			dataSource.setDatabaseName(dataBaseName);
			dataSource.setImplicitCachingEnabled(true);
			dataSource.setFastConnectionFailoverEnabled(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	public String getDataBaseUserName() {
		return dataBaseUserName;
	}

	public void setDataBaseUserName(String dataBaseUserName) {
		this.dataBaseUserName = dataBaseUserName;
	}

	public String getDataBasePassword() {
		return dataBasePassword;
	}

	public void setDataBasePassword(String dataBasePassword) {
		this.dataBasePassword = dataBasePassword;
	}

	public String getDataBaseHost() {
		return dataBaseHost;
	}

	public void setDataBaseHost(String dataBaseHost) {
		this.dataBaseHost = dataBaseHost;
	}

	public String getDataBasePort() {
		return dataBasePort;
	}

	public void setDataBasePort(String dataBasePort) {
		this.dataBasePort = dataBasePort;
	}

}
