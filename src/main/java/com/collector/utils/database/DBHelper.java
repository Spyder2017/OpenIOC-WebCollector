package com.collector.utils.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

/**
 * @author Java
 * 
 */
public class DBHelper {

	// 此方法为获取数据库连接

	public static Connection getConnection() {

		Connection conn = null;

		try {
			conn = DBPool.getConnection("DemoData");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 
	 * 增删改【Add、Del、Update】
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @return int
	 */

	public static int executeNonQuery(String sql) {

		int result = 0;

		Connection conn = null;

		Statement stmt = null;

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			result = stmt.executeUpdate(sql);

			free(null, stmt, conn);

		} catch (SQLException err) {

			err.printStackTrace();

			free(null, stmt, conn);

		} finally {

			free(null, stmt, conn);

		}

		return result;

	}

	/**
	 * 
	 * 增删改【Add、Delete、Update】
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @param obj
	 * 
	 * @return int
	 */

	public static int executeNonQuery(String sql, Object... obj) {

		int result = 0;

		Connection conn = null;

		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < obj.length; i++) {

				pstmt.setObject(i + 1, obj[i]);

			}

			result = pstmt.executeUpdate();

			free(null, pstmt, conn);

		} catch (SQLException err) {

			err.printStackTrace();

			free(null, pstmt, conn);

		} finally {

			free(null, pstmt, conn);

		}

		return result;

	}

	/**
	 * 
	 * 查【Query】
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @return ResultSet
	 */

	public static Result executeQuery(String sql) {

		Result result = null;

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			result = ResultSupport.toResult(rs);

			free(rs, stmt, conn);

		} catch (SQLException err) {

			err.printStackTrace();

			free(rs, stmt, conn);

		}

		return result;

	}

	/**
	 * 
	 * 查【Query】
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @param obj
	 * 
	 * @return ResultSet
	 */

	public static Result executeQuery(String sql, Object... obj) {

		Result result = null;

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < obj.length; i++) {

				pstmt.setObject(i + 1, obj[i]);

			}

			rs = pstmt.executeQuery();

			result = ResultSupport.toResult(rs);

			free(rs, pstmt, conn);

		} catch (SQLException err) {

			err.printStackTrace();

			free(rs, pstmt, conn);

		}

		return result;

	}

	/**
	 * 
	 * 判断记录是否存在
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @return Boolean
	 */

	public static Boolean isExist(String sql) {

		int count = getCount(sql);

		if (count > 0) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * 
	 * 判断记录是否存在
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @return Boolean
	 */

	public static Boolean isExist(String sql, Object... obj) {

		int count = getCount(sql, obj);

		if (count > 0) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * 
	 * 获取查询记录的总行数
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @return int
	 */

	public static int getCount(String sql) {

		Result result = executeQuery(sql);

		return result.getRowCount();

	}

	/**
	 * 
	 * 获取查询记录的总行数
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @param obj
	 * 
	 * @return int
	 */

	public static int getCount(String sql, Object... obj) {

		Result result = executeQuery(sql, obj);

		return result.getRowCount();

	}

	/**
	 * 
	 * 释放【ResultSet】资源
	 * 
	 * 
	 * 
	 * @param rs
	 */

	public static void free(ResultSet rs) {

		try {

			if (rs != null) {

				rs.close();

			}

		} catch (SQLException err) {

			err.printStackTrace();

		}

	}

	/**
	 * 
	 * 释放【Statement】资源
	 * 
	 * 
	 * 
	 * @param st
	 */

	public static void free(Statement st) {

		try {

			if (st != null) {

				st.close();

			}

		} catch (SQLException err) {

			err.printStackTrace();

		}

	}

	/**
	 * 
	 * 释放【Connection】资源
	 * 
	 * 
	 * 
	 * @param conn
	 */

	public static void free(Connection conn) {

		DBPool.closeConnection();

	}

	/**
	 * 
	 * 释放所有数据资源
	 * 
	 * 
	 * 
	 * @param rs
	 * 
	 * @param st
	 * 
	 * @param conn
	 */

	public static void free(ResultSet rs, Statement st, Connection conn) {

		free(rs);

		free(st);

		free(conn);

	}

	public static void main(String[] args) throws SQLException{
		String query="select * from      rules";
//		DBHelper.executeNonQuery(query);
		System.out.printf(DBHelper.getConnection().toString());
	}
}