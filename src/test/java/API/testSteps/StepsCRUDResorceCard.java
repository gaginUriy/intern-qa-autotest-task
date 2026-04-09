import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class StepsCRUDResorceCard {


    @Step("Отправить POST-запрос для создания карточки товара")
    public Response PostCardCreated(CreateCardResorceDTO cardResorceDTO) {
     Response response =   given()
                 .contentType(ContentType.JSON)
                .baseUri(ConfigAPI.getBaseUrl())
                .body(cardResorceDTO)
        .when()
                .post(ConfigAPI.getendPointForCreateresources());
        return response;
    }

    @Step("Удалить карточку товара")
    public Response DeleteCard(Response response){

        Response delete =   given()
                .baseUri(ConfigAPI.getBaseUrl())
                .log().all()
                .when()
                .delete(ConfigAPI.getendPointForCreateresources());
        return delete;


    }
    @Step("получить карточку товара по SellerId")
    public Response getCardForSellerId(int seller) {
        Response getSellerId =   given()
                .baseUri(ConfigAPI.getBaseUrl())
                .log().all()
                .when()
                .get(ConfigAPI.geteEndPointForGetSellerId(seller))
        .then()
                .extract().response();
        return getSellerId;
    }
    @Step("получить карточку товара по UUid")
    public Response getCardresorsesForUUid(Response response) {
        Response responsed =   given()
                .baseUri(ConfigAPI.getBaseUrl())
                .log().all()
                .when()
                .get(ConfigAPI.geteCardresorsesForUUid(response))
                .then()
                .extract().response();
        return responsed;
    }
    @Step("получить карточку товара по UUid")
    public Response getCardresorsesForUUid(String response) {
        Response responsed =   given()
                .baseUri(ConfigAPI.getBaseUrl())
                .log().all()
                .when()
                .get("/api/1/item/"+response)
                .then()
                .extract().response();
        return responsed;
    }
}
