package org.zph.claude_test.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void createsPersonWithNameAndAddress() {
        Person person = new Person("Alice", "123 Main St");
        assertEquals("Alice", person.name());
        assertEquals("123 Main St", person.address());
    }

    @Test
    void equalPersonsHaveSameNameAndAddress() {
        Person p1 = new Person("Bob", "456 Elm St");
        Person p2 = new Person("Bob", "456 Elm St");
        assertEquals(p1, p2);
    }

    @Test
    void personsWithDifferentNamesAreNotEqual() {
        Person p1 = new Person("Alice", "123 Main St");
        Person p2 = new Person("Bob", "123 Main St");
        assertNotEquals(p1, p2);
    }

    @Test
    void personsWithDifferentAddressesAreNotEqual() {
        Person p1 = new Person("Alice", "123 Main St");
        Person p2 = new Person("Alice", "789 Oak Ave");
        assertNotEquals(p1, p2);
    }

    @Test
    void equalPersonsHaveSameHashCode() {
        Person p1 = new Person("Alice", "123 Main St");
        Person p2 = new Person("Alice", "123 Main St");
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void toStringContainsNameAndAddress() {
        Person person = new Person("Alice", "123 Main St");
        String result = person.toString();
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("123 Main St"));
    }

    @Test
    void allowsNullFields() {
        Person person = new Person(null, null);
        assertNull(person.name());
        assertNull(person.address());
    }
}
