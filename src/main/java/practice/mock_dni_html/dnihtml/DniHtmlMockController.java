package practice.mock_dni_html.dnihtml;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/dnihtml")
public class DniHtmlMockController {

    //    private static final String FILE_PATH = "/Users/WONJANGHO/Desktop/test/";
    private static final String FILE_PATH = "/Users/wjh20/Desktop/test/";

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(
        @RequestPart("html") MultipartFile html,
        @RequestPart("json") MultipartFile json,
        @RequestPart("formRequest") FormRequest formRequest) {
        try {
            uploadFile(html, formRequest.getFormCd(), "html");
            uploadFile(json, formRequest.getFormCd(), "json");
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    private void uploadFile(MultipartFile file, String formCd, String type) throws IOException {
        String fileName = formCd + "." + type;
        try {
            Path path = Paths.get(FILE_PATH + fileName);
            file.transferTo(path);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @Data
    public static class FormRequest {

        private String formCd;
        private String formNm;
        private String eFormVerNo;
    }

    @GetMapping("/viewer/download/html/{filename}")
    public ResponseEntity<Resource> downloadHtmlFile(@PathVariable String filename) {
        try {
            Path filePath = Paths.get(FILE_PATH + filename + ".html");
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" + resource.getFilename() + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/viewer/download/json/{filename}")
    public ResponseEntity<Resource> downloadJsonFile(@PathVariable String filename) {
        try {
            Path filePath = Paths.get(FILE_PATH + filename + ".json");
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" + resource.getFilename() + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
