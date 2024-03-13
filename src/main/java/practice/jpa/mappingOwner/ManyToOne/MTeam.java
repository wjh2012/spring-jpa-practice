package practice.jpa.mappingOwner.ManyToOne;

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
public class MTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column
    @OneToMany
    @Builder.Default
    private List<MMember> mMembers = new ArrayList<>();

}

