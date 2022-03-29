package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.mapper.MenuMapper;
import com.example.server.pojo.Admin;
import com.example.server.pojo.Menu;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cruder
 * @since 2022-03-04
 */
public interface IAdminService extends IService<Admin> {


    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

    List<Role> getRoles(Integer adminId);

}
