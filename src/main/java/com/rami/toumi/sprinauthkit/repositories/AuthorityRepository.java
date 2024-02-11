package com.rami.toumi.sprinauthkit.repositories;

import com.rami.toumi.sprinauthkit.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
