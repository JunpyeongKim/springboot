package com.example.domain.user;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = false)
public class Button extends Privilege {
    @Id
    @SequenceGenerator(name = "SeqButton", sequenceName = "SEQ_BUTTON")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqButton")
    private Long id;
}
