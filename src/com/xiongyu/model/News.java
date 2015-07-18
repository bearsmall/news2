package com.xiongyu.model;

/**
 * 新闻实体类
 * @author xiong
 */
public class News {
	private int id;		//ID
	private int user_id;//录入者id
	private int newsType_id;//新闻类型ID
	private String title;	//新闻标签
	private String author;	//作者姓名
	private String keywords;//关键字
	private String source;//新闻来源
	private String content;//新闻正文
	private String createTime;//创建时间
	private int click;//点击次数
	private int state;//状态位（0.未审核，1.已发布，2.已废除）
	private int del;//删除状态（0.未删除，1.已删除）
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getNewsType_id() {
		return newsType_id;
	}
	public void setNewsType_id(int newsType_id) {
		this.newsType_id = newsType_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
}
