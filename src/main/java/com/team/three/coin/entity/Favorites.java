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
@Table(value = "favorites")
public class Favorites {
    @Id
    @Column(value = "index")
    private Integer index;

    @Column(value ="userId")
    private String userId;

    @Column(value ="coinSym")
    private String coinSym;
}
