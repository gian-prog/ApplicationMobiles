package com.giancarlo.serveur_avec_bd.interfaces;

import com.giancarlo.serveur_avec_bd.controller.PasBonneChoseException;
import com.giancarlo.serveur_avec_bd.models.Truc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrucService {

    @Autowired
    private TrucRepo trucRepo;

    public void ajouterUnTruc(String leChoseDuTruc) throws PasBonneChoseException {
        Truc truc = new Truc();
        if (leChoseDuTruc == null) {
            throw new PasBonneChoseException();
        }
        Truc trucExistant = trucRepo.findByChose(leChoseDuTruc);
        if (trucExistant != null) {
            throw new PasBonneChoseException();
        }
        truc.chose = leChoseDuTruc;
        trucRepo.save(truc);
    }

    public List<Truc> listerTrucs() {
        return trucRepo.findAll();
    }

}