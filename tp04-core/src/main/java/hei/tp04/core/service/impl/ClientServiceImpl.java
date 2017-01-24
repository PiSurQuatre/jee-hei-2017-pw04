package hei.tp04.core.service.impl;

import hei.tp04.core.dao.ClientDAO;
import hei.tp04.core.entity.Client;
import hei.tp04.core.service.ClientService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class ClientServiceImpl implements ClientService {

    @Inject
    private ClientDAO clientDAO;


    @Override
    public List<Client> findByNom(String nom) {
        return clientDAO.findByNom(nom);
    }


    @Override
    public void saveClient(Client client) {
        clientDAO.save(client);
    }


    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public List<Client> findAllWithCommandes() {
        List<Client> clients = clientDAO.findAllWithCommandes();
        return clients;
    }

    @Override
    public void deleteClient(int idClient) {
        clientDAO.delete((long) idClient);
    }
}
