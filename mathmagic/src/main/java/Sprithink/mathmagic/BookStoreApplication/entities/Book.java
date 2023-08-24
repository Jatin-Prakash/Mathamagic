package Sprithink.mathmagic.BookStoreApplication.entities;


import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "project_books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @GraphQLQuery(name = "title", description = "Title of the book")
    private String title;
    @GraphQLQuery(name = "desc", description = "Description of the book")
    private String desc;
    @GraphQLQuery(name = "author", description = "Author of the book")
    private String author;
}
