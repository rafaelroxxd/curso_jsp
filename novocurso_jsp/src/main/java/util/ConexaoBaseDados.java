package util;



import java.sql.Connection;

import java.sql.SQLException;



import org.apache.commons.dbcp2.BasicDataSource;

public class ConexaoBaseDados 
{
    private static String url = "jdbc:mysql://localhost:3306/db_produtos?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=true&useSSL=true";
    private static String username = "root";
    private static String password = "R1234567";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if (pool == null) 
        {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3);            
            pool.setDriverClassName("com.mysql.cj.jdbc.Driver");
            pool.setMinIdle(3);
            pool.setMaxIdle(8);
            pool.setMaxTotal(8);           
           
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException
   {
    	
    	
    	return getInstance().getConnection();
    }
    
 
}
