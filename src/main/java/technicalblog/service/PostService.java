package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.controller.HomeController;
import technicalblog.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {

    public PostService(){
        System.out.println("**************************");
    }

    public ArrayList<Post> getAllPost() {
        ArrayList<Post> posts = new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres","123");
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM posts");
            while (set.next()){
                Post post = new Post();
                post.setTitle(set.getString("title"));
                post.setBody(set.getString("body"));
                post.setDate(new Date());
                posts.add(post);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return posts;

    }
}
