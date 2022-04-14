package com.afs.crashhandler.utils;

import android.util.Log;

public class SendEmailUtils {

    /**
     * 邮件发送程序
     * <p>
     * 接收邮件的address
     *
     * @param subject        邮件主题
     * @param content        邮件内容
     * @param attachmentPath 附件路径
     * @param attachmentName 附件名称
     * @throws Exception
     */
    public static void sendEmail(String toAddress, String subject, String content, String attachmentPath, String attachmentName) {
        Log.i("name", "name=" + subject);
        Log.i("content", content);
        String host = "smtp.163.com";
        String address = "logfeedback@163.com";
        String from = "logfeedback@163.com";
        String password = "LogFdbk2016zf";// 密码
        if ("".equals(toAddress) || toAddress == null) {
            toAddress = "logfeedback@163.com";
        }
        String port = "25";
//        SendEmail(host, address, from, password, toAddress, port, subject, content, attachmentPath, attachmentName);
    }

//    /**
//     * 邮件发送程序
//     *
//     * @param host           邮件服务器 如：smtp.qq.com
//     * @param address        发送邮件的地址 如：878458730@qq.com
//     * @param from           来自： wsx2miao@qq.com/也就是发件人地址
//     * @param password       您的邮箱密码
//     * @param to             接收人
//     * @param port           端口（QQ:25/sina:25/163:25）
//     * @param subject        邮件主题
//     * @param content        邮件内容
//     * @param attachmentPath 附件路径
//     * @param attachmentName 附件名称
//     * @throws Exception
//     */
//    public static void SendEmail(String host, String address, String from, String password, String to, String port, String subject, String content, String attachmentPath, String attachmentName) throws Exception {
//        Multipart multiPart;
//        String finalString = "";
//        //附件地址
//        // String affix="/mnt/sdcard/oppo.mp4";
//        // String affixName="oppo.mp4";
//        Properties props = System.getProperties();
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.user", address);
//        props.put("mail.smtp.password", password);
//        props.put("mail.smtp.port", port);
//        props.put("mail.smtp.auth", "true");
//
//        Log.i("Check", "done pops");
//        Session session = Session.getDefaultInstance(props, null);
//        DataHandler handler = new DataHandler(new ByteArrayDataSource(finalString.getBytes(), "text/plain"));
//        MimeMessage message = new MimeMessage(session);
//        message.setFrom(new InternetAddress(from));
//        message.setDataHandler(handler);
//        Log.i("Check", "done sessions");
//
//        multiPart = new MimeMultipart();
//        //添加附件
//        BodyPart messageBodyPart = new MimeBodyPart();
//        DataSource source = new FileDataSource(attachmentPath);
//        messageBodyPart.setDataHandler(new DataHandler(source));
//
//        //添加接收人地址to代表接收人地址
//        InternetAddress toAddress = new InternetAddress(to);
//        messageBodyPart.setFileName(attachmentName);
//        multiPart.addBodyPart(messageBodyPart);
//
//        message.addRecipient(Message.RecipientType.TO, toAddress);
//        Log.i("Check", "added recipient");
//        message.setSubject(subject);
//        // message.setContent(multiPart);
//        message.setText(content);
//
//        //将multipart对象放到message中
//        message.setContent(multiPart);
//        //保存邮件
//        message.saveChanges();
//        Log.i("check", "transport");
//        Transport transport = session.getTransport("smtp");
//        Log.i("check", "connecting");
//        transport.connect(host, address, password);
//        Log.i("check", "wana send");
//        transport.sendMessage(message, message.getAllRecipients());
//        transport.close();
//        Log.i("check", "sent");
//    }
}