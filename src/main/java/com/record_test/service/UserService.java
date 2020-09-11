package com.record_test.service;

import com.record_test.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 铁壮
 * @since 2020-09-01
 */
public interface UserService extends IService<User> {
    User login(String name, String password);

    /**
     * 导出csv文件
     * @return
     */
    byte[] exportCsv();
}
