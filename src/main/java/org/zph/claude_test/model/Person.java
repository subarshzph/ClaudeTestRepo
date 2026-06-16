package org.zph.claude_test.model;

public record Person(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String address,
        String city,
        String state,
        String zipCode,
        String country
) {}
