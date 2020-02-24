package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.swislowski.kamil.project.platerecognition.spring.service.platerecognizer.model.PlateRecognizerResponse;

import java.util.logging.Logger;

@Service
public class PlateRecognizerService {
    private static final Logger LOGGER = Logger.getLogger(PlateRecognizerService.class.getName());

    public PlateRecognizerResponse recognize(Resource resource) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("Authorization", "Token 651ccdbfbbf70b832e8a8086471997b7efa0c2b8");

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("upload", resource);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String serverUrl = "https://api.platerecognizer.com/v1/plate-reader/";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PlateRecognizerResponse> response = restTemplate.postForEntity(serverUrl, requestEntity, PlateRecognizerResponse.class);

        return response.getBody();
    }
}
