package com.bupt.crud.service.impl;

import com.bupt.crud.entities.User;
import com.bupt.crud.service.UserService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther TyCoding
 * @date 2018/9/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void create(User user) {
        userMapper.create(user);
    }

    @Override
    public void delete(Long id) {

       userMapper.delete(id);

    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    @RabbitListener(queues = "atguigu.news")
    public void receive01(Message message){
        System.out.println("收到消息--消息头:"+message.getBody());
        System.out.println("收到消息--propertie:"+message.getMessageProperties());
    }
}
