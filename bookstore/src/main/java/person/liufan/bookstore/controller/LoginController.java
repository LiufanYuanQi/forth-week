package person.liufan.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.service.AdminService;
import person.liufan.bookstore.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/28
 * 处理登录请求
 */

@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;
    /**
     * 跳转到登录页面
     * @return 登录页面
     */
    @RequestMapping("/index")
    public String index() {
        return "redirect:/html/login.html";
    }

    /**
     * 用户登录验证，验证成功放入session
     * @param name 账户
     * @param password 密码
     * @param request 请求
     * @return 验证结果
     */
    @ResponseBody
    @RequestMapping("/login")
    public Map login(String name, String password, HttpServletRequest request) {
        Map map = userService.login(name, password);
        if ((boolean)map.get(MyConstant.LOGIN_FLAG)) {
            HttpSession session = request.getSession();
            session.setAttribute(MyConstant.LOGIN_USER, map.get(MyConstant.LOGIN_USER));
            map.remove(MyConstant.LOGIN_USER);
        }
        return map;
    }
    /**
     * 管理员登录验证，验证成功放入session
     * @param name 账户
     * @param password 密码
     * @param request 请求
     * @return 验证结果
     */
    @ResponseBody
    @RequestMapping("/admin")
    public Map admin(String name, String password, HttpServletRequest request) {
        Map map = adminService.login(name, password);
        if ((boolean)map.get(MyConstant.LOGIN_FLAG)) {
            HttpSession session = request.getSession();
            session.setAttribute(MyConstant.LOGIN_ADMIN, map.get(MyConstant.LOGIN_ADMIN));
            map.remove(MyConstant.LOGIN_ADMIN);
        }
        return map;
    }
}
