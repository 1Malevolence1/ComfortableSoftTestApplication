package org.unitbean.comfortablesofttestapplication.valdate;

import java.io.File;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class XlsxValidator {

    public void validateN(int n) {
        if (n <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Некорректное значение N: " + n + ". Число должно быть положительным (N ≥ 1)."
            );
        }
    }

    public void validateFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Файл не найден по пути: " + filePath
            );
        }
        if (!file.isFile()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Указанный путь не является файлом: " + filePath
            );
        }
    }

    public void validateEnoughNumbers(int actualCount, int requiredCount) {
        if (actualCount < requiredCount) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "В файле недостаточно чисел: найдено " + actualCount + ", требуется " + requiredCount
            );
        }
    }
}
