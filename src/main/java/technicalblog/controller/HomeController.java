package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    public HomeController(){
        System.out.println("231432143");
    }

    @RequestMapping("/")
    public String getPost(Model model){

        ArrayList<Post> posts = postService.getAllPost();

        model.addAttribute("posts",posts);
        return "index";
    }
}
