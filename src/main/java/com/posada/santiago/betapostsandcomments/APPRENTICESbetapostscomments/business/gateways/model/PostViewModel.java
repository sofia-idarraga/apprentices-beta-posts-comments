package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model;

import java.util.List;

public class PostViewModel {

    private String id;
    private String postId;
    private String author;
    private String title;
    private List<String> tags;
    private List <CommentViewModel> comments;

    public PostViewModel() {
    }

    public PostViewModel(String postId, String author, String title, List<String> tags, List<CommentViewModel> comments) {
        this.postId = postId;
        this.author = author;
        this.title = title;
        this.tags = tags;
        this.comments = comments;
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

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<CommentViewModel> getComments() {
        return comments;
    }
}
