package com.xiongyu.dao;

import java.util.List;

import com.xiongyu.model.News;
import com.xiongyu.model.NewsModel;
import com.xiongyu.utils.AppException;

public interface NewsDao {

	/**
	 * 新增新闻信息
	 * @param news 新闻对象
	 * @return boolean 成功返回true，否则返回false
	 * @throws AppException
	 */
	public boolean add(News news)throws AppException;
	/**
	 * 根据新闻typeid和新闻状态分页查询新闻集合（分页）
	 * @param state 新闻状态
	 * @param newsId 新闻id
	 * @param page 分页页码
	 * @param size 分页查询的数目
	 * @return 分页查询新闻集合
	 * @throws AppException
	 */
	public List<NewsModel> getListByType(int state,int newsTypeId,int page,int size) throws AppException;
	/**
	 * 根据用户id和新闻状态分页查询新闻集合（分页）
	 * @param state 新闻状态
	 * @param userId 用户id
	 * @param page 分页页码
	 * @param size 分页查询的数目
	 * @return 符合条件的新闻列表
	 * @throws AppException
	 */
	public List<NewsModel> getList(int state,int userId,int page,int size) throws AppException;
	/**
	 * 根据新闻状态查询新闻集合（分页）
	 * @param state 新闻状态
	 * @param page 分页之当前页码
	 * @param size 分页之页面大小
	 * @return 符合条件的新闻列表
	 * @throws AppException
	 */
	public List<NewsModel> getList(int state,int page,int size)throws AppException;
	
	/**查询热点新闻（点击量为指标）（分页）
	 * @param state 新闻状态
	 * @param page 分页之当前页码
	 * @param size 分页之页面大小
	 * @return 符合条件的新闻列表
	 * @throws AppException
	 */
	public List<NewsModel> getHotList(int state,int page,int size)throws AppException;
	
	/**根据关键字查询新闻（分页）
	 * @param key 关键字
	 * @param state 新闻状态
	 * @param page 分页之当前页码
	 * @param size 分页之页面大小
	 * @return 符合条件的新闻列表
	 * @throws AppException
	 */
	public List<NewsModel> getListByKeyWords(String key,int state,int page,int size)throws AppException;
	/**
	 * 根据用户id和新闻状态查询符合条件的记录数（分页）
	 * @param state 新闻状态
	 * @param userId 用户id
	 * @return 总记录数
	 * @throws AppException
	 */
	public int getCount(int state,int userId)throws AppException;
	
	/**根据新闻状态查询符合条件的总记录数
	 * @param state 新闻状态
	 * @return符合条件的新闻数量
	 * @throws AppException
	 */
	public int getCount(int state)throws AppException;
	
	/**查询包含特定关键字key，且状态为state的新闻条数
	 * @param key 关键字
	 * @param state 新闻状态
	 * @return 符合条件的新闻条数
	 * @throws AppException
	 */
	public int getCount(String key,int state)throws AppException;
	
	/**根据新闻状态查询特定类别新闻的总记录数
	 * @param state 新闻状态
	 * @return符合条件的新闻人数量
	 * @throws AppException
	 */
	public int getTypeCount(int state,int newsType)throws AppException;
	/**根据id查询新闻信息
	 * @param id 新闻id
	 * @return news新闻对象
	 */
	public News getById(int id)throws AppException;
	/**
	 * 根据id更新新闻的状态
	 * @param state 新闻状态
	 * @param id 新闻id
	 * @return 是否更新成功
	 * @throws AppException
	 */
	public boolean update(int state,int id)throws AppException;
	
	/**更新点击量
	 * @param id 新闻id
	 * @param click 点击量
	 * @return 成功true，失败false
	 */
	public boolean updateClick(int id,int click);
}
