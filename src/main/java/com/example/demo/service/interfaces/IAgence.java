package com.example.demo.service.interfaces;
import com.example.demo.persistance.entities.Agence;
import java.util.List;

public interface IAgence {

	Agence saveAgence(Agence agence);
	Agence updateAgence(Agence agence);
    boolean deleteAgence(Long id);
    List<Agence> getListAgence();
    Agence getAgence(Long id);
    Agence findAgenceByName(String nom);
    int getQuantityOfAgence();
    Agence getAgenceByIdAgence(Long id);

}
