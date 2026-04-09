
import TestTools.UUidTranform;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertSteps {

    @Step("Отправить POST-запрос для создания карточки товара")
    public static void UUIdAssertForValidation(Response response){
        String responses = response.jsonPath().getString("status");
        assertThat(response.getStatusCode()).
                as("Статус код не совпадает").
                isEqualTo(200);

        assertThat(responses)
                .isNotNull()
                .isNotEmpty()
                .containsPattern("Сохранили объявление - [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");
    }

    @Step("Сравнить полученные ID")
    public static void equalsDifferentObjectsReturnsFalse(Response createUser1, Response createUser2) {
        String responses1 = createUser1.jsonPath().getString("status");
        String responses2 = createUser2.jsonPath().getString("status");
        assertThat(responses1).isNotEqualTo(responses2);
    }
    @Step("Проверка ошибки пустого поля")
    public static void createWithFieldEmpty(Response createUser, String name) {
        String message = "поле " + name + " обязательно";

        assertThat(createUser.getStatusCode()).
                as("Статус код не совпадает").
                isEqualTo(400);
        assertThat(createUser.jsonPath().getString("result.message"))
                .isEqualTo(message);
    }

    public static void aseertToArreyForGetSellerId(Response response, int sellerId) {
        JsonPath jsonPath = response.jsonPath();
        List<Integer> actualSellerIds = jsonPath.getList("sellerId", Integer.class);

        Assertions.assertFalse(actualSellerIds.isEmpty(), "Список товаров пуст");

        // Теперь здесь int == int, все работает верно
        boolean allMatch = actualSellerIds.stream()
                .allMatch(id -> id == sellerId);

        Assertions.assertTrue(allMatch,
                String.format("Не у всех товаров sellerId=%d. Найдены: %s", sellerId, actualSellerIds));
    }

    public static void assertToEmptyList(Response response) {
        List<Integer> actualSellerIds = response.jsonPath().getList("sellerId", Integer.class);
        assertThat(actualSellerIds)
                .as("Список товаров не должен быть пустым") // Сообщение для отчета
                .isEmpty();


    }

    public static void assrtToIDandUUidRavni(Response getcard, Response cardCreate) {
       String cardCreateGuid = UUidTranform.extractGuidFromResponse(cardCreate);
        String getcardGuid = UUidTranform.extractGuidFromResponse(getcard);
        assertThat(cardCreateGuid).isEqualTo(getcardGuid);
    }

    public static void assrtErrorNotFound(Response getcard) {

        String error = "item " +UUidTranform.extractGuidFromResponse(getcard) +" not found";
        assertThat(getcard.getStatusCode())
                .as("неверный код ответа")
                .isEqualTo(404);
        assertThat(getcard.jsonPath().getString("result.message"))
                .isEqualTo(error);
    }
}

