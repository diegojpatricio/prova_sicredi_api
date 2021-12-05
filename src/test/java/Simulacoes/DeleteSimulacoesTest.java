package Simulacoes;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteSimulacoesTest {

    @Test
    public void deleteSimulationSucessFull(){
        given()
                .pathParams("id","13")
                .when()
                .delete("http://localhost:8080/api/v1/simulacoes/{id}")
                .then()
                .log().all()
                .statusCode(200);


    }
}
