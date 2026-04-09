


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Feature("создание карточки товара")

public class GetResourceCardForUUID {

    private Response cardCreate;
    StepsCRUDResorceCard cardSteps = new StepsCRUDResorceCard();
    @BeforeEach
    void setUp(){
        TestDataGen.GenerateDate date = new TestDataGen.GenerateDate();
        SudClassStatictis statistics = new SudClassStatictis(date.likesRandom(),date.viewCountRandom(),date.contactsRandom());
        CreateCardResorceDTO cardResorceDTO = new CreateCardResorceDTO(
                date.priceRandom(),date.nameRandom(),date.sellerIdRandom(),statistics);

        cardCreate = cardSteps.PostCardCreated(cardResorceDTO);
    }

    @Test
    @Description("Получение существующего объявления по валидному UUID")
    public void getAdExistingUuidReturnsAd(){
       Response getcard=  cardSteps.getCardresorsesForUUid(cardCreate);
       AssertSteps.assrtToIDandUUidRavni(getcard,cardCreate);


    }
    @Test
    @Description("Получение объявления по несуществующему UUID ")
    public void getAdNonExistentUuidThrowsNotFoundException(){
        Response getcard=  cardSteps.getCardresorsesForUUid("76b70d93-5d81-4733-a958-ca0ddbb04506");
        AssertSteps.assrtErrorNotFound(getcard);
    }
}
