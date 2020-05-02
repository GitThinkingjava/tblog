package com.tao.blog.u.article.model;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_log
 * 
 * @author
 */
public class SysLog implements Serializable {
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 操作地址的IP
	 */
	private String ip;

	/**
	 * 操作时间
	 */
	private Date createBy;

	/**
	 * 操作内容
	 */
	private String remark;

	/**
	 * 操作的访问地址
	 */
	private String operateUrl;

	/**
	 * 操作的浏览器
	 */
	private String operateBy;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOperateUrl() {
		return operateUrl;
	}

	public void setOperateUrl(String operateUrl) {
		this.operateUrl = operateUrl;
	}

	public String getOperateBy() {
		return operateBy;
	}

	public void setOperateBy(String operateBy) {
		this.operateBy = operateBy;
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
		SysLog other = (SysLog) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
				&& (this.getCreateBy() == null ? other.getCreateBy() == null
						: this.getCreateBy().equals(other.getCreateBy()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
				&& (this.getOperateUrl() == null ? other.getOperateUrl() == null
						: this.getOperateUrl().equals(other.getOperateUrl()))
				&& (this.getOperateBy() == null ? other.getOperateBy() == null
						: this.getOperateBy().equals(other.getOperateBy()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
		result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getOperateUrl() == null) ? 0 : getOperateUrl().hashCode());
		result = prime * result + ((getOperateBy() == null) ? 0 : getOperateBy().hashCode());
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
		sb.append(", remark=").append(remark);
		sb.append(", operateUrl=").append(operateUrl);
		sb.append(", operateBy=").append(operateBy);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}