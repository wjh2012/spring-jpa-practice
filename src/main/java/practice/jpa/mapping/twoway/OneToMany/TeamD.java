package practice.jpa.mapping.twoway.OneToMany;

import lombok.*;
import practice.jpa.mapping.twoway.ManyToOne.MemberC;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TeamD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name="TEAMD_ID")
    @Builder.Default
    private List<MemberD> memberDs  = new ArrayList<>();
}
