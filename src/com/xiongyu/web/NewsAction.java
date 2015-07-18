package com.xiongyu.web;

import com.opensymphony.xwork2.ActionSupport;
import com.xiongyu.model.News;
import com.xiongyu.model.NewsModel;
import com.xiongyu.model.PageModel;
import com.xiongyu.service.NewsService;
import com.xiongyu.utils.AppException;

@SuppressWarnings("serial")
public class NewsAction extends ActionSupport {
	private String key;
	private News news;
	private int page;
	private int size;
	private int state;
	private int newsTypeId;
	private int newsId;
	private PageModel<NewsModel> pageModel;

	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public int getNewsTypeId() {
		return newsTypeId;
	}

	public void setNewsTypeId(int newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public PageModel<NewsModel> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<NewsModel> pageModel) {
		this.pageModel = pageModel;
	}

	/**创建新闻功能
	 * @return
	 */
	public String createNews() {
		if (news == null) {
			return "fail";
		}
		NewsService newsService = new NewsService();
		try {
			if (newsService.create(news)) {
				return "success";
			} else {
				return "fail";
			}
		} catch (AppException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	/**查看所有state状态下的新闻功能
	 * @return
	 */
	public String showNews() {
		NewsService newsService = new NewsService();
		try {
			pageModel = newsService.getList(state, page, size);
			return "success";
		} catch (AppException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	/**主页标题栏分类别查看新闻功能
	 * @return
	 */
	public String showNewsType() {
		NewsService newsService = new NewsService();
		try {
			pageModel = newsService.getListByType(state, newsTypeId, page, size);
			return "success";
		} catch (AppException e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/**首页新闻栏目加载功能（一个新闻栏目对应一个新闻列表box）
	 * @return
	 */
	public String loadNewsBox() {
		NewsService newsService = new NewsService();
		try {
			pageModel = newsService.getListByType(state, newsTypeId, page, size);
			return "success";
		} catch (AppException e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	public String loadhotNewsBox(){
		NewsService newsService = new NewsService();
		try {
			pageModel = newsService.getListOnClickOrder(state, page, size);
			return "success";
		} catch (AppException e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/**审核新闻功能
	 * @return
	 */
	public String checkNews() {
		NewsService newsService = new NewsService();
		try {
			boolean flag = newsService.check(state, newsId);
			pageModel = newsService.getList(0, page, size);
			if (flag) {
				return "success";
			} else {
				return "fail";
			}
		} catch (AppException e) {
			e.printStackTrace();
		}
		return "fail";
	}

	/**预览新闻功能
	 * @return
	 */
	public String previewNews() {
		NewsService newsService = new NewsService();
		try {
			news = newsService.preview(newsId);
			if (news != null) {
				return "success";
			} else {
				return "fail";
			}
		} catch (AppException e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	public String searchNews(){
		NewsService newsService = new NewsService();
		try {
			pageModel = newsService.getListByKeyWords(key, state, page, size);
			return "success";
		} catch (AppException e) {
			e.printStackTrace();
			return "fail";
		}
	}
}