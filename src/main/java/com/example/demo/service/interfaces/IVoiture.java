package com.example.demo.service.interfaces;
import com.example.demo.persistance.entities.Voiture;

import java.util.List;

public interface IVoiture {
	Voiture saveVoiture(Voiture voiture);
	Voiture updateVoiture(Voiture voiture);
    boolean deleteVoiture(Long id);
    List<Voiture> getListVoiture();
    Voiture getVoiture(Long id);
    Voiture findVoitureByCouleur(String couleur);
    Voiture getVoitureByIdVoiture(Long id);

}
