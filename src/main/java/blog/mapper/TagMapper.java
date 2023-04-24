package blog.mapper;

import blog.pojo.SysUser;
import blog.pojo.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ychhh
 * @ClassName TagMapper.java
 * @Description TODO
 * @createTime 2022年04月19日 09:00:00
 */

public interface TagMapper  extends BaseMapper<Tag> {

    List<Tag> getTagsByArticleID(@Param("id")long id);

    List<Long> getHotTagIds(int limit);

    List<Tag> getTagsByTagIds(List<Long> tagIds);

    List<String> getTagsNameByIds(long id);

    Long getTagIdsByType(String type);
}
