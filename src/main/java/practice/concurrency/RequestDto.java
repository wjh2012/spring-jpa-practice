package practice.concurrency;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestDto {
    private String name;
    private int number;

    public MemberEntity toModel() {
        return MemberEntity.builder().number(number).build();
    }
}
