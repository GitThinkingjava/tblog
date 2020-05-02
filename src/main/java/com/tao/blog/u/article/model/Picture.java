package com.tao.blog.u.article.model;

import java.io.Serializable;
import java.util.Date;

/**
 * article_picture
 * 
 * @author
 */
public class Picture implements Serializable {

	private Long id;

	/**
	 * 对应文章id
	 */
	private Long articleId;

	/**
	 * 图片url
	 */
	private String pictureUrl;

	/**
	 * 创建时间
	 */
	private Date createBy;

	/**
	 * 更新时间
	 */
	private Date modifiedBy;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Date getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Date createBy) {
		this.createBy = createBy;
	}

	public Date getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Date modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Picture other = (Picture) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getArticleId() == null ? other.getArticleId() == null
						: this.getArticleId().equals(other.getArticleId()))
				&& (this.getPictureUrl() == null ? other.getPictureUrl() == null
						: this.getPictureUrl().equals(other.getPictureUrl()))
				&& (this.getCreateBy() == null ? other.getCreateBy() == null
						: this.getCreateBy().equals(other.getCreateBy()))
				&& (this.getModifiedBy() == null ? other.getModifiedBy() == null
						: this.getModifiedBy().equals(other.getModifiedBy()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
		result = prime * result + ((getPictureUrl() == null) ? 0 : getPictureUrl().hashCode());
		result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
		result = prime * result + ((getModifiedBy() == null) ? 0 : getModifiedBy().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", articleId=").append(articleId);
		sb.append(", pictureUrl=").append(pictureUrl);
		sb.append(", createBy=").append(createBy);
		sb.append(", modifiedBy=").append(modifiedBy);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}