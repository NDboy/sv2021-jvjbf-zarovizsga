package org.training360.finalexam.teams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.training360.finalexam.players.PositionType;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("select distinct t from Team t join fetch t.players")
    List<Team> findAllWithPlayers();

    @Query("select count(p) from Team t join fetch t.players p where p.position =: position")
    int countPlayersOnPosition(PositionType position);
}
