package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pack.dto.ProductDto;
import pack.repository.ProductProcess;

@RestController
@RequestMapping("/products") // API 기본 경로: http://localhost/products
public class ProductController {

    @Autowired
    private ProductProcess productProcess; // DB 작업 담당 클래스 주입

    // ✅ 전체 상품 목록 조회 (GET /products)
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> products = productProcess.getAll();  // 전체 상품 목록 가져오기
        return ResponseEntity.ok(products);                   // 200 OK + 상품 리스트 응답
    //    return ResponseEntity.notFound().build(); // 404
    }

    // ✅ 특정 상품 조회 (GET /products/{code})
    @GetMapping("/{code}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("code") String code) {
        ProductDto product = productProcess.getData(code);        // 상품 코드로 DB에서 상품 찾기
        if (product != null) {
            return ResponseEntity.ok(product);                    // 200 OK + 상품 정보 반환
        } else {
            return ResponseEntity.notFound().build();             // 404 Not Found
        }
    }

    // ✅ 상품 등록 (POST /products)
    @PostMapping
    public ResponseEntity<String> insert(@RequestBody ProductDto dto) {
        if (dto == null || dto.getCode() == null) {
            return ResponseEntity.badRequest().body("invalid data"); // 400 Bad Request
        }

        productProcess.insert(dto);                                // 전달받은 상품 정보 저장
        return ResponseEntity.status(HttpStatus.CREATED).body("insert success"); // 201 Created
    }

 // ✅ 상품 수정 (PUT /products/{code})
    @PutMapping("/{code}")
    public ResponseEntity<String> update(@PathVariable("code") String code, @RequestBody ProductDto dto) {
        // ✅ 1. URL 경로로부터 전달받은 code로 기존 상품 조회
        ProductDto existing = productProcess.getData(code);

        // ✅ 2. 수정 대상이 없으면 404 Not Found 반환
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        // ✅ 3. URL의 code를 body에 주입해 일관성 유지
        dto.setCode(code);

        // ✅ 4. 상품 정보 업데이트 실행
        productProcess.update(dto);

        // ✅ 5. 성공 응답 반환
        return ResponseEntity.ok("update success"); // 200 OK
    }



 // ✅ 상품 삭제 (DELETE /products/{code})
    @DeleteMapping("/{code}")
    public ResponseEntity<String> delete(@PathVariable("code") String code) {
        if (productProcess.getData(code) == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }

        productProcess.delete(code); // 상품 삭제
        return ResponseEntity.ok("delete success");  // 200 OK
    }
}
