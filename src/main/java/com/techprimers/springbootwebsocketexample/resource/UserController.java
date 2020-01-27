package com.techprimers.springbootwebsocketexample.resource;

import com.techprimers.springbootwebsocketexample.model.User;
import com.techprimers.springbootwebsocketexample.model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    @MessageMapping("/user") // to send message to this address: /app/user
    // ApplicationDestinationPrefixes: /app
    @SendTo("/topic/user") // to subscribe
    public UserResponse getUser(User user) {

        return new UserResponse("Hi " + user.getName());
    }
}
