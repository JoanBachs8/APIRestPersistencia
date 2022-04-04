package com.example.apirestpersistencia.Controladors;


import com.example.apirestpersistencia.Model.entitats.Beguda;
import com.example.apirestpersistencia.Model.serveis.ServeiBegudes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorBegudes {
    private final ServeiBegudes serveiBegudes;

    @GetMapping("/begudes")
    public List<Beguda> llistarBegudes(){ return serveiBegudes.llistaBegudes(); }

    @GetMapping("/begudes/{id}")
    public ResponseEntity<Beguda> consultarBeguda(@PathVariable String id){
        Beguda beguda = serveiBegudes.consultarBeguda(id);
        if (beguda == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(beguda);
    }

    @GetMapping("/begudes/{tipus}")
    public List<Beguda> llistarBegudesPerTipus(@PathVariable String tipus){
        return serveiBegudes.llistarBegudesTipus(tipus);
    }

    @GetMapping("/begudes/comptar/{tipus}")
    public long comptarPerTipus(@PathVariable String tipus){
        return serveiBegudes.comptarPerTipus(tipus);
    }

    @PostMapping("/begudes")
    public ResponseEntity<Beguda> crearBeguda(@RequestBody Beguda nou){
        Beguda beguda = serveiBegudes.afegirBeguda(nou);
        return new ResponseEntity(beguda, HttpStatus.CREATED);
    }

    @DeleteMapping("/begudes/{id}")
    public ResponseEntity<Beguda> eliminarBeguda(@PathVariable String id){
        Beguda beguda = serveiBegudes.eliminarBeguda(id);
        if (beguda == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    @PutMapping("/begudes")
    public ResponseEntity<Beguda> modificarBeguda(@RequestBody Beguda mod){
        Beguda beguda = serveiBegudes.modificarBeguda(mod);
        if (beguda == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(beguda);
    }

}
