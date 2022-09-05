package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.commands;

import co.com.sofka.domain.generic.Command;

public class EditCommentContent extends Command {

    private String postId;
    private String commentId;
    private String content;

    public EditCommentContent() {
    }

    public EditCommentContent(String postId, String commentId, String content) {
        this.postId = postId;
        this.commentId = commentId;
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }
}
