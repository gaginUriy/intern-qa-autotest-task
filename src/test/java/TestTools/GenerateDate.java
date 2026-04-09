package TestDataGen;
import com.github.javafaker.*;

import java.util.Random;

public class GenerateDate {
    Faker faker = new Faker();



    public int sellerIdRandom(){
        return faker.random().nextInt(111111,999999);
    }

    public String nameRandom(){
        return faker.name().firstName();
    }

    public int priceRandom(){
        return faker.random().nextInt(0,99999999);
    }
    public int likesRandom(){
        return faker.random().nextInt(0,999999);
    }
    public int viewCountRandom(){
        return faker.random().nextInt(0,999999);
    }
    public int contactsRandom(){
        return faker.random().nextInt(0,999999);
    }

}
