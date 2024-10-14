package ee.carlrobert.llm.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import okhttp3.Response;

public class DeserializationUtil {

  private DeserializationUtil() {
  }

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
      .setSerializationInclusion(JsonInclude.Include.NON_NULL);

  public static <T> T mapResponse(Response response, Class<T> clazz) {
    final var body = response.body();
    try {
      return OBJECT_MAPPER.readValue(body.string(), clazz);
    } catch (IOException ex) {
      throw new RuntimeException("Could not deserialize response", ex);
    }
  }

  public static <T> String serializeToJson(T request) throws JsonProcessingException {
    try {
      final String result = OBJECT_MAPPER.writeValueAsString(request);
      // Just to see what is it sent to AI Provider
      // TODO manage a local log file to store the sending request body to be analyse (could be an option in CodeGpt settings
      // It should be done just before the http request is sent to be sure all sending case are taken into account
      System.out.println(result);
      if (true == true) {
        throw new RuntimeException("Force stop sending to control the request body");
      }
      return result;
    } catch (IOException ex) {
      throw new RuntimeException("Could not serialize request", ex);
    }
  }
}
