package cn.synu.types.service;
import java.util.List;
import cn.synu.domain.Types;
import cn.synu.types.dao.TypeDao;
public class TypeService {
	private TypeDao dao = new TypeDao();
	public List<Types> queryAll(){
		return dao.queryAll();
	}
}
