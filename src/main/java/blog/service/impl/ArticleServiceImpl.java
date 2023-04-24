package blog.service.impl;

import blog.mapper.ArticleMapper;
import blog.mapper.TagMapper;
import blog.pojo.Article;
import blog.pojo.Tag;
import blog.service.ArticleService;
import blog.service.SysUserService;
import blog.service.TagService;
import blog.vo.ArticleVo;
import blog.vo.Result;
import blog.vo.TagVo;
import blog.vo.params.PageParams;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ychhh
 * @ClassName ArticleService.java
 * @Description TODO
 * @createTime 2022年04月19日 09:18:00
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private SysUserService userService;

    @Override
    public List<ArticleVo> getArticleByKeywords(String keywords) {
        List<Article> articles = articleMapper.getArticleByKeywords(keywords);
        return copyList(articles,true,false);
    }

    @Override
    public List<ArticleVo> selectArticlesByType(String type) {
        Long tagId = tagService.getTagIdByType(type);
        List<Long> articleIds = articleMapper.getArticleIdsByTagId(tagId);
        List<Article> articles = new ArrayList<>();
        if(articleIds.isEmpty())
            articles = Collections.emptyList();
         else articles = articleMapper.selectByIds(articleIds);
        return copyList(articles,true,false);
    }

    @Override
    public ArticleVo getArticleById(long id) {
        Article article = articleMapper.getBodyByArticleId(id);
        ArticleVo articleVo = copy(article,true,false);
        return articleVo;
    }

    @Override
    public List<ArticleVo> listAllArticle() {
        List<Article> list = articleMapper.selectAll();

        List<ArticleVo> resList = copyList(list,true,false);

        return resList;

    }

    @Override
    public List<ArticleVo> listArticle(PageParams pageParams,boolean isTag,boolean isUser) {
        Page<Article> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        // 按照指定规则进行排序
        LambdaQueryWrapper<Article>  queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.orderByDesc(Article::getWeight); //置顶

        queryWrapper.orderByDesc(Article::getCreateDate);

        Page<Article> articlePage = articleMapper.selectPage(page,queryWrapper);
        List<Article> records = articlePage.getRecords();

        List<ArticleVo> res = copyList(records,isTag,isUser);

        return res;
    }

    private List<ArticleVo> copyList(List<Article> records,boolean isTag,boolean isUser) {
        List<ArticleVo> list = new ArrayList<>();
        for(Article article : records)
            list.add(copy(article,isTag,isUser));
        return list;
    }

    private ArticleVo copy(Article article,boolean isTag,boolean isUser){
        ArticleVo articleVo = new ArticleVo();
        // 属性复制工具类
        BeanUtils.copyProperties(article,articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if (isTag){
            long id = article.getId();
            String tagName = tagService.getTagStrByAtricleId(id);
            articleVo.setTagName(tagName);
        }

        if(isUser){
            long id = article.getAuthorId();
            articleVo.setAuthor(userService.getUserByID(id).getNickname());
        }

        return articleVo;
    }


}
