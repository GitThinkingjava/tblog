package com.tao.blog.s.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;

/**
 * 定义 BaseService 接口通用的 CRUD操作 继承可以直接使用
 * 
 */
@Service
@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private BaseDao<T> baseDao;

	/**
	 * 查询所有信息
	 * 
	 * @param t 查询所有 参数为 NULL ，支持条件查询，参数当前对象。
	 * @return List<当前对象>
	 */

	@Override
	public List<T> queryAll(T t) {
		return baseDao.queryAll(t);
	}

    /**
	 * 查询对象，返回当前对象
	 * 
	 * @param t 当前对象
	 * @return 单行记录
	 */
	public T queryObject(T t) {
		return baseDao.queryObject(t);
	}

	/**
	 * 根据id 查询
	 * 
	 * @param t 当前对象
	 * @return 单行记录
	 */
	@Override
	public T queryById(String id) {
		return baseDao.queryById(id);
	}

	/**
	 * Mybatis的 pageHelper 分页插件
	 * 
	 * @param pageNo   当前页
	 * @param pageSize 一页显示几条数据
	 * @return
	 */
	@Override
	public PageInfo<T> pageHelpers(Integer pageNo, Integer pageSize) {
		return null;
	}

	/**
	 * Mybatis的 pageHelper 分页插件
	 * 
	 * @param pageNo   当前页
	 * @param pageSize 一页显示几条数据
	 * @return
	 */
	@Override
	public PageInfo<T> pageHelpers(T t, Integer pageNo, Integer pageSize) {
		return null;
	}

	/**
	 * 保存信息 调用 dao 层 如果受影响的行数不为 0 返回 true
	 * 
	 * @param t 当前对象信息
	 * @return true/false
	 */
	@Override
	public boolean save(T t) {
		boolean flag = false;
		int row = baseDao.save(t);
		if (row != 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 更新信息 调用 dao 层 如果受影响的行数不为 0 返回 true
	 * 
	 * @param t 当前对象信息
	 * @return true/false
	 */
	@Override
	public boolean update(T t) {
		boolean flag = false;
		int row = baseDao.update(t);
		if (row != 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 删除信息 调用 dao 层 如果受影响的行数不为 0 返回 true 否则 false
	 * 
	 * @param id 删除表信息的id
	 * @return true/false
	 */
	@Override
	public boolean delete(String id) {
		boolean flag = false;
		int row = baseDao.delete(id);
		if (row != 0) {
			flag = true;
		}
		return flag;
	}

}
