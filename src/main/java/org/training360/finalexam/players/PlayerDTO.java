package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.training360.finalexam.teams.Team;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private PositionType position;

//    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PositionType getPosition() {
        return position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

//    public Team getTeam() {
//        return team;
//    }

//    public void setTeam(Team team) {
//        this.team = team;
//    }
}
