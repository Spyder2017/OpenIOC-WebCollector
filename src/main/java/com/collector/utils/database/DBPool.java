package com.collector.utils.database;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.HashMap;
import java.util.Properties;
import java.util.SortedMap;
import java.beans.PropertyVetoException; 
import java.io.IOException;

import com.mchange.v2.c3p0.ComboPooledDataSource; 

import java.sql.DatabaseMetaData;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.jsp.jstl.sql.Result;



public class DBPool {
    //保存数据库连接池的容器
    private static HashMap<String, ComboPooledDataSource> datasourceMap = new HashMap<String, ComboPooledDataSource>();
    private final static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    
    static {
        InitDataSource();
    }


    /**
     * 初始化连接池
     * */
    private final static void InitDataSource(){
    		Properties dbProperties = new Properties();
            try {
				dbProperties.load(DBPool.class.getClassLoader().getResourceAsStream("c3p0.properties"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
            //获取数据源名称
            Set<String> keys = new HashSet<String>();
            for (Object key : dbProperties.keySet()){
                String skey = (String)key;
                Integer point = skey.indexOf(".");
                keys.add(skey.substring(0, point));
            }

            //实例化DataSource并放入容器中
            for (String key : keys)
            {
                ComboPooledDataSource ds = new ComboPooledDataSource();
                try {
						ds.setDriverClass(dbProperties.getProperty(key + "." + "Driver"));
						ds.setJdbcUrl(dbProperties.getProperty(key + "." + "Url"));
		                ds.setUser(dbProperties.getProperty(key + "." + "User"));
		                ds.setPassword(dbProperties.getProperty(key + "." + "Password"));
		                ds.setMaxPoolSize(Integer.parseInt(dbProperties.getProperty(key + "." + "MaxPoolSize")));
		                ds.setMinPoolSize(Integer.parseInt(dbProperties.getProperty(key + "." + "MinPoolSize")));
		                ds.setMaxIdleTime(Integer.parseInt(dbProperties.getProperty(key + "." + "MaxIdleTime")));
		                ds.setInitialPoolSize(Integer.parseInt(dbProperties.getProperty(key + "." + "InitialPoolSize")));
		                ds.setAcquireIncrement(Integer.parseInt(dbProperties.getProperty(key + "." + "AcquireIncrement")));
		                ds.setAcquireRetryAttempts(Integer.parseInt(dbProperties.getProperty(key + "." + "AcquireRetryAttempts")));
		                ds.setAcquireRetryDelay(Integer.parseInt(dbProperties.getProperty(key + "." + "AcquireRetryDelay")));
		                ds.setMaxStatements(Integer.parseInt(dbProperties.getProperty(key + "." + "MaxStatements")));
		                ds.setIdleConnectionTestPeriod(Integer.parseInt(dbProperties.getProperty(key + "." + "IdleConnectionTestPeriod")));
		                ds.setCheckoutTimeout(Integer.parseInt(dbProperties.getProperty(key + "." + "CheckoutTimeout")));
		                ds.setTestConnectionOnCheckin(Boolean.parseBoolean(dbProperties.getProperty(key + "." + "TestConnectionOnCheckin")));
		                ds.setTestConnectionOnCheckout(Boolean.parseBoolean(dbProperties.getProperty(key + "." + "TestConnectionOnCheckout")));

		                datasourceMap.put(key, ds);

		                Connection conn = null;
						try {
							conn = getConnection(key);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                try {
							DatabaseMetaData metaData = conn.getMetaData();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		               
		                closeConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
            }
    }

    /**
     * 断开连接池
     * */
    public  final static  void closeDataSource(String dataSourceName){
        try{
            ComboPooledDataSource dataSource = datasourceMap.get(dataSourceName);
            dataSource.close();
        }
        catch (Exception e){
           // logger.error("Unable to destroy DataSource! " + e.toString());
        }
    }

    /**
     * 获取连接
     * @return Connection
     * */
    public final static Connection getConnection(String dataSourceName) throws SQLException{
        Connection conn = conns.get();
        if (conn == null || conn.isClosed()){
            ComboPooledDataSource dataSource = datasourceMap.get(dataSourceName);
            conn = dataSource.getConnection();
            conns.set(conn);
        }

        return conn;
    }

    /**
     * 关闭连接
     * */
    public final static void closeConnection(){
        Connection conn = conns.get();
        try{
            if (conn != null && !conn.isClosed()){
                conn.setAutoCommit(true);
                conn.close();
            }
        }
        catch (SQLException ex){
           // logger.error("Unable to close connection! " + ex.toString());
        }
        finally {
            conns.remove();
            //conns.set(null);
        }
    }

	    
public   static   void   main(String[]   args)   throws   SQLException   { 
	
	 
//	 for (Integer i=0; i<1000000; i++){
//         try{
//             System.out.println(DBPool.getConnection("DemoData"));
//           //  DBPool.closeConnection();
//             System.out.println(i+"---------------------------");
//
//         }
//         catch (Exception ex){
//             ex.printStackTrace();
//         }
//     }
			String sql = "select * from rules";
			//Object[] obj ={1};
			
			
			
//			String sql = "update ftrs_folder_copy set creator = 1 where id =1;";
			
			for(int i=0;i<10;i++){
//			Connection conn = DBPool.getConnection("DemoData");
//		System.out.println(DBHelper.isExist(sql,obj));
//			//	int  count = DBHelper.getCount(sql,obj);
//				
//				System.out.println(count);
//                Result result = DBHelper.executeQuery(sql);
//				for(SortedMap item : result.getRows()){
//					Object id = item.get("fname");
//					System.out.println(id);
//				}
				
			System.out.println(DBHelper.getCount(sql)+"\t"+i);
			}
			 
	} 
}
