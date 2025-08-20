package br.com.wsp.service;


import br.com.wsp.dto.ChatRequest;
import br.com.wsp.dto.ImageGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private ChatClient chatClient;

    public AIService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public String chat(ChatRequest request) {

        return chatClient.prompt().user(u -> u.text(request.userInput())).call().content();
    }

    public String promptTemplate(ChatRequest message) {

        PromptTemplate promptTemplate = new PromptTemplate(message.context());
        promptTemplate.add("userInput", message.userInput());
        promptTemplate.add("role", message.role());
        promptTemplate.add("goal", message.goal());
        promptTemplate.add("constraints", message.constraints());
        promptTemplate.add("examples", message.examples());
        promptTemplate.add("format", message.format());

        return chatClient.prompt(promptTemplate.render()).call().content();

    }

    public ChatResponse prompt(ChatRequest message) {

        Prompt promptTemplate = new Prompt(message.userInput());
        return chatClient.prompt(promptTemplate).call().chatResponse();
    }


    public br.com.wsp.dto.AudioTranscription transcribeAudio(byte[] audio, String fileName) {
        return null;
    }


    public ImageGeneration generateImage(String prompt, String size, int n) {
        return null;
    }
}
