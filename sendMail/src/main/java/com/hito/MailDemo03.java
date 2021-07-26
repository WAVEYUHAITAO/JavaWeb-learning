package com.hito;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.util.Properties;

public class MailDemo03 {
    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com");//设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp");//邮件发送协议
        prop.setProperty("mail.smtp.auth", "true");//需要验证用户名密码

        //关于QQ邮箱，还需要设置SSL加密，加上以下代码即可
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", 465);

        //使用JavaMail发送邮件的5个步骤

        //1.创建定义整个应用程序所需的环境信息的Session对象
        Session session = Session.getDefaultInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);

        //2.通过session得到transport对象
        Transport ts = session.getTransport();

        //3.使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com", "413168358@qq.com", "gwmsyccxdrxdcaba");

        //4.创建邮件(写邮件)
        //创建邮件对象
        MimeMessage message = createImageMail(session);

        //5.发送邮件
        ts.sendMessage(message, message.getAllRecipients());

        //6.关闭连接
        ts.close();
    }

    public static MimeMessage createImageMail(Session session) throws Exception {
        //创建邮件
        MimeMessage message = new MimeMessage(session);
        //设置邮件的基本信息
        //发件人
        message.setFrom(new InternetAddress("413168358@qq.com","haitao","UTF-8"));
        //To: 增加收件人（可选）
        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("413168358@qq.com", "USER_DD", "UTF-8")); //InternetAddress 第二个参数是别名
        //Cc: 抄送（可选）
        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("yuhaitao521ok@hotmail.com", "USER_EE", "UTF-8"));
        //Bcc: 密送（可选）
        message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("tom9106@163.com", "USER_FF", "UTF-8"));

        //邮件标题
        message.setSubject("带图片的邮件");

        // 准备邮件数据
        // 准备邮件正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封邮件正文带图片<img src='cid:2020.jpg'>和附件的邮件！", "text/html;charset=UTF-8");
        // 创建邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh1 = new DataHandler(new FileDataSource("src/main/resources/WeChat_20210720231923.mp4"));
        attach.setDataHandler(dh1);
        attach.setFileName(dh1.getName());
        // 描述关系:正文和附件
        MimeMultipart mp1 = new MimeMultipart();
        mp1.addBodyPart(text);
        mp1.addBodyPart(attach);
        mp1.setSubType("mixed");

        message.setContent(mp1);
        message.saveChanges();
        //将创建好的邮件写入到E盘以文件的形式进行保存
        message.writeTo(new FileOutputStream("E:\\Repositories\\JavaWeb-learning\\sendMail\\saved_email\\ImageMail.eml"));
        //返回创建好的邮件
        return message;
    }
}


