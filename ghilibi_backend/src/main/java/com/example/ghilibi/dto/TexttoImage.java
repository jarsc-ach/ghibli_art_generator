package com.example.ghilibi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TexttoImage {

    @JsonProperty("text_prompts") // ✅ tells Jackson to name this correctly in JSON
    private List<TextPrompt> textPrompts;

    @JsonProperty("cfg_scale")
    private double cfgScale = 7;

    private int height = 512;
    private int width = 768;
    private int samples = 1;
    private int steps = 30;

    @JsonProperty("style_preset")
    private String stylePreset;

    // ✅ Inner class to match API structure
    public static class TextPrompt {
        private String text;

        public TextPrompt(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    // ✅ Constructor that builds the request body
    public TexttoImage(String prompt, String style) {
        this.textPrompts = List.of(new TextPrompt(prompt));
        this.stylePreset = style;
    }

    // ✅ Getters for the API request
    public List<TextPrompt> getTextPrompts() {
        return textPrompts;
    }

    public double getCfgScale() {
        return cfgScale;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getSamples() {
        return samples;
    }

    public int getSteps() {
        return steps;
    }

    public String getStylePreset() {
        return stylePreset;
    }
}
