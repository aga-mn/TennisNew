package tennis.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "club_id")
    private int clubId;

    @Column(name = "club_name")
    private String clubName;
    @Column(name = "club_street")
    private String street;
    @Column(name = "club_street_number")
    private String streetNumber;
    @Column(name = "club_postcode")
    private String postCode;
    @Column(name = "club_city")
    private String city;
    @Column(name = "club_description")
    private String description;

//    @OneToMany(mappedBy="club")
//    private Set<Player> players;
//
//    @OneToMany(mappedBy = "club")
//    private Set<Tournament> tournaments;

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    //public Set<Player> getPlayers() {
    //    return this.players;
    //}

    //public void setPlayers(Set<Player> players) {
    //    this.players = players;
    //}

//    public Set<Tournament> getTournaments() {
//        return tournaments;
//    }
//
//    public void setTournaments(Set<Tournament> tournaments) {
//        this.tournaments = tournaments;
//    }


    @Override
    public String toString() {
        return "Club{" +
                "clubId=" + clubId +
                ", clubName='" + clubName + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
