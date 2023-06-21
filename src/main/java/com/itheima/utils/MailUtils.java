package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MailUtils {

    //如果使用邮箱 那么需要调用JAVA提供的邮箱配置类
    @Resource
    private JavaMailSenderImpl mailSender;

    //发送邮件 需要 发送人，接收人，邮件标题，邮件的主题信息

    //springboot 读取配置文件的信息 数据
    @Value("${spring.mail.username}")
    private String mailfrom;
    //邮件发送方法
    public void sendEmail(String mailto,String title,String content){
        //定制邮件发送内容
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mailfrom);
        message.setTo(mailto);
        //设置邮件标题
        message.setSubject(title);
        //设置邮件的主题信息
        message.setText(content);

        //发送邮件
        mailSender.send(message);
    }



}
