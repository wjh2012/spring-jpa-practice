package practice.updown;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UpDownController {
    // 파일을 저장할 경로 설정
    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
        }

        try {
            // 파일 데이터를 저장할 경로 생성
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            // 파일 데이터 저장
            Files.write(path, file.getBytes());

            // 성공 메시지 추가
            attributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile() {
        try {
            // 파일 경로 설정
            Path filePath = Paths.get("여기에_파일의_절대_또는_상대경로를_입력하세요");
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() || resource.isReadable()) {
                // 파일 이름 추출
                String filename = filePath.getFileName().toString();

                // 파일 다운로드를 위한 HTTP 헤더 설정
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                        .body(resource);
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
