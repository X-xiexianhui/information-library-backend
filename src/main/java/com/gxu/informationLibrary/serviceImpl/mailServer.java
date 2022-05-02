package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.userDao;
import com.gxu.informationLibrary.entity.response;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
public class mailServer {
    private final JavaMailSender mailSender;//一定要用@Autowired
    private final StringRedisTemplate redisTemplate;
    private final userDao userManage;
    public mailServer(JavaMailSender mailSender, StringRedisTemplate redisTemplate, userDao userManage) {
        this.mailSender = mailSender;
        this.redisTemplate = redisTemplate;
        this.userManage = userManage;
    }

    /**
     * 给前端输入的邮箱，发送验证码
     */
    @Async("taskExecutor")
    public Future<response<Boolean>> sendMimeMail(String user_id) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setSubject("验证码邮件");//主题
            //生成随机数
            String code = randomCode();
            String email = userManage.queryEmail(user_id);
            if (email == null){
                return new AsyncResult<>(new response<>(500,"用户未绑定邮箱，请联系管理员重置密码",false));
            }
            //将随机数放置到redis中
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            ops.set("email_" + user_id, code, 5 * 60, TimeUnit.SECONDS);

            mailMessage.setText("尊敬的用户"+user_id+"，\n"+"您正在进行找回密码操作，本次的验证码是：" + code + "，验证码5分钟内有效，请及时输入。");//内容

            mailMessage.setTo(email);//发给谁

            String from = "1281715740@qq.com";
            mailMessage.setFrom(from);//你自己的邮箱

            mailSender.send(mailMessage);//发送
        }catch (Exception e){
            e.printStackTrace();
            return new AsyncResult<>(new response<>(500,e.getCause().getMessage(),false));
        }
        return new AsyncResult<>(new response<>(true));
    }
    public response<Boolean>checkAuthCode(String parma){
        try {
            JSONObject emailJSON= JSON.parseObject(parma);
            String user_id=emailJSON.getString("user_id");
            String auth_code=emailJSON.getString("auth_code");
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            String code = ops.get("email_"+user_id);
            if (!auth_code.equals(code)){
                return new response<>(404,"验证码错误",false);
            }
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),false);
        }
        return new response<>(true);
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
