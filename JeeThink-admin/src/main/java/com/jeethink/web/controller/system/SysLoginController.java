package com.jeethink.web.controller.system;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jeethink.web.controller.common.CaptchaController;
import io.swagger.annotations.ResponseHeader;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jeethink.common.constant.Constants;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.core.domain.entity.SysMenu;
import com.jeethink.common.core.domain.entity.SysUser;
import com.jeethink.common.core.domain.model.LoginBody;
import com.jeethink.common.core.domain.model.LoginUser;
import com.jeethink.common.utils.ServletUtils;
import com.jeethink.framework.web.service.SysLoginService;
import com.jeethink.framework.web.service.SysPermissionService;
import com.jeethink.framework.web.service.TokenService;
import com.jeethink.system.service.ISysMenuService;

/**
 * 登录验证
 * 
 * @author jeethink
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private CaptchaController captchaController;

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestParam(value = "username",required = false) String loginBody,@RequestParam(value = "password",required = false) String password) throws IOException {
        System.err.println(loginBody);
        captchaController.getCode();
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
       /* String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), "1",
                loginBody.getUuid());*/
        String token = loginService.login(loginBody, password, "1",
                "22fa5d2b761244cb850b5e03c607e908");
        System.err.println(token);
        ajax.put(Constants.TOKEN, token);

        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {

        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());

        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);

        return ajax;
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
