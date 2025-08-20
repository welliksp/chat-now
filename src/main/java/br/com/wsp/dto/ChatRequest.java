package br.com.wsp.dto;

public record ChatRequest(String userInput, String role, String goal, String context, String constraints, String examples, String format) {
}
