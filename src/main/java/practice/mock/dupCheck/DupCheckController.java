package practice.mock.dupCheck;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dupCheck")
public class DupCheckController {

    @GetMapping("/{name}")
    public ResponseEntity<Object> dupCheckMock(@PathVariable String name){
        if(name.equals("test")){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
