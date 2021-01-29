package person.liufan.bookstore.service.impl;

import org.springframework.stereotype.Component;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.BookstoreBook;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.mapper.BookstoreUserMapper;
import person.liufan.bookstore.service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/18
 */
@Component
public class UserServiceImpl implements UserService {
    @Resource
    private BookstoreUserMapper userMapper;

    @Override
    public Map login(String userName, String password) {
        Map map = new HashMap(4);
        BookstoreUser user = userMapper.selectByName(userName);
        /*
         * 如果用户存在返回tru及对应user
         * 用户不存在或者错误返回false及提示消息
         * */
        if (user != null) {
            boolean flag = password.equals(user.getTbBookstoreUserPassword());
            if (flag) {
                map.put("flag", true);
                map.put("user", user);
                return map;
            }
        }
        map.put("flag", false);
        map.put("message", "账号验证错误");
        return map;
    }

    @Override
    public Boolean sava(BookstoreUser user) {
        BookstoreUser rest = userMapper.selectByName(user.getTbBookstoreUserName());
        if (rest != null) {
            return false;
        }
        userMapper.save(user);
        return true;
    }

    @Override
    public BookstoreUser getUserDetail(Long userId) {
        return userMapper.getOne(userId);
    }

    @Override
    public Map listUserDetailByName(Long id, int pageNum, int pageSize) {
        List<BookstoreUser> list = null;
        if (id != null) {
            list = userMapper.listUserById(id, (pageNum-1)*pageSize, pageNum*pageSize);
        } else {
            list = userMapper.listUser((pageNum-1)*pageSize, pageNum*pageSize);
        }
        Long count = userMapper.count();
        Map map = new HashMap(4);
        map.put(MyConstant.LIST, list);
        map.put(MyConstant.COUNT, count);
        return map;
    }

    @Override
    public boolean updateUser(BookstoreUser user) {
        BookstoreUser one = userMapper.getOne(user.getId());
        user.setTbBookstoreUserCreateTime(one.getTbBookstoreUserCreateTime());
        userMapper.save(user);
        return true;
    }
    @Override
    public Boolean deleteUserByIds(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            userMapper.deleteById(Long.valueOf(ids[i]));
        }
        return true;
    }
}
