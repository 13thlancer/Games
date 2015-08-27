package hx.service;

import hx.pageModel.DataGrid;
import hx.pageModel.Dise;

import java.util.List;



public interface DiseServiceI {

	public Dise save(Dise dise);

	public DataGrid datagrid(Dise dise);

	public void remove(String ids);

	public Dise edit(Dise dise);

	public List<Dise> findAll();
	
	public void add(List<Dise> dise);
	
	public Dise findById(int id);
}
