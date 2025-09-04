package com.example.LibraryManagementApplication.repositories;

import com.example.LibraryManagementApplication.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Client c WHERE c.cpf = :cpf")
    Boolean existsByCpf(@Param("cpf") String cpf);
}
