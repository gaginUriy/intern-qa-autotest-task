

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Feature("Удаление карточки")
public class DeleteCard {

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
    @Disabled("В тесте баги/уточнения")
    @Description("Успешное удаление существующего объявления")
    public void deleteAdExistingAdReturnsSuccess(){

       Response response = cardSteps.DeleteCard(cardCreate);






    }

    @Test
    @Disabled("В тесте баги/уточнения")
    @Description("Удаление несуществующего объявления")
    public void deleteAdNonExistentAdThrowsNotFoundException(){

    }
}
