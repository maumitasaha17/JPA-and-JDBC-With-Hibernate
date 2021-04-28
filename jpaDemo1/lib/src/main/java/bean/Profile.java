package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Profile {

	@Id
	private int id;
	private String contactNo;
	private String email;

	@OneToOne(mappedBy = "profile")
	private Employees employees;

	// Constructors
	public Profile() {
	}

	public Profile(int id, String contactNo, String email) {
		this.id = id;
		this.contactNo = contactNo;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// POJO Class
	@Override
	public String toString() {
		return "Profile [id=" + id + ", contactNo=" + contactNo + ", email=" + email + "]";
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

}
