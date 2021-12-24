package com.mirea.demo.controller;

import com.mirea.demo.model.dto.CreatedRequestDTO;
import com.mirea.demo.model.dto.DemoResponse;
import com.mirea.demo.model.dto.NewRequestDTO;
import com.mirea.demo.model.dto.RequestDTO;
import com.mirea.demo.service.RequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/demo")
@Api(tags = "Методы контроллера")
@AllArgsConstructor
public class RequestController {
    private RequestService requestService;

    @PostMapping()
    @ApiOperation(value = "Запись запроса в базу данных", notes = "Запись запроса в бд и получение нового объекта")
    public DemoResponse<CreatedRequestDTO> createRequest(@RequestBody NewRequestDTO newRequestDTO) {
        return DemoResponse.ok(requestService.createRequest(newRequestDTO));
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Получение данных запроса", notes = "Получение данных запроса по идентификатору")
    public DemoResponse<RequestDTO> getRequest(@ApiParam("Идентификатор запроса") @PathVariable Long id) {
        return DemoResponse.ok(requestService.getRequest(id));
    }

    @DeleteMapping("{name}")
    @ApiOperation(value = "Запрос на удаление",
            notes = "Получение данных запроса на удаление")
    public DemoResponse<String> deleteRequest(@ApiParam("Идентификатор для удаления") @PathVariable String name) {
        return DemoResponse.ok(String.format("%s was deleted", name));
    }

    @PutMapping("{name}")
    @ApiOperation(value = "Запрос на обновление",
            notes = "Получение данных запроса на обновление")
    public DemoResponse<String> putRequest(@ApiParam("Идентификатор для обновления") @PathVariable String name) {
        return DemoResponse.ok(String.format("%s was updated", name));
    }
}
