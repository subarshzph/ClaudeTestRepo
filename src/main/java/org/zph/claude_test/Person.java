package org.zph.claude_test;

import java.time.LocalDate;

public record Person(
        String firstName,
        String lastName,
        int age,
        String ssn,
        LocalDate dob
) {
}
