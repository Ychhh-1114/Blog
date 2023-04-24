package blog.controller;

import blog.service.TagService;
import blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ychhh
 * @ClassName TagController.java
 * @Description TODO
 * @createTime 2022年04月20日 08:23:00
 */
@RestController //返回json数据
@RequestMapping("tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("hot")
    public Result hot(){
        int limit = 6;
        return Result.sucess(tagService.hots(limit));
    }
}
