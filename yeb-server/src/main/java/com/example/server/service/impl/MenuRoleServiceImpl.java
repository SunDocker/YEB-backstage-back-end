package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.MenuRoleMapper;
import com.example.server.pojo.MenuRole;
import com.example.server.pojo.RespBean;
import com.example.server.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cruder
 * @since 2022-03-04
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {
    @Autowired
    MenuRoleMapper menuRoleMapper;

    /**
     * 更新角色菜单
     *
     * @param rid
     * @param mids
     * @return
     */
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        Map<String, Object> deleteMap = new HashMap<>();
        deleteMap.put("rid", rid);
        menuRoleMapper.deleteByMap(deleteMap);
        if (null == mids || 0 == mids.length) {
            return RespBean.success("更新成功！");
        }
        List<MenuRole> menuRoleList = new ArrayList<>();
        for (int mid : mids) {
            MenuRole menuRole = new MenuRole();
            menuRole.setRid(rid);
            menuRole.setMid(mid);
            menuRoleList.add(menuRole);
        }
        if(saveBatch(menuRoleList)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
}
