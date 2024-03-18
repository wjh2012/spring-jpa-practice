package practice.jpa.mapping.twoway.noMaster;

import lombok.*;
import practice.jpa.mapping.twoway.OneToMany.Twoway_Team_Master;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Twoway_Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Twoway_Team team;
}
