package com.example.demo.service.interfaces;
import com.example.demo.persistance.entities.Facture;
import com.example.demo.persistance.entities.Voiture;

import java.util.List;
import java.util.Optional;

public interface IFacture {

	Facture saveFacture(Facture facture);
	Facture updateFacture(Facture facture);
    boolean deleteFacture(Long id);
    List<Facture> getListFacture();
    Facture getFacture(Long id);
    Facture findFactureBynumero(Long numero);
    Facture getFactureByIdFacture(Long id);
	Optional<Facture> getFactureById(Long id);
	List<Facture> getAllFactures();

}
