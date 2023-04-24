package blog.service;

import blog.pojo.Article;
import blog.vo.Result;
import blog.vo.TagVo;

import java.util.List;

/**
 * @author ychhh
 * @ClassName TagService.java
 * @Description TODO
 * @createTime 2022年04月19日 10:06:00
 */
public interface TagService {

    List<TagVo> getTagsByArticleID(long id);

    Result hots(int limit);

    List<String> getTagNameByArticleId(long id);

    String getTagStrByAtricleId(long id);

    Long getTagIdByType(String type);
}
