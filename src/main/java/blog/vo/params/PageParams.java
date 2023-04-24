package blog.vo.params;

import lombok.Data;

/**
 * @author ychhh
 * @ClassName PageParams.java
 * @Description TODO
 * @createTime 2022年04月19日 09:03:00
 */
@Data
public class PageParams {
    private int page = 1;

    private int pageSize = 10;
}
