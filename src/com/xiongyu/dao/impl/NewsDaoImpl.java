package com.xiongyu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.xiongyu.dao.NewsDao;
import com.xiongyu.model.News;
import com.xiongyu.model.NewsModel;
import com.xiongyu.utils.AppException;
import com.xiongyu.utils.DBUtil;

public class NewsDaoImpl implements NewsDao {

	@Override
	public boolean add(News news) throws AppException {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Integer userId = (Integer) session.get("userId");

		boolean flag = false;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "insert into t_news"
				+ "(title,user_id,newsType_id,source,author,createTime,keywords,content)"
				+ "values(?,?,?,?,?,?,?,?)";
		// 预编译sql，并指定返回生成的主键
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			// 设置参数值
			psmt.setString(1, news.getTitle());
			psmt.setInt(2, userId);
			psmt.setInt(3, news.getNewsType_id());
			psmt.setString(4, news.getSource());
			psmt.setString(5, news.getAuthor());
			psmt.setString(6, news.getCreateTime());
			psmt.setString(7, news.getKeywords());
			psmt.setString(8, news.getContent());

			psmt.executeUpdate();// 执行更新操作
			rs = psmt.getGeneratedKeys();// 得到插入行的主键，结果集中只有一条记录
			if (rs.next()) {
				news.setId(rs.getInt(1));// 获取主键的值，并设置到news对象中
				flag = true;// 如果受影响行数大于0，操作成功
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.xiongyu.dao.impl.NewsDaoImpl.add");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	public List<NewsModel> getList(int state, int userId, int page, int size)
			throws AppException {
		// 初始化新闻列表
		List<NewsModel> newsList = new ArrayList<NewsModel>();
		// 声明数据库连接对象，预编译对象的结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名和密码查询用户编号，“？”为占位符
			String sql = "select t_news.id,t_news.createTime,t_news.source,t_news.title,t_news.author,t_newstype.name "
					+ "from t_news,t_newstype "
					+ "where "
					+ "t_news.state=? and t_news.user_id=? "
					+ "and t_news.newstype_id=t_newstype.type_id "
					+ "and t_news.del=0 limit ?,?";
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// 设置新闻状态
			psmt.setInt(2, userId);// 设置用户id

			// 计算分页查询的起始位置
			int offset = (page - 1) * size;

			// 将分页查询参数设置到对应参数中
			psmt.setInt(3, offset);
			psmt.setInt(4, size);

			// 执行查询
			rs = psmt.executeQuery();// 执行查询操作
			// 提取信息，保存到newsList中
			while (rs.next()) {
				NewsModel newsModel = new NewsModel();// 实例化NewsModel对象
				// 设置newsNode对象的各属性值
				newsModel.setId(rs.getInt("id"));
				// 获取时间，格式："yyyy-mm-dd"
				String createTime = (rs.getString("createTime"));

				newsModel.setCreateTime(createTime);
				newsModel.setSource(rs.getString("source"));
				newsModel.setTitle(rs.getString("title"));
				newsModel.setAuthor(rs.getString("author"));
				newsModel.setNewsType(rs.getString("t_newstype.name"));// 设置新闻类别名称
				newsList.add(newsModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.xiongyu.dao.Impl.NewsDaoImpl.getList(int state,int userId");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	@Override
	public List<NewsModel> getList(int state, int page, int size)
			throws AppException {
		// 初始化新闻列表
		List<NewsModel> newsList = new ArrayList<NewsModel>();
		// 声明数据库连接对象，预编译对象的结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名和密码查询用户编号，“？”为占位符
			String sql = "select t_news.id,t_news.createTime,t_news.source,t_news.title,t_news.author,t_newstype.name "
					+ "from t_news,t_newstype "
					+ "where "
					+ "t_news.state=? "
					+ "and t_news.newstype_id=t_newstype.type_id "
					+ "and t_news.del=0 limit ?,?";
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// 设置新闻状态

			// 计算分页查询的起始位置
			int offset = (page - 1) * size;

			// 将分页查询参数设置到对应参数中
			psmt.setInt(2, offset);
			psmt.setInt(3, size);

			// 执行查询
			rs = psmt.executeQuery();// 执行查询操作
			// 提取信息，保存到newsList中
			while (rs.next()) {
				NewsModel newsModel = new NewsModel();// 实例化NewsModel对象
				// 设置newsNode对象的各属性值
				newsModel.setId(rs.getInt("id"));
				// 获取时间，格式："yyyy-mm-dd"
				String createTime = (rs.getString("createTime"));
				newsModel.setCreateTime(createTime);
				newsModel.setSource(rs.getString("source"));
				newsModel.setTitle(rs.getString("title"));
				newsModel.setAuthor(rs.getString("author"));
				// 设置新闻类别名称
				newsModel.setNewsType(rs.getString("t_newstype.name"));
				newsList.add(newsModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.xiongyu.dao.Impl.NewsDaoImpl.getList(int state,int userId");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	@Override
	public List<NewsModel> getListByType(int state, int newsTypeId, int page,
			int size) throws AppException {
		// 初始化新闻列表
		List<NewsModel> newsList = new ArrayList<NewsModel>();
		// 声明数据库连接对象，预编译对象的结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名和密码查询用户编号，“？”为占位符
			String sql = "select t_news.id,t_news.createTime,t_news.source,t_news.title,t_news.author,t_news.click "
					+ "from t_news "
					+ "where "
					+ "t_news.state=? and t_news.newsType_id=? "
					+ "and t_news.del=0 limit ?,?";
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// 设置新闻状态
			psmt.setInt(2, newsTypeId);// 设置新闻typeid

			// 计算分页查询的起始位置
			int offset = (page - 1) * size;

			// 将分页查询参数设置到对应参数中
			psmt.setInt(3, offset);
			psmt.setInt(4, size);
			// 执行查询
			rs = psmt.executeQuery();// 执行查询操作
			// 提取信息，保存到newsList中
			while (rs.next()) {
				NewsModel newsModel = new NewsModel();// 实例化NewsModel对象
				// 设置newsNode对象的各属性值
				newsModel.setId(rs.getInt("id"));
				// 获取时间，格式："yyyy-mm-dd"
				String createTime = (rs.getString("createTime"));
				newsModel.setCreateTime(createTime);
				newsModel.setSource(rs.getString("source"));
				newsModel.setTitle(rs.getString("title"));
				newsModel.setAuthor(rs.getString("author"));
				newsModel.setClick(rs.getInt("click"));

				newsList.add(newsModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.xiongyu.dao.Impl.NewsDaoImpl.getList(int state,int userId");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	@Override
	public List<NewsModel> getHotList(int state, int page, int size)
			throws AppException {
		// 初始化新闻列表
		List<NewsModel> newsList = new ArrayList<NewsModel>();
		// 声明数据库连接对象，预编译对象的结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名和密码查询用户编号，“？”为占位符
			String sql = "select t_news.id,t_news.createTime,t_news.source,t_news.title,t_news.author,t_news.click "
					+ "from t_news "
					+ "where "
					+ "t_news.state=? "
					+ "and t_news.del=0 order by click desc limit ?,?";
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// 设置新闻状态

			// 计算分页查询的起始位置
			int offset = (page - 1) * size;

			// 将分页查询参数设置到对应参数中
			psmt.setInt(2, offset);
			psmt.setInt(3, size);
			// 执行查询
			rs = psmt.executeQuery();// 执行查询操作
			// 提取信息，保存到newsList中
			while (rs.next()) {
				NewsModel newsModel = new NewsModel();// 实例化NewsModel对象
				// 设置newsNode对象的各属性值
				newsModel.setId(rs.getInt("id"));
				// 获取时间，格式："yyyy-mm-dd"
				String createTime = (rs.getString("createTime"));
				newsModel.setCreateTime(createTime);
				newsModel.setSource(rs.getString("source"));
				newsModel.setTitle(rs.getString("title"));
				newsModel.setAuthor(rs.getString("author"));
				newsModel.setClick(rs.getInt("click"));

				newsList.add(newsModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.xiongyu.dao.Impl.NewsDaoImpl.getList(int state,int userId");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	@Override
	public int getCount(int state, int userId) throws AppException {
		int rowCount = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			String sql = "select *"
					+ "from t_news where user_id=? and state=? and del=0";
			// 设置从参数，进行查询
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userId);// 设置新闻id
			psmt.setInt(2, state);// 设置新闻状态
			// 执行查询
			rs = psmt.executeQuery();// 执行查询操作
			// 提取信息，保存到newsList中
			rs.last(); // 移到最后一行
			rowCount = rs.getRow(); // 得到当前行号，也就是记录数
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return rowCount;
	}

	@Override
	public News getById(int id) throws AppException {
		News news = null;
		// 声明数据库连接对象，预编译对象的结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			String sql = "select id,author,title,createTime,source,click,content "
					+ "from t_news where id=? and del=0";
			// 设置从参数，进行查询
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);// 设置新闻id
			// 执行查询
			rs = psmt.executeQuery();// 执行查询操作
			// 提取信息，保存到newsList中
			if (rs.next()) {
				news = new News();// 创建一个News实例对象
				// 设置news对象的各属性的值
				news.setId(rs.getInt("id"));
				news.setAuthor(rs.getString("author"));
				news.setTitle(rs.getString("title"));
				news.setCreateTime(rs.getString("createTime"));
				news.setSource(rs.getString("source"));
				int click = rs.getInt("click") + 1;
				news.setClick(click);
				news.setContent(rs.getString("content"));

				updateClick(id, click);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return news;
	}

	@Override
	public int getCount(int state) throws AppException {
		int rowCount = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			String sql = "select *" + "from t_news where state=? and del=0";
			// 设置从参数，进行查询
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// 设置新闻状态
			// 执行查询
			rs = psmt.executeQuery();// 执行查询操作
			// 提取信息，保存到newsList中
			rs.last(); // 移到最后一行
			rowCount = rs.getRow(); // 得到当前行号，也就是记录数
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return rowCount;
	}

	@Override
	public int getTypeCount(int state, int newsType) throws AppException {
		int rowCount = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			String sql = "select *"
					+ "from t_news where state=? and newsType_id=? and del=0";
			// 设置从参数，进行查询
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// 设置新闻状态
			psmt.setInt(2, newsType);// 设置新闻类别Id
			// 执行查询
			rs = psmt.executeQuery();// 执行查询操作
			// 提取信息，保存到newsList中
			rs.last(); // 移到最后一行
			rowCount = rs.getRow(); // 得到当前行号，也就是记录数
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return rowCount;
	}

	@Override
	public boolean update(int state, int id) throws AppException {
		// 声明数据库连接对象，预编译对象的结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			String sql = "update t_news set state=? where id=? and del=0";
			// 设置从参数，进行查询
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// 设置新闻状态
			psmt.setInt(2, id);
			int role = psmt.executeUpdate();
			if (role >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return false;
	}

	@Override
	public boolean updateClick(int id, int click) {
		// 声明数据库连接对象，预编译对象的结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			String sql = "update t_news set click=? where id=? and del=0";
			// 设置从参数，进行查询
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, click);// 设置新闻状态
			psmt.setInt(2, id);
			int role = psmt.executeUpdate();
			if (role >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return false;
	}

	@Override
	public List<NewsModel> getListByKeyWords(String key, int state, int page,
			int size) throws AppException {
		// 初始化新闻列表
		List<NewsModel> newsList = new ArrayList<NewsModel>();
		// 声明数据库连接对象，预编译对象的结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名和密码查询用户编号，“？”为占位符
			String sql = "select t_news.id,t_news.createTime,t_news.source,t_news.title,t_news.author,t_newstype.name "
					+ "from t_news,t_newstype "
					+ "where "
					+ "t_news.state=? "
					+ "and t_news.newstype_id=t_newstype.type_id "
					+ "and t_news.del=0 and (keywords like ? or title like ?) limit ?,?";
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// 设置新闻状态
			psmt.setString(2, "%"+key+"%");// 设置查询关键字
			psmt.setString(3, "%"+key+"%");// 设置查询关键字
			// 计算分页查询的起始位置
			int offset = (page - 1) * size;
			
			// 将分页查询参数设置到对应参数中
			psmt.setInt(4, offset);
			psmt.setInt(5, size);

			// 执行查询
			rs = psmt.executeQuery();// 执行查询操作
			// 提取信息，保存到newsList中
			while (rs.next()) {
				NewsModel newsModel = new NewsModel();// 实例化NewsModel对象
				// 设置newsNode对象的各属性值
				newsModel.setId(rs.getInt("id"));
				// 获取时间，格式："yyyy-mm-dd"
				String createTime = (rs.getString("createTime"));
				newsModel.setCreateTime(createTime);
				newsModel.setSource(rs.getString("source"));
				newsModel.setTitle(rs.getString("title"));
				newsModel.setAuthor(rs.getString("author"));
				// 设置新闻类别名称
				newsModel.setNewsType(rs.getString("t_newstype.name"));
				newsList.add(newsModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.xiongyu.dao.Impl.NewsDaoImpl.getList(int state,int userId");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	@Override
	public int getCount(String key, int state) throws AppException {
		int rowCount = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			String sql = "select * "
					+ "from t_news where state=? and del=0 and keywords like ?";
			// 设置从参数，进行查询
			// 预编译sql，并设置参数
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// 设置新闻状态
			psmt.setString(2, "%" + key + "%");
			// 执行查询
			rs = psmt.executeQuery();// 执行查询操作
			// 提取信息，保存到newsList中
			rs.last(); // 移到最后一行
			rowCount = rs.getRow(); // 得到当前行号，也就是记录数
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return rowCount;
	}
}
