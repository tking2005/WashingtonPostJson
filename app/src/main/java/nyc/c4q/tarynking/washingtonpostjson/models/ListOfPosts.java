package nyc.c4q.tarynking.washingtonpostjson.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tarynking on 12/8/16.
 */

public class ListOfPosts {

    @SerializedName("posts")
    @Expose
    private List<Post> posts = null;

    /**
     *
     * @return
     * The posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     *
     * @param posts
     * The posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}