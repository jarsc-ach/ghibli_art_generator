package com.example.ghilibi.service;

import com.example.ghilibi.client.StabilityAiClient;
import com.example.ghilibi.dto.TexttoImage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ghilibiartservice {
    private final StabilityAiClient stabilityAiClient;
    private final String apiKey;
    public ghilibiartservice(StabilityAiClient stabilityAiClient, @Value("${stability.api.key}") String apiKey) {
        this.stabilityAiClient = stabilityAiClient;
        this.apiKey = apiKey;
    }

    public byte[] createghibliart(MultipartFile file,String prompt) {
        String finalprompt = prompt+", in the style of Studio Ghibli";
        String engineId = "stable-diffusion-v1-6";
        String stylePreset = "anime";
        return stabilityAiClient.generateImageFromImage(
                "Bearer "+apiKey,
                engineId,
                file,
                finalprompt,
                stylePreset
        );

    }
    public byte[] createghibliart(String prompt,String style) {
        String finalprompt = prompt + ", in the style of Studio Ghibli";
        String engineId = "stable-diffusion-v1-6";
        String stylePreset = style.equals("genral") ? "anime" : style.replace("_", "_");
        TexttoImage requestpayload = new TexttoImage(finalprompt, stylePreset);
        return stabilityAiClient.generateImageFromText(
                "Bearer " + apiKey,
                engineId,
                requestpayload
        );
    }
}
