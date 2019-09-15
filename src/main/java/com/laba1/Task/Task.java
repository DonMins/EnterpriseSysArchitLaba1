package com.laba1.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Simple Java Class
 * Используется для передачи введенного числа пользователем с клиента на сервер {@link com.laba1.Bean.GameServlet }
 * @author Maks
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String number;
    private String serverResponse;

    public Task(String number){
        this.number = number;
    }
}
