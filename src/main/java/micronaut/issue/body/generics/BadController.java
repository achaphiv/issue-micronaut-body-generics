package micronaut.issue.body.generics;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/bad")
public final class BadController {
  @Post
  public Token create(@Body WrappedData<Token> value) {
    return value.getData();
  }
}
