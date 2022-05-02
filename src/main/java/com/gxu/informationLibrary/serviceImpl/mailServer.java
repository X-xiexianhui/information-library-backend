package com.gxu.informationLibrary.serviceImpl;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class mailServer {
    private final JavaMailSender mailSender;//一定要用@Autowired
    private final StringRedisTemplate redisTemplate;
    public mailServer(JavaMailSender mailSender, StringRedisTemplate redisTemplate) {
        this.mailSender = mailSender;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 给前端输入的邮箱，发送验证码
     */
    public boolean sendMimeMail(String email,String user_id) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setSubject("验证码邮件");//主题
            //生成随机数
            String code = randomCode();

            //将随机数放置到redis中
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            ops.set("email_"+user_id,code,5*60, TimeUnit.SECONDS);

            mailMessage.setText("您正在恢复密码，给您发送的的验证码是："+code+"，验证码5分钟内有效。");//内容

            mailMessage.setTo(email);//发给谁

            String from = "1281715740@qq.com";
            mailMessage.setFrom(from);//你自己的邮箱

            mailSender.send(mailMessage);//发送
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 随机生成4位数的验证码
     * @return String code
     */
    public String randomCode(){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
