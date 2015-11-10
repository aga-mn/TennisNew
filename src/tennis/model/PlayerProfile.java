package tennis.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "player_profile")
public class PlayerProfile {
    @Id
    @Column(name="player_id", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters={@Parameter(name="property", value="player")})
    private int playerId;

    @Column(name = "racquet")
    private String racquet;
    @Column(name = "hand")
    private String hand;
    @Column(name = "favourite_player")
    private String favouritePlayer;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;


    @OneToOne
    @PrimaryKeyJoinColumn
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getRacquet() {
        return racquet;
    }

    public void setRacquet(String racquet) {
        this.racquet = racquet;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getFavouritePlayer() {
        return favouritePlayer;
    }

    public void setFavouritePlayer(String favouritePlayer) {
        this.favouritePlayer = favouritePlayer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
