package cn.mldn.util.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.AbstractDAO;
import cn.mldn.util.dao.IEmpDAO;
import cn.mldn.vo.Emp;

public class EmpDAOImpl extends AbstractDAO implements IEmpDAO {

	@Override
	public boolean doCreate(Emp vo) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO emp(empno,ename,age) VALUES (?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, vo.getEmpno());
		super.pstmt.setString(2, vo.getEname());
		super.pstmt.setInt(3, vo.getAge());
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(Emp vo) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE SET emp ename=?,age=? WHERE empno = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getEname());
		super.pstmt.setInt(2, vo.getAge());
		super.pstmt.setInt(3, vo.getEmpno());
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer("DELETE FROM emp WHERE deptno in (");
		Iterator<Integer> iter = ids.iterator();
		while(iter.hasNext()){
			buf.append(iter.next()).append(",");
		}
		buf.delete(buf.length()-1, buf.length()).append(")");
		super.pstmt = super.conn.prepareStatement(buf.toString());
		return super.pstmt.executeUpdate() == ids.size();
	}

	@Override
	public Emp findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		Emp emp = new Emp();
		String sql = "SELECT empno,ename,age FROM emp WHERE empno = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setAge(rs.getInt(3));
		}
		return emp;
	}

	@Override
	public List<Emp> findAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Emp> list = new ArrayList<Emp>();
		String sql = "SELECT empno,ename,age FROM EMP";
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Emp vo = new Emp();
			super.pstmt.setInt(1, vo.getEmpno());
			super.pstmt.setString(2, vo.getEname());
			super.pstmt.setInt(3, vo.getAge());
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<Emp> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		List<Emp> list = new ArrayList<Emp>();
		String sql = "SELECT empno,ename,age FROM emp LIMIT ?,?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, currentPage*lineSize);
		super.pstmt.setInt(2, (currentPage-1)*lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Emp vo = new Emp();
			super.pstmt.setInt(1, vo.getEmpno());
			super.pstmt.setString(2, vo.getEname());
			super.pstmt.setInt(3, vo.getAge());
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<Emp> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		List<Emp> list = new ArrayList<Emp>();
		String sql = "SELECT empno,ename,age FROM emp WHERE "+column+" LIKE ?"
				+ " AND LIMIT ?,? ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord+"%");
		super.pstmt.setInt(2, currentPage*lineSize);
		super.pstmt.setInt(3, (currentPage-1)*lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Emp vo = new Emp();
			super.pstmt.setInt(1, vo.getEmpno());
			super.pstmt.setString(2, vo.getEname());
			super.pstmt.setInt(3, vo.getAge());
			list.add(vo);
		}
		return list;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM emp";
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM emp WHERE "+column+" LIKE ? ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord+"%");
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
		return null;
	}

}
