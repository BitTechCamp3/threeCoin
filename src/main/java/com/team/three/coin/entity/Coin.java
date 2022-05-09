package com.team.three.coin.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "coin")
public class Coin {
    @Id
    @Column(value = "index")
    private Integer index;

    @Column(value ="coinSym")
    private String coinSym;

    @Column(value ="coinName")
    private String coinName;

    @Column(value="useYn")
    private boolean useYn = true;

}
