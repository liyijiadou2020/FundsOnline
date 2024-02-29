package com.atguigu.crowd.service.api;
import java.util.List;
import com.atguigu.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;

/**
 * Created: 2024/2/28
 * Author: Li Yijia
 * Description:
 */
public interface AdminService {

    /**
     * 数据库添加一个管理员
     * @param admin 管理员实体类对象
     */
    void saveAdmin(Admin admin);

    /**
     * 查询数据库中的所有用户
     * @return 管理员实体类对象列表
     */
    List<Admin> getAll();

    /**
     * 通过账号密码获得Admin对象
     * @param loginAcct 账号
     * @param userPswd 密码
     * @return Admin对象
     */
    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    /**
     * 分页显示 Admin列表
     * @param keyword 匹配条件
     * @param pageNum 页面
     * @param pageSize 每页显示的条数
     * @return PageInfo对象
     */
    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);
}
