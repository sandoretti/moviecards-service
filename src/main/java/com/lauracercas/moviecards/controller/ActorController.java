/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.Actor;
//import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.actor.ActorService;
//import com.lauracercas.moviecards.util.Messages;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

//Imports añadidos
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

//@Controller
@RestController
public class ActorController {

    //private final ActorService actorService;
    @Autowired
    ActorService actorService;
    
    // @GetMapping("actors")
    // public String getActorsList(Model model) {
    //     model.addAttribute("actors", actorService.getAllActors());
    //     return "actors/list";
    // }
    @GetMapping("/actors")
    public List<Actor> getActorsList() {
        return (actorService.getAllActors());
    }

    // @GetMapping("actors/new")
    // public String newActor(Model model) {
    //     model.addAttribute("actor", new Actor());
    //     model.addAttribute("title", Messages.NEW_ACTOR_TITLE);
    //     return "actors/form";
    // }
    @PostMapping("/actors")
    public void newActor(@RequestBody Actor actor) {
        actorService.save(actor);
    }

    // @PostMapping("saveActor")
    // public String saveActor(@ModelAttribute Actor actor, BindingResult result,
    // Model model) {
    // if (result.hasErrors()) {
    // return "actors/form";
    // }
    // Actor actorSaved = actorService.save(actor);
    // if (actor.getId() != null) {
    // model.addAttribute("message", Messages.UPDATED_ACTOR_SUCCESS);
    // } else {
    // model.addAttribute("message", Messages.SAVED_ACTOR_SUCCESS);
    // }
    // model.addAttribute("actor", actorSaved);
    // model.addAttribute("title", Messages.EDIT_ACTOR_TITLE);
    // return "actors/form";
    // }
   @PutMapping("/actors")
    public void saveActor(@RequestBody Actor actor) {
        actorService.save(actor);
    }

    // @GetMapping("editActor/{actorId}")
    // public String editActor(@PathVariable Integer actorId, Model model) {
    // Actor actor = actorService.getActorById(actorId);
    // List<Movie> movies = actor.getMovies();
    // model.addAttribute("actor", actor);
    // model.addAttribute("movies", movies);
    // model.addAttribute("title", Messages.EDIT_ACTOR_TITLE);
    // return "actors/form";
    // }
    @GetMapping("actors/{actorId}")
    public Actor editActor(@PathVariable("actorId") Integer actorId) {
        return actorService.getActorById(actorId);
    }

}
