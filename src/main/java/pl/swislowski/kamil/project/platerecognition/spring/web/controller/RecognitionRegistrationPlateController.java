package pl.swislowski.kamil.project.platerecognition.spring.web.controller;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.PlateRecognizerException;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.service.RecognitionRegistrationPlateService;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/plate-recognition")
public class RecognitionRegistrationPlateController {
    private static final Logger LOGGER = Logger.getLogger(RecognitionRegistrationPlateController.class.getName());

    private RecognitionRegistrationPlateService recognitionRegistrationPlateService;

    public RecognitionRegistrationPlateController(RecognitionRegistrationPlateService recognitionRegistrationPlateService) {
        this.recognitionRegistrationPlateService = recognitionRegistrationPlateService;
    }

    @PostMapping(value = "/recognize")
    public Optional<RegistrationPlateModel> recognize(@RequestParam("upload") MultipartFile upload)
            throws RegistrationPlateException, PlateRecognizerException {

        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel();
        registrationPlateModel.setFileName(upload.getOriginalFilename());

        Resource resource = upload.getResource();
        return recognitionRegistrationPlateService.recognize(registrationPlateModel, resource);
    }

//    RecognitionRegistrationPlateRequest recognitionRegistrationPlateRequest =
//            RecognitionRegistrationPlateRequest.builder()
//                    .fileName(upload.getOriginalFilename())
//                    .fileSize(upload.getSize())
//                    .inputStream(upload.getInputStream())
//                    .build();
//        try {
////            registrationPlateModel.setContent(upload.getBytes());
////            registrationPlateModel.setContent(upload.getInputStream());
//        InputStream inputStream = upload.getInputStream();
//    } catch (IOException e) {
//        throw new RegistrationPlateNoContentException("No content, file in request.", e);
//    }
}
