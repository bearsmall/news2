package com.xiongyu.test;

import java.util.List;

import org.junit.Test;

import com.xiongyu.dao.NewsDao;
import com.xiongyu.dao.impl.NewsDaoImpl;
import com.xiongyu.model.NewsModel;
import com.xiongyu.utils.AppException;

/**测试类
 * @author xiong
 *
 */
public class Search {

	public void hotSearch() {
		NewsDao newsdao = new NewsDaoImpl();
		try {
			List<NewsModel> newsList = newsdao.getHotList(1, 1, 23);
			for (NewsModel newsModel : newsList) {
				System.out.println(newsModel.getClick());
			}
		} catch (AppException e) {
			e.printStackTrace();
		}
	}

	public void keyWordsSearch1() {
		NewsDao newsdao = new NewsDaoImpl();
		try {
			System.out.println(newsdao.getCount("k", 1));
		} catch (AppException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void keyWordsSearch2() {
		NewsDao newsdao = new NewsDaoImpl();
		try {
			List<NewsModel> newsList = newsdao.getListByKeyWords("k", 1, 1, 30);
			for (NewsModel newsModel : newsList) {
				System.out.println(newsModel.getTitle());
			}
		} catch (AppException e) {
			e.printStackTrace();
		}
	}
}
