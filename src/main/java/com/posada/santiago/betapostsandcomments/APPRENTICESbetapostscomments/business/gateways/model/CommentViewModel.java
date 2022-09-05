package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model;

public class CommentViewModel {

    private String id;
    private String postId;
    private String author;
    private String content;

    public CommentViewModel() {
    }

    public CommentViewModel(String id,  String postId, String author, String content) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getPostId() {
        return postId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
