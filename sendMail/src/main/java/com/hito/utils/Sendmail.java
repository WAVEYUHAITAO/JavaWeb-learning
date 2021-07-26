package com.hito.utils;

import com.hito.pojo.User;
import com.sun.mail.util.MailSSLSocketFactory;
import lombok.SneakyThrows;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

//网站3秒原则：用户体验
//多线程实现用户体验！ 异步处理
public class Sendmail extends Thread {
    //用于给用户发送邮件的邮箱
    private String from = "413168358@qq.com";
    //邮箱的用户名
    private String username = "413168358@qq.com";
    //邮箱的密码
    private String password = "gwmsyccxdrxdcaba";
    //发送邮件的服务器地址
    private String host = "smtp.qq.com";
    private User user;

    public Sendmail(User user) {
        this.user = user;
    }

    @SneakyThrows
    @Override
    public void run() {
        Properties prop = new Properties();
        prop.setProperty("mail.host", host);//设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp");//邮件发送协议
        prop.setProperty("mail.smtp.auth", "true");//需要验证用户名密码

        //关于QQ邮箱，还需要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);


        //使用JavaMail发送邮件的5个步骤

        //1.创建定义整个应用程序所需的环境信息的Session对象
        Session session = Session.getDefaultInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);

        //2.通过session得到transport对象
        Transport ts = session.getTransport();

        //3.使用邮箱的用户名和授权码连上邮件服务器
        ts.connect(host, username, password);

        //4.创建邮件(写邮件)
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);

        //指明邮件的发件人
        message.setFrom(new InternetAddress(from));

        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己发给自己
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));

        //邮件的标题
        message.setSubject("用户注册邮件");

        //邮件的文本内容
        //发送过去的文字其实是一段html代码
        String info = "恭喜您注册成功，您的用户名：" + user.getUsername() + ",您的密码：" + user.getPassword() + ",请妥善保管,如有任何问题联系网站客服";
        message.setContent("<h4 style='color:red'>" + info + "</h4>", "text/html;charset=utf-8");

        //5.发送邮件
        ts.sendMessage(message, message.getAllRecipients());

        //6.关闭连接
        ts.close();
    }
}
