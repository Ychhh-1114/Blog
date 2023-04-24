package blog.service.impl;

import blog.mapper.TagMapper;
import blog.pojo.Article;
import blog.pojo.Tag;
import blog.service.TagService;
import blog.vo.Result;
import blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ychhh
 * @ClassName TagServiceImpl.java
 * @Description TODO
 * @createTime 2022年04月19日 10:07:00
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Long getTagIdByType(String type) {
        Long id = tagMapper.getTagIdsByType(type);
        return id;
    }

    @Override
    public String getTagStrByAtricleId(long id) {
        List<Tag> tags = tagMapper.getTagsByArticleID(id);
        String str = "";
        for(Tag tag : tags)
            if("design".equals(tag.getTagName())) str += " 设计模式";
            else if("heart".equals(tag.getTagName())) str +=" 个人心得";
            else str += " " + tag.getTagName();
        return str;
    }

    @Override
    public List<String> getTagNameByArticleId(long id) {
        List<Tag> tags = tagMapper.getTagsByArticleID(id);
        List<String> tagNames = new ArrayList<>();
        for(Tag tag : tags)
            tagNames.add(tag.getTagName());
        return tagNames;
    }

    @Override
    public Result hots(int limit) {
        List<Long> listId = tagMapper.getHotTagIds(limit);
        if(listId.isEmpty())
            return Result.sucess(Collections.emptyList());
        List<Tag> tags = tagMapper.getTagsByTagIds(listId);
        return Result.sucess(tags);
    }

    @Override
    public List<TagVo> getTagsByArticleID(long id) {
        List<Tag> tags = tagMapper.getTagsByArticleID(id);
        return copyList(tags);
    }

    public List<TagVo> copyList(List<Tag> tags){
        List<TagVo> list = new ArrayList<>();
        for(Tag tag : tags)
            list.add(copy(tag));
        return list;
    }

    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }
}
