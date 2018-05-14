package cn.synu.types.dao;
import static cn.synu.utils.DataSourceUtils.*;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.synu.domain.Types;
import cn.synu.utils.QueryRunner;
public class TypeDao {
	/**
	 * 查询所有图书分类
	 */
	public List<Types> queryAll(){
		String sql = "select * from types";
		QueryRunner run = new QueryRunner(getDatasSource());
		List<Types> types = 
				run.query(sql,new BeanListHandler<Types>(Types.class));
		return types;
	}
}
