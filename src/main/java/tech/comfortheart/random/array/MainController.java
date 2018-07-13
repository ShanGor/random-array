package tech.comfortheart.random.array;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class MainController {
    @GetMapping("/shuffle/{size}")
    public List<Integer> shuffle(@PathVariable("size") int size,
                                 @RequestParam(value = "from", required = false) Integer fromNumber)  {
        if (fromNumber == null) {
            fromNumber = 1;
        }

        List<Integer> hey = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            hey.add(fromNumber + i);
        }
        Collections.shuffle(hey);
        return hey;
    }

    @GetMapping("/shuffle-square/{size}")
    public int[][] shuffleSquare(@PathVariable("size") int size,
                                 @RequestParam(value = "from", required = false) Integer fromNumber)  {
        List<Integer> hey = shuffle(size * size, fromNumber);
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = hey.remove(0);
            }
        }
        return array;
    }
}