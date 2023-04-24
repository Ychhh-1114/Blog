package blog.pojo;

import lombok.Data;

/**
 * @author ychhh
 * @ClassName Article.java
 * @Description TODO
 * @createTime 2022年04月19日 08:55:00
 */

@Data
public class Article {
    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    private String content;

    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    /**
     * 作者id
     */
    private Long authorId;
    /**
     * 内容id
     */
    private Long bodyId;
    /**
     *类别id
     */
    private Long categoryId;

    /**
     * 置顶
     */
    private int weight = Article_Common;


    /**
     * 创建时间
     */
    private Long createDate;




}
