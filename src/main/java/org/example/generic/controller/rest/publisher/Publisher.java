package org.example.generic.controller.rest.publisher;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.generic.controller.rest.Audit;
import org.example.generic.controller.rest.book.Book;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Publisher extends Audit {

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.PERSIST)
    private List<Book> books;
}
