package Sprithink.mathmagic.MultiplicationApplication.controller;

import Sprithink.mathmagic.MultiplicationApplication.entities.Multiplication;
import Sprithink.mathmagic.MultiplicationApplication.service.MultiplicationService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MultiplicationController {
    @Autowired
    MultiplicationService multiplicationService;

    @MutationMapping(name = "generate")
    public Multiplication generate(@Argument MultiplicationInput multiplicationInput){
        Multiplication multiplication = new Multiplication();
        multiplication.mult1 = multiplicationInput.getMult1();
        multiplication.mult2 = multiplicationInput.getMult2();
        return multiplication;
    }

    @Getter
    @Setter
    class MultiplicationInput{
        int mult1;
        int mult2;
    }
}
