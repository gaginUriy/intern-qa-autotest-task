

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Feature("Полчение карточки по идентификатору продавца")
public class GetAllResourceCardForSellerId {

    private int seller;
    private Response cardCreate1;
    private Response cardCreate2;
    StepsCRUDResorceCard cardSteps = new StepsCRUDResorceCard();
    @BeforeEach
    void setUp(){
        TestDataGen.GenerateDate date = new TestDataGen.GenerateDate();
        int sellerId = date.sellerIdRandom();
        SudClassStatictis statistics = new SudClassStatictis(date.likesRandom(),date.viewCountRandom(),date.contactsRandom());
        CreateCardResorceDTO cardResorceDTO = new CreateCardResorceDTO(
                date.priceRandom(),date.nameRandom(),sellerId,statistics);

        cardCreate1 = cardSteps.PostCardCreated(cardResorceDTO);
        cardCreate2 = cardSteps.PostCardCreated(cardResorceDTO);
        seller = sellerId;
    }

    @Test
    @Description("Получение всех объявлений по валидному sellerID")
    public void getAdsBySellerIdValidSellerIdReturnsAdsList(){
        Response getCard = cardSteps.getCardForSellerId(seller);
        AssertSteps.aseertToArreyForGetSellerId(getCard, seller);


    }
    @Test
    @Description("Получение списка для sellerID без объявлений")
    public void getAdsBySellerIdSellerHasNoAdsReturnsEmptyList(){
        Response getCard = cardSteps.getCardForSellerId(95554755);
        AssertSteps.assertToEmptyList(getCard);
    }



}
