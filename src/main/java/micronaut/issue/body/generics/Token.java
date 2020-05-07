package micronaut.issue.body.generics;

import com.fasterxml.jackson.annotation.JsonValue;

public final class Token {
  private final String value;

  public Token(String value) {
    if (value.length() < 3) {
      throw new IllegalArgumentException("Some invalid condition: " + value);
    }
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }
}
