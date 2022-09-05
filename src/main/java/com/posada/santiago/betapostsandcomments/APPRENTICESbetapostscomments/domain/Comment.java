package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain;

import co.com.sofka.domain.generic.Entity;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Author;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.CommentId;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.values.Content;

import java.util.Objects;

public class Comment extends Entity<CommentId> {

    private Author author;
    private Content content;

    public Comment(CommentId entityId, Author author, Content content) {
        super(entityId);
        this.author = author;
        this.content = content;
    }

    public Author author() {
        return author;
    }

    public Content content() {
        return content;
    }

    public void editContent(Content content){
        this.content = Objects.requireNonNull(content);
    }
}
