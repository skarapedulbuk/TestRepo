package HW11;

import com.sun.org.apache.xpath.internal.operations.Or;

public class Orange extends Fruit{
    public Orange() {
        super(1.5F);
    }
    public Orange generate () {
        return new Orange();
    }
}
