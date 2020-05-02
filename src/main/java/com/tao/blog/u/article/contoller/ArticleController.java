package com.tao.blog.u.article.contoller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tao.blog.s.LoginCheck;
import com.tao.blog.s.common.BaseController;
import com.tao.blog.s.rest.Resp;
import com.tao.blog.s.rest.ReturnRest;
import com.tao.blog.u.article.ArticleHelper;
import com.tao.blog.u.article.model.Article;
import com.tao.blog.u.article.service.IArticleService;
import com.tao.blog.u.article.service.ICategoryService;
import com.tao.blog.u.users.model.Users;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

/**
 * 文章前台展示
 * 
 * @author tao
 *
 */
@Log4j2
@Controller
@RequestMapping(ArticleHelper.PLUGIN_MAPPING)
public class ArticleController extends BaseController {

	@Autowired
	IArticleService articleService;

	@Autowired
	public ICategoryService categoryService;
	
	@ApiOperation("文章列表")
	@RequestMapping("index")
	public String index(Integer pageNo) {
		List<Article> ArticleList = articleService.queryAll(null);
		PageInfo<Article> pageInfo=articleService.pageHelpers(pageNo,6);
		this.setReqAttr("ariticlePage",pageInfo);
		this.setReqAttr("articleList", ArticleList);
		this.setReqAttr("articleCategoryList", categoryService.queryAll(null));
		return "article-list";
	}

	@ApiOperation("文章详情")
	@RequestMapping("details/{id}")
	public String Details(@PathVariable String id) {
		this.setReqAttr("details", articleService.queryById(id));
		return "article-details";
	}

	@ApiOperation("rest文章列表 ")
	@ResponseBody
	@RequestMapping("rest")
	public ReturnRest<Object> indexs(Integer pageNo, Integer pageSize) {
		PageInfo<Article> page = articleService.pageHelpers(pageNo, pageSize);
		return Resp.success(page);
	}

	@LoginCheck
	@ApiOperation("后台管理文章列表")
	@RequestMapping("mgr/index")
	public String mgrIndex() {
		List<Article> ArticleList = articleService.queryAll(null);
		this.setReqAttr("ArticleList", ArticleList);
		return "mgr/article-list";
	}

	@LoginCheck
	@ApiOperation("新建文章")
	@RequestMapping("mgr/news")
	public String news(Article article) {
		if (StringUtils.isNotBlank(article.getContent())) {
			System.out.println(article.toString());
			Users user = this.getUserInfo();
			article.setAuthor(user.getUserName());
			article.setCreateUser(user.getUserName());
			article.setCreateTime(new Date());
			articleService.save(article);
		}
		return "mgr/article-new";
	}

	@LoginCheck
	@ApiOperation("文章编辑")
	@RequestMapping("edit/{id}")
	public String edit(@PathVariable String id) {
		this.setReqAttr("edit", articleService.queryById(id));
		return "mgr/article-edit";
	}

	@LoginCheck
	@ApiOperation("修改文章")
	@RequestMapping("modify")
	public String modify(Article article) {
		articleService.update(article);
		return "redirect:/article/mgr/index";
	}

	@LoginCheck
	@ApiOperation("删除文章")
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		articleService.delete(id);
		return "redirect:/article/mgr/index";
	}

	@Override
	public String getModulePath() {
		return ArticleHelper.PLUGIN_MAPPING;
	}

}
