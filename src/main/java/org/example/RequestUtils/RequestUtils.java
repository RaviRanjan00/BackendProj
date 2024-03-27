package org.example.RequestUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
@Slf4j
public class RequestUtils {
    RequestSpecification spec;
    Response res;

    public  RequestUtils() {
        spec = RestAssured.given();
    }

    public Response getResponse() {
        return res;
    }

    public Response get(String url, String api) {
        // TODO Auto-generated method stub
        spec.baseUri(url);
        res = spec.get(api);
        Serenity.setSessionVariable("getResponse").to(res);
//		 Serenity.sessionVariableCalled("apiResponse");
        return res;
    }

    public Response post(String url, Object body) {
        spec.baseUri(url);
        spec.contentType(ContentType.JSON);
        spec.body(body);
        res = spec.post();
        Serenity.setSessionVariable("postResponse").to(res);
        return res;
    }

    public String getJsonStringByObject(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return requestBody;
    }
}
