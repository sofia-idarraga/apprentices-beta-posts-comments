package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.CommentAdded;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.CommentContentEdited;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.PostCreated;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.TagAdded;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Author;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.CommentId;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Content;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.PostId;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Tag;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Title;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Post extends AggregateEvent<PostId> {

    protected Title title;
    protected Author author;
    protected List<Tag> tags;
    protected List<Comment> comments;

    public Post(PostId entityId, Title title, Author author) {
        super(entityId);
        subscribe(new PostChange(this));
        appendChange(new PostCreated(title.value(), author.value())).apply();
    }

    private Post(PostId id) {
        super(id);
        subscribe(new PostChange(this));
    }

    public static Post from(PostId id, List<DomainEvent> events) {
        Post post = new Post(id);
        events.forEach(domainEvent -> post.applyEvent(domainEvent));
        return post;
    }

    //----------- BEHAVIORS

    public void addComment(CommentId id, Author author, Content content) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(author);
        Objects.requireNonNull(content);
        appendChange(new CommentAdded(id.value(), author.value(), content.value())).apply();
    }

    public void addTag(Tag tag){
        Objects.requireNonNull(tag);
        appendChange(new TagAdded(tag.value())).apply();
    }

    public void editCommentContent(CommentId commentId, Content content){
        Objects.requireNonNull(commentId);
        Objects.requireNonNull(content);
        appendChange( new CommentContentEdited(commentId.value(), content.value())).apply();
    }

    //------------- FINDER

    public Optional<Comment> getCommentById(CommentId commentId) {
        return comments.stream().filter((comment -> comment.identity().equals(commentId))).findFirst();
    }

    //----- ACCESS


    public List<Tag> tags() {
        return tags;
    }

    public Title title() {
        return title;
    }

    public Author author() {
        return author;
    }

    public List<Comment> comments() {
        return comments;
    }
}
