package com.suke.czx.modules.sys.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.suke.czx.common.annotation.SysLog;
import com.suke.czx.common.base.AbstractController;
import com.suke.czx.common.utils.Constant;
import com.suke.czx.modules.sys.entity.SysRole;
import com.suke.czx.modules.sys.service.SysRoleService;
import com.suke.zhjg.common.autofull.annotation.AutoFullData;
import com.suke.zhjg.common.autofull.util.R;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author czx
 * @email object_czx@163.com
 */
@RestController
@RequestMapping("/sys/role")
@AllArgsConstructor
@Api(value = "SysRoleController", tags = "角色管理")
public class SysRoleController extends AbstractController {

    private final SysRoleService sysRoleService;

    /**
     * 角色列表
     */
    @AutoFullData
    @GetMapping(value = "/list")
    public R list(@RequestParam Map<String, Object> params) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (!getUserId().equals(Constant.SUPER_ADMIN)) {
            queryWrapper.lambda().eq(SysRole::getCreateUserId, getUserId());
        }

        //查询列表数据
        final String keyword = mpPageConvert.getKeyword(params);
        if (StrUtil.isNotEmpty(keyword)) {
            queryWrapper
                    .lambda()
                    .and(func -> func.like(SysRole::getRoleName, keyword));
        }
        IPage<SysRole> listPage = sysRoleService.page(mpPageConvert.<SysRole>pageParamConvert(params), queryWrapper);
        return R.ok().setData(listPage);
    }

    /**
     * 角色列表
     */
    @GetMapping(value = "/select")
    public R select() {
        final List<SysRole> list = sysRoleService.list();
        return R.ok().setData(list);
    }


    /**
     * 保存角色
     */
    @SysLog("保存角色")
    @PostMapping(value = "/save")
    public R save(@RequestBody SysRole role) {
        role.setCreateUserId(getUserId());
        sysRoleService.saveRoleMenu(role);
        return R.ok();
    }

    /**
     * 修改角色
     */
    @SysLog("修改角色")
    @PostMapping(value = "/update")
    public R update(@RequestBody SysRole role) {
        role.setCreateUserId(getUserId());
        sysRoleService.updateRoleMenu(role);

        return R.ok();
    }

    /**
     * 删除角色
     */
    @SysLog("删除角色")
    @PostMapping(value = "/delete")
    public R delete(@RequestBody SysRole role) {
        if (role == null || role.getRoleId() == null) {
            return R.error("ID为空");
        }
        sysRoleService.deleteBath(role.getRoleId());
        return R.ok();
    }
}
