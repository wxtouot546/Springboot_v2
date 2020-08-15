package com.fc.test.controller.gen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fc.test.common.base.BaseController;
import com.fc.test.mapper.auto.ThIpMapper;
import com.fc.test.mapper.auto.ThUserGroupMapper;
import com.fc.test.mapper.auto.ThUserMapper;
import com.fc.test.mapper.auto.ThUserRelationGroupMapper;
import com.fc.test.model.auto.ThIp;
import com.fc.test.model.auto.ThUser;
import com.fc.test.model.auto.ThUserGroup;
import com.fc.test.model.auto.ThUserRelationGroup;

import io.swagger.annotations.Api;

@Api(value = "")
@Controller
@RequestMapping("/ThDaoRuController")
public class ThDaoRuController extends BaseController{
	
	@Autowired
	ThIpMapper thIpMapper;
	@Autowired
	ThUserGroupMapper thUserGroupMapper;
	@Autowired
	ThUserMapper thUserMapper;
	@Autowired
	ThUserRelationGroupMapper thUserRelationGroupMapper;
	
	
	@RequestMapping(value = "/addUsers", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String addUsers(HttpServletRequest request,@RequestParam(value="file",required=false) MultipartFile input,HttpServletResponse rsp) throws InvalidFormatException,IOException{
		request.setCharacterEncoding("UTF-8");
		rsp.setContentType("text/html;charset=UTF-8");
		String tys = "导入成功";
		try {
			CommonsMultipartFile cFile = (CommonsMultipartFile) input;
			DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
			InputStream is = fileItem.getInputStream(); 
			Workbook workbook = WorkbookFactory.create(fileItem.getInputStream());
			
			/*
			 * Workbook wb = new XSSFWorkbook(new
			 * POIFSFileSystem(fileItem.getInputStream()));
			 */
	        Sheet sheet = workbook.getSheetAt(0);
			
			/* XSSFSheet sheet = workbook.getSheetAt(0); */
			int rowNum = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rowNum; i++) {
				Row row = sheet.getRow(i);
				// 用户
				Cell cell = row.getCell(0);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				String cellStr = cell.getStringCellValue();
				// 用户组
				Cell cell1 = row.getCell(1);
				cell1.setCellType(XSSFCell.CELL_TYPE_STRING);
				String cellStr1 = cell1.getStringCellValue();
				// 用户ip地址
				Cell cell2 = row.getCell(2);
				cell2.setCellType(XSSFCell.CELL_TYPE_STRING);
				String cellStr2 = cell2.getStringCellValue();
				// 用户密码
				Cell cell3 = row.getCell(3);
				cell3.setCellType(XSSFCell.CELL_TYPE_STRING);
				String cellStr3 = cell3.getStringCellValue();
				// ipid
				int ipdd = 0;
				int groupid = 0;
				int userid = 0;
				if(null != cellStr2 && !"".equals(cellStr2.trim())) {
					// 查询 IP地址是否存在 
					ThIp thIp = new ThIp();
					thIp.setIp(cellStr2.trim());
					List<ThIp> thiplist = thIpMapper.selectAll(thIp);
					if(null == thiplist || thiplist.size() == 0){
						thIp.setType('0');
						thIp.setStatus('0');
						thIp.setCreateTime(new Date());
						// 这个时候我就插入一条数据
						thIpMapper.insertSelective(thIp);
						ipdd = thIp.getId();
					}else {
						ipdd = thiplist.get(0).getId();
					}
				}
				if(null != cellStr1 && !"".equals(cellStr1.trim())) {
					ThUserGroup oup = new ThUserGroup();
					oup.setUserGroupName(cellStr1.trim());
					List<ThUserGroup> group = thUserGroupMapper.selectAll(oup);
					if(null == group || group.size() == 0) {
						oup.setUserGroupName(cellStr1.trim());
						oup.setCreateTime(new Date());
						thUserGroupMapper.insertSelective(oup);
						groupid = oup.getId();
					}else {
						groupid = group.get(0).getId();
					}
				}else {
					tys = "导入失败 用户组不能为空";
					break;
				}
				if(null != cellStr && !"".equals(cellStr.trim()) && 
						null != cellStr3 && !"".equals(cellStr3.trim()) ) {
					
					
					// 进行用户添加操作
					ThUser tu = new ThUser();
					tu.setUserId(cellStr.trim());
					List<ThUser> uslist = thUserMapper.selectAll(tu);
					if(null == uslist || uslist.size() == 0) {
						tu.setIpId(ipdd+"");
						tu.setFraction(0);
						tu.setGrade(0);
						tu.setPassword(cellStr3.trim());
						tu.setCreatTime(new Date());
						tu.setIsdel('0');
						thUserMapper.insertSelective(tu);
						userid = tu.getId();
					}else {
						ThUser userdd = uslist.get(0);
						userdd.setPassword(cellStr3.trim());
						if(ipdd != 0) {
							userdd.setIpId(ipdd+"");
						}
						thUserMapper.updateByPrimaryKeySelective(userdd);
						userid = uslist.get(0).getId();
					}
					
				}else {
					tys = "导入失败 用户名密码不能为空";
					break;
				}
				
				ThUserRelationGroup thUserRelationGroup = new ThUserRelationGroup();
				thUserRelationGroup.setUserId(userid);
				thUserRelationGroup.setGorupId(groupid);
				// 然后判断用户组和用户有没有关联 如果没有关联那么就关联上
				ThUserRelationGroup oos  = thUserRelationGroupMapper.selectByPrimaryuser(thUserRelationGroup);
				if(null == oos) {
					thUserRelationGroup.setCreateTime(new Date());
					thUserRelationGroupMapper.insertSelective(thUserRelationGroup);
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			tys = "导入失败";
		}
		return tys;
	}
	
}
