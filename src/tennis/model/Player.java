package tennis.model;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import java.util.Set;


@Entity
@Table (name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;

   // @OneToOne(mappedBy="player")
    ///kasowanie na raz profilu i pleyera
  //  @Cascade(value= CascadeType.DELETE)
   // private PlayerProfile playerProfile;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "username", unique = true)
    private String username;

  //  @ManyToOne
   // @JoinColumn(name="club_id")
   // private Club club;

 //   @OneToMany(mappedBy="player")
//    private Set<PlayerRanking> playerRankings;

  //  public PlayerProfile getPlayerProfile() {
   //     return playerProfile;
  //  }

 //   public void setPlayerProfile(PlayerProfile playerProfile) {
  //      this.playerProfile = playerProfile;
 //   }

  //  public Club getClub() {
  //      return this.club;
  //  }

  //  public void setClub(Club club) {
 //       this.club = club;
  //  }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
    //testowy commit
