import java.util.ArrayList;
import java.util.List;

public class HalloJavamitForEach {
    public List<String> loop = new ArrayList<>();

    public void forEach(){
        for (String s :
                loop) {
            System.out.println(s);
        }
    }

    public void forEachMethod(){
        loop.forEach(System.out::println);
    }



}
