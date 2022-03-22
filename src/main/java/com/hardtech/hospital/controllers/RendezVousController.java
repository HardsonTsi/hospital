package com.hardtech.hospital.controllers;

import com.hardtech.hospital.entities.RendezVous;
import com.hardtech.hospital.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;

    @GetMapping("/rendezvous")
    List<RendezVous> getRendezVous() {
        return rendezVousService.getAllRendezVous();
    }

    @GetMapping("/rendezvous/{id}")
    RendezVous rendezVous(@PathVariable Long id) {
        return rendezVousService.getRendezVous(id);
    }

    @PostMapping("/rendezvous")
    RendezVous saveRendezvous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.saveRendezVous(rendezVous);
    }

    @PutMapping("/rendezvous")
    RendezVous updateRendezvous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.updateRendezVous(rendezVous);
    }

    @DeleteMapping("/rendezvous/delete/{id}")
    void deleteRendezvous(@PathVariable Long id) {
        rendezVousService.deleteRendezVous(id);
    }
}
