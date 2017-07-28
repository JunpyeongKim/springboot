package com.example.domain.user;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue
    private Long id;

    // 메뉴명: NN
    private String name;

    // 레벨
    private Integer level;

    // 메뉴 순서 : NN
    private Integer order;

    // 상위메뉴
    private Integer parent;

    // 관련 링크 : NN
    private String linkUrl;

    // 설정: 개인정보포함, 승인여부, 메뉴노출여부, 팝업여부
//    List<Object> objects;

    // 사용 여부
    private String useYn;
}
