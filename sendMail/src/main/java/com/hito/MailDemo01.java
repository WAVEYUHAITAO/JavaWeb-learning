package com.hito;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailDemo01 {
    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com");//设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp");//邮件发送协议
        prop.setProperty("mail.smtp.auth", "true");//需要验证用户名密码

        //关于QQ邮箱，还需要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        //使用JavaMail发送邮件的5个步骤

        //1.创建定义整个应用程序所需的环境信息的Session对象

        //QQ才有！其他邮箱不用
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名，授权码
                return new PasswordAuthentication("413168358@qq.com", "gwmsyccxdrxdcaba");
            }
        });
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);

        //2.通过session得到transport对象
        Transport ts = session.getTransport();

        //3.使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com", "413168358@qq.com", "gwmsyccxdrxdcaba");

        //4.创建邮件(写邮件)
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);

        //指明邮件的发件人
        message.setFrom(new InternetAddress("413168358@qq.com"));

        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己发给自己
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("413168358@qq.com"));

        //邮件的标题
        message.setSubject("只包含文本的简单邮件");

        //邮件的文本内容
        //发送过去的文字其实是一段html代码
        message.setContent("<h1 style='color:red'>你好啊！</h1>", "text/html;charset=utf-8");

        //5.发送邮件
        ts.sendMessage(message, message.getAllRecipients());

        //6.关闭连接
        ts.close();
    }
}
