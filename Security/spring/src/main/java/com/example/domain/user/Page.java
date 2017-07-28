package com.example.domain.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Page extends Privilege {
    // PK
    @Id
//    @SequenceGenerator(name = "SeqPage", sequenceName = "SEQ_PAGE")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqPage")
    @GeneratedValue
    private Long id;
}
