package cliente;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class ClienteCalculadoraRS {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Atividade20/webresources";

    public ClienteCalculadoraRS() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("calculadora");
    }

    public String somar(int a, int b) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource
                .queryParam("a", a)
                .queryParam("b", b)
                .request(javax.ws.rs.core.MediaType.TEXT_PLAIN
                ).get(String.class);
    }

    public String subtrair(int a, int b) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource
                .queryParam("a", a)
                .queryParam("b", b)
                .request(javax.ws.rs.core.MediaType.TEXT_PLAIN
                ).get(String.class);
    }

    public String multiplicar(int a, int b) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource
                .queryParam("a", a)
                .queryParam("b", b)
                .request(javax.ws.rs.core.MediaType.TEXT_PLAIN
                ).get(String.class);
    }

    public String dividir(int a, int b) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource
                .queryParam("a", a)
                .queryParam("b", b)
                .request(javax.ws.rs.core.MediaType.TEXT_PLAIN
                ).get(String.class);
    }

    public String getXml() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    public void putXml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void close() {
        client.close();
    }

}
