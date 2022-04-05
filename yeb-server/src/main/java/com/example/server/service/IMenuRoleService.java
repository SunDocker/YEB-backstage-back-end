package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.MenuRole;
import com.example.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cruder
 * @since 2022-03-04
 */
public interface IMenuRoleService extends IService<MenuRole> {

    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
