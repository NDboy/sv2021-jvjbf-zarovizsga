package org.training360.finalexam.players;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class PlayerNotFoundException extends AbstractThrowableProblem {

    private static final URI TYPE = URI.create("players/player-not-found");

    public PlayerNotFoundException(long id) {
        super(  TYPE,
                "Not found",
                Status.NOT_FOUND,
                String.format("Player with id: %s not found", id));
    }
}