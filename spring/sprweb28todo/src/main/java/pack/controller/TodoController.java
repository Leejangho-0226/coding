package pack.controller;

import lombok.AllArgsConstructor;
import pack.model.TodoEntity;
import pack.model.TodoResponse;
import pack.model.TodoService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")  // 외부 도메인 허용 (CORS 해결용)
//  @CrossOrigin(origins = "*")  *은 모든 외부 도메인에서 이 API 호출 가능하다는 뜻
//  예를 들어, http://localhost:3000 (React) 같은 프론트엔드 앱에서
//  http://localhost:8080/todos 같은 백엔드 API를 호출할 수 있게 해줌
//  안 붙이면 브라우저에서 CORS 오류 발생 가능
@RequestMapping("/")
public class TodoController {
	private final TodoService service;
	
	@PostMapping
	public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request){
		System.out.println("create(insert)");
		//return null;
		
		if(ObjectUtils.isEmpty(request.getTitle())) {
			return ResponseEntity.badRequest().build(); // 에러가 있는 경우 에러코드 반환
		}
		
		if(ObjectUtils.isEmpty(request.getOrder()))
			request.setOrder(0); // Oder가 없는 경우 0으로 설정
		
		if(ObjectUtils.isEmpty(request.getCompleted()))
			request.setCompleted(false);; // Completed가 없는 경우 false로 설정
			
		TodoEntity entity = service.add(request); // insert 처리 후 결과 반환	
		System.out.println("insert result : " + ResponseEntity.ok(new TodoResponse(entity)));
		
		return ResponseEntity.ok(new TodoResponse(entity)); // 변수=값 형식(JSON)으로 반환됨
	}
	
	@GetMapping
	public ResponseEntity<List<TodoResponse>> readAll(){
		System.out.println("readAll");
		//return null;
		List<TodoEntity> list = service.searchAll();
		// Entity를 DTO로 변환
		List<TodoResponse> responses = list.stream().map(TodoResponse::new).collect(Collectors.toList());
		// new는 new TodoResponse(todo엔티티)를 의미
		System.out.println("readAll result : " + ResponseEntity.ok(responses));
		return ResponseEntity.ok(responses); // 변수=값 형식(JSON)으로 반환됨
	}
	@GetMapping(value = "{id}")
	public ResponseEntity<TodoResponse> readOne(@PathVariable(name = "id")Integer id){
		System.out.println("readOne");
		//return null;
		TodoEntity entity = service.searchById(id);
		// Entity를 DTO로 변환
		return ResponseEntity.ok(new TodoResponse(entity)); // 생성자를 이용해 Entity를 DTO로 변환 후 반환
	}

	@PatchMapping("{id}")
	public ResponseEntity<TodoEntity> update(
			@PathVariable(name = "id")Integer id, 
			@RequestBody TodoRequest request){
		System.out.println("update");
		
		TodoEntity entity = service.updateById(id, request);
		System.out.println("update one : " + ResponseEntity.ok(entity));
		return ResponseEntity.ok(entity);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteOne(
			@PathVariable(name = "id")Integer id){
		System.out.println("deleteOne");
		// return null;
			
		service.deleteById(id);
		System.out.println("delete one : " + ResponseEntity.ok());
		
		return ResponseEntity.ok().build(); // 200 ok만 반환. 처리 성공만 알림
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteAll(){
		System.out.println("deleteAll");
		// return null;
			
		service.deleteAll();
		System.out.println("deleteAll : " + ResponseEntity.ok());
		
		return ResponseEntity.ok().build(); // 200 ok만 반환. 처리 성공만 알림
	}
	
}
