package com.tao.blog.u.article.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tao.blog.s.common.BaseController;
import com.tao.blog.u.article.model.Article;
import com.tao.blog.u.article.service.IArticleService;
import com.tao.blog.u.article.service.ICategoryService;

import io.swagger.annotations.ApiOperation;

/**
 * 首页
 * 
 * @author tao
 *
 */
@Controller
public class IndexController extends BaseController {

	@Autowired
	public IArticleService articleService;

	@Autowired
	public ICategoryService categoryService;

	@ApiOperation("首页展示")
	@RequestMapping("index")
	public String index() {
		List<Article> queryAll =articleService.queryAll(null);
		
		//queryAll.stream().
		
		// 文章查询
		this.setReqAttr("articleList", queryAll.subList(0, 5));
		// 文章类型查询
		this.setReqAttr("articleCategoryList", categoryService.queryAll(null));
		return view("index");
	}

	@Override
	public String getModulePath() {
		return "";
	}

}
