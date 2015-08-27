package hx.service;

import hx.pageModel.DataGrid;
import hx.pageModel.User;

public interface UserServiceI {

	public User save(User user);

	public User login(User user);

	public DataGrid datagrid(User user);


}
