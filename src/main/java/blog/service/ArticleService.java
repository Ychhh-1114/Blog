package blog.service;

import blog.pojo.Article;
import blog.vo.ArticleVo;
import blog.vo.Result;
import blog.vo.params.PageParams;

import java.util.List;

/**
 * @author ychhh
 * @ClassName ArticleService.java
 * @Description TODO
 * @createTime 2022年04月19日 09:19:00
 */
public interface ArticleService {

    List<ArticleVo> listArticle(PageParams pageParams, boolean isTag, boolean isUser);

    List<ArticleVo> listAllArticle();

    ArticleVo getArticleById(long id);

    List<ArticleVo> selectArticlesByType(String type);

    List<ArticleVo> getArticleByKeywords(String keywords);
}
