package person.liufan.bookstore.service.impl;

import org.springframework.stereotype.Component;
import person.liufan.bookstore.entity.BookstoreAdmin;
import person.liufan.bookstore.mapper.BookstoreAdminMapper;
import person.liufan.bookstore.service.AdminService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/21
 */
@Component
public class AdminServiceImpl implements AdminService {
    @Resource
    private BookstoreAdminMapper adminMapper;
    @Override
    public Map login(String userName, String password) {
        Map map = new HashMap(4);
        BookstoreAdmin admin = adminMapper.selectByName(userName);
        /*
         * 如果用户存在返回tru及对应user
         * 用户不存在或者错误返回false及提示消息
         * */
        if (admin != null) {
            boolean flag = password.equals(admin.getTbBookstoreAdminPassword());
            if (flag) {
                map.put("flag", true);
                map.put("admin", admin);
                return map;
            }
        }
        map.put("flag", false);
        map.put("message", "账号验证错误");
        return map;
    }
}
