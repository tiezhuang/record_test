package com.record_test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.record_test.config.CsvUtil;
import com.record_test.entity.User;
import com.record_test.mapper.UserMapper;
import com.record_test.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 铁壮
 * @since 2020-09-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User login(String name, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        wrapper.eq("password",password);
        User us = baseMapper.selectOne(wrapper);
        return us;
    }
    @Override
    public byte[] exportCsv() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        byte[] content = null;
        try {
            String[] sTitles = new String[]{"id","账号","密码"};
            String[] mapKeys = new String[]{"id","name","password"};
            List<Map<String, Object>> mapList = this.baseMapper.selectMaps(wrapper);
            ByteArrayOutputStream os = CsvUtil.doExport(sTitles,mapKeys, mapList);
            content = os.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return content;
    }


}
