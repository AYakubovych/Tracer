package ddns.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    public void sendMail(String text) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("a.yakubovych@yahoo.com");
        mail.setFrom("bochkalouno@gmailc.om");
        mail.setSubject("Feedback");
        mail.setText(text);

        javaMailSender.send(mail);
    }

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
}
