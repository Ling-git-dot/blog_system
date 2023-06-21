package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.model.domain.Article;

import java.util.List;

public interface IArticleService {
    //做文件分页，查询文章列表 需要使用mybatis pagehepler插件

    //分页查询文章列表
    public PageInfo<Article> selectArticleWithPage(Integer page,Integer count);

    //统计前十的热度文章
    public List<Article> getHeatArticles();

    //根据id查询单个文章详情
    public Article selectArticleWithId(Integer id);

    //发布文章
    public void publish(Article article);

    // 根据主键更新文章
    public void updateArticleWithId(Article article);

    // 根据主键删除文章
    public void deleteArticleWithId(int id);
}
