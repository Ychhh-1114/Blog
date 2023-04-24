package blog.vo;

import blog.pojo.Tag;
import lombok.Data;

import java.util.List;

/**
 * @author ychhh
 * @ClassName ArticleVo.java
 * @Description TODO
 * @createTime 2022年04月19日 09:31:00
 */
@Data
public class ArticleVo {

    private String content;

    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private List<String> tagNames;

    private String tagName;


    private List<TagVo> tags;

    /**
     * 作者id
     */
    private String author;
    /**
     * 内容id
     */

    private int weight ;
    /**
     * 创建时间
     */
    private String createDate;


}
