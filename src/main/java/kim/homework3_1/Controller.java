package kim.homework3_1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    List<Integer> integers = new ArrayList<>(Arrays.asList(31, 52));

    @GetMapping("integers")
    public List<Integer> getIntegers() {
        return integers;
    }

    @PostMapping("integers")
    public String addInteger(@RequestBody Integer newInteger) {
        integers.add(newInteger);
        return "Successfully added: " + newInteger;
    }

    @DeleteMapping("integers/{id}")
    public String deleteInteger(@PathVariable int id) {
        integers.remove(id);
        return "Successfully deleted";
    }

    @DeleteMapping()
    public String deleteAllIntegers() {
        integers.clear();
        return "Successfully deleted all integers";
    }

    @PutMapping("integers/{id}")
    public String editInteger(@PathVariable int id, @RequestBody Integer integer) {
        integers.set(id, integer);
        return "Successfully edited:" + id + ",new value is:" + integer;
    }

    @GetMapping("integers/sum")
    public List<Integer> sumIntegers() {
        Integer sum = integers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        return Collections.singletonList(sum);
    }

    @GetMapping("integers/avg")
    public List<Double> avgIntegers() {
        Double avg = integers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        return Collections.singletonList(avg);
    }

    @GetMapping("integers/count")
    public List<Long> countIntegers() {
        Long sum = integers.stream()
                .collect(Collectors.counting());
        return Collections.singletonList(sum);
    }
}
