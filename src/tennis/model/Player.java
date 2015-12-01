package tennis.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement(name="Player")
@XmlType(propOrder={"playerId", "lastName", "firstName", "username", "gender"})
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
    @NotNull(message = "fisrt name cannot be null")
    @NotEmpty(message = "fisrt name cannot be empty")
    @Pattern(regexp="[a-zA-Z]+", message = "name contains illegal characters" )
    //@NotBlank(message = "fisrt name cannot be blank")
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

    @XmlElement(name="PlayerUsername")
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
