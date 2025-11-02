package org.unitbean.comfortablesofttestapplication.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.unitbean.comfortablesofttestapplication.anotation.WebController;
import org.unitbean.comfortablesofttestapplication.service.XlsxService;
import org.unitbean.comfortablesofttestapplication.util.BaseRouts;


@WebController(BaseRouts.API_XLSX_V1)
@RequiredArgsConstructor
public class XlsxController {

    private final XlsxService service;


    @GetMapping("/min")
    public ResponseEntity<Integer> getNthMin(
            @Parameter(description = "Путь к файлу .xlsx на сервере лежит по пути src/main/resources/data.xlsx",
                    required = true)
            @RequestParam(required = false) String path,
            @Parameter(required = true)
            @RequestParam(required = false) int n) {
        return ResponseEntity.ok(service.findNthSmallest(path, n));
    }
}
