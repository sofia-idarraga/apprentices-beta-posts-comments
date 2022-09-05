package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain;

import co.com.sofka.domain.generic.EventChange;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.CommentAdded;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.CommentContentEdited;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.PostCreated;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.TagAdded;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Author;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.CommentId;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Content;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Tag;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Title;

import java.util.ArrayList;

public class PostChange extends EventChange {

    public PostChange(Post post) {
        apply((PostCreated event) -> {
            post.title = new Title(event.getTitle());
            post.author = new Author(event.getAuthor());
            post.comments = new ArrayList<>();
            post.tags = new  ArrayList<>();
        });

        apply((CommentAdded event) -> {
            Comment comment = new Comment(
                    CommentId.of(event.getId()),
                    new Author(event.getAuthor()),
                    new Content(event.getContent())
            );
            post.comments.add(comment);
        });

        apply((TagAdded event) ->{
            Tag tag = new Tag(event.getTag());
            post.tags.add(tag);
        });

        apply((CommentContentEdited event)->{
            var comment = post.getCommentById(CommentId.of(event.getCommentId()))
                    .orElseThrow(() -> new IllegalArgumentException("Comment ID doesn't exist"));
            comment.editContent(new Content(event.getContent()));
        });
    }
}
