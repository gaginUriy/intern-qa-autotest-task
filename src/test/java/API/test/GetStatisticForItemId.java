

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
@Disabled("неуспеваю сделать")
@Feature("получение статистики карточки товара")
public class GetStatisticForItemId {


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
    @Disabled("неуспеваю сделать")
    @Description("Получение статистики по существующему item ID")
    public void  getItemStatsExistingItemIdReturnsStats() {

    }
    @Test
    @Disabled("неуспеваю сделать")
    @Description("Получение статистики по несуществующему ID")
    public void getItemStatsNonExistentItemIdThrowsNotFoundException() {

    }

}
