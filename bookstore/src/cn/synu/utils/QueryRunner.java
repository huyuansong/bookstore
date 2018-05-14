package cn.synu.utils;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.sql.DataSource;

import org.apache.commons.dbutils.ResultSetHandler;
public class QueryRunner extends org.apache.commons.dbutils.QueryRunner{
	//添加save方法
	/**
	 * 对传递的bean进行分析
	 * 将t对象转成insert into users
	 */
	public <T> T save(T t) throws Exception{
		//获取类
		Class<?> cls = t.getClass();
		//从这个字节码上获取name值这个就是表名
		Table table = cls.getAnnotation(Table.class);
		//获取表名
		String tableName = table.name();
		//组成insert into users(id,name,pwd) values('id',"name','');
		String sql = "insert into "+tableName;
		String cols="(";
		String values="values(";
		
		//获取所有声明的字段
		Field[] fs = cls.getDeclaredFields();
		//遍历所有字段
		for(Field f:fs){
			if(f.isAnnotationPresent(Column.class)){
				//获取列名
				String colName = f.getName();
				//获取column的对象
				Column col = f.getAnnotation(Column.class);
				if(col.name()!=null && !col.name().trim().equals("")){
					colName=col.name();
				}
				//获取列值
				f.setAccessible(true);
				//获取列值
				Object value = f.get(t);
				if(cols.equals("(")){
					cols+=colName;
					if(value instanceof String){
						values+="'"+value+"'";
					}else{
						values+=value;
					}
					
				}else{
					cols+=","+colName;
					if(value instanceof String){
						values+=",'"+value+"'";
					}else{
						values+=","+value;
					}
				}
			}
		}
		cols+=")";
		values+=")";
		sql = sql+cols+" "+values;
		System.err.println(sql);
		update(sql);
		return t;
	}
	
	
	
	
	public QueryRunner() {
	}
	public QueryRunner(DataSource ds){
		super(ds);
	}
	@Override
	public int[] batch(Connection arg0, String arg1, Object[][] arg2){
		try {
			return super.batch(arg0, arg1, arg2);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	@Override
	public int[] batch(String sql, Object[][] params){
		try {
			return super.batch(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	protected void close(Connection conn) {
		try {
			super.close(conn);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	protected void close(ResultSet rs){
		try {
			super.close(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}

	@Override
	protected void close(Statement stmt){
		try {
			super.close(stmt);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}

	@Override
	public void fillStatement(PreparedStatement arg0, Object... arg1)
			{
		try {
			super.fillStatement(arg0, arg1);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public void fillStatementWithBean(PreparedStatement arg0, Object arg1,
			PropertyDescriptor[] arg2){
		try {
			super.fillStatementWithBean(arg0, arg1, arg2);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public void fillStatementWithBean(PreparedStatement arg0, Object arg1,
			String... arg2) {
		try {
			super.fillStatementWithBean(arg0, arg1, arg2);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public DataSource getDataSource() {
		return super.getDataSource();
	}

	@Override
	protected Connection prepareConnection() {
		try {
			return super.prepareConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	protected PreparedStatement prepareStatement(Connection conn, String sql)
			{
		try {
			return super.prepareStatement(conn, sql);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	
	}

	@Override
	public <T> T query(Connection conn, String sql, Object param,
			ResultSetHandler<T> rsh) {
		try {
			return super.query(conn, sql, param, rsh);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public <T> T query(Connection conn, String sql, Object[] params,
			ResultSetHandler<T> rsh) {
		try {
			return super.query(conn, sql, params, rsh);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	public <T> T query(Connection arg0, String arg1, ResultSetHandler<T> arg2,
			Object... arg3){
		try {
			return super.query(arg0, arg1, arg2, arg3);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh)
			 {
		try {
			return super.query(conn, sql, rsh);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh)
		 {
		try {
			return super.query(sql, param, rsh);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh)
			 {
		try {
			return super.query(sql, params, rsh);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
			 {
		try {
			return super.query(sql, rsh, params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh){
		try {
			return super.query(sql, rsh);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	protected void rethrow(SQLException cause, String sql, Object... params)
			 {
		try {
			super.rethrow(cause, sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public int update(Connection arg0, String arg1, Object... arg2)
			 {
		try {
			return super.update(arg0, arg1, arg2);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public int update(Connection conn, String sql, Object param)
			 {
		try {
			return super.update(conn, sql, param);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public int update(Connection conn, String sql) {
		try {
			return super.update(conn, sql);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public int update(String sql, Object... params){
		try {
			return super.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public int update(String sql, Object param){
		try {
			return super.update(sql, param);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	public int update(String sql) {
		try {
			return super.update(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

	@Override
	protected ResultSet wrap(ResultSet rs) {
		return super.wrap(rs);
	}
}
