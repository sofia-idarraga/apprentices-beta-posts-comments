package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.generics;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public abstract class DomainUpdater {

    protected Set<Consumer<? super DomainEvent>> listeners = new HashSet<>();

    public DomainUpdater() {
    }

    //We add to the list of listeners an event that must be a consumer which extends from Domain Event
    protected void listen(Consumer<? extends DomainEvent> event) {
        this.listeners.add((Consumer<? super DomainEvent>) event);
    }

    // We will apply the events that are collected in "listeners"
    // The way we execute a consumer is with accept. The consumer "do something" and doesn't return anything
    public final void applyEvent(DomainEvent domainEvent) {
        this.listeners.forEach(consumer -> {
            try {
                consumer.accept(domainEvent);
            } catch (ClassCastException classCastException) {
            }
        });
    }
}
