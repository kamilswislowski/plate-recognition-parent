package pl.swislowski.kamil.project.platerecognition.spring.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.swislowski.kamil.project.platerecognition.spring.service.PlateRecognizerService;
import pl.swislowski.kamil.project.platerecognition.spring.service.RecognitionRegistrationPlateService;
import pl.swislowski.kamil.project.platerecognition.spring.service.RegistrationPlateService;
import pl.swislowski.kamil.project.platerecognition.spring.service.mapper.RegistrationPlateMapper;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecognitionRegistrationPlateController.class)
//@MockBeans({
//        @MockBean(PlateRecognizerService.class),
//        @MockBean(RegistrationPlateMapper.class)
//})
class RecognitionRegistrationPlateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecognitionRegistrationPlateService recognitionRegistrationPlateService;
    @MockBean
    private RegistrationPlateService registrationPlateService;
    @MockBean
    private PlateRecognizerService plateRecognizerService;
    @MockBean
    private RegistrationPlateMapper registrationPlateMapper;

    @Test
    void recognize() throws Exception {
        //given:
        MockMultipartFile firstFile = new MockMultipartFile("upload", "filename.txt", "multipart/form-data", "some xml".getBytes());
        //when:
        when(recognitionRegistrationPlateService.recognize(new RegistrationPlateModel("wi 313131"), null))
                .thenReturn(Optional.of(new RegistrationPlateModel("wa 333311")));
        //then:
        MvcResult mvcResult = mockMvc.perform(multipart("/plate-recognition/recognize").file(firstFile))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        System.out.println("#######" + contentAsString);
        System.out.println(response.getContentType());
    }

    @Test
    void recognizeWithResponse() throws Exception {
        //given:
        MockMultipartFile firstFile = new MockMultipartFile("upload", "filename.txt", "text/plain", "some xml".getBytes());
        //when:
        when(recognitionRegistrationPlateService.recognize(new RegistrationPlateModel("wi 313131"), null))
                .thenReturn(Optional.of(new RegistrationPlateModel("wa 333311")));
        when(registrationPlateService.recognize(new RegistrationPlateModel("wa 333311"), null))
                .thenReturn(Optional.of(new RegistrationPlateModel("wa 333311")));
        //then:
        MvcResult mvcResult = mockMvc.perform(multipart("/plate-recognition/recognize").file(firstFile))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        System.out.println("########" + contentAsString);
    }
}