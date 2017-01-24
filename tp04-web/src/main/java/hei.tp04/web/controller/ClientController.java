package hei.tp04.web.controller;


import hei.tp04.core.entity.Client;
import hei.tp04.core.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class ClientController {

    @Inject
    private ClientService clientService;


    private final static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @RequestMapping(value = {"/*", "/list"}, method = RequestMethod.GET)
    public String getListOfClients(ModelMap modelMapClients) {
        modelMapClients.addAttribute("clients", clientService.findAllWithCommandes());
        LOGGER.error("AFFICHAGE LISTE");
        return "clientsList";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(ModelMap modelMap) {
        Client client = new Client();
        modelMap.addAttribute("client", client);
        return "clientsForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:list";
    }

    @RequestMapping(value = "/{idClient:\\d+}/delete", method = RequestMethod.GET)
    public String deleteForm(@PathVariable("idClient") int idClient) {
        clientService.deleteClient(idClient);
        return "redirect:../list";
    }
}
