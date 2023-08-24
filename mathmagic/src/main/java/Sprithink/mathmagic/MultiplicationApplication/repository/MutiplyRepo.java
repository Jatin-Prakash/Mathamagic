package Sprithink.mathmagic.MultiplicationApplication.repository;

import Sprithink.mathmagic.MultiplicationApplication.entities.Multiplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutiplyRepo extends JpaRepository<Multiplication,Integer> {
}
