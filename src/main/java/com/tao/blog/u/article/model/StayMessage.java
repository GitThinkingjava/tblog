package com.tao.blog.u.article.model;

import java.io.Serializable;
import java.util.Date;

/**
 * stay_message
 * 
 * @author
 */
public class StayMessage implements Serializable {
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 留言/评论内容
	 */
	private String content;

	/**
	 * 创建日期
	 */
	private Date createBy;

	/**
	 * 邮箱，用于回复消息
	 */
	private String email;

	/**
	 * 用户自己定义的名称
	 */
	private String name;

	/**
	 * 留言/评论IP
	 */
	private String ip;

	/**
	 * 是否有效，默认为1为有效，0为无效
	 */
	private Boolean isEffective;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Date createBy) {
		this.createBy = createBy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Boolean getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(Boolean isEffective) {
		this.isEffective = isEffective;
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
		StayMessage other = (StayMessage) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getContent() == null ? other.getContent() == null
						: this.getContent().equals(other.getContent()))
				&& (this.getCreateBy() == null ? other.getCreateBy() == null
						: this.getCreateBy().equals(other.getCreateBy()))
				&& (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
				&& (this.getIsEffective() == null ? other.getIsEffective() == null
						: this.getIsEffective().equals(other.getIsEffective()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
		result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
		result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
		result = prime * result + ((getIsEffective() == null) ? 0 : getIsEffective().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", content=").append(content);
		sb.append(", createBy=").append(createBy);
		sb.append(", email=").append(email);
		sb.append(", name=").append(name);
		sb.append(", ip=").append(ip);
		sb.append(", isEffective=").append(isEffective);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}