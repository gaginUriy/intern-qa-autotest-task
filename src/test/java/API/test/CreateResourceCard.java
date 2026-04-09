

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


@Feature("создание карточки товара")

public  class CreateResourceCard {
    StepsCRUDResorceCard createCard = new StepsCRUDResorceCard();


    @Test
    @Description("Создание объявления с валидными данными")
    public void createAdValidDataReturnsCreatedAd() {

        TestDataGen.GenerateDate date = new TestDataGen.GenerateDate();
        SudClassStatictis statistics = new SudClassStatictis(date.likesRandom(),date.viewCountRandom(),date.contactsRandom());
        CreateCardResorceDTO cardResorceDTO = new CreateCardResorceDTO(
                date.priceRandom(),date.nameRandom(),date.sellerIdRandom(),statistics);



       Response createUser = createCard.PostCardCreated(cardResorceDTO);
        AssertSteps.UUIdAssertForValidation(createUser);
    }

    @Test
    @Description("Возврат уникального ID при создании объявления")
    public void createAdValidDataAssignsUniqueId(){

        TestDataGen.GenerateDate date = new TestDataGen.GenerateDate();
        SudClassStatictis statistics = new SudClassStatictis(date.likesRandom(),date.viewCountRandom(),date.contactsRandom());
        CreateCardResorceDTO cardResorceDTO = new CreateCardResorceDTO(
                date.priceRandom(),date.nameRandom(),date.sellerIdRandom(),statistics);



        Response createUser1 = createCard.PostCardCreated(cardResorceDTO);
        Response createUser2 = createCard.PostCardCreated(cardResorceDTO);

        AssertSteps.equalsDifferentObjectsReturnsFalse(createUser1,createUser2);

    }

    @Test
    @Description("Создание объявления с пустым полем name")
    public void createAdEmptyNameThrowsValidationException(){

        TestDataGen.GenerateDate date = new TestDataGen.GenerateDate();
        SudClassStatictis statistics = new SudClassStatictis(date.likesRandom(),date.viewCountRandom(),date.contactsRandom());
        CreateCardResorceDTO cardResorceDTO = new CreateCardResorceDTO(
                date.priceRandom(),null,date.sellerIdRandom(),statistics);

        Response createUser = createCard.PostCardCreated(cardResorceDTO);
        AssertSteps.createWithFieldEmpty(createUser,"name");

    }

}
