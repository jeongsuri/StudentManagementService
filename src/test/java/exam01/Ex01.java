package exam01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01 {
    @Test
    public void test() {
        List<String> abc = new ArrayList<>();
        abc.add("aaa");
        abc.add("bbb");
        String str = String.join("!", abc);
        System.out.println(str);

    }
}
