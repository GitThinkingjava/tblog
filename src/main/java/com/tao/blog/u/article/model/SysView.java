package com.tao.blog.u.article.model;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * sys_view
 * 
 * @author
 */
public class SysView implements Serializable {
	private Long id;

	/**
	 * 访问IP
	 */
	private String ip;

	/**
	 * 访问时间
	 */
	private Date createBy;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Date createBy) {
		this.createBy = createBy;
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
		SysView other = (SysView) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
				&& (this.getCreateBy() == null ? other.getCreateBy() == null
						: this.getCreateBy().equals(other.getCreateBy()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
		result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", ip=").append(ip);
		sb.append(", createBy=").append(createBy);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}