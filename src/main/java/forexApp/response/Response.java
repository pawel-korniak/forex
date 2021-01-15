package forexApp.response;

import forexApp.messages.Message;

public interface Response {
    String getResponse(Message message);
}
