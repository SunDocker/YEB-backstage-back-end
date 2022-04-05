package com.example.server.controller;


import com.example.server.pojo.Joblevel;
import com.example.server.pojo.RespBean;
import com.example.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
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
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {
    @Autowired
    public IJoblevelService joblevelService;

    @ApiOperation("获取所有职称")
    @GetMapping("/")
    public List<Joblevel> getAllJobLevels() {
        return joblevelService.list();
    }

    @ApiOperation("添加职称")
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel) {
        joblevel.setCreateDate(LocalDateTime.now());
        if (joblevelService.save(joblevel)) {
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation("更新职称")
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel) {
        if (joblevelService.updateById(joblevel)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation("删除职称")
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id) {
        if (joblevelService.removeById(id)) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/")
    public RespBean deleteJobLevelByIds(Integer[] ids) {
        if (joblevelService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败");
    }

}
