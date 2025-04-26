import java.util.*;
import java.util.concurrent.*;

public class SpicesManagement {

    public static void main(String[] args) {

    }

    public static int generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
