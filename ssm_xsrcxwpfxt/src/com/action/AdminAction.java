//-------------------------请加下面QQ请求远程辅助运行代码  ID:3664--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Admin;
import com.service.AdminService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/admin", produces = "text/plain;charset=utf-8")
public class AdminAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private AdminService adminService;

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Admin admin = this.adminService.getAdminById(adminid);
		if (password.equals(admin.getPassword())) {
			admin.setPassword(repassword);
			this.adminService.updateAdmin(admin);
		} else {
			this.getRequest().setAttribute("message", "旧密码错误");
		}
		return "editpwd";
	}

	// 准备添加数据
	@RequestMapping("createAdmin.action")
	public String createAdmin() {
		return "addadmin";
	}

	// 添加数据
	@RequestMapping("addAdmin.action")
	public String addAdmin(Admin admin) {
		admin.setAddtime(VeDate.getStringDateShort());
		this.adminService.insertAdmin(admin);
		return "redirect:/admin/createAdmin.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteAdmin.action")
	public String deleteAdmin(String id) {
		this.adminService.deleteAdmin(id);
		return "redirect:/admin/getAllAdmin.action";
	}

	// 批量删除数据
	@RequestMapping("deleteAdminByIds.action")
	public String deleteAdminByIds() {
		String[] ids = this.getRequest().getParameterValues("adminid");
		for (String adminid : ids) {
			this.adminService.deleteAdmin(adminid);
		}
		return "redirect:/admin/getAllAdmin.action";
	}

	// 更新数据
	@RequestMapping("updateAdmin.action")
	public String updateAdmin(Admin admin) {
		this.adminService.updateAdmin(admin);
		return "redirect:/admin/getAllAdmin.action";
	}

	// 显示全部数据
	@RequestMapping("getAllAdmin.action")
	public String getAllAdmin(String number) {
		List<Admin> adminList = this.adminService.getAllAdmin();
		PageHelper.getPage(adminList, "admin", null, null, 10, number, this.getRequest(), null);
		return "listadmin";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryAdminByCond.action")
	public String queryAdminByCond(String cond, String name, String number) {
		Admin admin = new Admin();
		if (cond != null) {
			if ("username".equals(cond)) {
				admin.setUsername(name);
			}
			if ("password".equals(cond)) {
				admin.setPassword(name);
			}
			if ("realname".equals(cond)) {
				admin.setRealname(name);
			}
			if ("contact".equals(cond)) {
				admin.setContact(name);
			}
			if ("addtime".equals(cond)) {
				admin.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.adminService.getAdminByLike(admin), "admin", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryadmin";
	}

	// 按主键查询数据
	@RequestMapping("getAdminById.action")
	public String getAdminById(String id) {
		Admin admin = this.adminService.getAdminById(id);
		this.getRequest().setAttribute("admin", admin);
		return "editadmin";
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
//-------------------------请加下面QQ请求远程辅助运行代码  ID:3664--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------