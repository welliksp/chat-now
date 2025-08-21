package br.com.wsp.controller;

import br.com.wsp.dto.ChatRequest;
import br.com.wsp.service.AIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class AiController {

    private final AIService service;

    public AiController(AIService service) {
        this.service = service;
    }


    @PostMapping("/chatClient")
    public ResponseEntity<String> chat(@RequestParam ChatRequest request) {

        return ResponseEntity.ok(service.chat(request));
    }

    @PostMapping("/promptTemplate")
    public ResponseEntity<String> promptTemplate(@RequestBody ChatRequest request) {

        return ResponseEntity.ok(service.promptTemplate(request));
    }

    @PostMapping("/prompt")
    public ResponseEntity<?> prompt(@RequestBody ChatRequest request) {

        return ResponseEntity.ok(service.prompt(request));
    }

    @PostMapping("/image")
    public ResponseEntity<?> generateImage(@RequestBody ChatRequest request) {

        return ResponseEntity.ok(service.generateImage(request.userInput()));
    }
}
