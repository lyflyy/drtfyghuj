package cn.mldn.util.service;

import java.util.Map;
import java.util.Set;

import cn.mldn.vo.Emp;

public interface IEMPService {
		public boolean add(Emp vo) throws Exception;
		public boolean edit(Emp vo) throws Exception ;
		public boolean removeEmp(Set<Integer> ids) throws Exception ;
		public Map<String,Object> List(String mid,int eid) throws Exception ;
		public Map<String, Object> listByFlag(String mid, int flag, String column, String keyWord, int currentPage,int lineSize) throws Exception; 
}
