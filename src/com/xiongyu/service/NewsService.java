package com.xiongyu.service;

import java.util.List;

import com.xiongyu.dao.NewsDao;
import com.xiongyu.dao.impl.NewsDaoImpl;
import com.xiongyu.model.News;
import com.xiongyu.model.NewsModel;
import com.xiongyu.model.PageModel;
import com.xiongyu.utils.AppException;

public class NewsService {
	private NewsDao newsDao = new NewsDaoImpl();

	/**创建一条新闻
	 * @param news 待创建的新闻实体对象
	 * @return 是否创建成功：true：成功，false：失败
	 * @throws AppException
	 */
	public boolean create(News news) throws AppException {
		boolean flag = false;// 定义标识
		try {
			flag = newsDao.add(news);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("com.xiongyu.service.NewsService.createNews");
		}
		return flag;
	}

	/**获得某一用户特定状态下的所有新闻（limit分页处理）
	 * @param state 新闻状态
	 * @param userId 用户id
	 * @param page 分页之当前页面
	 * @param size 分页之页面大小
	 * @return 分页模型对象
	 * @throws AppException
	 */
	public PageModel<NewsModel> getList(int state, int userId, int page, int size)
			throws AppException {
		PageModel<NewsModel> pageModel = new PageModel<NewsModel>();// 实例化分页模型
		List<NewsModel> newsList = null;// 声明新闻列表
		try {
			// 1.获取总记录数
			int totalCount = newsDao.getCount(state, userId);

			// 2.分页查询新闻信息
			newsList = newsDao.getList(state, userId, page, size);

			// 3.将总记录数设置到pageModel中
			pageModel.setTotalCount(totalCount);

			// 4.将page和size设置到pageModel中
			pageModel.setPage(page);
			pageModel.setSize(size);

			// 5.将新闻集合设置到pageModel中
			pageModel.setList(newsList);

		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.xiongyu.service.NewsService.getList(int state,int userId,int page,int size");
		}
		// 6.返回分页模型对象
		return pageModel;
	}

	/**获得特定状态下的所有新闻（limit分页处理）
	 * @param state 新闻状态
	 * @param page 分页之当前页数
	 * @param size 分页之页面大小
	 * @return 返回分页模型对象
	 * @throws AppException
	 */
	public PageModel<NewsModel> getList(int state, int page, int size) throws AppException {
		// ....构建分页模型对象
		PageModel<NewsModel> pageModel = new PageModel<NewsModel>();// 实例化分页模型
		List<NewsModel> newsList = null;// 声明新闻列表
		try {
			// 1.获取总记录数
			int totalCount = newsDao.getCount(state);

			// 2.分页查询新闻信息
			newsList = newsDao.getList(state, page, size);

			// 3.将总记录数设置到pageModel中
			pageModel.setTotalCount(totalCount);

			// 4.将page和size设置到pageModel中
			pageModel.setPage(page);
			pageModel.setSize(size);

			// 5.将新闻集合设置到pageModel中
			pageModel.setList(newsList);

		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.xiongyu.service.NewsService.getList(int state,int userId,int page,int size");
		}
		// 6.返回分页模型对象
		return pageModel;
	}

	/**获得特定类别的所有新闻（特定状态下），（limit分页处理）
	 * @param state 新闻状态
	 * @param newsTypeId 新闻类别id
	 * @param page 分页之当前页数
	 * @param size 分页之页面大小
	 * @return 分页模型对象
	 * @throws AppException
	 */
	public PageModel<NewsModel> getListByType(int state, int newsTypeId, int page, int size)
			throws AppException {
		PageModel<NewsModel> pageModel = new PageModel<NewsModel>();// 实例化分页模型
		List<NewsModel> newsList = null;// 声明新闻列表
		try {
			// 1.获取总记录数
			int totalCount = newsDao.getTypeCount(state, newsTypeId);

			// 2.分页查询新闻信息
			newsList = newsDao.getListByType(state, newsTypeId, page, size);

			// 3.将总记录数设置到pageModel中
			pageModel.setTotalCount(totalCount);

			// 4.将page和size设置到pageModel中
			pageModel.setPage(page);
			pageModel.setSize(size);
			// 5.将新闻集合设置到pageModel中
			pageModel.setList(newsList);

		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.xiongyu.service.NewsService.getList(int state,int userId,int page,int size");
		}
		// 6.返回分页模型对象
		return pageModel;
	}
	
	/**根据点击量查询新闻（分页）
	 * @param state 新闻状态
	 * @param page 分页之当前页面
	 * @param size 分页之页面大小
	 * @return 分页模型对象
	 * @throws AppException
	 */
	public PageModel<NewsModel> getListOnClickOrder(int state, int page, int size)
			throws AppException {
		PageModel<NewsModel> pageModel = new PageModel<NewsModel>();// 实例化分页模型
		List<NewsModel> newsList = null;// 声明新闻列表
		try {
			// 1.获取总记录数
			int totalCount = newsDao.getCount(state);

			// 2.分页查询新闻信息
			newsList = newsDao.getHotList(state, page, size);

			// 3.将总记录数设置到pageModel中
			pageModel.setTotalCount(totalCount);

			// 4.将page和size设置到pageModel中
			pageModel.setPage(page);
			pageModel.setSize(size);
			// 5.将新闻集合设置到pageModel中
			pageModel.setList(newsList);

		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.xiongyu.service.NewsService.getList(int state,int userId,int page,int size");
		}
		// 6.返回分页模型对象
		return pageModel;
	}
	
	public PageModel<NewsModel> getListByKeyWords(String key, int state, int page, int size)
			throws AppException {
		PageModel<NewsModel> pageModel = new PageModel<NewsModel>();// 实例化分页模型
		List<NewsModel> newsList = null;// 声明新闻列表
		try {
			// 1.获取总记录数
			int totalCount = newsDao.getCount(key,state);

			// 2.分页查询新闻信息
			newsList = newsDao.getListByKeyWords(key, state, page, size);

			// 3.将总记录数设置到pageModel中
			pageModel.setTotalCount(totalCount);

			// 4.将page和size设置到pageModel中
			pageModel.setPage(page);
			pageModel.setSize(size);
			// 5.将新闻集合设置到pageModel中
			pageModel.setList(newsList);

		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.xiongyu.service.NewsService.getList(int state,int userId,int page,int size");
		}
		// 6.返回分页模型对象
		return pageModel;
	}
	
	/**审核新闻
	 * @param state 新闻最后的状态
	 * @param id 新闻id
	 * @return 是否审核成功
	 * @throws AppException
	 */
	public boolean check(int state, int id) throws AppException {
		// ...审核新闻
		return newsDao.update(state, id);
	}

	/**预览新闻
	 * @param id 待预览新闻id
	 * @return 返回待预览新闻对象
	 * @throws AppException
	 */
	public News preview(int id) throws AppException {
		News news = newsDao.getById(id);
		return news;
	}
}