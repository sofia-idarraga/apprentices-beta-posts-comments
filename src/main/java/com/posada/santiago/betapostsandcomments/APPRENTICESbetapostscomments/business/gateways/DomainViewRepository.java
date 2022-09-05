package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways;

import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.CommentViewModel;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.PostViewModel;
import reactor.core.publisher.Mono;

public interface DomainViewRepository {

    Mono<PostViewModel> savePost(PostViewModel postViewModel);
    Mono<PostViewModel> addComment(CommentViewModel commentViewModel);

}
