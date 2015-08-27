package hx.service.impl;

import hx.dao.BaseDaoI;
import hx.model.Tdise;
import hx.model.Tuser;
import hx.pageModel.DataGrid;
import hx.pageModel.Dise;
import hx.service.DiseServiceI;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






@Service("diseService")
public class DiseServiceImpl implements DiseServiceI {

	private static final Logger logger = Logger.getLogger(DiseServiceImpl.class);

	private BaseDaoI<Tdise> diseDao;

	public BaseDaoI<Tdise> getDiseDao() {
		return diseDao;
	}

	@Autowired
	public void setDiseDao(BaseDaoI<Tdise> diseDao) {
		this.diseDao = diseDao;
	}

	@Override
	public Dise save(Dise dise) {
		Tdise t = new Tdise();
		BeanUtils.copyProperties(dise, t);
		t.setId(UUID.randomUUID().toString());
		t.setCreatedatetime(new Date());
		
		diseDao.save(t);
		BeanUtils.copyProperties(t, dise);
		return dise;
	}

	

	@Override
	public DataGrid datagrid(Dise dise) {
		DataGrid dg = new DataGrid();
		String hql = "from Tdise t ";
		Map<String, Object> params = new HashMap<String, Object>();
		hql = addWhere(dise, hql, params);
		String totalHql = "select count(*) " + hql;
		hql = addOrder(dise, hql);
		List<Tdise> l = diseDao.find(hql, params, dise.getPage(), dise.getRows());
		List<Dise> nl = new ArrayList<Dise>();
		changeModel(l, nl);
		dg.setTotal(diseDao.count(totalHql, params));
		dg.setRows(nl);
		return dg;
	}

	private void changeModel(List<Tdise> l, List<Dise> nl) {
		if (l != null && l.size() > 0) {
			for (Tdise t : l) {
				Dise u = new Dise();
				BeanUtils.copyProperties(t, u);
				nl.add(u);
			}
		}
	}

	private String addOrder(Dise dise, String hql) {
		if (dise.getSort() != null) {
			hql += " order by " + dise.getSort() + " " + dise.getOrder();
		}
		return hql;
	}

	private String addWhere(Dise dise, String hql, Map<String, Object> params) {
		if (dise.getName() != null && !dise.getName().trim().equals("")) {
			hql += " where t.name like :name";
			params.put("name", "%%" + dise.getName().trim() + "%%");
		}
		return hql;
	}

	@Override
	public void remove(String ids) {
		// for (String id : ids.split(",")) {
		// Tuser u = userDao.get(Tuser.class, id);
		// if (u != null) {
		// userDao.delete(u);
		// }
		// }
		String[] nids = ids.split(",");
		String hql = "delete Tdise t where t.id in (";
		for (int i = 0; i < nids.length; i++) {
			if (i > 0) {
				hql += ",";
			}
			hql += "'" + nids[i] + "'";
		}
		hql += ")";
		diseDao.executeHql(hql);
	}

	@Override
	public Dise edit(Dise dise) {
		Tdise t=diseDao.get(Tdise.class,dise.getId());
		BeanUtils.copyProperties(dise,t,new String[]{"id","pwd"});
		t.setModifydatetime(new Date());
		return dise;
	}
	
	public List<Dise> findAll() {
		return diseDao.findAll();
	}
	
	public void add(List<Dise> dise){
		diseDao.add(dise);
	}
	
	public Dise findById(int id){
		return diseDao.findById(id);
	}




}
