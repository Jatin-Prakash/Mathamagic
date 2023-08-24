package Sprithink.mathmagic;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomNumberSupplierServiceImpl implements RandomNumberSupplier{

    Integer MINIMUM_FACTOR = 11;
    Integer MAXIMUM_FACTOR = 100;
    @Override
    public Integer generateRandomNumber() {

        return new Random().nextInt((MAXIMUM_FACTOR-MINIMUM_FACTOR)+1);
    }



    @Override
    public Object get() {
        return null;
    }
}
