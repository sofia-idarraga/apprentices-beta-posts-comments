package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.commands;

import co.com.sofka.domain.generic.Command;

public class CreatePost extends Command {

    private String postId;
    private String title;
    private String author;

    public CreatePost() {

    }

    public CreatePost(String postId, String title, String author) {
        this.postId = postId;
        this.title = title;
        this.author = author;
    }

    public String getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
