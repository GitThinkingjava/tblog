package com.tao.blog.s.common;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 定义Dao层通用的 CRUD操作 继承可以直接使用
 * 
 */
@Mapper
public interface BaseDao<T> {

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
	 * 根据id 查询
	 * 
	 * @param t 当前对象
	 * @return 单行记录
	 */
    T queryById(String id);

	/**
	 * 
	 * 
	 * 插入信息
	 * 
	 * @param t 当前对象
	 * @return 受影响的行数
	 */
    int save(T t);

	/**
	 * 更新信息
	 * 
	 * @param t 当前对象
	 * @return 受影响的行数
	 */
    int update(T t);

	/**
	 * 根据id 删除信息
	 * 
	 * @param String id 当前需要删除的id
	 * @return
	 */
    int delete(String id);

}
