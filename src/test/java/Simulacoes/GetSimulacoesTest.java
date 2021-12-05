package Simulacoes;

import org.junit.Test;
import static io.restassured.RestAssured.given;


public class GetSimulacoesTest {

    private String cpf = "66414919004";
    private String cpfNoSimulation = "1043266019";

    @Test
    public void getSimulationAll(){
        given()
                .when()
                .get("http://localhost:8080/api/v1/simulacoes")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getSimulationCPF(){
        given()
                .when()
                .get("http://localhost:8080/api/v1/simulacoes/"+ cpf)
                .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void getCPFNoSimulation(){
        given()
            .when()
                .get("http://localhost:8080/api/v1/simulacoes/"+ cpfNoSimulation)
                .then()
                .log().all()
                .statusCode(404);
    }
}
