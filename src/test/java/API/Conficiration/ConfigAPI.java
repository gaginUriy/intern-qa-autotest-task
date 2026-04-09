
import TestTools.UUidTranform;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public  class ConfigAPI {
    //Я неумею правильно хранить URL
    private static final String baseUrl = "https://qa-internship.avito.com";
    private static final String endPointForCreateresources = "/api/1/item";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getendPointForCreateresources() {
        return endPointForCreateresources;
    }

    public static String geteEndPointForDeleteResources(Response response) {
        String Guid= UUidTranform.extractGuidFromResponse(response);
        return "/api/2/item/"+Guid;
    }

    public static String geteEndPointForGetSellerId(Integer id) {
        return "/api/1/"+id+"/item";
    }
    public static String geteCardresorsesForUUid(Response response) {
        String Guid= UUidTranform.extractGuidFromResponse(response);
        return "/api/1/item/"+Guid;
    }

    public static String geteCardresorsesForNotUUid(Response response) {
        String Guid = UUidTranform.extractGuidFromResponse(response);
        return "/api/1/item/" + Guid;
    }
}
