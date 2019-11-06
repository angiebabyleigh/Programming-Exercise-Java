package com.containerstore.whereis.controller;

import com.containerstore.whereis.dao.WhereIsConferenceRooms;
import com.containerstore.whereis.viewmodel.WhereIsViewModel;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class WhereIsController {

	@Autowired
	WhereIsConferenceRooms conferenceRooms;

	@GetMapping("/")
	public String whereisForm(Model model) {
		model.addAttribute("queryModel", new WhereIsViewModel());
		return "whereis";
	}

	@GetMapping("/conference_rooms")
	public String listConferenceRooms() {
		return "conferencerooms";
	}

	@PostMapping("/")
	public String submitForm(Model model, @ModelAttribute WhereIsViewModel viewModel) {
		
		viewModel.setResult(conferenceRooms.locationOf(viewModel.getQuery()));

		model.addAttribute("queryModel", viewModel);
		return "whereis";
	}

	@PostMapping("/incoming")
	@ResponseStatus(OK)
	public void incoming(@RequestBody String query, @RequestParam("From") String origin) {

		Twilio.init("(account sid)", "(auth token)");

		MessageCreator creator = Message.creator(new PhoneNumber(origin), new PhoneNumber("4694164526"),
				conferenceRooms.locationOf(query));
		creator.create();
	}
}
