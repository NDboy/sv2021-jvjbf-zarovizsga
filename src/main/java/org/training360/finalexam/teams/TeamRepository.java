package org.training360.finalexam.teams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.training360.finalexam.players.Player;
import org.training360.finalexam.players.PositionType;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {


}
