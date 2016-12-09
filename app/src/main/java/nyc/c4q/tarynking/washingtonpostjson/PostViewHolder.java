package nyc.c4q.tarynking.washingtonpostjson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.tarynking.washingtonpostjson.models.Post;

/**
 * Created by tarynking on 12/8/16.
 */
public class PostViewHolder extends RecyclerView.ViewHolder {
    private TextView postIdTextView;
    private TextView postTitleTextView;
    private TextView postExcerptTextView;
    private TextView postDateTextView;

    public PostViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        postIdTextView = (TextView) itemView.findViewById(R.id.post_id);
        postTitleTextView = (TextView) itemView.findViewById(R.id.post_title);
        postExcerptTextView = (TextView) itemView.findViewById(R.id.post_excerpt);
        postDateTextView = (TextView) itemView.findViewById(R.id.post_date);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.viewholder_post, parent, false);
    }

    public void bind(final Post post) {
        postIdTextView.setText(post.getId() + "");
        postTitleTextView.setText(post.getTitle());
        postExcerptTextView.setText(post.getExcerpt());
        postDateTextView.setText(post.getDate());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), SecondActivity.class);

                //make bundle to hold post data to be passed into the intent which will be passed to SecondActivity
                Bundle extras = new Bundle();
                extras.putString("POST_ID", String.valueOf(post.getId()));
                extras.putString("POST_TITLE", post.getTitle());
                extras.putString("POST_CONTENT", post.getContent());
                extras.putString("POST_DATE", post.getDate());
                intent.putExtras(extras);

                itemView.getContext().startActivity(intent);

            }
        });
    }

}
