package com.entidade.relacional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAppUser extends JpaRepository<AppUser, Long> {
}
