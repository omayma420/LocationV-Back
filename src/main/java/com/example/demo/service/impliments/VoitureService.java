package com.example.demo.service.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.VoitureRepository;
import com.example.demo.persistance.entities.Voiture;
import com.example.demo.service.interfaces.IVoiture;

@Service
public class VoitureService implements IVoiture {

    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public Voiture saveVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @Override
    public Voiture updateVoiture(Voiture voiture) {
        return voitureRepository.saveAndFlush(voiture);
    }

    @Override
    public boolean deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Voiture> getListVoiture() {
        return voitureRepository.findAll();
    }

    @Override
    public Voiture getVoiture(Long id) {
        return voitureRepository.findById(id).get();
    }

    @Override
    public Voiture findVoitureByCouleur(String couleur) {
        return voitureRepository.findByCouleur(couleur);
    }

    @Override
    public Voiture getVoitureByIdVoiture(Long id) {
        // Vous devez implémenter cette méthode selon votre logique métier
        return null;
    }
}
