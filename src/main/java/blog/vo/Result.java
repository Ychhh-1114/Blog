package blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ychhh
 * @ClassName Result.java
 * @Description TODO
 * @createTime 2022年04月19日 09:10:00
 */



/*
 *功能描述
 *  对于数据请求结果的封装
 *  便于更好的前后端分离
 * @author ychhh
 * @date 2022/4/19
 * @param null
 * @return
 */
@Data
@AllArgsConstructor //全部构造方法注解
public class Result {
    private boolean success;

    private int code;

    private String msg;

    private Object data;

    static public Result sucess(Object obj){
        return new Result(true,200,"sucess",obj);
    }

}
