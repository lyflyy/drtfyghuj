package cn.mldn.util.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.dao.IEmpDAO;
import cn.mldn.util.dao.impl.EmpDAOImpl;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.util.service.IEMPService;
import cn.mldn.vo.Emp;

public class EmpServiceImpl implements IEMPService {

	@Override
	public boolean add(Emp vo) throws Exception {
		// TODO Auto-generated method stub
		IEmpDAO empDAO = DAOFactory.getInstance(EmpDAOImpl.class);
		return empDAO.doCreate(vo);
	}

	@Override
	public boolean edit(Emp vo) throws Exception {
		IEmpDAO empDAO = DAOFactory.getInstance(EmpDAOImpl.class);
		return empDAO.doUpdate(vo);
	}

	@Override
	public boolean removeEmp(Set<Integer> ids) throws Exception {
		IEmpDAO empDAO = DAOFactory.getInstance(EmpDAOImpl.class);
		return empDAO.doRemoveBatch(ids);
	}

	@Override
	public Map<String, Object> List(String mid, int eid) throws Exception {
		// TODO Auto-generated method stub
		IEmpDAO empDAO = DAOFactory.getInstance(EmpDAOImpl.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allEmps",empDAO.getAllCount());
		return null;
	}

	@Override
	public Map<String, Object> listByFlag(String mid, int flag, String column, String keyWord, int currentPage,
			int lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
