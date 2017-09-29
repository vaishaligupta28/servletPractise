package com.testbatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserService {

	public void insertUser(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);
			infoMapper.insertUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public User getUserById(Integer userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);
			return infoMapper.getUserById(userId);
		} finally {
			sqlSession.close();
		}
	}

	public List<User> getAllUsers() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);
			return infoMapper.getAllUsers();
		} finally {
			sqlSession.close();
		}
	}

	public void updateUser(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);
			infoMapper.updateUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void deleteUser(Integer userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);
			infoMapper.deleteUser(userId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
