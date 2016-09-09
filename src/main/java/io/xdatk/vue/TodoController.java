package io.xdatk.vue;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by qiang.feng on 16/9/9.
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    private List<Todo> todos = getTodos();

    private String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    private List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int a = new Random(10).nextInt();
            if (a % 2 == 0) {
                todos.add(new Todo(getRandomString(10), true));
            } else {
                todos.add(new Todo(getRandomString(10), false));
            }
        }
        return todos;
    }

    @GetMapping("")
    public List<Todo> index() {
        return todos;
    }


    @PostMapping("")
    public boolean save(@RequestBody Todo todo) {
        todos.add(todo);
        return true;
    }
}
