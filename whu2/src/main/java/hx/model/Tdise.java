package hx.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Tdise entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TDISE", schema = "WHU", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Tdise implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String a;
	private String b;
	private Date createdatetime;
	private Date modifydatetime;

	// Constructors

	/** default constructor */
	public Tdise() {
	}

	/** minimal constructor */
	public Tdise(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Tdise(String id, String name, String a, String b,
			Date createdatetime, Date modifydatetime) {
		this.id = id;
		this.name = name;
		this.a = a;
		this.b = b;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = true, nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "A", length = 50)
	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}

	@Column(name = "B", length = 50)
	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATETIME", length = 7)
	public Date getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFYDATETIME", length = 7)
	public Date getModifydatetime() {
		return this.modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

}