package hx.pageModel;

import java.util.Date;

public class Dise implements java.io.Serializable {

	private int page;
	private int rows;
	private String sort;
	private String order;
	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	private String id;
	private String name;
	private String A;
	private String B;
	private String C;
	private Date createdatetime;
	private Date modifydatetime;

	


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getA() {
		return A;
	}

	public void setA(String a) {
		this.A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		this.B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		this.C = c;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public Date getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	public Date getModifydatetime() {
		return modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

}
