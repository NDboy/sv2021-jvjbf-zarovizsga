package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.training360.finalexam.teams.Team;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    @Enumerated(value = EnumType.STRING)
    private PositionType position;

    @ManyToOne
    private Team team;

    public Player(String name, LocalDate birthDate, PositionType position, Team team) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.team = team;
    }

    public Player(String name, LocalDate birthDate, PositionType position) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
    }

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

 /*Team (id, név, játékosok)
 Player (id, név, születési idő, pozíció, csapat)

 Az entitások között kétirányú egy-több kapcsolat van,
 vagyis egy csapatnak lehet több játékosa, de egy játékos egyszerre csak egy csapatban játszhat.
 A pontos elnevezéseket a tesztben megtalálod. Lehetséges pozíciók: GOALKEEPER, RIGHT_FULLBACK,
 LEFT_FULLBACK, CENTER_BACK, DEFENDING_MIDFIELDER, RIGHT_WINGER, LEFT_WINGER, STRIKER

 Táblák neve legyen teams és players!

 A feladat megoldásához a következő funkciókat
 kell megvalósítanod a megfelelő végpontokon.

 A PlayerController a /api/players végponton figyel

 Lehessen lekérdezni az összes adatbázisban szereplő játékost
 Lehessen felvenni új játékost. (Ekkor bekerül a liga nyilvántartásába,
 de lehet hogy még egy csapat sem igazolta le.)
 A nevet, születési időt és pozíciót lehet megadni. Ebből a név megadása kötelező.
 Lehessen törölni egy játékost id alapján a /api/players/{id} végponton
 A TeamController a /api/teams végponton figyel

 Lehessen lekérdezni a csapatokat, az összes játékosukkal együtt
 Lehessen új csapatot létrehozni. Ehhez csak a csapat nevét kell megadni, ami kötelező.
 Lehessen egy csapathoz
 új játékost hozzáadni a /api/teams/{id}/players végponton keresztül
 post metódussal.
 Ebben az esetben egy játékos minden adatát várjuk és úgy adjuk hozzá
 a csapathoz, hogy egyúttal a játékosok táblába is lementjük
 Lehessen a meglévő, szabad játékosok közül játékost igazolni a
 /api/teams/{id}/players végponton keresztül put metódussal.
 Ekkor a következő feltételeknek kell teljesülnie:
 A játékosnak ne legyen csapata
 A csapatban kevesebb mint kettő ezen a pozíción szereplő játékos legyen (ezt a service rétegben implementáld!)
 Ha a fenti kettő közül valamelyik nem teljesül, ne történjen meg az igazolás */