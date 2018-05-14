package cn.synu.address.service;

import java.util.List;

import cn.synu.address.dao.AddressDao;
import cn.synu.domain.Address;
public class AddressService {
	private AddressDao dao = new AddressDao();
	public List<Address> queryAll(String uid){
		return dao.queryAll(uid);
	}
	public Address queryOne(String id){
		return dao.queryOne(id);
	}
}
