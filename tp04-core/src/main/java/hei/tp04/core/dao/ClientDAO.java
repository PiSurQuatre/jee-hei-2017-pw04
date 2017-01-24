package hei.tp04.core.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import hei.tp04.core.entity.Client;

public interface ClientDAO extends JpaRepository<Client, Long> {

    List<Client> findByNom(String nom);

    @Query("SELECT DISTINCT c FROM Client c LEFT JOIN FETCH c.commandes co LEFT JOIN FETCH co.produits")
    List<Client> findAllWithCommandes();
}
