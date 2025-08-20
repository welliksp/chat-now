package br.com.wsp.controller;

import br.com.wsp.dto.ChatMessage;
import br.com.wsp.dto.ChatResponse;
import br.com.wsp.service.AzureOpenAIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class AiController {

    private final AzureOpenAIService service;

    public AiController(AzureOpenAIService service) {
        this.service = service;
    }


    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatMessage request) {

        ChatResponse chat = service.chat(request);

        return ResponseEntity.ok(chat);
    }
}
