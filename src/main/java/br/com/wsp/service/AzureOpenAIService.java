package br.com.wsp.service;


import br.com.wsp.dto.ChatMessage;
import br.com.wsp.dto.ChatResponse;
import br.com.wsp.dto.ImageGeneration;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class AzureOpenAIService {

    private ChatClient chatClient;

    public AzureOpenAIService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }


    public br.com.wsp.dto.ChatResponse chat(ChatMessage message) {

        String response = chatClient.prompt().user(u -> u.text(message.content())).call().content();

        return new ChatResponse(response);

    }


    public br.com.wsp.dto.AudioTranscription transcribeAudio(byte[] audio, String fileName) {
        return null;
    }


    public ImageGeneration generateImage(String prompt, String size, int n) {
        return null;
    }
}
