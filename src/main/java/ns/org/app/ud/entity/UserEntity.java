package ns.org.app.ud.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 539409805169385425L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true)
	private Long id;

	
	@Column(name = "UUID", unique = true)
	private String uuid;

	@Column(name = "FIRST_NAME")
	private String firstName;

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "uuid", referencedColumnName = "uuid")
	private List<UserAccountEntity> userAccount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<UserAccountEntity> getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(List<UserAccountEntity> userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", uuid=" + uuid + ", firstName=" + firstName + ", userAccount=" + userAccount
				+ "]";
	}

}
