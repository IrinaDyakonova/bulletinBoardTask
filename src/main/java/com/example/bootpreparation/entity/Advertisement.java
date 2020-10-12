package com.example.bootpreparation.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String filename;
    private String textDescription;
    private LocalDate addTime;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    public Advertisement(String title, String textDescription, User user) {
        this.title = title;
        this.textDescription = textDescription;
        this.user = user;
    }
}
