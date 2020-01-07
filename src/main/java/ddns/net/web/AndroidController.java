package ddns.net.web;


import ddns.net.entities.Child;
import ddns.net.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/android")
public class AndroidController {

    private ChildService childService;

    @RequestMapping(value = "/registration")
    public String createChildProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Child child = new Child(
                request.getParameter("username"),request.getParameter("pass")
        );

        childService.save(child);
        response.getWriter().println(child.getId());

        return null;
    }

    @RequestMapping("/tracking/{id}")
    public String addLocation(@PathVariable String id, HttpServletRequest request){

        System.out.println( id + " " + request.getParameter("lat") + " " + request.getParameter("lon"));

        return null;
    }


    @Autowired
    public void setChildService(ChildService childService) {
        this.childService = childService;
    }
}
