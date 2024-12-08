import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    void testAddContact() {
        assertEquals(1, phoneBook.add("Alice", "12345"));
        assertEquals(2, phoneBook.add("Bob", "67890"));
        assertEquals(2, phoneBook.add("Alice", "54321")); // Дубликат не добавляется
    }
    @Test
    void testFindByNumber() {
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");
        assertEquals("Alice", phoneBook.findByNumber("12345"));
        assertEquals("Bob", phoneBook.findByNumber("67890"));
        assertNull(phoneBook.findByNumber("00000")); // Номер не найден
    }
}