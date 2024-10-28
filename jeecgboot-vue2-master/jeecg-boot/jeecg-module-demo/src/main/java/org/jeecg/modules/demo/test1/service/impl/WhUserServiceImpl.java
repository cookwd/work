package org.jeecg.modules.demo.test1.service.impl;

import org.jeecg.modules.demo.test1.entity.WhUser;
import org.jeecg.modules.demo.test1.mapper.WhUserMapper;
import org.jeecg.modules.demo.test1.service.IWhUserService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: wh用户表
 * @Author: jeecg-boot
 * @Date:   2024-10-23
 * @Version: V1.0
 */
@Service
public class WhUserServiceImpl extends ServiceImpl<WhUserMapper, WhUser> implements IWhUserService {

}
