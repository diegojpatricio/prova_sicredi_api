package Simulacoes;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostSimulacoesTest {

    @Test
    public void registrationSimulationSucessFullSafeTrue(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"nome\": \"Fulano de Tal\",\n" +
                        "  \"cpf\": 97093236015,\n" +
                        "  \"email\": \"email@email.com\",\n" +
                        "  \"valor\": 1200,\n" +
                        "  \"parcelas\": 3,\n" +
                        "  \"seguro\": true\n" +
                        "}")
                .when()
                    .post("http://localhost:8080/api/v1/simulacoes")
                .then()
                   .log().all()
                    .statusCode(201);
    }
    @Test
    public void registrationSimulationDuplicate(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"nome\": \"Fulano de Tal\",\n" +
                        "  \"cpf\": 97093236015,\n" +
                        "  \"email\": \"email@email.com\",\n" +
                        "  \"valor\": 1200,\n" +
                        "  \"parcelas\": 3,\n" +
                        "  \"seguro\": true\n" +
                        "}")
                .when()
                .post("http://localhost:8080/api/v1/simulacoes")
                .then()
                .log().all()
                .body("mensagem", containsString("CPF duplicado"))
                .statusCode(409);
    }
    @Test
    public void registrationSimulationSucessFullSafeFalse(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"nome\": \"Fulano de Tal\",\n" +
                        "  \"cpf\": 96093266019,\n" +
                        "  \"email\": \"email@email.com\",\n" +
                        "  \"valor\": 1200,\n" +
                        "  \"parcelas\": 3,\n" +
                        "  \"seguro\": false\n" +
                        "}")
                .when()
                .post("http://localhost:8080/api/v1/simulacoes")
                .then()
                .log().all()
                .statusCode(201);
    }
    @Test
    public void registrationSimulationNameEmpty(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"cpf\": 97093236015,\n" +
                        "  \"email\": \"email@email.com\",\n" +
                        "  \"valor\": 1200,\n" +
                        "  \"parcelas\": 3,\n" +
                        "  \"seguro\": true\n" +
                        "}")
                .when()
                    .post("http://localhost:8080/api/v1/simulacoes")
                .then()
                    .log().all()
                    .body("erros.nome", containsString("Nome não pode ser vazio"))
                    .statusCode(400);
    }
    @Test
    public void registrationSimulationCPFEmpty(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"nome\": \"Fulano de Tal\",\n" +
                        "  \"email\": \"email@email.com\",\n" +
                        "  \"valor\": 1200,\n" +
                        "  \"parcelas\": 3,\n" +
                        "  \"seguro\": true\n" +
                        "}")
                .when()
                .post("http://localhost:8080/api/v1/simulacoes")
                .then()
                .log().all()
                .body("erros.cpf", containsString("CPF não pode ser vazio"))
                .statusCode(400);
    }
    @Test
    public void registrationSimulationEmailEmpty(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"nome\": \"Fulano de Tal\",\n" +
                        "  \"cpf\": 97093236015,\n" +
                        "  \"valor\": 1200,\n" +
                        "  \"parcelas\": 3,\n" +
                        "  \"seguro\": true\n" +
                        "}")
                .when()
                .post("http://localhost:8080/api/v1/simulacoes")
                .then()
                .log().all()
                .body("erros.email", containsString("E-mail não deve ser vazio"))
                .statusCode(400);
    }
    @Test
    public void registrationSimulationValueEmpty(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"nome\": \"Fulano de Tal\",\n" +
                        "  \"cpf\": 97093236015,\n" +
                        "  \"email\": \"email@email.com\",\n" +
                        "  \"parcelas\": 3,\n" +
                        "  \"seguro\": true\n" +
                        "}")
                .when()
                .post("http://localhost:8080/api/v1/simulacoes")
                .then()
                .log().all()
                .body("erros.valor", containsString("Valor não pode ser vazio"))
                .statusCode(400);
    }
    @Test
    public void registrationSimulationInstallmentsEmpty(){
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"nome\": \"Fulano de Tal\",\n" +
                        "  \"cpf\": 97093236015,\n" +
                        "  \"email\": \"email@email.com\",\n" +
                        "  \"valor\": 1200,\n" +
                        "  \"seguro\": true\n" +
                        "}")
                .when()
                .post("http://localhost:8080/api/v1/simulacoes")
                .then()
                .log().all()
                .body("erros.parcelas", containsString("Parcelas não pode ser vazio"))
                .statusCode(400);
    }
}
