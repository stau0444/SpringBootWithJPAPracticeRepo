package com.practice.jpapraticerepo.practice.JPAprac.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    @OneToOne(mappedBy = "book")
    private BookReviewInfo bookReviewInfo;

    @ManyToMany
    @JoinColumn(name = "book_id")
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private Publisher publisher;


    @OneToMany(mappedBy = "book")
    private List<Review> reviews = new ArrayList<>();

}
