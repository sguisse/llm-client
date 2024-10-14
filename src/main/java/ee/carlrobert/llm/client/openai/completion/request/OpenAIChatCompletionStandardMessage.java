package ee.carlrobert.llm.client.openai.completion.request;

public class OpenAIChatCompletionStandardMessage implements OpenAIChatCompletionMessage {

  private String role;
  private String content;

  public OpenAIChatCompletionStandardMessage(String role, String content) {
    this.role = role;
    this.content = content;
  }

  public String getRole() {
    return role;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content  = content;
  }

  public void setRole(String role) {
    this.role = role;
  }

}
