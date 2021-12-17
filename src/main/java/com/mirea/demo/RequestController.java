package com.mirea.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/demo")
@Api(tags = "Методы контроллера")
@AllArgsConstructor
public class RequestController {
    @PostMapping()
    @ApiOperation(value = "Получение post-запроса", notes = "Получение post-запроса")
    public ResponseEntity<String> createRequest(@RequestBody String requestString) {
        return ResponseEntity.ok(String.format("Hello %s", requestString));
    }

    @GetMapping("{name}")
    @ApiOperation(value = "Получение get-запроса", notes = "Получение данных get-запроса")
    public ResponseEntity<String> getRequest(@ApiParam("Идентификатор запроса") @PathVariable String name) {
        return ResponseEntity.ok(String.format("Hello %s", name));
    }

    @DeleteMapping("{name}")
    @ApiOperation(value = "Запрос на удаление",
            notes = "Получение данных запроса на удаление")
    public ResponseEntity<String> deleteRequest(@ApiParam("Идентификатор для удаления") @PathVariable String name) {
        return ResponseEntity.ok(String.format("%s was deleted", name));
    }

    @PutMapping("{name}")
    @ApiOperation(value = "Запрос на обновление",
            notes = "Получение данных запроса на обновление")
    public ResponseEntity<String> putRequest(@ApiParam("Идентификатор для обновления") @PathVariable String name) {
        return ResponseEntity.ok(String.format("%s was updated", name));
    }
}
