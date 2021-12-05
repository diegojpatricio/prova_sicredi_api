package Simulacoes;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class PutSimulacoesTest {

    @Test
    public void update(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"nome\": \"Beltrano de Tal\",\n" +
                        "  \"cpf\": 97093236052,\n" +
                        "  \"email\": \"Fulano@email.com\",\n" +
                        "  \"valor\": 5000,\n" +
                        "  \"parcelas\": 5,\n" +
                        "  \"seguro\": false\n" +
                        "}")
                .when()
                    .put("http://localhost:8080/api/v1/simulacoes/97093236052")
                .then()
                    .log().all()
                    .statusCode(200);
    }

    @Test
    public void updateCPF(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"nome\": \"Beltrano de Tal\",\n" +
                        "  \"cpf\": 97093236053,\n" +
                        "  \"email\": \"Fulano@email.com\",\n" +
                        "  \"valor\": 5000,\n" +
                        "  \"parcelas\": 5,\n" +
                        "  \"seguro\": false\n" +
                        "}")
                .when()
                .put("http://localhost:8080/api/v1/simulacoes/97093236052")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateCPFInvalid(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"nome\": \"Beltrano de Tal\",\n" +
                        "  \"cpf\": 97093236053,\n" +
                        "  \"email\": \"Fulano@email.com\",\n" +
                        "  \"valor\": 5000,\n" +
                        "  \"parcelas\": 5,\n" +
                        "  \"seguro\": false\n" +
                        "}")
                .when()
                .put("http://localhost:8080/api/v1/simulacoes/1")
                .then()
                .log().all()
                .body("mensagem", containsString("CPF 1 não encontrado"))
                .statusCode(404);
    }

}
