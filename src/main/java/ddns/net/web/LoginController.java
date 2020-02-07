package ddns.net.web;


import ddns.net.authenticators.CustomAuthenticationProvider;
import ddns.net.entities.User;
import ddns.net.service.UserService;
import ddns.net.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.executable.ValidateOnExecution;
import java.util.Locale;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@PropertySource("classpath:/properties/testUser.properties")
@RequestMapping("/login")
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    private CustomAuthenticationProvider customAuthenticationProvider;

    @Value("${mail}")
    private String testEmail;

    @Value("${pass}")
    private String testPass;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView open(HttpServletResponse response,HttpServletRequest request,Locale locale,Model model,
                             @RequestParam(value = "test",defaultValue = "false") boolean test){
        if(test){
            doAutoLogin(testEmail,testPass,request);
            return new ModelAndView("redirect:/profile");
        }

        return new ModelAndView("login");
    }

    private void doAutoLogin(String username, String password, HttpServletRequest request) {

        try {
            // Must be called from request filtered by Spring Security, otherwise SecurityContextHolder is not updated
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = customAuthenticationProvider.authenticate(token);
            logger.debug("Logging in with [{}]", authentication.getPrincipal());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            SecurityContextHolder.getContext().setAuthentication(null);
            logger.error("Failure in autoLogin", e);
        }

    }

    @Autowired
    public void setCustomAuthenticationProvider(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }
}
