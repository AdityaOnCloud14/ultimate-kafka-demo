package com.example.customeraccountstatechange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStateChangeRepository extends JpaRepository<AccountStateChange, String> {
}
