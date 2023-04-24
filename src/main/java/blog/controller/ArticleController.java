package blog.controller;

import blog.pojo.Article;
import blog.service.ArticleService;
import blog.vo.ArticleVo;
import blog.vo.Result;
import blog.vo.params.PageParams;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

/**
 * @author ychhh
 * @ClassName ArticleController.java
 * @Description TODO
 * @createTime 2022年04月19日 09:01:00
 */
@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    @ResponseBody
    public Result articles() {
        List<ArticleVo> articles = articleService.listAllArticle();
        return Result.sucess(articles);
    }

    @GetMapping("/page/{id}")
    public ModelAndView articleBody(@PathVariable long id) {

        ModelAndView modelAndView = new ModelAndView();
        ArticleVo article = articleService.getArticleById(id);
        modelAndView.addObject("article", article);
        modelAndView.setViewName("/show/art.jsp");
        return modelAndView;
    }

    @GetMapping("/{type}")
    public ModelAndView getArticlesByType(@PathVariable String type){
        List<ArticleVo> list = articleService.selectArticlesByType(type);
        if (list.isEmpty())
            list = Collections.emptyList();
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("/show/tagIndex.jsp");
        return modelAndView;
    }

    @GetMapping("/search/{keywords}")
    public Result getArticlesBySearch(@PathVariable String keywords){
        System.out.println(66);
        String keyword_ = keywords.trim();
        if("".equals(keyword_)){
            return this.articles();
        }
        else{
            List<ArticleVo> list = articleService.getArticleByKeywords(keywords);
            return Result.sucess(list);
        }

    }
}
