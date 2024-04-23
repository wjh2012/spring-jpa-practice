package practice.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ReqBody")
public class PostReqBodyController {

    @PostMapping("/req")
    public void handleFileUpload(
            @RequestBody ReqBodyDTO reqBodyDTO) {
        System.out.println("reqBodyDTO = " + reqBodyDTO.id);
        System.out.println("reqBodyDTO = " + reqBodyDTO.name);
    }

    @Data
    public static class ReqBodyDTO {
        private String name;
        private List<Long> id;
    }

}
