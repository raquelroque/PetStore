// 1 - Pacote
package petstore;

// 2- Bibliotecas


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

// 3 -Classe
public class Pet {

    //3.1 - Atributos

    String uri = "https://petstore.swagger.io/v2/pet"; //endereco da entidade Pet


    //3.2 - Metodos e Funções

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }


    // Incluir - Create - Post
    @Test  //Identifica o método ou função com um teste para o TestNG
    public void inluirPet() throws IOException {
        String jsonBody =  lerJson("db/pet1.json");

        //sintaxe Gherkin
        //Dado - Quando - Então
        //Given - When -  Then

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
        ;

    }



}
