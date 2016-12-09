package nyc.c4q.tarynking.washingtonpostjson;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.tarynking.washingtonpostjson.models.Post;

/**
 * Created by tarynking on 12/8/16.
 */
public class PostAdapter extends RecyclerView.Adapter {
    private List<Post> posts = new ArrayList<>();//#18 in notes

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PostViewHolder postViewHolder = (PostViewHolder) holder;
        Post post = posts.get(position);
        postViewHolder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setData(List<Post> posts) {//step #19 in notes
        this.posts = posts;
        notifyDataSetChanged();
    }

}
