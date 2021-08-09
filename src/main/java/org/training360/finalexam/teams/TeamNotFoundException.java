package org.training360.finalexam.teams;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class TeamNotFoundException extends AbstractThrowableProblem {

    private static final URI TYPE = URI.create("teams/not-found");

    public TeamNotFoundException(long id) {
        super(  TYPE,
                "Not found",
                Status.NOT_FOUND,
                String.format("Team with id: %s not found", id));
    }


}
