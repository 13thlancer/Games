package hx.action;

import hx.pageModel.Dise;
import hx.pageModel.Json;
import hx.pageModel.User;
import hx.service.DiseServiceI;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;



import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@Action(value = "diseAction")
public class DiseAction extends BaseAction implements ModelDriven<Dise> {
	private Dise dise = new Dise();

	@Override
	public Dise getModel() {
		return dise;
	}

	private static final Logger logger = Logger.getLogger(DiseAction.class);

	private DiseServiceI diseService;

	public DiseServiceI getDiseService() {
		return diseService;
	}

	@Autowired
	public void setDiseService(DiseServiceI diseService) {
		this.diseService = diseService;
	}

	

	public void add() {
		Json j = new Json();
		try {
			Dise d = diseService.save(dise);
			j.setSuccess(true);
			j.setMsg("添加成功！");
			j.setObj(d);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}

		super.writeJson(j);

	}

	

	public void datagrid() {
		super.writeJson(diseService.datagrid(dise));
	}

	public void remove() {
		diseService.remove(dise.getIds());
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功！");
		super.writeJson(j);
	}
	public void edit(){
		Dise d = diseService.edit(dise);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("编辑成功！");
		j.setObj(d);
		super.writeJson(j);
		
		
	}
}
