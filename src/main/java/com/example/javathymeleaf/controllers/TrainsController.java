package com.example.javathymeleaf.controllers;

import com.example.javathymeleaf.models.Station;
import com.example.javathymeleaf.models.Train;
import com.example.javathymeleaf.models.TrainNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TrainsController {
  @GetMapping("/trains/{id}")
  public String getTrain(@PathVariable Integer id, Model model) {
    Train train;
    try {
      train = getTrains().get(id - 1);
    }
    catch(IndexOutOfBoundsException e) {
      //throw an exception that will result in a 404
      throw new TrainNotFoundException();
    }

    //if the train is found, we can render the template
    model.addAttribute("train", train);
    return "trains/show";
  }

  @GetMapping("/trains")
  public String getTrains(Model model) {
    model.addAttribute("station", getStation());
    model.addAttribute("trains", getTrains());

    return "trains/index";
  }

  private List<Train> getTrains() {
    List<Train> trains = new ArrayList<Train>();

    Train thomas = new Train();
    thomas.setName("Thomas");
    thomas.setColor("blue");
    trains.add(thomas);

    Train percy = new Train();
    percy.setColor("green");
    percy.setName("Percy");
    trains.add(percy);

    Train james = new Train();
    james.setColor("red");
    james.setName("James");
    trains.add(james);

    return trains;
  }

  private Station getStation() {
    Station knapford = new Station();
    knapford.setName("Knapford");
    knapford.setLocation("Sodor");
    return knapford;
  }
}
