package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.usecases;

import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.DomainViewRepository;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.CommentViewModel;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.PostViewModel;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.generics.DomainUpdater;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.CommentAdded;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.PostCreated;

import java.util.ArrayList;

public class ViewUpdater extends DomainUpdater {

    private final DomainViewRepository repository;

    public ViewUpdater(DomainViewRepository repository){
        this.repository = repository;

        listen((PostCreated event)->{
            PostViewModel post = new PostViewModel(event.aggregateRootId(), event.getAuthor(), event.getTitle(), new ArrayList<>(), new ArrayList<>());
            repository.savePost(post);
        });

        listen((CommentAdded event)->{
            CommentViewModel comment = new CommentViewModel(event.getId() , event.aggregateRootId(), event.getAuthor(), event.getContent());
            repository.addComment(comment);
        });
    }


}
