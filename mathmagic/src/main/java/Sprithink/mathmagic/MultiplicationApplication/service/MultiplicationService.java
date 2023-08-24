package Sprithink.mathmagic.MultiplicationApplication.service;

import Sprithink.mathmagic.MultiplicationApplication.entities.Multiplication;

import java.util.List;

public interface MultiplicationService {

    boolean checkMultiplication(int id, int product);
    Multiplication generate(String playerName);

    List<Multiplication> getAllRecords();

}
