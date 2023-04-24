package blog.mapper;

import blog.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ychhh
 * @ClassName ArticleMapper.java
 * @Description TODO
 * @createTime 2022年04月19日 08:58:00
 */
@Component
public interface ArticleMapper extends BaseMapper<Article> {
    @Select("select * from ms_article")
    List<Article> selectAll();

    Article getBodyByArticleId(long id);

    List<Long> getArticleIdsByTagId(Long tagId);

    List<Article> selectByIds(List<Long> articleIds);

    List<Article> getArticleByKeywords(String keywords);
}
