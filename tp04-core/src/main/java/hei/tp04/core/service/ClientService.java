package hei.tp04.core.service;

import hei.tp04.core.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> findByNom(String nom);


    void saveClient(Client client);


    List<Client> findAll();


    List<Client> findAllWithCommandes();

    void deleteClient(int idClient);
}
