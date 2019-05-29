package com.b2b.cart.models;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "answers")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Answer extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(
//            name = "answer_generator",
//            sequenceName = "answer_sequence",
//            initialValue = 1000
//    )
    private Long id;

    @Column(columnDefinition = "text")
    private String text;








}
