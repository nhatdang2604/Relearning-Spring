package org.example.condition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class MagicBean {

    private static int nNextAvailableId = 0;
    private int id;

    public MagicBean() {
        id = ++nNextAvailableId;
    }
}
