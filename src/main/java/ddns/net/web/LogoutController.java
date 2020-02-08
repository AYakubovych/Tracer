package ddns.net.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  This Controller not in use. Replaced by Spring Security implementation
 */
@RequestMapping("/logout")
@Controller
public class LogoutController {

    private Logger logger = LoggerFactory.getLogger(LogoutController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        deleteIdCookies(request.getCookies(),response);
        logger.info("User logout");

        return new ModelAndView("redirect:/");
    }


    private void deleteIdCookies(Cookie[] cookies,HttpServletResponse response){
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        logger.info("Cookies deleted");
    }

}
