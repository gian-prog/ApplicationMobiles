package org.benedetti.calculMethodes.service;

import org.benedetti.calculMethodes.model.Truc;
import org.benedetti.calculMethodes.repos.TrucRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrucService {

    @Autowired
    private TrucRepo trucRepo;

    public void ajouterUnTruc(String leChoseDuTruc) throws PasUneBonneChoseException {
        Truc truc = new Truc();
        if (leChoseDuTruc == null) {
            throw new PasUneBonneChoseException();
        }
        Truc trucExistant = trucRepo.findByChose(leChoseDuTruc);
        if (trucExistant != null) {
            throw new PasUneBonneChoseException();
        }
        truc.chose = leChoseDuTruc;
        trucRepo.save(truc);
    }

    public List<Truc> listerTrucs() {
        if (trucRepo.count() == 0) {
            System.out.println("La base de données est vide, création de 10 objets par défaut.");
            for (int i = 1; i <= 10; i++) {
                Truc truc = new Truc();
                truc.chose = "chose" + i;
                trucRepo.save(truc);
            }
        }
        List<Truc> trucs = trucRepo.findAll();
        System.out.println("Nombre d'objets trouvés : " + trucs.size());
        return trucs;
    }
    public void EmptyList() { trucRepo.deleteAll() ;
    }

}