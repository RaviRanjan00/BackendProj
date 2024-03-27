package com.test.steps;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import org.assertj.core.api.Assertions;
import org.example.Pojos.pojo;
import org.example.Pojos.res;
import org.example.RequestUtils.RequestUtils;

@Slf4j
public class javaSteps {
    RequestUtils req = new RequestUtils();

    public void sendPost(String url, String userName) {
        pojo pj = pojo.builder()
                .userName(userName)
                .build();
        String body = req.getJsonStringByObject(pj);
        Response res = req.post(url, body);
        res.then().log().all();
        res.prettyPrint();
        Serenity.setSessionVariable("response").to(res);
    }

    public void responseValidation(String username) {
        res r = req.getResponse().then().extract().as(res.class);
        Assertions.assertThat(username).isEqualTo(r.getType());

    }
}
