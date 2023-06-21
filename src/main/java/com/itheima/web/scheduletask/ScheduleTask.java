package com.itheima.web.scheduletask;

import com.itheima.dao.StatisticMapper;
import com.itheima.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class ScheduleTask {
    //需要注入刚才写好的MailUtils

    //还需要注入 文章统计表

    @Autowired
    private StatisticMapper statisticMapper;

    @Autowired
    private MailUtils mailUtils;

    @Value("${spring.mail.username}")
    private String mailto;

    //定时任务  0 */2 * * * ?
    @Scheduled(cron = "0 0 12 1 * ?")
    public  void  sendEmail(){
        //定制邮件内容

        long totalVisit = statisticMapper.getTotalVisit();

        long totalComment = statisticMapper.getTotalComment();

        //创建邮件主题
        StringBuffer conent =new StringBuffer();

        conent.append("博客访问总量为："+totalVisit+"人次").append("\n");
        conent.append("博客评论总数为："+totalComment+"人次").append("\n");

        mailUtils.sendEmail(mailto,"博客系统流量统计情况",conent.toString());

    }







}
