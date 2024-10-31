package com.dev6.Webfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev6.Webfoodapp.model.Aliment;
import com.dev6.Webfoodapp.model.Nutrition;
import com.dev6.Webfoodapp.model.Nutrition.Nutrient;
import com.dev6.Webfoodapp.repository.Alimentproxy;

import lombok.Data;

@Data
@Service
public class AlimentService {

	@Autowired
	private Alimentproxy alimentProxy;

	public Aliment getAliment(final int id) {
		return alimentProxy.getAliment(id);
	}

	public Iterable<Aliment> getAliments() {
		return alimentProxy.getAliments();
	}

	public void deleteAliment(final int id) {
		alimentProxy.deleteAliment(id);
	}

	public Aliment saveAliment(Aliment aliment) {
		Aliment savedAliment;

		Nutrition nutrition = alimentProxy.getNutritionByName(aliment.getName());
		List<Nutrient> nutriments = nutrition.getNutrition().getNutrients();

		// Initialiser les valeurs par défaut
		double calories = 0;
		double proteins = 0;
		double carbohydrates = 0;
		double lipids = 0;

		// Boucler sur chaque élément de nutriments pour extraire les valeurs
		// nécessaires
		for (Nutrient nutrient : nutriments) {
			switch (nutrient.getName().toLowerCase()) {
				case "calories":
					calories = nutrient.getAmount();
					break;
				case "protein":
					proteins = nutrient.getAmount();
					break;
				case "carbohydrates":
					carbohydrates = nutrient.getAmount();
					break;
				case "fat": // "Fat" dans les données de Spoonacular pour Lipids
					lipids = nutrient.getAmount();
					break;
			}
		}

		// Mettre à jour les valeurs de l'aliment avec les nutriments correspondants
		aliment.setName(aliment.getName());
		aliment.setPrice(aliment.getPrice());
		aliment.setQuantity(aliment.getQuantity());
		aliment.setCalories(calories);
		aliment.setProteins(proteins);
		aliment.setCarbohydrates(carbohydrates);
		aliment.setLipids(lipids);

		System.out.println("Aliment créer dans le Service : " + aliment);

		if (aliment.getId() == null) {
			savedAliment = alimentProxy.createAliment(aliment);
			System.out.println("Aliment créé : " + savedAliment);
		} else {
			savedAliment = alimentProxy.updateAliment(aliment);
		}

		return savedAliment;
	}
}
