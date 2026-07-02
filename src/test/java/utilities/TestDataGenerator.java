package utilities;

import java.util.concurrent.atomic.AtomicInteger;

public final class TestDataGenerator {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private TestDataGenerator() {
    }

    public static TestUser generateUser() {

        String sequence = String.format("%04d", COUNTER.getAndIncrement());

        return new TestUser(
                "UserFirstName" + sequence,
                "UserLastName" + sequence,
                "user" + sequence + "@gmail.com",
                "TestUser@" + sequence
        );
    }
}