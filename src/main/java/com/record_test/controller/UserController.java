package com.record_test.controller;


import com.record_test.config.CsvUtil;
import com.record_test.entity.User;
import com.record_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 铁壮
 * @since 2020-09-01
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/exportCsv")
    public ResponseEntity<byte[]> exportCsv(){
        //设置excel文件名
        String fileName="管理员账号";
        //设置HttpHeaders，设置fileName编码，排除导出文档名称乱码问题
        HttpHeaders headers = CsvUtil.setCsvHeader(fileName);
        byte[] value = null;
        try {
            //获取要导出的数据
            value = this.userService.exportCsv();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(value,headers, HttpStatus.OK);
    }




    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     */

    @RequestMapping("/login")
    public String login(@RequestParam(value = "name",required = false) String name,
                       @RequestParam(value = "password",required = false) String password,
                        HttpServletRequest request){
        User login = userService.login(name,password);
        if(login==null){
            request.setAttribute("msg", "用户名或密码不存在！");
            return "index";
        }else if(name.equals(login.getName())){

        }
        return "login";
    }
}

