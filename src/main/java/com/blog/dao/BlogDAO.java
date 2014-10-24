package com.blog.dao;

import com.blog.domain.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 博客
 * @author kongqingyu
 * @date 2013-3-20 下午9:47:11
 */
public interface BlogDAO {

	/**
	 * 查询用户博客信息
	 * @return
	 */
	@Select("SELECT * FROM ch_blog WHERE uid=#{uid} AND status=#{status} ORDER BY create_time DESC LIMIT #{offset},#{size}")
    List<Blog> getByUid(@Param("uid") long uId,@Param("offset") int offset,@Param("size") int size,@Param("status") int status);

    /**
     * 查询分享信息列表
     * @return
     */
    @Select("SELECT id,title FROM ch_blog WHERE status=#{status} ORDER BY create_time DESC LIMIT 0,#{size}")
    List<Blog> queShares(@Param("size") int size,@Param("status") int status);

    /**
     * 查询博客总数
     * @param status
     * @return
     */
    @Select("SELECT count(*) FROM ch_blog WHERE status=#{status}")
    int getTotalCount(@Param("status") int status);

    /**
     * 添加博客
     * @param blog
     */
    @Insert("INSERT INTO ch_blog (uid,title,content,content_txt,type,create_time,update_time,status) " +
            "VALUES (#{uid},#{title},#{content},#{content_txt},#{type},#{create_time},#{update_time},#{status})")
    void save(Blog blog);

    /**
     * 查询博客详情
     * @param blogId
     * @return
     */
    @Select("SELECT * FROM ch_blog WHERE id=#{id} AND status!=-1")
    Blog getDetailById(@Param("id") Long blogId);

    /**
     * 增加预览数量
     * @param blogId
     */
    @Select("UPDATE ch_blog SET view_count=view_count+1 WHERE id=#{id}")
    void addViewCount(@Param("id") Long blogId);

    /**
     * 增加支持数量
     * @param blogId
     */
    @Select("UPDATE ch_blog SET support_count=support_count+1 WHERE id=#{id}")
    void addSupportCount(@Param("id") Long blogId);

    /**
     * 增加评论数量
     * @param blogId
     */
    @Select("UPDATE ch_blog SET comment_count=comment_count+1 WHERE id=#{id}")
    void addCommentCount(@Param("id") Long blogId);

	
	
	
}
