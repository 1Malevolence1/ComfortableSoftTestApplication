package org.unitbean.comfortablesofttestapplication.service;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.dhatim.fastexcel.reader.Cell;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
import org.springframework.stereotype.Service;
import org.unitbean.comfortablesofttestapplication.valdate.XlsxValidator;


@Service
@RequiredArgsConstructor
public class XlsxService {

    private final QuickSelect quickSelect;
    private final XlsxValidator xlsxValidator;

    public int findNthSmallest(String filePath, int n) {
        xlsxValidator.validateN(n);
        xlsxValidator.validateFile(filePath);

        Set<Integer> numbers = readFirstColumn(filePath);

        xlsxValidator.validateEnoughNumbers(numbers.size(), n);

        int[] arr = numbers.stream().mapToInt(Integer::intValue).toArray();
        return quickSelect.select(arr, n - 1);
    }

    @SneakyThrows
    private Set<Integer> readFirstColumn(String filePath) {
        Set<Integer> numbers = new HashSet<>();

        try (ReadableWorkbook workbook = new ReadableWorkbook(new FileInputStream(filePath))) {
            Sheet sheet = workbook.getSheets().findFirst().orElseThrow();

            try (Stream<Row> rows = sheet.openStream()) {
                rows.forEach(row -> {
                    Cell cell = row.getCell(0);
                    if (cell != null && cell.getValue() instanceof Number number) {
                        numbers.add(number.intValue());
                    }
                });
            }
        }
        return numbers;
    }
}
