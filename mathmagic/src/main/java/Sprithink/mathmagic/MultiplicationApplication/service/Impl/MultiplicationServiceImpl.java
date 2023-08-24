package Sprithink.mathmagic.MultiplicationApplication.service.Impl;

import Sprithink.mathmagic.RandomNumberSupplier;
import Sprithink.mathmagic.MultiplicationApplication.dto.MultiplicationInputData;
import Sprithink.mathmagic.MultiplicationApplication.entities.Multiplication;
import Sprithink.mathmagic.MultiplicationApplication.repository.MutiplyRepo;
import Sprithink.mathmagic.MultiplicationApplication.service.MultiplicationService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class MultiplicationServiceImpl implements MultiplicationService {
    MutiplyRepo multiplyRepo;

    @Autowired
    RandomNumberSupplier randomNumberSupplier;

    @Autowired
    MultiplicationServiceImpl(MutiplyRepo multiplyRepo){
        this.multiplyRepo = multiplyRepo;
    }

    @GraphQLMutation(name = "checkMultiplication")
    @Override
    public boolean checkMultiplication(@GraphQLArgument(name = "Id", description = "Id of the multiplication object")int id,
                                       @GraphQLArgument(name = "supplyProduct", description = "value of the Multiplication") int supplyProduct) {
        Optional<Multiplication> optionalMultiplication = multiplyRepo.findById(id);
        Multiplication multiplication = optionalMultiplication.get();
        int actualProduct = multiplication.mult1 * multiplication.mult2;
        int rewards = multiplication.getRewards();
        if(actualProduct==supplyProduct){
            multiplication.setProduct(supplyProduct);
            multiplication.setRewards(++rewards);
            multiplyRepo.save(multiplication);

            return true;

        }
        return false;
    }

    @GraphQLMutation(name = "generate")
    @Override
    public Multiplication generate(
            @GraphQLArgument(name = "multiplication", description = "takes the multiplication Object") String name) {

        MultiplicationInputData multiplicationInputData = new MultiplicationInputData(name);
        Multiplication multiplication = new Multiplication();
        multiplication.setName(multiplicationInputData.getPlayerName());
        multiplication.setMult1(randomNumberSupplier.generateRandomNumber());
        multiplication.setMult2(randomNumberSupplier.generateRandomNumber());

        return multiplyRepo.save(multiplication);
    }

    @GraphQLQuery(name = "getAllRecords")
    @Override
    public List<Multiplication> getAllRecords() {

        return multiplyRepo.findAll();
    }
}
