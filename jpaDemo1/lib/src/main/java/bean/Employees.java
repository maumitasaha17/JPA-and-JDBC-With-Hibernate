//POJO class

package bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees { // employees

	@Id // will give primary key
	private int id;
	@Column(name = "name")
	private String name;
	// @Column(name="dept_id")
	private int deptId;

	// linking 2 classess employee and profile
	// has a relation

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Profile profile; // refernce name is profile

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "addr_id")
	private List<Address> address = new ArrayList<>();

	// Constructors
	public Employees() {
	}

	public Employees(int id, String name, int deptId) {
		this.id = id;
		this.name = name;
		this.deptId = deptId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", deptId=" + deptId + "]";
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
