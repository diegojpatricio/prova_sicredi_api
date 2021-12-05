package Restricoes;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;

public class GetRestricoes {

    @Test
    public void restricoes() {
        given()
                .when()
                .get("http://localhost:8080/api/v1/restricoes/60094146012")
                .then()
                .log().all()
                .body("mensagem", containsString("O CPF 60094146012 tem problema"))
                .statusCode(200);
    }

    @Test
    public void restricoes2() {
        given()
                .when()
                .get("http://localhost:8080/api/v1/restricoes/1")
                .then()
                .log().all()
               //.body("mensagem", containsString("Não possui restrição"))
                .statusCode(204);
    }
}


