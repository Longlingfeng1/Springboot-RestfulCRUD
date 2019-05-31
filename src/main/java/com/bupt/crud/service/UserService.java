package com.bupt.crud.service;

import cn.tycoding.entity.User;
import org.springframework.amqp.core.Message;

/**
 * @auther TyCoding
 * @date 2018/9/28
 */
public interface UserService extends BaseService<User> {

    User findByName(String name);

    //public void receive(User user);

    public void receive01(Message message);
}
