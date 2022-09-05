package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.commands;

import co.com.sofka.domain.generic.Command;

public class AddTag extends Command {

    private String postId;

    private String tag;

    public AddTag() {

    }

    public AddTag(String postId, String tag) {
        this.postId = postId;
        this.tag = tag;
    }

    public String getPostId() {
        return postId;
    }

    public String getTag() {
        return tag;
    }
}
