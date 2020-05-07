package micronaut.issue.body.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JacksonTest {
  @Test
  public void canDeserializeWrappedData() throws Exception {
    WrappedData<Token> actual = new ObjectMapper().readValue(
      "{ \"data\": \"123\" }",
      new TypeReference<WrappedData<Token>>() {}
    );

    assertEquals("123", actual.getData().getValue());
  }
}
