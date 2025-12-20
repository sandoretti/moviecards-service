/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.unittest.controller;

import com.lauracercas.moviecards.controller.ActorController;
import com.lauracercas.moviecards.model.Actor;
//import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.actor.ActorService;
//import com.lauracercas.moviecards.util.Messages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class ActorControllerTest {

    // @Mock
    // private ActorService actorServiceMock;
    @Mock
    private ActorService actorService;

    // private ActorController controller;
    @InjectMocks // auto inject actorService
    private ActorController controller = new ActorController();

    private AutoCloseable closeable;

    // @Mock
    // private Model model;

    @BeforeEach
    void setUp() {
        closeable = openMocks(this);
        // controller = new ActorController(actorServiceMock);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void shouldGoListActorAndGetAllActors() {
        List<Actor> actors = new ArrayList<>();
        actors.add(new Actor()); // Añadido
        actors.add(new Actor()); // Añadido

        // when(actorServiceMock.getAllActors()).thenReturn(actors);
        when(actorService.getAllActors()).thenReturn(actors);

        // String viewName = controller.getActorsList(model);
        List<Actor> result = controller.getActorsList();

        // assertEquals("actors/list", viewName);
        assertEquals(2, result.size());
    }

    // @Test
    // public void shouldInitializeActor() {
    // String viewName = controller.newActor(model);
    // assertEquals("actors/form", viewName);
    // verify(model).addAttribute("actor", new Actor());
    // verify(model).addAttribute("title", Messages.NEW_ACTOR_TITLE);
    // }

    // @Test
    // public void shouldSaveActorWithNoErrors() {
    // Actor actor = new Actor();
    // BindingResult result = mock(BindingResult.class);
    // when(result.hasErrors()).thenReturn(false);
    // when(actorService.save(any(Actor.class))).thenReturn(actor);
    // String viewName = controller.saveActor(actor);
    // assertEquals("actors/form", viewName);
    // verify(model).addAttribute("actor", actor);
    // verify(model).addAttribute("title", Messages.EDIT_ACTOR_TITLE);
    // verify(model).addAttribute("message", Messages.SAVED_ACTOR_SUCCESS);
    // }

    // @Test
    // public void shouldUpdateActorWithNoErrors() {
    // Actor actor = new Actor();
    // actor.setId(1);
    // BindingResult result = mock(BindingResult.class);
    // when(result.hasErrors()).thenReturn(false);
    // when(actorServiceMock.save(any(Actor.class))).thenReturn(actor);
    // String viewName = controller.saveActor(actor, result, model);
    // assertEquals("actors/form", viewName);
    // verify(model).addAttribute("actor", actor);
    // verify(model).addAttribute("title", Messages.EDIT_ACTOR_TITLE);
    // verify(model).addAttribute("message", Messages.UPDATED_ACTOR_SUCCESS);
    // }

    // @Test
    // public void shouldTrySaveActorWithErrors() {
    // Actor actor = new Actor();
    // BindingResult result = mock(BindingResult.class);
    // when(result.hasErrors()).thenReturn(true);
    // String viewName = controller.saveActor(actor, result, model);
    // assertEquals("actors/form", viewName);
    // verifyNoInteractions(model);
    // }

    @Test
    public void shouldGoToEditActor() {
        Actor actor = new Actor();
        actor.setId(1);
        actor.setName("Sample Actor"); // Añadir

        // List<Movie> movies = List.of(new Movie());
        // actor.setMovies(movies);
        // when(actorServiceMock.getActorById(actor.getId())).thenReturn(actor);
        when(actorService.getActorById(actor.getId())).thenReturn(actor);

        // String viewName = controller.editActor(actor.getId(), model);
        Actor result = controller.editActor(actor.getId());

        // assertEquals("actors/form", viewName);
        assertEquals(1, result.getId());
        assertEquals("Sample Actor", result.getName());

        // verify(model).addAttribute("actor", actor);
        // verify(model).addAttribute("movies", movies);
        // verify(model).addAttribute("title", Messages.EDIT_ACTOR_TITLE);
    }

}