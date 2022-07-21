package com.sheila.springproject.controller;

import javax.validation.Valid;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheila.springproject.dto.TransactionDto;
import com.sheila.springproject.model.TransactionModel;
import com.sheila.springproject.service.TransactionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/transaction")
public class TransactionController {

	final TransactionService transactionService;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping
	public ResponseEntity<Object> saveTransaction(@RequestBody @Valid TransactionDto transactionDto)
			throws JsonProcessingException {

		var transactionModel = new TransactionModel();
		BeanUtils.copyProperties(transactionDto, transactionModel);
		String rountingKey = "transactions";

		String transactionJson = objectMapper.writeValueAsString(transactionDto);

		Message message = MessageBuilder.withBody(transactionJson.getBytes())
				.setContentType(MessageProperties.CONTENT_TYPE_JSON).build();

		rabbitTemplate.convertAndSend(rountingKey, message);
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.save(transactionModel));

	}

}