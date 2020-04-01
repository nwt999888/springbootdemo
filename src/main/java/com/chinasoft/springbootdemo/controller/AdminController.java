package com.chinasoft.springbootdemo.controller;

import com.chinasoft.springbootdemo.service.AdminService;

import com.chinasoft.springbootdemo.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService  adminService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        List<Map<String,Object>> list=adminService.selectUsers(RequestUtil.getQueryMap(request));
        Map<String,Object> map=new HashMap<String,Object>();
        if (list.size()>0){
            request.setAttribute("map",list.get(0));
        }else {
            map.put("name","抱歉，没有");
            request.setAttribute("map",map);
        }
        return "admin/index";
    }

}
