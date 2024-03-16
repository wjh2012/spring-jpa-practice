package practice.jpa.mapping.twoway.OneToMany;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Twoway_Team_Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "TEAMD_ID")
    @Builder.Default
    private List<Twoway__Member_Slave> twowayMemberSlaves = new ArrayList<>();
}
