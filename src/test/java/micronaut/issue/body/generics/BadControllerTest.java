package micronaut.issue.body.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
public final class BadControllerTest {
  @Inject
  @Client("/")
  RxHttpClient client;

  @Test
  public void deserializeGeneric() {
    HttpRequest<WrappedData<Token>> request = HttpRequest.POST(
      "/bad",
      new WrappedData<>("id", new Token("value"))
    );
    String body = client.toBlocking().retrieve(request);

    assertEquals("value", body);
  }
}
