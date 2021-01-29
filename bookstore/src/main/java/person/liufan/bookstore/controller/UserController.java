package person.liufan.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.liufan.bookstore.constant.MyConstant;
import person.liufan.bookstore.entity.BookstoreUser;
import person.liufan.bookstore.entity.City;
import person.liufan.bookstore.entity.Province;
import person.liufan.bookstore.service.CityService;
import person.liufan.bookstore.service.ProvinceService;
import person.liufan.bookstore.service.UserService;
import person.liufan.bookstore.util.Rest;
import person.liufan.bookstore.vo.UserDetailVO;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/28
 * 处理用户相关的请求
 */

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @RequestMapping("/register")
    public Rest saveUser(BookstoreUser user) {
        user.setTbBookstoreUserCreateTime(new Date());
        Boolean flag = userService.sava(user);
        return Rest.ok().put(MyConstant.LOGIN_FLAG, flag);
    }
    @RequestMapping("/provinces")
    public Rest province() {
        List<Province> provinces = provinceService.listProvince();
        return Rest.ok().put(MyConstant.DATA, provinces);
    }
    @RequestMapping("/city")
    public Rest city(Long provinceId) {
        List<City> cities = cityService.listCity(provinceId);
        return Rest.ok().put(MyConstant.DATA, cities);
    }
    @RequestMapping("/query/one")
    public Rest queryOne(Long id) {
        BookstoreUser userDetail = userService.getUserDetail(id);
        City city = cityService.selectCityById(userDetail.getTbBookstoreUserCityId());
        Long provinceId = city.getProvinceId();
        List<Province> provinces = provinceService.listProvince();
        List<City> cities = cityService.listCity(provinceId);
        Map map = new HashMap(8);
        map.put("user", userDetail);
        map.put("provinceId", provinceId);
        map.put("provinces", provinces);
        map.put("cities", cities);
        return Rest.ok().put(MyConstant.DATA,map);
    }
    @RequestMapping("/update")
    public Rest update(BookstoreUser user) {
        user.setTbBookstoreUserUpdateTime(new Date());
        boolean flag = userService.updateUser(user);
        return Rest.ok().put(MyConstant.LOGIN_FLAG, flag);
    }
    @RequestMapping("/delete")
    public Rest delete(String deleteList) {
        String[] ids = deleteList.split("&");
        Boolean flag = userService.deleteUserByIds(ids);
        return Rest.ok().put(MyConstant.DATA,flag);
    }
    @RequestMapping("/exit")
    public Rest exit() {
        return Rest.ok().put(MyConstant.LOGIN_FLAG, true);
    }

    @RequestMapping("/query/all")
    public Rest queryAll(Long id, Integer pageNum, Integer pageSize) {
        Map map = userService.listUserDetailByName(id, pageNum, pageSize);
        Map rest = toUserDetailVO(map);
        return Rest.ok().put(MyConstant.DATA, rest);
    }

    private Map toUserDetailVO(Map map) {
        List<UserDetailVO> voList = new ArrayList<>();
        List<BookstoreUser> users = (List<BookstoreUser>) map.get(MyConstant.LIST);
        for (BookstoreUser obj : users) {
            UserDetailVO vo = new UserDetailVO();
            vo.setId(obj.getId());
            vo.setTbBookstoreUserName(obj.getTbBookstoreUserName());
            vo.setTbBookstoreUserRealName(obj.getTbBookstoreUserRealName());
            vo.setTbBookstoreUserPhone(obj.getTbBookstoreUserPhone());
            vo.setTbBookstoreUserEmail(obj.getTbBookstoreUserEmail());
            vo.setTbBookstoreUserAddress(obj.getTbBookstoreUserAddress());
            vo.setTbBookstoreUserHobby(obj.getTbBookstoreUserHobby());
            City city = cityService.selectCityById(obj.getTbBookstoreUserCityId());
            Long provinceId = city.getProvinceId();
            String provinceAndCity = getProvinceAndCity(provinceService,Math.toIntExact(provinceId), city.getId());
            vo.setTbBookstoreUserProvinceAndCity(provinceAndCity);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            vo.setTbBookstoreUserCreateTime(simpleDateFormat.format(obj.getTbBookstoreUserCreateTime()));
            voList.add(vo);
        }
        map.put(MyConstant.LIST, voList);
        return map;
    }
    private String getProvinceAndCity(ProvinceService provinceService,Integer provinceId, Long cityId) {
        String provinceAndCity = provinceService.getProvinceAndCity(provinceId, cityId);
        return provinceAndCity;
    }
}
