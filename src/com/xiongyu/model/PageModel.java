package com.xiongyu.model;

import java.util.List;

/**分页模型实体类
 * @author xiong
 * @param <T>
 */
public class PageModel<T> {
	private List<T> list;// 数据集合
	private int size;// 每页记录数
	private int page;// 当前页码
	private int totalCount;// 总记录数

	/**
	 * 无参构造方法
	 */
	public PageModel() {
		super();
	}

	/**
	 * 构造方法
	 * @param page
	 * @param size
	 */
	public PageModel(int page, int size) {
		this(page, size, 0, null);
	}

	public PageModel(int page, int size, int totalCount, List<T> list) {
		this.page = page;
		this.size = size;
		this.totalCount = totalCount;
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**返回上一页的页数
	 * @return 上一页的页数（没有上一页的话返回当前页数）
	 */
	public int getPre() {
		if (hasPre())
			return page - 1;
		else {
			return page;
		}
	}

	/**得到下一页
	 * @return 下一页的页数（没有下一页的话返回当前页数）
	 */
	public int getNext() {
		if (hasNext())
			return page + 1;
		else {
			return page;
		}
	}

	/**获得总的页数
	 * @return 总页数
	 */
	public int getTotalPage() {
		int totalPage = totalCount / size;
		// 若总记录数%每页数量>0，
		// 表示末尾还有一页。
		if (totalCount % size > 0||totalCount==0) {
			totalPage++;
		}
		return totalPage;
	}

	/**判断是否有下一页
	 * @return true：有，false：没有
	 */
	public boolean hasNext() {
		int totalPage = getTotalPage();
		if (page < totalPage)
			return true;
		else {
			return false;
		}
	}

	/**判断是否有上一夜
	 * @return true:有，false：没有
	 */
	public boolean hasPre() {
		return page == 1 ? false : true;
	}
}
