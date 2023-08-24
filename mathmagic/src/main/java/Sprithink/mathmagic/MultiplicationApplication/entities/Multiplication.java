package Sprithink.mathmagic.MultiplicationApplication.entities;

import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "MULTIPLICATION_TABLE")
@Getter
@Setter
public class Multiplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GraphQLQuery(name = "Id", description = "Id of multiplication Object")
    public int Id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    public int mult1;

    @GeneratedValue(strategy = GenerationType.AUTO)
    public int mult2;

    @GraphQLQuery(name = "name", description = "name of player")
    private String name;
    public int product;

    public int rewards;
}
