package com.example.server.controller;


import com.example.server.pojo.Menu;
import com.example.server.service.IAdminService;
import com.example.server.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cruder
 * @since 2022-03-04
 */
@RestController
@RequestMapping("/system/cfg")
public class MenuController {
    @Autowired
    private IMenuService menuService;

    @ApiOperation("通常用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenuByAdminId() {
        //用户登录后，登录状态已经存在会话域中了，相关信息都是后端自己查询，而不是前端传过来
        return menuService.getMenusByAdminId();
    }
}
