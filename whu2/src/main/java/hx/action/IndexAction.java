package hx.action;

import hx.pageModel.Dise;
import hx.service.DiseServiceI;
import hx.util.UploadFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Scope("prototype")
@Component
public class IndexAction extends ActionSupport {

	private InputStream excelFile;
	private File uploadFile;
	private String uploadFileFileName;
	private DiseServiceI DiseService;

	// ����ҳ���ѯ���
	public String listAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Dise> sList = DiseService.findAll();
		request.setAttribute("list", sList);
		return "listAll";
	}

	// ����Excel
	public String ExcelExport() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		List<Dise> list = new ArrayList<Dise>();
		String[] array = ids.split(",");
		int[] id = new int[array.length];
		for (int i = 0; i < id.length; i++) {
			Dise dise =DiseService
					.findById(Integer.valueOf(array[i]));
			list.add(dise);
		}
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("ѧ����Ϣ");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ѧ��");
		row.createCell(1).setCellValue("����");
		row.createCell(2).setCellValue("����");
		row.createCell(3).setCellValue("�Ա�");
		row.createCell(4).setCellValue("��ַ");
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
		for (int i = 1; i <= list.size(); i++) {
			Dise stu = list.get(i - 1);
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(stu.getIds());
			row.createCell(1).setCellValue(stu.getName());
			row.createCell(2).setCellValue(stu.getA());
			row.createCell(3).setCellValue(stu.getB());
			row.createCell(4).setCellValue(stu.getC());
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		excelFile = new ByteArrayInputStream(baos.toByteArray());
		baos.close();
		return "excel";
	}

	// ����Excel
	public String ExcelInto() throws Exception {
		String directory = "/file";
		String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
		File target = UploadFile.Upload(uploadFile, uploadFileFileName,targetDirectory);
		List<Dise> sList = new ArrayList<Dise>();
		excelFile = new FileInputStream(target);
		Workbook wb = new HSSFWorkbook(excelFile);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		for (int i = 1; i < rowNum; i++) {
			Dise dise = new Dise();
			Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for (int j = 0; j < cellNum; j++) {
				Cell cell = row.getCell(j);
				String cellValue = null;
				switch (cell.getCellType()) { // �ж�excel��Ԫ�����ݵĸ�ʽ�����������ת�����Ա������ݿ�
				case 0:
					cellValue = String
							.valueOf((int) cell.getNumericCellValue());
					break;
				case 1:
					cellValue = cell.getStringCellValue();
					break;
				case 2:
					cellValue = String
							.valueOf((int) cell.getNumericCellValue());
					break;
				case 3:
					cellValue = cell.getStringCellValue();
					break;
				case 4:
					cellValue = cell.getStringCellValue();
					break;
				}

				switch (j) {// ͨ���������ж϶�Ӧ������ֶ�
				case 1:
					dise.setName(cellValue);
					break;
				case 2:
					dise.setA(cellValue);
					break;
				case 3:
					dise.setB(cellValue);
					break;
				case 4:
					dise.setC(cellValue);
					break;
				}
			}
			sList.add(dise);
		}
		DiseService.add(sList);
		return "listAll";
	}

	public InputStream getExcelFile() {
		return excelFile;
	}

	public DiseServiceI getDiseService() {
		return DiseService;
	}

	@Resource(name = "diseService")
	public void setStudentService(DiseServiceI diseService) {
		this.DiseService = diseService;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
}
