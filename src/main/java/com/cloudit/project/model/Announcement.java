package com.cloudit.project.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;


import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
public class Announcement implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(min = 3, max = 40)
    String title;
    @Size(min = 15, max = 5000)
    private String content;
    String image;
    @CreationTimestamp
    Date createdAt;
    Long createdBy;  //user id
    Boolean approved;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="announcement")
    private Set<Comment> comments;



}
