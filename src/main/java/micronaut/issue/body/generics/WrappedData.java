package micronaut.issue.body.generics;

import java.beans.ConstructorProperties;

public final class WrappedData<T> {
  private final String id;
  private final T data;

  @ConstructorProperties({ "id", "data" })
  public WrappedData(String id, T data) {
    this.id = id;
    this.data = data;
  }

  public String getId() {
    return id;
  }

  public T getData() {
    return data;
  }
}
