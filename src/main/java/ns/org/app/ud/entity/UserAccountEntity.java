package ns.org.app.ud.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "ACCOUNT")
public class UserAccountEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "USERNAME") // , unique = true
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "VERIFIED")
	private boolean verified;

	@Column(name = "CREATED_TIMESTAMP")
	@CreatedDate
	private Date createdTimestamp;

	@Column(name = "UUID")
	private String uuid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "UserAccountEntity [id=" + id + ", type=" + type + ", username=" + username + ", password=" + password
				+ ", verified=" + verified + ", createdTimestamp=" + createdTimestamp + ", uuid=" + uuid + "]";
	}

}
