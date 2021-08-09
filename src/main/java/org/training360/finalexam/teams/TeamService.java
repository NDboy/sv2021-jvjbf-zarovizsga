package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.finalexam.players.CreatePlayerCommand;
import org.training360.finalexam.players.Player;
import org.training360.finalexam.players.PlayerNotFoundException;
import org.training360.finalexam.players.PlayerRepository;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {

    private ModelMapper modelMapper;

    private TeamRepository teamRepository;

    private PlayerRepository playerRepository;


    public List<TeamDTO> listAllTeams() {
        List<Team> teams = teamRepository.findAll();

        Type targetListType = new TypeToken<List<TeamDTO>>() {}.getType();
        return modelMapper.map(teams, targetListType);
    }

    public TeamDTO createTeam(CreateTeamCommand command) {
        Team team = new Team(command.getName());
        teamRepository.save(team);
        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO addNewPlayer(long id, CreatePlayerCommand command) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());
        playerRepository.save(player);
        team.addPlayer(player);

        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO addExistingPlayer(long id, UpdateWithExistingPlayerCommand command) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
        Player player = playerRepository.findById(command.getId()).orElseThrow(() -> new PlayerNotFoundException(command.getId()));
        long count = team.getPlayers().stream().filter(p -> p.getPosition() == player.getPosition()).count();
        if (player.getTeam() == null && count < 2) {
            team.addPlayer(player);
        }
        return modelMapper.map(team, TeamDTO.class);
    }
}
