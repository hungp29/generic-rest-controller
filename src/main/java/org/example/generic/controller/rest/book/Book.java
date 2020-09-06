package org.example.generic.controller.rest.book;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.generic.controller.rest.Audit;
import org.example.generic.controller.rest.publisher.Publisher;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Audit {

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private Integer year;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;
}
