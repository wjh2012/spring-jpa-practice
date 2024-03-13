package practice.jpa.mapping.twoway.ManyToOne;

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
public class TeamC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "teamC") // 주의! 다(many) 쪽의 변수명을 정확히 적어야함
    @Builder.Default
    private List<MemberC> memberCs = new ArrayList<>();

}

