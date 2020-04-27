package Parser;

import java.awt.*;

public class Test {
    private List name;

    public Test() {
    }

    public Test(List name) {
        this.name = name;
    }

    public List getName() {
        return name;
    }
    private static void getAll(){
        Test test = new Test();
        test.getName();
    }
}
