
package com.airtribe.aggregatorApi.repository;
import com.airtribe.aggregatorApi.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Integer> {

    Optional<user> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
