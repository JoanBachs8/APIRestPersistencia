package com.example.apirestpersistencia.Model.serveis;

import com.example.apirestpersistencia.Model.entitats.Beguda;
import com.example.apirestpersistencia.Model.repositoris.RepositoriBegudes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiBegudes {
    private final RepositoriBegudes repositoriBegudes;

    public List<Beguda> llistaBegudes(){
        return repositoriBegudes.findAll();
    }

    public List<Beguda> llistarBegudesTipus(String tipus){
        return repositoriBegudes.findByTipus(tipus);
    }

    public long comptarPerTipus(String tipus){
        return repositoriBegudes.countByTipus(tipus);
    }

    public List<Beguda> llistatPerPreuMenorA(double preu){
        return repositoriBegudes.findByPreuLessThan(preu);
    }

    public Beguda consultarBeguda(String id){
        return repositoriBegudes.findById(id).orElse(null);
    }

    public Beguda afegirBeguda(Beguda it){
        return repositoriBegudes.save(it);
    }

    public Beguda modificarBeguda(Beguda it){
        Beguda aux = null;
        if(repositoriBegudes.existsById(it.getId())) aux = repositoriBegudes.save(it);
        return aux;
    }

    public Beguda eliminarBeguda(String id){
        Beguda res = repositoriBegudes.findById(id).orElse(null);
        if (res!=null) repositoriBegudes.deleteById(id);
        return res;
    }
}
