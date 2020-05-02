package com.tao.blog.s.common;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 定义 Service 接口层通用的 CRUD操作 继承可以直接使用
 * 
 */
public interface BaseService<T> {

	/**
	 * 查询所有信息
	 * 
	 * @param t 查询所有 参数为 NULL ，支持条件查询，参数当前对象。
	 * @return List<当前对象>
	 */
	List<T> queryAll(T t);

	/**
	 * 查询对象，返回当前对象
	 * 
	 * @param t 当前对象
	 * @return 单行记录
	 */
	T queryObject(T t);

	/**
	 * 条件查询
	 * 
	 * @param t 当前对象
	 * @return 单行记录
	 */
	T queryById(String id);

	/**
	 * Mybatis的 pageHelper 分页插件
	 * 
	 * @param pageNo   当前页
	 * @param pageSize 一页显示几条数据
	 * @return
	 */
	PageInfo<T> pageHelpers(Integer pageNo,Integer pageSize);

	/**
	 * Mybatis的 pageHelper 分页插件
	 * 
	 * @param pageNo   当前页
	 * @param pageSize 指定一页显示几条数据
	 * @return
	 */
	PageInfo<T> pageHelpers(T t, Integer pageNo, Integer pageSize);

	/**
	 * 保存信息 调用 dao 层 如果受影响的行数不为 0 返回 true
	 * 
	 * @param t 当前对象信息
	 * @return true/false
	 */
	boolean save(T t);

	/**
	 * 保存信息 调用 dao 层 如果受影响的行数不为 0 返回 true
	 * 
	 * @param t 当前对象信息
	 * @return true/false
	 */
	boolean update(T t);

	/**
	 * 删除信息 调用 dao 层 如果受影响的行数不为 0 返回 true 否则 false
	 * 
	 * @param id 删除表信息的id
	 * @return true/false
	 */
	boolean delete(String id);

}
